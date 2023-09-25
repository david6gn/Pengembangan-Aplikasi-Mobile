package com.example.myapplication.ui.skill

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemSkillBinding


class SkillAdapter(private val data: ArrayList<Skills>): RecyclerView.Adapter<SkillAdapter.ViewHolder>() {
    private var onClickListener: OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemSkillBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = data[position]
        holder.txt.text = current.txtskill
        holder.img.setImageResource(current.imgview)
        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, current)
            }
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, model: Skills)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder (binding: ItemSkillBinding): RecyclerView.ViewHolder(binding.root) {
        val img = binding.imgView
        val txt = binding.skillView

    }


}