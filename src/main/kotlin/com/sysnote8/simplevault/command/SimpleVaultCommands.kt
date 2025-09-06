package com.sysnote8.simplevault.command

import com.mojang.brigadier.tree.LiteralCommandNode
import com.sysnote8.simplevault.extension.currentInventory
import com.sysnote8.simplevault.gui.VaultPage
import com.sysnote8.simplevault.gui.VaultSelectionMenu
import com.sysnote8.simplevault.holder.InvDataRepresentation
import com.tksimeji.kunectron.Kunectron
import io.papermc.paper.command.brigadier.CommandSourceStack
import io.papermc.paper.command.brigadier.Commands
import io.papermc.paper.command.brigadier.Commands.literal
import io.papermc.paper.plugin.lifecycle.event.registrar.ReloadableRegistrarEvent
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object SimpleVaultCommands {
    val VAULT: LiteralCommandNode<CommandSourceStack> =
        literal("vault")
            .executes { ctx ->
                val player = ctx.source.executor
                if (player !is Player) return@executes 0

                Kunectron.create(VaultSelectionMenu(player))
                return@executes 1
            }.then(
                literal("open-debug").executes { ctx ->
                    val player = ctx.source.executor
                    if (player !is Player) return@executes 0

                    player.currentInventory.also { inv ->
                        inv.openPage(VaultPage(inv, getFakeInvData()))
                    }
                    return@executes 1
                },
            ).build()

    fun getFakeInvData(): InvDataRepresentation {
        val invData = InvDataRepresentation()
        invData.slotData.also {
            for (slotId in 0..26) {
                it.put(slotId, ItemStack(Material.BOW))
            }
        }

        return invData
    }

    fun register(event: ReloadableRegistrarEvent<Commands>) {
        event.registrar().apply {
            register(VAULT)
        }
    }
}
