package com.example.jetpackdemo

interface SuccessAPICallback<T> {
    fun onResponse(t: T)
}