package com.example.databinding


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.txt1.text = "Registration!!"
        binding.btnRegister.setOnClickListener {
            if (binding.txtName.text?.isEmpty()!! || binding.txtEmail.text?.isEmpty()!! || binding.txtAge.text?.isEmpty()!! || binding.txtPassword.text?.isEmpty()!!) {
                Toast.makeText(this, "please enter the remaining field", Toast.LENGTH_SHORT).show()
            }
            if (!isEmailValid(binding.txtEmail.text.toString())) {
                Toast.makeText(
                    this,
                    "please enter the valid email",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this, HomeActivity::class.java)
                val sharedPreferences: SharedPreferences =
                    getSharedPreferences("MySharedPref", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("name", binding.txtName.text.toString())
                editor.putString("age", binding.txtAge.text.toString())
                editor.putString("email", binding.txtEmail.text.toString())
                editor.putString("password", binding.txtPassword.text.toString())
                editor.apply()
                Log.d("saved",sharedPreferences.toString())
                startActivity(intent)

            }
        }


    }

    fun isEmailValid(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }
}