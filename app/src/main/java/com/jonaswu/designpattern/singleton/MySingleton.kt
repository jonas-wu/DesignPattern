package com.jonaswu.designpattern.singleton

class MySingleton private constructor(){
    companion object {
        private const val TAG = "MySingleton"

        private var instance : MySingleton? = null
            get() {
                if (field == null) {
                    synchronized(this) {
                        if (field == null)
                            field = MySingleton()
                    }
                }
                return field
            }

        fun get(): MySingleton {
            return instance!!
        }
    }

    fun foo() {
        println("$TAG foo")
    }
}