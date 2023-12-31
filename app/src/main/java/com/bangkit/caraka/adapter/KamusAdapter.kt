package com.bangkit.caraka.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bangkit.caraka.data.database.Kamus
import com.bangkit.caraka.databinding.ItemAksaraBinding
import com.bangkit.caraka.databinding.ItemHistoryBinding

class KamusAdapter(private val kamus: List<Kamus>) :
    RecyclerView.Adapter<KamusAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: ItemAksaraBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Kamus, position: Int) {
            binding.apply {
                ivItemAksara.load(item.aksara)
                tvItemLatin.text = item.latin

                binding.cardViewKamus.setOnClickListener {
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemAksaraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val materiKamus = kamus[position]
        holder.bind(materiKamus, position)
    }

    override fun getItemCount(): Int = kamus.size
}