package com.iroom.economy.data

import com.iroom.economy.data.money.Money.Companion.loadMoney
import com.iroom.economy.data.money.Money.Companion.saveMoney
import com.iroom.economy.shop.ShopItem.Companion.initItemList
import org.bukkit.Bukkit

class DataManager {
    companion object
    {
        fun saveData()
        {
            saveMoney("./DataBase/Money.mcdat")
            Bukkit.getConsoleSender().sendMessage("Saved Data!")
        }

        fun loadData()
        {
            loadMoney("./DataBase/Money.mcdat")
            initItemList()
            Bukkit.getConsoleSender().sendMessage("Loaded Data!")
        }
    }
}