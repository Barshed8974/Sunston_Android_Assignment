package vp.ali.sunstone_android_assignment.showActivities

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import kotlinx.android.synthetic.main.activity_show_video.*
import kotlinx.android.synthetic.main.custom_control.*
import vp.ali.sunstone_android_assignment.R

class ShowVideo : AppCompatActivity() {

    private var bool=true
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_video)
        val sessionId = intent.getStringExtra("key")?.toUri()
        Log.d("show", sessionId.toString())
        videoView.setVideoURI(sessionId)
        videoView.start()
        play.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_pause_circle_outline_24))

        Log.d("dura",videoView.duration.toString())
        back.setOnClickListener {
            if (videoView.currentPosition - 10000>=0)
                videoView.seekTo(videoView.currentPosition - 10000)
            else
                videoView.start()
            Log.d("TAG", "BACK")
        }

        play.setOnClickListener {
            Log.d("TATA", "PLAY")
            if (videoView.isPlaying) {
                Log.d("TAG", "isPlaying")
                videoView.pause()
                play.setImageDrawable(resources.getDrawable(R.drawable.play_btn))
            } else {
                Log.d("TAG", "is not Playing")
                videoView.start()
                play.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_pause_circle_outline_24))
            }
        }

        forward.setOnClickListener {
            Log.d("TAG", "Forward")
            if (videoView.currentPosition + 10000<videoView.duration)
                videoView.seekTo(videoView.currentPosition + 10000)
            else
                videoView.start()
        }
        idRlVideo.setOnClickListener {
            Log.d("TAG", "videoRV")
            if (bool) {
                hideControl()
                bool = false
            } else {
                showControl()
                bool = true
            }
        }

    }

    private fun showControl() {
        idIrControl.visibility = View.VISIBLE
    }

    private fun hideControl() {
        idIrControl.setVisibility(View.GONE)
    }
}
