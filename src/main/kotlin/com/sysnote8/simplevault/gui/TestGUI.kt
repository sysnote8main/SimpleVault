package com.sysnote8.simplevault.gui

import com.sysnote8.simplevault.extension.lore
import dev.felnull.bettergui.core.InventoryGUI
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class TestGUI(
    gui: InventoryGUI,
) : GUIPageBase(
        gui,
        "test",
        3,
    ) {
    override fun setUp() {
        setItem(13, ItemStack(Material.STICK))
        val testStack =
            ItemStack(Material.STONE).apply {
                lore(
                    Component.text("AAA"),
                )
            }
    }

    override fun back() {
    }

    override fun getInventory(): Inventory = inventory
}
