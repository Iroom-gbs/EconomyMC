package com.iroom.test

import com.iroom.test.economy.Money.Companion.loadMoney
import com.iroom.test.economy.Money.Companion.saveMoney
import com.iroom.test.economy.Shop.ShopItem.Companion.initItemList
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