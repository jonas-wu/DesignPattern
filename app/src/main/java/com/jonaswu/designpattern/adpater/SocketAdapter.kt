package com.jonaswu.designpattern.adpater

class SocketAdapter(private val gbSocket: GBSocket) : DBSocket {
    override fun poweredByTwoRound() {
        gbSocket.poweredByThreeFlat()
    }
}