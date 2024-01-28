package com.example.shiftapplicationrmvl.ui.users

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModelProvider
import com.example.shiftapplicationrmvl.databinding.FragmentUsersBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class UsersFragment : Fragment() {

    private var _binding:FragmentUsersBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var usersViewModelFactory:ViewModelProvider.Factory

    private val usersViewModel:UsersViewModel by createViewModelLazy(
        UsersViewModel::class,
        {this.viewModelStore},
        factoryProducer = {usersViewModelFactory}
    )

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        usersViewModel.getRandomUser()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}