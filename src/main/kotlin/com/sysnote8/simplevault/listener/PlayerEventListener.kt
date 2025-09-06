package com.sysnote8.simplevault.listener

import com.sysnote8.simplevault.api.gui.InventoryGUIManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

class PlayerEventListener : Listener {
    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        InventoryGUIManager.remove(event.player)
    }
}
