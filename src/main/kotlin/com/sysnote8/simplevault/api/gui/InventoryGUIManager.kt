package com.sysnote8.simplevault.api.gui

import dev.felnull.bettergui.core.GUIPage
import dev.felnull.bettergui.core.InventoryGUI
import org.bukkit.entity.Player
import java.util.UUID

object InventoryGUIManager {
    private val playerGuiMap: MutableMap<UUID, InventoryGUI> = mutableMapOf()

    fun get(player: Player) = playerGuiMap.getOrPut(player.uniqueId) { InventoryGUI(player) }

    fun remove(player: Player) {
        playerGuiMap.remove(player.uniqueId)
    }
}
