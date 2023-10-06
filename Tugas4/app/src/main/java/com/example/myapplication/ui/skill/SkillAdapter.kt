package com.example.myapplication.ui.skill

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemSkillBinding
import java.util.Locale


class SkillAdapter(private var data: ArrayList<Skills>, val onClickItemListener: (string: String) -> Unit): RecyclerView.Adapter<SkillAdapter.ViewHolder>(), Filterable {
    private var skillListOriginal: ArrayList<Skills> = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemSkillBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val query = p0.toString().lowercase(Locale.getDefault())
                val filteredList = if (query.isEmpty()) {
                    skillListOriginal
                } else {
                    skillListOriginal.filter { skills ->
                        skills.txtSkill.lowercase(Locale.getDefault()).contains(query)
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
        holder.txt.text = current.txtSkill
        holder.img.setImageResource(current.imgView)
        holder.itemView.setOnClickListener {
            onClickItemListener(current.txtSkill)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder (binding: ItemSkillBinding): RecyclerView.ViewHolder(binding.root) {
        val img = binding.imgView
        val txt = binding.skillView
    }
}