package com.jonaswu.designpattern.observer

class ObserverA : Observer {
    override fun update(data: String) {
        println("ObserverA update $data")
    }
}