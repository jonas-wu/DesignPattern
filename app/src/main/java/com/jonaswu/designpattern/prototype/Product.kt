package com.jonaswu.designpattern.prototype

interface Product {
    var desc:String
    fun show()
    fun copy(): Product
}