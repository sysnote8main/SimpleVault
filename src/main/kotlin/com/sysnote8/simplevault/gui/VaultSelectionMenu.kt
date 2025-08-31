package com.sysnote8.simplevault.gui

import com.tksimeji.kunectron.ChestGui
import com.tksimeji.kunectron.element.Element
import com.tksimeji.kunectron.hooks.ChestGuiHooks
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player

@ChestGui
class VaultSelectionMenu(
    @ChestGui.Player private val player: Player,
) : ChestGuiHooks {
    @ChestGui.Element(index = [0])
    private val testButton =
        Element
            .item(Material.STICK)
            .sound(Sound.UI_BUTTON_CLICK)
            .handler { e -> player.sendMessage("You clicked test button!") }
}
