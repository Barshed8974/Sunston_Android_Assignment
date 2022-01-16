package vp.ali.sunstone_android_assignment.Fetcher

import android.content.ContentUris
import android.content.Context
import android.content.CursorLoader
import android.net.Uri
import android.provider.MediaStore

class ImageFetcher (val context: Context){
    fun fetchall():ArrayList<Uri>{
        val fields= arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DATA
        )
        val listSms=ArrayList<Uri>()

        val curLoader= CursorLoader(
            context,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            fields,
            null,
            null,
            null
        )
        val cursor=curLoader.loadInBackground()
        if(cursor.moveToFirst())
        {
            //val path=cursor.getColumnIndex(MediaStore.Images.Media.DATA)
            do {
                val txt=ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,cursor.getLong(
                    cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
                ))
                if (txt!=null)
                {
                    listSms.add(txt)
                }
            }while (cursor.moveToNext())
        }
        return listSms
    }
}