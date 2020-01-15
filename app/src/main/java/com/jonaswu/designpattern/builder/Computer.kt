package com.jonaswu.designpattern.builder

class Computer private constructor() {
    private var cpu: String? = null
    private var mainBoard: String? = null

    class Builder {
        private val computer = Computer()

        fun setCpu(cpu: String): Builder {
            computer.cpu = cpu
            return this
        }

        fun setMainboard(mainBoard: String): Builder {
            computer.mainBoard = mainBoard
            return this
        }

        fun build(): Computer {
            return computer
        }
    }

    fun show() {
        println("$TAG cpu=$cpu mainBoard=$mainBoard")
    }

    companion object {
        private const val TAG = "Computer"
    }
}