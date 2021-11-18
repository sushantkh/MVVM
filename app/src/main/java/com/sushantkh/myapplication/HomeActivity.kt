package com.sushantkh.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sushantkh.myapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCompose.setOnClickListener { startActivity(Intent(this,ComposeMainActivity::class.java)) }
        binding.btnViews.setOnClickListener { startActivity(Intent(this,MainActivity::class.java)) }

    }
}