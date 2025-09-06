package com.sysnote8.simplevault.gui

import com.sysnote8.simplevault.extension.ampersandText
import com.sysnote8.simplevault.extension.toSlots
import dev.felnull.bettergui.core.GUIPage
import dev.felnull.bettergui.core.InventoryGUI
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

abstract class GUIPageBase(
    gui: InventoryGUI,
    title: String,
    slotLines: Int,
) : GUIPage(
        gui,
        ampersandText(title),
        slotLines.toSlots(),
    ) {
    override fun getInventory(): Inventory = inventory

    fun getInventoryAsMap(): Map<Int, ItemStack?> = inventory.contents.withIndex().associate { it.index to it.value }
}
