package com.example.athena

import android.content.Intent

fun location(command: String): Intent {
    val ulogger = "net.fabiszewski.ulogger"
    val intent = Intent("$ulogger.intent.action.COMMAND").apply {
        setPackage(ulogger)
        setClassName(ulogger, "$ulogger.ExternalCommandReceiver")
        putExtra("command", command)
    }
    return intent
}
