package com.example.sontbv.base_mvp_sample.ui.list

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.sontbv.base_mvp_sample.R
import com.example.sontbv.base_mvp_sample.data.db.model.Photo
import com.example.sontbv.base_mvp_sample.ui.photo_detail.PhotoDetailActivity
import com.example.sontbv.base_mvp_sample.widget.SquareImage
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text

class ListAdapter(): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private lateinit var listener: ListAdapter.onItemClickListener
    private lateinit var photos: MutableList<Photo>
    private lateinit var context: Context
    private val TAG = "ListAdapter"

    constructor(context: Context, photos: MutableList<Photo>,
                fragment: Fragment) : this() {
        this.listener = fragment as onItemClickListener
        this.context = context
        this.photos = photos
    }

    inner class ListViewHolder : RecyclerView.ViewHolder {
        var username: TextView
        var photo: SquareImage
        var userAvatar: CircleImageView
        var itemLayout: FrameLayout

        constructor(viewHolder: View): super(viewHolder){
            username = viewHolder.findViewById(R.id.item_photo_username)
            photo = viewHolder.findViewById(R.id.item_photo_photo)
            userAvatar = viewHolder.findViewById(R.id.item_photo_user_avatar)
            itemLayout = viewHolder.findViewById(R.id.item_photo_layout)
            itemLayout.setOnClickListener {
                val position = getAdapterPosition()

                val photoId = photos.get(position).id
                val intent = Intent(context, PhotoDetailActivity::class.java)
                intent.putExtra("photoId", photoId)
                context.startActivity(intent)
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_photo, parent, false)
        return ListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val photo = photos.get(position)
        holder.username.text = photo.user.username
        Log.d(TAG, photo.toString() + "")
        Glide
                .with(context)
                .load(photo.urls.regular)
                .into(holder.photo)
        Glide
                .with(context)
                .load(photo.user.profile_image.small)
                .into(holder.userAvatar)
    }

    interface onItemClickListener {
        fun itemDetail(photoId : String)
    }
}