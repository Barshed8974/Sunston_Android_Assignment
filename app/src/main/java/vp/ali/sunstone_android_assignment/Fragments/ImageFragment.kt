package vp.ali.sunstone_android_assignment.Fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_image.*
import vp.ali.sunstone_android_assignment.Fetcher.ImageFetcher
import vp.ali.sunstone_android_assignment.Adapter.ImageAdapter
import vp.ali.sunstone_android_assignment.ClickListener
import vp.ali.sunstone_android_assignment.R
import vp.ali.sunstone_android_assignment.showActivities.ShowImage


class ImageFragment : Fragment(), ClickListener {

    var imageUriList = ArrayList<Uri>()      //this list is use to store videos from content provider

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getImage()
    }


    //this method is for get the images uri from ImageFetcher class
    private fun getImage() {
        val contentFetcher = ImageFetcher(requireContext())
        imageUriList = contentFetcher.fetchall()
        recyclerImage.adapter = this.context?.let {
            ImageAdapter(contentFetcher.fetchall(), it, this)
        }
        recyclerImage.layoutManager = GridLayoutManager(this.context, 3)
    }

    //method from ClickListener interface
    override fun onClick(uri: Uri) {
        val intent = Intent(this.context, ShowImage::class.java)
        intent.putExtra("key", uri.toString())
        startActivity(intent)
    }
}