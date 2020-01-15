package com.jonaswu.designpattern

import com.jonaswu.designpattern.adpater.DBSocketImpl
import com.jonaswu.designpattern.adpater.GBSocketImpl
import com.jonaswu.designpattern.adpater.Hotel
import com.jonaswu.designpattern.adpater.SocketAdapter
import com.jonaswu.designpattern.builder.Computer
import com.jonaswu.designpattern.factory.FactoryA
import com.jonaswu.designpattern.factory.FactoryB
import com.jonaswu.designpattern.observer.ObserverA
import com.jonaswu.designpattern.observer.ObserverB
import com.jonaswu.designpattern.observer.SubjectImpl
import com.jonaswu.designpattern.prototype.ProductA
import com.jonaswu.designpattern.prototype.ProductB
import com.jonaswu.designpattern.prototype.ProductManager
import com.jonaswu.designpattern.proxy.MyProxy
import com.jonaswu.designpattern.singleton.MySingleton

class Main {
    companion object {
        @JvmStatic
        fun main(vararg args: String) {
            val obj = Main()
            obj.observerDemo()
        }
    }

    fun singletonDemo() {
        MySingleton.get().foo()
    }

    fun factoryDemo() {
        FactoryA.create().show()
        FactoryB.create().show()
    }

    fun prototypeDemo() {
        val manager = ProductManager()
        manager.register("product-a", ProductA())
        manager.register("product-b", ProductB())

        val p = manager.create("product-a")
        p?.show()

        val p2 = manager.create("product-b")
        p2?.show()
    }

    fun builderDemo() {
        Computer.Builder()
            .setCpu("amd")
            .setMainboard("ABC")
            .build().show()
    }

    fun adapterDemo() {
        val hotel = Hotel(DBSocketImpl())
        hotel.charge()

        val hotel2 = Hotel(SocketAdapter(GBSocketImpl()))
        hotel2.charge()
    }

    fun proxyDemo() {
        val subject = MyProxy()
        subject.buyMac()
    }

    fun observerDemo() {
        val subject = SubjectImpl("hello")

        val observerA = ObserverA()
        subject.registerListener(observerA)
        subject.notify(observerA)

        val observerB = ObserverB()
        subject.registerListener(observerB)
        subject.notifyAllObservers()
    }
}