package com.khoirullatif.navigationapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.navigation.findNavController
import com.khoirullatif.navigationapp.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!
    private var nameLifestyle = ""
    private val TAG = "CategoryFragment"

    companion object {
        val EXTRA_NAME = "extra_name"
        val EXTRA_DESC = "extra_desc"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_category, container, false)
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCategoryLifestyle.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (binding.rgLifestyle.checkedRadioButtonId){
            R.id.rb_makan -> nameLifestyle = binding.rbMakan.text.toString()
            R.id.rb_tidur -> nameLifestyle = binding.rbTidur.text.toString()
        }
        val bundle = Bundle()
        bundle.putString(EXTRA_NAME, nameLifestyle)
        bundle.putLong(EXTRA_DESC, 9)
        p0?.findNavController()?.navigate(R.id.action_categoryFragment_to_detailCategoryFragment, bundle)

    }

}