package com.example.myapplication.ui.skill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentSkillDetailsBinding

class SkillFragmentDetails : Fragment() {
    private var _binding: FragmentSkillDetailsBinding?=null
    private val binding get()=_binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSkillDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    companion object {
        var EXTRA_NAME="extra_name"
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            val name=arguments?.getString(EXTRA_NAME)
            binding?.textDetail?.text= "Ini Bahasa Pemrograman $name"
        }

    }

}