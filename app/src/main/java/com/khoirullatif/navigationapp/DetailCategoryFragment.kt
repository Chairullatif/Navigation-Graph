package com.khoirullatif.navigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khoirullatif.navigationapp.databinding.FragmentDetailCategoryBinding

class DetailCategoryFragment : Fragment() {

    private var _binding: FragmentDetailCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Get data dengan SafeArgs
        val dataName = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).name
        val dataDesc = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).level

        //Get data dengan bundle
//        val dataName = arguments?.getString(CategoryFragment.EXTRA_NAME)
//        val dataDesc = arguments?.getLong(CategoryFragment.EXTRA_DESC).toString()

        binding.tvCategoryName.text = dataName
        binding.tvCategoryDescription.text = "Level: $dataDesc"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}