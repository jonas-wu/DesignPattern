package com.jonaswu.designpattern.adpater

class Hotel(private val dbSocket: DBSocket) {
    fun charge() {
        dbSocket.poweredByTwoRound()
    }
}