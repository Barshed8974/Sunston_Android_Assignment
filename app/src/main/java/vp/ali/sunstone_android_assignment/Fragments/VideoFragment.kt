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
import vp.ali.sunstone_android_assignment.Fetcher.VideoFetcher
import vp.ali.sunstone_android_assignment.R


class VideoFragment : Fragment() {
    var al=ArrayList<Uri>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false)
    }
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getVideos()
    }
    @RequiresApi(Build.VERSION_CODES.Q)
    private fun getVideos() {
        val contentFetcher= VideoFetcher(requireContext())
        al=contentFetcher.fetchall()
        videoRecycler.adapter= this.context?.let {
            VideoAdapter(al, it) }
        videoRecycler.layoutManager= GridLayoutManager(this.context,3)
    }
}