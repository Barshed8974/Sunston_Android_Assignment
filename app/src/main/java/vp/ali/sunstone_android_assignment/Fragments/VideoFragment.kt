package vp.ali.sunstone_android_assignment.Fragments

import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_video.*
import vp.ali.sunstone_android_assignment.Adapter.VideoAdapter
import vp.ali.sunstone_android_assignment.R
import vp.ali.sunstone_android_assignment.fetcher.VideoFetcher

class VideoFragment : Fragment() {
    var al = ArrayList<Uri>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getVideos()
    }

    private fun getVideos() {
        val contentFetcher = VideoFetcher(requireContext())
        al = contentFetcher.fetchAllVideo()
        videoRecycler.adapter = this.context?.let {
            VideoAdapter(contentFetcher.fetchAllVideo(), it)
        }
        videoRecycler.layoutManager = GridLayoutManager(this.context, 3)
    }
}