package vp.ali.sunstone_android_assignment.fetcher

import android.content.ContentUris
import android.content.Context
import android.content.CursorLoader
import android.net.Uri
import android.provider.MediaStore

class VideoFetcher(val context: Context) {

    //required fields to access
    fun fetchAllVideo(): ArrayList<Uri> {

            val fields = arrayOf(
                MediaStore.Video.Media._ID,
                MediaStore.Video.Media.DATA
            )

            //list for storing Image uri
            val videoUriList = ArrayList<Uri>()

            val curLoader = CursorLoader(
                context,
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                fields,
                null,
                null,
                null
            )
            val cursor = curLoader.loadInBackground()
            if (cursor.moveToFirst()) {
                do {
                    val videoUri = ContentUris.withAppendedId(
                        MediaStore.Video.Media.EXTERNAL_CONTENT_URI, cursor.getLong(
                            cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID)
                        )
                    )
                    if (videoUri != null) {
                        videoUriList.add(videoUri)
                    }
                } while (cursor.moveToNext())
            }
            return videoUriList
    }
}