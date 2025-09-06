package com.sysnote8.simplevault

import com.sysnote8.simplevault.extension.registerEvents
import com.sysnote8.simplevault.listener.PlayerEventListener
import org.bukkit.plugin.java.JavaPlugin

class SimpleVault : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        plLogger.info("Starting $PL_NAME (${PL_VERSION})")
        registerEvents(
            PlayerEventListener(),
        )
    }

    override fun onDisable() {
        // Plugin shutdown logic
        plLogger.info("See you!")
    }

    companion object {
        private val plLogger by DelegatedLogger()
    }
}
