package com.sysnote8.simplevault.extension

import net.kyori.adventure.text.Component
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

fun ItemStack.lore(vararg components: Component) {
    lore(components.toList())
}

fun ItemStack.editMeta(applyFunc: ItemMeta.() -> Unit) {
    itemMeta = itemMeta.apply(applyFunc)
}
