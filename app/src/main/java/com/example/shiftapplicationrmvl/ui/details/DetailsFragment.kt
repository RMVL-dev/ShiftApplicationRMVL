package com.example.shiftapplicationrmvl.ui.details

import android.content.Context
import android.content.Intent
import android.net.Uri
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
import com.example.shiftapplicationrmvl.helpers.dateConverter
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
        infoFilling(user = user)
        setClickListeners(user = user)
    }

    private fun infoFilling(user: User?){
        Glide.with(binding.detailsPicture).load(user?.picture?.largeUrl).into(binding.detailsPicture)
        binding.detailsFirstname.text = "${user?.name?.title} ${user?.name?.firstName}"
        binding.detailsLastname.text = user?.name?.lastName
        binding.detailsGender.text = user?.gender
        binding.detailsNational.text = user?.national
        binding.detailsPhoneNumber.text = "phone: ${user?.phoneNumber}"
        binding.detailsCell.text = "another number: ${user?.cellNumber}"
        binding.detailsEmail.text = "email: ${user?.email}"
        binding.detailsAddressCountry.text = user?.location?.country
        binding.detailsAddressState.text = user?.location?.state
        binding.detailsAddressStreet.text = user?.location?.street?.name
        binding.detailsAddressNumber.text = user?.location?.street?.number.toString()
        binding.detailsAddressPostcode.text = user?.location?.postcode
        binding.detailsDataOfBirthday.text = "Birthday: ${user?.dateOfBirthday?.date?.let { dateConverter(it) }}"
        binding.detailsAge.text = "age: ${user?.dateOfBirthday?.age}"
        binding.detailsRegisteredDate.text = "Registered: ${user?.registerDate?.date?.let { dateConverter(it) }}"
        binding.detailsRegisteredAge.text = "age: ${user?.registerDate?.age}"

    }

    private fun setClickListeners(user: User?){
        binding.detailsPhoneNumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
                .setData(Uri.parse("tel:${user?.phoneNumber?.trim()}"))
            startActivity(intent)
        }
        binding.detailsCell.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
                .setData(Uri.parse("tel:${user?.cellNumber?.trim()}"))
            startActivity(intent)
        }

        binding.detailsEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, user?.email)
            }
            startActivity(intent)
        }

        binding.detailsAddressCountry.setOnClickListener {
            mapIntent(user = user)
        }

        binding.detailsAddressState.setOnClickListener {
            mapIntent(user = user)
        }

        binding.detailsAddressStreet.setOnClickListener {
            mapIntent(user = user)
        }
        binding.detailsAddressNumber.setOnClickListener {
            mapIntent(user = user)
        }
    }

    private fun mapIntent(user:User?){
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("geo:${user?.location?.coordinates?.latitude},${user?.location?.coordinates?.longitude}")
        }
        startActivity(intent)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}