package com.example.shiftapplicationrmvl.ui.details

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.shiftapplicationrmvl.R
import com.example.shiftapplicationrmvl.data.User
import com.example.shiftapplicationrmvl.data.converter.Converter
import com.example.shiftapplicationrmvl.databinding.FragmentDetailsBinding
import dagger.android.support.AndroidSupportInjection


class DetailsFragment : Fragment() {

    private var _binding:FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val args:DetailsFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val user = Converter().fromJson(data = args.user)

        Glide.with(binding.detailsPicture).load(user?.picture?.largeUrl).into(binding.detailsPicture)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}