package com.example.upworksample.ui.user.profile.settings

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.example.upworksample.R
import com.example.upworksample.dagger.App
import com.example.upworksample.dagger.module.viewModule.ViewModelFactory
import com.example.upworksample.databinding.SettingsFragmentBinding
import com.example.upworksample.ui.user.profile.ProfileViewModel
import com.example.upworksample.utils.SHARED_KEY
import javax.inject.Inject

class SettingsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: ProfileViewModel by navGraphViewModels(R.id.user) { viewModelFactory }
    private lateinit var binding: SettingsFragmentBinding

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.appComponent.inject(this)

        binding = SettingsFragmentBinding.inflate(inflater)
        sharedPreferences = activity?.getSharedPreferences(SHARED_KEY, Context.MODE_PRIVATE)!!
        editor = sharedPreferences.edit()
        binding.btnSingOut.setOnClickListener {
            viewModel.authUser.value?.signOut()
            viewModel.testTrue()

            editor.putString(SHARED_KEY, "null")
            editor.commit();

        }



        return binding.root
    }
}
