package vp.ali.sunstone_android_assignment.Fetcher

import android.content.ContentUris
import android.content.Context
import android.content.CursorLoader
import android.net.Uri
import android.provider.MediaStore

class VideoFetcher (val context: Context){
    fun fetchall():ArrayList<Uri>{
        val fields= arrayOf(
            MediaStore.Video.Media._ID
        )
        val listVideo=ArrayList<Uri>()

        val curLoader= CursorLoader(
            context,
            MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
            fields,
            null,
            null,
            null
        )
        val cursor=curLoader.loadInBackground()
        if(cursor.moveToFirst())
        {
            do {
                val txt= ContentUris.withAppendedId(
                    MediaStore.Video.Media.EXTERNAL_CONTENT_URI,cursor.getLong(
                    cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID)
                ))
                listVideo.add(txt)
            }while (cursor.moveToNext())
        }
        return listVideo
    }
}