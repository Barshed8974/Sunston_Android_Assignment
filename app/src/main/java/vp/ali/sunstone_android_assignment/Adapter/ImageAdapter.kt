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
class ImageAdapter(val list: List<Uri>, val context: Context,val clickListener: ClickListener) :
    RecyclerView.Adapter<ImageAdapter.ImageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false)
        return ImageHolder(view,clickListener)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        Log.d("adapter", "adapter")
        holder.setImage(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ImageHolder(itemView: View, private val clickListener: ClickListener) : RecyclerView.ViewHolder(itemView) {
        fun setImage(uri: Uri) {
            Picasso.get()
                .load(uri)
                .resize(400,200)
                .into(itemView.imageItem)

            itemView.imageItem.setOnClickListener {
                clickListener.onClick(uri)
            }
        }

    }
}