package com.jonaswu.designpattern.factory

class ProductA : Product {
    companion object {
        private const val TAG = "ProductA"
    }

    override fun show() {
        println("$TAG show")
    }
}