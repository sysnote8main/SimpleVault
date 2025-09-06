package com.sysnote8.simplevault

import org.bukkit.plugin.java.JavaPlugin

internal const val PL_NAME = "Simple Vault"
internal const val PL_ID = "simplevault"

internal val PL_VERSION: String
    get() = instance.pluginMeta.version

internal val instance: SimpleVault
    get() = JavaPlugin.getPlugin(SimpleVault::class.java)
