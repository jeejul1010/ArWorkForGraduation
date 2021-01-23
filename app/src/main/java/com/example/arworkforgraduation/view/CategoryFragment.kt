package com.example.arworkforgraduation.view

import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.arworkforgraduation.R
import com.example.arworkforgraduation.data.model.Category
import com.example.arworkforgraduation.data.model.Gallery
import com.example.arworkforgraduation.databinding.FragmentCategoryBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CategoryFragment : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentCategoryBinding

    // 카테고리 리스트에 대한 데이터
    val categorys = listOf(
        Category(R.drawable.ic_travel, "Travel"),
        Category(R.drawable.ic_fantasy, "Fantasy"),
        Category(R.drawable.ic_king, "History"),
        Category(R.drawable.ic_nature, "Nature"),
        Category(R.drawable.ic_game, "Game")
    )

    // 상단 갤러리 리스트에 대한 데이터
    val gallerys = listOf(
        Gallery("Christmas AR", "Shall we go to the Christmas festival?"),
        Gallery("Harry Potter AR", "To the magical world with Harry Potter!")
    )

    // 뷰 초기화
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_category,
            container,
            false
        )
        return binding.root
    }

    // 바텀시트 크기에 대한 설정과 리스트를 나타내기 위한 어댑터 초기화
    override fun onResume() {
        super.onResume()
        val windowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)

        val params: ViewGroup.LayoutParams? = dialog?.window?.attributes
        val deviceWidth = size.x
        params?.width = (deviceWidth * 1.0).toInt()
        dialog?.window?.attributes = params as WindowManager.LayoutParams

        binding.rvCategory.adapter = CategoryAdapter(categorys, object : CategoryAdapter.ItemClickListener {
            override fun onClickItem() {
                (activity as MainActivity).onVisibleCheckButton()
                dismiss()
            }
        })
        binding.vpCategory.adapter = GalleryAdapter(gallerys)
    }
}