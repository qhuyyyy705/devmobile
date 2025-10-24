package com.example.manalibrary.model


data class Student(
    val name: String,
    val borrowedBooks: MutableList<String>
)
