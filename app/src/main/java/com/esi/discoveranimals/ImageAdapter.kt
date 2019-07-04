package com.esi.discoveranimals

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ImageAdapter(private val list: List<Animal>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    companion object {
        var playing: MediaPlayer? = null

    }
    init {
        playing?.setOnCompletionListener { player -> player.release() }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder.creat(parent)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ImageViewHolder private constructor(private val parent: View) : RecyclerView.ViewHolder(parent) {
        private val image = parent.findViewById<ImageView>(R.id.image)
        private val name = parent.findViewById<TextView>(R.id.name)

        fun bind(animal: Animal) {
            name.text = animal.name
            Glide.with(parent.context)
                .load(animal.image)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_image))
                .into(image)

            image.setOnClickListener {
                val player = MediaPlayer()
                player.setDataSource(animal.sound)
                player.prepare()
                if (playing != null){
                    if ((playing as MediaPlayer).isPlaying) {
                        playing?.stop()
                        playing?.release()
                    }
                }
                playing = player
                playing?.start()
            }
        }


        companion object {
            fun creat(parent: ViewGroup): ImageViewHolder {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item, parent, false)
                return ImageViewHolder(itemView)
            }
        }
    }
}