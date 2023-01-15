package com.example.athena

import android.content.Intent

fun Location(command: String) {
    val ulogger = "net.fabiszewski.ulogger"
    val intent = Intent("$ulogger.intent.action.COMMAND").apply {
        setPackage(ulogger)
        setClassName(ulogger, "$ulogger.ExternalCommandReceiver")
        putExtra("command", command)
    }
}
