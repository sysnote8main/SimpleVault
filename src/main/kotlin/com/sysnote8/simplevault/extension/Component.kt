package com.sysnote8.simplevault.extension

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer

fun ampersandText(msg: String): String = Component.text(msg).toAmpersand()

fun Component.toAmpersand(): String = LegacyComponentSerializer.legacyAmpersand().serialize(this)
