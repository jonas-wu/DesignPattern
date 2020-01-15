package com.jonaswu.designpattern.prototype

class ProductManager {
    private val productMap: MutableMap<String, Product> = mutableMapOf()

    fun register(name: String, product: Product) {
        productMap[name] = product
    }

    fun create(name: String): Product? {
        val product = productMap[name]
        return product?.create()
    }
}