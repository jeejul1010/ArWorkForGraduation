package com.example.arworkforgraduation.view

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.arworkforgraduation.R
import com.example.arworkforgraduation.databinding.ActivityMainBinding
import com.unity3d.player.UnityPlayer
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    //private lateinit var outputDirectory: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.cameraPlusButton.visibility = View.INVISIBLE
        binding.cameraProfileButton.visibility = View.INVISIBLE
        binding.checkButton.visibility = View.INVISIBLE

        // Request camera permissions
        if (allPermissionsGranted()) {
            //startCamera()
        } else {
            ActivityCompat.requestPermissions(
                this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
        }
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults:
        IntArray) {
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                //startCamera()
            } else {
                Toast.makeText(this,
                    "Permissions not granted by the user.",
                    Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    // 플러스 버튼을 눌렀을 때
    fun onClickPlusButton(view: View) {
        CategoryFragment().show(supportFragmentManager, "TAG")
    }

    // category가 선택되었을 때
    fun onCategorySelected(title: String) { //categoryName: string
        //Toast.makeText(applicationContext, title, Toast.LENGTH_LONG).show()

        if(title.equals("Nature") || title.equals("Horror"))
        {
            UnityPlayer.UnitySendMessage("Placement Indicator", "showIndicator", "true")
        }
        else
        {
            Toast.makeText(applicationContext, "Not Available!", Toast.LENGTH_LONG).show()
        }
         //categoryName
        when(title){
            "Nature" -> UnityPlayer.UnitySendMessage("AR Session Origin", "ChooseArtwork", "Nature")
            "Horror" -> UnityPlayer.UnitySendMessage("AR Session Origin", "ChooseArtwork", "Horror")
            else -> UnityPlayer.UnitySendMessage("AR Session Origin", "ChooseArtwork", "Else")
        }

    }


    public fun showCheckButton() {
        binding.checkButton.visibility = View.VISIBLE
    }

    public fun hideCheckButton() {
        binding.checkButton.visibility = View.INVISIBLE
    }

    // Check 버튼을 눌렀을 때
    fun onClickCheckButton(view: View) {
        UnityPlayer.UnitySendMessage("AR Session Origin", "ButtonOnClick", "")

        // hide all buttons
        binding.checkButton.visibility = View.INVISIBLE
        binding.cameraPlusButton.visibility = View.INVISIBLE
        binding.cameraProfileButton.visibility = View.INVISIBLE
    }

    fun onUnityModeEnded() {
        binding.cameraPlusButton.visibility = View.VISIBLE
        binding.cameraProfileButton.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        private const val TAG = "CameraXBasic"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }
}