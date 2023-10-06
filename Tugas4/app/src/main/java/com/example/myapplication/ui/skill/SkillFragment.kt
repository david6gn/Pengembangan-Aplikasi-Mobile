package com.example.myapplication.ui.skill

import helper.ConstantUtil
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
    lateinit var itemAdapter: SkillAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSkillBinding.inflate(inflater, container, false)
        createRecyclerView()
        createSearchView()

        return binding.root
    }

    private fun createRecyclerView () {
        val recyclerView: RecyclerView = binding.recycleview
        val skillList: ArrayList<Skills> = ConstantUtil.getSkillData(this)
        itemAdapter = SkillAdapter(skillList) {
            navigateDetail(it)
        }
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemAdapter
    }

    private fun createSearchView () {
        val searchView: SearchView = binding.searchBar

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(p0: String?): Boolean {
                itemAdapter.filter.filter(p0)
                return false
            }
        })
    }

    private fun navigateDetail(extraName: String) {
        val bundle= bundleOf(
            SkillFragmentDetails.EXTRA_NAME to extraName
        )
        findNavController().navigate(R.id.action_nav_skill_to_details,bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}