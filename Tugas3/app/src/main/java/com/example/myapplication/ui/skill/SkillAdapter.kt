package com.example.myapplication.ui.skill

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemSkillBinding
import java.util.Locale


class SkillAdapter(private var data: ArrayList<Skills>): RecyclerView.Adapter<SkillAdapter.ViewHolder>(), Filterable {
    private var onClickListener: OnClickListener? = null
    private var SkillListOriginal: ArrayList<Skills> = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemSkillBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val query = p0.toString().lowercase(Locale.getDefault())
                val filteredList = if (query.isEmpty()) {
                    SkillListOriginal
                } else {
                    SkillListOriginal.filter { skills ->
                        skills.txtskill.lowercase(Locale.getDefault()).contains(query)
                    }
                }
                val results = FilterResults()
                results.values = filteredList
                return results
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                data = p1?.values as ArrayList<Skills>
                notifyDataSetChanged()
            }
        }
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
        val temp = data
        return temp.size
    }

    class ViewHolder (binding: ItemSkillBinding): RecyclerView.ViewHolder(binding.root) {
        val img = binding.imgView
        val txt = binding.skillView

    }


}