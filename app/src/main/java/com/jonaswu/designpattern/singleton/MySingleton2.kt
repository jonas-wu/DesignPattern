package com.jonaswu.designpattern.singleton

object MySingleton2 {
    private const val TAG = "MySingleton2"

    fun bar() {
        println("$TAG bar")
    }
}