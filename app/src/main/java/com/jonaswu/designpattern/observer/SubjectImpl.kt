package com.jonaswu.designpattern.observer

class SubjectImpl(var data: String) : Subject {
    private val observers: MutableList<Observer> = mutableListOf()

    override fun registerListener(observer: Observer) {
        if (!observers.contains(observer))
            observers.add(observer)
    }

    override fun removeListener(observer: Observer) {
        if (observers.contains(observer))
            observers.remove(observer)
    }

    override fun notify(observer: Observer) {
        observer.update(data)
    }

    override fun notifyAllObservers() {
        observers.forEach { it.update(data) }
    }
}