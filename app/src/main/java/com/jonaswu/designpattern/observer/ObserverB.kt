package com.jonaswu.designpattern.observer

class ObserverB : Observer {
    override fun update(data: String) {
        println("ObserverB update $data")
    }
}