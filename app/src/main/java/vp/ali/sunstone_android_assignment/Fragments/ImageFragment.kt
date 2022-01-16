package vp.ali.sunstone_android_assignment.Fragments

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
import vp.ali.sunstone_android_assignment.R


class ImageFragment : Fragment() {
    var al=ArrayList<Uri>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getVideos()
    }


    private fun getVideos() {
        val contentFetcher= ImageFetcher(requireContext())
        al=contentFetcher.fetchall()
        recyclerImage.adapter= this.context?.let {
            ImageAdapter(contentFetcher.fetchall(), it) }
        recyclerImage.layoutManager=GridLayoutManager(this.context,3)
    }
}