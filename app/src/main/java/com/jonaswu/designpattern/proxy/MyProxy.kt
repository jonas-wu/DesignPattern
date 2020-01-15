package com.jonaswu.designpattern.proxy

class MyProxy : Subject {
    override fun buyMac() {
        val subject = RealSubject()
        subject.buyMac()
        wrapMac()
    }

    private fun wrapMac() {
        println("用盒子包装好Mac")
    }
}