package com.example.myapplication.ui.skill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSkillBinding


class SkillFragment : Fragment() {
    private var _binding: FragmentSkillBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_skill, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var skillList: ArrayList<Skills> = constant.getskilldata()
        val itemAdapter = SkillAdapter(skillList)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycleview)
        val searchView: SearchView = view.findViewById(R.id.search_bar)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                itemAdapter.filter.filter(p0)
                return true
            }
        })

        itemAdapter.setOnClickListener(object : SkillAdapter.OnClickListener{
            override fun onClick(position: Int, model: Skills) {
                val bundle= bundleOf(
                    SkillFragmentDetails.EXTRA_NAME to model.txtskill
                )
                findNavController().navigate(R.id.action_nav_skill_to_details,bundle)
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}