package com.jonaswu.designpattern.factory

class ProductB : Product {
    companion object {
        private const val TAG = "ProductB"
    }

    override fun show() {
        println("$TAG show")
    }
}