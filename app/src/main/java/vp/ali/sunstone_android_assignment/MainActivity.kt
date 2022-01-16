package vp.ali.sunstone_android_assignment

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import vp.ali.sunstone_android_assignment.Adapter.MyPagerAdapter

class MainActivity : AppCompatActivity() {
    private val READ_STORAGE = 101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        askPermission();
    }

    private fun askPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            READ_STORAGE
        )
    }

    private fun setAdapter() {
        val myPagerAdapter= MyPagerAdapter(supportFragmentManager,this.lifecycle)
        VPfragmentHolder.adapter=myPagerAdapter
        TabLayoutMediator(tab, VPfragmentHolder) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = " Video "
                }
                1 -> {
                    tab.text = "Image"
                }
            }

        }.attach()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isNotEmpty() && requestCode == 101) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
                setAdapter()
            }
            else  {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_LONG).show()
                askPermission()
            }
        }
    }
}