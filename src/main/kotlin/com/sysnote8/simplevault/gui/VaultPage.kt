package com.sysnote8.simplevault.gui

import com.sysnote8.simplevault.holder.InvDataRepresentation
import dev.felnull.bettergui.core.InventoryGUI

class VaultPage(
    gui: InventoryGUI,
    val invData: InvDataRepresentation,
) : GUIPageBase(gui, "Vault GUI (page ?)", 6) {
    override fun setUp() {
        invData.slotData.forEach { slot, stack ->
            setItem(slot, stack)
        }
    }

    override fun back() {}

    override fun close() {
        super.close()
        invData.slotData = getInventoryAsMap().toMutableMap()
    }
}
