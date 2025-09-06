package com.sysnote8.simplevault.extension

import com.sysnote8.simplevault.api.gui.InventoryGUIManager
import dev.felnull.bettergui.core.InventoryGUI
import org.bukkit.entity.Player

val Player.currentInventory: InventoryGUI
    get() = InventoryGUIManager.get(this)
