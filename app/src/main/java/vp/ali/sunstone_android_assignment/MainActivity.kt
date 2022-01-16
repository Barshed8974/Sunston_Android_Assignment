package vp.ali.sunstone_android_assignment

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import vp.ali.sunstone_android_assignment.Adapter.MyPagerAdapter

class MainActivity : AppCompatActivity(),EasyPermissions.PermissionCallbacks{
    private val READ_STORAGE = 101
    private val permissions=ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        setAdapter()
    }

    override fun onRestart() {
        super.onRestart()
        setAdapter()
    }

    //checking for permission
    private fun isPermissionGranted() =
        EasyPermissions.hasPermissions(
            this,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )

    //requesting for permission
    private fun requestStoragePermission()
    {
        EasyPermissions.requestPermissions(
            this,
            "this application require storage permission ",
            READ_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
    }

    //setting viewpager adapter
    private fun setAdapter() {
        if (isPermissionGranted())
        {
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
        else
            requestStoragePermission()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(READ_STORAGE,permissions,grantResults,this)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        setAdapter()
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.permissionPermanentlyDenied(this,Manifest.permission.READ_EXTERNAL_STORAGE))
            AppSettingsDialog.Builder(this).build().show()
        else
            requestStoragePermission()
    }
}