package com.sysnote8.simplevault.extension

import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

fun JavaPlugin.registerEvents(vararg listeners: Listener) {
    listeners.forEach { server.pluginManager.registerEvents(it, this) }
}
