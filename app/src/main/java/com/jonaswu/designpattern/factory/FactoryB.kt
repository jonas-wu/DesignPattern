package com.jonaswu.designpattern.factory

object FactoryB : Factory {
    override fun create(): Product {
        return ProductB()
    }
}