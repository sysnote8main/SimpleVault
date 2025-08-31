package com.sysnote8.simplevault.command

import com.mojang.brigadier.tree.LiteralCommandNode
import com.sysnote8.simplevault.gui.VaultSelectionMenu
import com.tksimeji.kunectron.Kunectron
import io.papermc.paper.command.brigadier.CommandSourceStack
import io.papermc.paper.command.brigadier.Commands
import io.papermc.paper.command.brigadier.Commands.literal
import io.papermc.paper.plugin.lifecycle.event.registrar.ReloadableRegistrarEvent
import org.bukkit.entity.Player

object SimpleVaultCommands {
    val VAULT: LiteralCommandNode<CommandSourceStack> =
        literal("vault")
            .executes { ctx ->
                val player = ctx.source.executor
                if (player !is Player) return@executes 0

                Kunectron.create(VaultSelectionMenu(player))
                return@executes 1
            }.build()

    fun register(event: ReloadableRegistrarEvent<Commands>) {
        event.registrar().apply {
            register(VAULT)
        }
    }
}
