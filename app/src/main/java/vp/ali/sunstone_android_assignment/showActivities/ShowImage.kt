package vp.ali.sunstone_android_assignment.showActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_show.*
import vp.ali.sunstone_android_assignment.R

class ShowImage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        val sessionId = intent.getStringExtra("key")
        Log.d("show",sessionId.toString())
        Picasso.get()
            .load(sessionId)
            .resize(400, 200)
            .into(imageShow);
    }
}