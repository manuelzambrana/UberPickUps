package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_splash_screen.*
import render.animations.Render
import render.animations.Zoom


class SplashScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        Handler().postDelayed({
            if (onBoardingFinished()){
                findNavController().navigate(R.id.action_splashScreen_to_inicioActivity)
            }else{
                findNavController().navigate(R.id.action_splashScreen_to_viewPagerFragment)
            }

        }, 1600)

        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val render = Render(requireActivity())
        render.setAnimation(Zoom().In(txtPrincipal))
        render.setDuration(1400)
        render.start()

    }

    private  fun onBoardingFinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return  sharedPref.getBoolean("Finished",false)
    }
}