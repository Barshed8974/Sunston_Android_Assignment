package vp.ali.sunstone_android_assignment.showActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.net.toUri
import kotlinx.android.synthetic.main.activity_show_video.*
import vp.ali.sunstone_android_assignment.R

class ShowVideo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_video)
        val sessionId = intent.getStringExtra("key")?.toUri()
        Log.d("show",sessionId.toString())
        video.setVideoURI(sessionId)
        video.start()
    }
}