package com.example.databinding


import android.content.Intent
import android.os.Bundle
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
            if (binding.edtName.text?.isEmpty()!! || binding.edtEmail.text?.isEmpty()!! || binding.edtAge.text?.isEmpty()!! || binding.edtPassword.text?.isEmpty()!!) {
                Toast.makeText(this, "please enter the remaining field", Toast.LENGTH_SHORT).show()
            }
            if (!isEmailValid(binding.edtEmail.text.toString())) {
                Toast.makeText(
                    this,
                    "please enter the valid email",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this, HomeActivity::class.java)
                val registration=Registration(binding.edtName.text.toString(),
                    binding.edtAge.text.toString(),binding.edtEmail.text.toString()
                    ,binding.edtPassword.text.toString())
                intent.putExtra("data",registration)
                startActivity(intent)

            }
        }


    }

    fun isEmailValid(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }
}