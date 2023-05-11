package com.dtech.darussalam.view.main.customer

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dtech.darussalam.R
import com.dtech.darussalam.data.remote.callback.ICallBackUri
import com.dtech.darussalam.data.remote.callback.ICallBackUriMultiple
import com.dtech.darussalam.databinding.FragmentMoreBinding
import com.dtech.darussalam.utilities.extensions.*
import com.dtech.darussalam.utilities.helper.Permissions
import com.dtech.darussalam.view.base.ActivityBase
import com.dtech.darussalam.view.base.BaseFragment
import com.dtech.darussalam.view.bottomsheet.MediaBottomSheetFragment
import com.sangcomz.fishbun.FishBun
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter

class MoreFragment: BaseFragment() , View.OnClickListener , MediaBottomSheetFragment.ISelectListener {

    lateinit var binding: FragmentMoreBinding
    private val REQUEST_CODE = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_more , container , false)

        setListener()
        return binding.root
    }
    private fun setListener(){
        binding.ivProfile.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.ivProfile ->{
                showBottomSheet()
            }

        }
    }

    private fun showBottomSheet() {
        var bottomSheetListFragment = MediaBottomSheetFragment(arrayListOf("Camera", "Gallery"), "Cancel")
        bottomSheetListFragment.setMyListener(this)
        if (!bottomSheetListFragment.isAdded) {
            bottomSheetListFragment.show(ActivityBase.activity.supportFragmentManager, "")
        }
    }

    override fun onMediaSelect(pos: Int) {
        when (pos) {
            0 -> {
                if (Permissions.checkPermission(requireActivity()))
                    requireActivity().startCamera(REQUEST_CODE)
            }
            1 -> {
                showGallery()
            }
        }
    }

    override fun onMediaCancel() {
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            FishBun.FISHBUN_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK) {
                    if (data != null) {
                        ActivityBase.activity.processGalleryMultipleImages(data,
                            object : ICallBackUriMultiple {
                                override fun imageUri(result: ArrayList<Uri>?) {
                                    var uri = ActivityBase.activity.compressFile(result!![0])
                                    binding.ivProfile.load(uri.path!!)
                                  //  customerUploadPic(uri.path!!)
                                }
                            })
                    }
                }
            }

            REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK) {
                    ActivityBase.activity.processCapturedPhoto(object : ICallBackUri {
                        override fun imageUri(imagePath: Uri?) {
                            var uri = ActivityBase.activity.compressFile(imagePath!!)
                            binding.ivProfile.load(uri!!.path!!)
                         //   customerUploadPic(uri!!.path!!)
                        }
                    })
                }
            }
        }

    }

    private fun showGallery() {
        FishBun.with(ActivityBase.activity)
            .setImageAdapter(GlideAdapter())
            .setMaxCount(1)
            .setActionBarColor(
                Color.parseColor("#E2F3FA"),
                Color.parseColor("#E2F3FA"),
                true
            )
            .setActionBarTitleColor(Color.parseColor("#474747"))
            .isStartInAllView(false)
            .startAlbum()
    }

}