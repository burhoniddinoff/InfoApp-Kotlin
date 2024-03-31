package com.example.infoapp.presenter.screen

import android.graphics.Color
import android.os.Bundle
import android.system.Os.bind
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.infoapp.R
import com.example.infoapp.databinding.ActivitySplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : Fragment(R.layout.activity_splash) {

    private val binding by viewBinding(ActivitySplashBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val animationView = binding.animationView
        animationView.setAnimation("splash_animation.json")
        animationView.playAnimation()

        lifecycleScope.launch {
            delay(2000)
            findNavController().navigate(SplashScreenDirections.actionSplashScreenToAllClubScreen())
        }

        requireActivity().window.statusBarColor = Color.WHITE

    }

}