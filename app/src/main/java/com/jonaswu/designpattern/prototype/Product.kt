package com.jonaswu.designpattern.prototype

interface Product {
    fun show()
    fun create(): Product
}