package com.jonaswu.designpattern.factory

object FactoryA : Factory {
    override fun create(): Product {
        return ProductA()
    }
}