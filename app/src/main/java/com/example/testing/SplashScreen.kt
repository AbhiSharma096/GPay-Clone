package com.example.testing

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import java.util.logging.Handler


class SplashScreen : Fragment() {


      override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
      ): View? {
            // Inflate the layout for this fragment
            requireActivity().window.statusBarColor = this.resources.getColor(R.color.black)
            val view = inflater.inflate(R.layout.fragment_splash_screen, container, false)

                val handler = android.os.Handler(Looper.getMainLooper())
                     handler.postDelayed({
                     findNavController().navigate(R.id.action_splashScreen_to_homeScreen)
                     }, 1000)


                return view




      }
}