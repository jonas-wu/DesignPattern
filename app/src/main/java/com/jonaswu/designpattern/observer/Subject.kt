package com.jonaswu.designpattern.observer

interface Subject {
    fun registerListener(observer: Observer)
    fun removeListener(observer: Observer)
    fun notify(observer: Observer)
    fun notifyAllObservers()
}