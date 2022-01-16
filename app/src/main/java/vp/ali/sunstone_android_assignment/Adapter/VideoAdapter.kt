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
import vp.ali.sunstone_android_assignment.ClickListener
import vp.ali.sunstone_android_assignment.R
class VideoAdapter(val list: List<Uri>, val context: Context,val clickListener: ClickListener) :
    RecyclerView.Adapter<VideoAdapter.VideoHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false)
        return VideoHolder(view,clickListener)
    }

    override fun onBindViewHolder(holder: VideoHolder, position: Int) {
        holder.setVideo(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class VideoHolder(itemView: View,val clickListener: ClickListener) : RecyclerView.ViewHolder(itemView) {
        fun setVideo(uri: Uri) {
            Picasso.get()
                .load(uri)
                .resize(400, 200)
                .into(itemView.imageItem);
            itemView.imageItem.setOnClickListener{
                clickListener.onClick(uri)
            }
        }
    }
}