package com.jonaswu.designpattern.prototype

class RealProduct : Product, Cloneable {
    override var desc: String = ""

    override fun show() {
        println(desc)
    }

    override fun copy(): Product {
        val p = super.clone() as Product
        p.desc = desc
        return p
    }
}