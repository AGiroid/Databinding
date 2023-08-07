package com.example.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private val homeBinding: ActivityHomeBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_home)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding.txt1.text = "HomeActivity!!"
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        homeBinding.txtName.text = sharedPreferences.getString("name","")
        homeBinding.txtAge.text = sharedPreferences.getString("age", "")
        homeBinding.txtEmail.text = sharedPreferences.getString("email", "")
        homeBinding.txtPassword.text = sharedPreferences.getString("password", "")
    }
}