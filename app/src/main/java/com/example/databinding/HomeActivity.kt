package com.example.databinding

import android.os.Bundle
import android.widget.Toast
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
        //Parceable
//       val receivedData = intent.getParcelableExtra<Registration>("data")
//        homeBinding.registration = receivedData

        //Serializable
        val receivedData = intent.getSerializableExtra("data") as? Registration
        if (receivedData != null) {
            // Data received successfully, use receivedData
            homeBinding.registration = receivedData
        } else {
            // Handle the case where casting failed
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show()
        }

    }
}