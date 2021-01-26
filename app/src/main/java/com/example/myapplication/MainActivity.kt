package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import render.animations.Render
import render.animations.Zoom


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val render = Render(this)
        render.setAnimation(Zoom().In(txtPrincipal))
        render.setDuration(1400)
        render.start()

        val mHandler = Handler()
        mHandler.postDelayed(Runnable {
            startActivity(Intent(this, InicioActivity::class.java))
        }, 1600L)
    }
}