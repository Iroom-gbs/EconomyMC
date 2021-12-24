package com.iroom.test.economy.Shop.GUI

import com.iroom.test.economy.Money.Companion.mutMoney
import com.iroom.test.economy.Money.Companion.setMoney
import com.iroom.test.economy.Shop.GUI.MenuGUI.Companion.openMenuGui
import com.iroom.test.economy.Shop.Shop.Companion.openInventory
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class DebugGUI {
    companion object
    {
        fun openDebugGui(player: Player)
        {
            openInventory(player, setDebugGui())
        }

        fun setDebugGui():Inventory
        {
            var inv:Inventory
            inv = Bukkit.createInventory(null,18,"디버그")
            inv.setItem(
                2,
                ItemStack(Material.RED_CONCRETE)
            )
            inv.setItem(
                3,
                ItemStack(Material.RED_CONCRETE_POWDER)
            )
            inv.setItem(
                4,
                ItemStack(Material.BLACK_CONCRETE)
            )
            inv.setItem(
                5,
                ItemStack(Material.GREEN_CONCRETE_POWDER)
            )
            inv.setItem(
                6,
                ItemStack(Material.GREEN_CONCRETE)
            )
            inv.setItem(
                17,
                ItemStack(Material.BARRIER)

            )
            return inv
        }

        fun clickDebugGui(player: Player, slot:Int)
        {
            when(slot)
            {
                2->
                {
                    if(mutMoney(player,-2000))
                    {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c-2000"))
                    }
                    else player.sendMessage("No Money!")
                }
                3->
                {
                    if(mutMoney(player,-1000))
                    {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c-1000"))
                    }
                    else player.sendMessage("No Money!")
                }
                4->
                {
                    setMoney(player,5000)
                    player.sendMessage("Clear Money!")
                }
                5->
                {
                    mutMoney(player,1000)
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a+1000"))
                }
                6->
                {
                    mutMoney(player,2000)
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a+2000"))
                }
                17->openMenuGui(player)
            }
        }
    }
}