package com.example.databinding

import java.io.Serializable


data class Registration
    (
    var name: String = "",
    var age: String = "",
    var email: String = "",
    var password: String = ""): Serializable