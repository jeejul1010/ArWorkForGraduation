package com.example.arworkforgraduation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.arworkforgraduation.R
import com.example.arworkforgraduation.data.model.Category
import com.example.arworkforgraduation.data.model.Gallery
import com.example.arworkforgraduation.databinding.FragmentCategoryBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class CategoryFragment : RoundedBottomSheetDialogFragment() {
    private lateinit var binding : FragmentCategoryBinding

    // 카테고리 리스트에 대한 데이터
    val categorys = listOf(
        Category(R.drawable.ic_travel, "Travel"),
        Category(R.drawable.ic_fantasy, "Fantasy"),
        Category(R.drawable.ic_king, "History"),
        Category(R.drawable.ic_nature, "Nature"),
        Category(R.drawable.ic_horror, "Horror")
    )

    // 상단 갤러리 리스트에 대한 데이터
    val gallerys = listOf(
        Gallery(R.drawable.layer_valentine,"Valentine AR", "Have a sweet Valentine's Day with us!"),
        Gallery(R.drawable.layer_halloween,"Halloween AR", "We invite you to the Halloween festival!")
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


    override fun onViewCreated(view:View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val offsetFromTop = 68
        (dialog as? BottomSheetDialog)?.behavior?.apply {
            isFitToContents = false
            setExpandedOffset(offsetFromTop)
            state = BottomSheetBehavior.STATE_EXPANDED
            skipCollapsed = true
        }
    }

    // 바텀시트 크기에 대한 설정과 리스트를 나타내기 위한 어댑터 초기화
    override fun onResume() {
        super.onResume()
        /*val windowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)

        val params: ViewGroup.LayoutParams? = dialog?.window?.attributes
        val deviceWidth = size.x
        params?.width = (deviceWidth * 1.0).toInt()
        dialog?.window?.attributes = params as WindowManager.LayoutParams*/

        binding.rvCategory.adapter = CategoryAdapter(categorys, object : CategoryAdapter.ItemClickListener {
            override fun onClickItem(title: String) {

                (activity as MainActivity).onCategorySelected(title)
                dismiss()
            }
        })
        binding.vpCategory.adapter = GalleryAdapter(gallerys)
    }


}