package com.iroom.test

import com.iroom.test.DataManager.Companion.loadData
import com.iroom.test.DataManager.Companion.saveData
import com.iroom.test.economy.Shop.Shop
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

class Test : JavaPlugin() {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean
    {
        //서버 종료
        if(command.name == "safestop")
        {
            if(sender.name == "zlfn")
            {
                val command = "stop"
                Bukkit.dispatchCommand(Bukkit.getServer().consoleSender,command)
                return true
            }
        }

        //플러그인 저장
        if(command.name == "safesave")
        {
            if(sender.name == "zlfn")
            {
                saveData()
                return true
            }
        }

        //상점 주는 명령어 (테스트)
        if(command.name == "shop")
        {
            var shop = ItemStack(Material.NETHER_STAR)
            var meta = shop.itemMeta
            meta?.addEnchant(Enchantment.LUCK,1,true)
            meta?.setDisplayName("메뉴".plus(ChatColor.GOLD))
            meta?.addItemFlags(ItemFlag.HIDE_ENCHANTS)
            shop.itemMeta = meta
            val p = sender as Player
            p.inventory.addItem(shop)
            return true
        }
        return false
    }


    companion object
    {
        lateinit var instance:Test
    }

    override fun onEnable() {
        this.getCommand("safestop")
        this.getCommand("safesave")
        loadData()
        server.pluginManager.registerEvents(EvListener(),this)
        server.pluginManager.registerEvents(Shop(), this)
        instance = this
        logger.info("Loded!")
    }

    override fun onDisable() {
        saveData()
    }
}