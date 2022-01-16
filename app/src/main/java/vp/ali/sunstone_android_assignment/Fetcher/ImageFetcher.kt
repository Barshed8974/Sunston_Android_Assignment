package vp.ali.sunstone_android_assignment.Fetcher

import android.content.ContentUris
import android.content.Context
import android.content.CursorLoader
import android.net.Uri
import android.provider.MediaStore

class ImageFetcher(val context: Context) {
    fun fetchall(): ArrayList<Uri> {

        //required fields to access
        val fields = arrayOf(
            MediaStore.Images.Media._ID
        )

        //list for storing Image uri
        val imageUriList = ArrayList<Uri>()


        val curLoader = CursorLoader(
            context,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            fields,
            null,
            null,
            null
        )

        val cursor = curLoader.loadInBackground()
        if (cursor.moveToFirst()) {
            do {
                val imageUri = ContentUris.withAppendedId(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cursor.getLong(
                        cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
                    )
                )
                imageUriList.add(imageUri)
            } while (cursor.moveToNext())
        }
        return imageUriList
    }
}