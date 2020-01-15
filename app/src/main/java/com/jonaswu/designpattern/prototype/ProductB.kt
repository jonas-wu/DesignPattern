package com.jonaswu.designpattern.prototype

class ProductB : Product {
    companion object {
        private const val TAG = "ProductB"
    }

    override fun show() {
        println("$TAG show")
    }

    override fun create(): Product {
        return ProductB()
    }
}