package com.example.daftaranime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class ListAnimeAdapter(private val listAnime:ArrayList<anime>) : RecyclerView.Adapter<ListAnimeAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallBack: OnItemClickCallBack

    fun setOnItemClickCallback(onItemClickCallBack: OnItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_anime, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listAnime.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (judul, deskripsi, foto) = listAnime[position]

        Glide.with(holder.itemView.context)
            .load(foto)
            .apply(RequestOptions().override(55,55))
            .into(holder.gbranime)
        holder.tvJudul.text = judul
        holder.tvDeskrip.text = deskripsi

        holder.itemView.setOnClickListener {
            onItemClickCallBack.onItemClicked(listAnime[holder.adapterPosition])
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvJudul: TextView = itemView.findViewById(R.id.judul)
        var tvDeskrip: TextView = itemView.findViewById(R.id.deskripsi)
        var gbranime: ImageView = itemView.findViewById(R.id.gambar_anime)
    }

    interface OnItemClickCallBack {
        fun onItemClicked(data: anime)
    }

}