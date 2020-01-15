package com.jonaswu.designpattern.proxy

class RealSubject : Subject {
    override fun buyMac() {
        println("买一台MAC")
    }
}