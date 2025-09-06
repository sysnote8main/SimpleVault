package com.sysnote8.simplevault.holder

import org.bukkit.inventory.ItemStack
import java.util.concurrent.atomic.AtomicBoolean

data class InvDataRepresentation(
    var slotData: MutableMap<Int, ItemStack?> = mutableMapOf(),
    val isEditing: AtomicBoolean = AtomicBoolean(),
)
