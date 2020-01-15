package com.jonaswu.designpattern.prototype

class ProductA : Product {
    companion object {
        private const val TAG = "ProductA"
    }

    override fun show() {
        println("$TAG show")
    }

    override fun create(): Product {
        return ProductA()
    }
}