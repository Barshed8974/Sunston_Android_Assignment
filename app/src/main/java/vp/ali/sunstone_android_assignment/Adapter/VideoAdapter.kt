package vp.ali.sunstone_android_assignment.Adapter

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_item.view.*
import vp.ali.sunstone_android_assignment.R

class VideoAdapter(val list: ArrayList<Uri>, val context: Context): RecyclerView.Adapter<VideoAdapter.VideoHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.image_item,parent,false)
        return VideoHolder(view)
    }

    override fun onBindViewHolder(holder: VideoHolder, position: Int) {
        Log.d("adapter","adapter")
        holder.setVideo(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class VideoHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        fun setVideo(uri: Uri)
        {
//            val thumb= uri.path?.let { ThumbnailUtils.createVideoThumbnail(it, MediaStore.Video.Thumbnails.MICRO_KIND) }
//            Glide
//                .with(itemView.imageItem)
//                .load(thumb)
//                .into(itemView.imageItem);
            Log.d("setImageoooo",uri.toString())
            Picasso.get().load(uri).into(itemView.imageItem);
        }
    }
}