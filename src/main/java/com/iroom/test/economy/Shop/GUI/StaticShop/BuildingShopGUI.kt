package com.iroom.test.economy.Shop.GUI.StaticShop

import com.iroom.test.economy.Shop.GUI.StaticShop.StaticShopGUI.Companion.createStaticShopItem
import com.iroom.test.economy.Shop.GUI.StaticShop.StaticShopGUI.Companion.openStaticShopGui
import com.iroom.test.economy.Shop.Shop
import com.iroom.test.economy.Shop.Shop.Companion.createGuiItem
import com.iroom.test.economy.Shop.Shop.Companion.createShopItem
import com.iroom.test.economy.Shop.Shop.Companion.openInventory
import com.iroom.test.economy.Shop.ShopItem
import com.iroom.test.economy.Shop.ShopItem.Companion.ItemList
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

class BuildingShopGUI {
    companion object
    {
        fun openBuildingShopGui(player: Player,page:Int) {
            openInventory(player,setBuildingShopGui(page))
        }

        fun setBuildingShopGui(page:Int): Inventory {
            val inv = Bukkit.createInventory(null,54,"건축블록 상점")
            when(page)
            {
                1->
                {
                    for(i:Int in 0..44)
                    {
                        val item = ItemList[i+(page-1)*45]
                        if(i+(page-1)*45 < ShopItem.NumberOfBuildingBlock)
                        inv.setItem(
                            i,
                            createStaticShopItem(item)
                        )
                    }

                    inv.setItem(
                        45,
                        createGuiItem(
                            Material.FEATHER,
                            "이전페이지"
                        )
                    )

                    inv.setItem(
                        48,
                        createGuiItem(
                            Material.BOOK,
                            "1"
                        )
                    )
                    inv.setItem(
                        49,
                        createGuiItem(
                            Material.BARRIER,
                            "뒤로가기"
                        )
                    )
                    inv.setItem(
                        53,
                        createGuiItem(
                            Material.FEATHER,
                            "다음페이지"
                        )
                    )
                }

                2->
                {
                    for(i:Int in 0..44)
                    {
                        val item = ItemList[i+(page-1)*45]
                        if(i+(page-1)*45 < ShopItem.NumberOfBuildingBlock)
                            inv.setItem(
                                i,
                                createStaticShopItem(item)
                            )
                    }

                    inv.setItem(
                        45,
                        createGuiItem(
                            Material.FEATHER,
                            "이전페이지"
                        )
                    )
                    inv.setItem(
                        48,
                        createGuiItem(
                            Material.BOOK,
                            "2"
                        )
                    )
                    inv.setItem(
                        49,
                        createGuiItem(
                            Material.BARRIER,
                            "뒤로가기"
                        )
                    )
                    inv.setItem(
                        53,
                        createGuiItem(
                            Material.FEATHER,
                            "다음페이지"
                        )
                    )
                }
                3->
                {
                    for(i:Int in 0..44)
                    {
                        val item = ItemList[i+(page-1)*45]
                        if(i+(page-1)*45 < ShopItem.NumberOfBuildingBlock)
                            inv.setItem(
                                i,
                                createStaticShopItem(item)
                            )
                    }

                    inv.setItem(
                        45,
                        createGuiItem(
                            Material.FEATHER,
                            "이전페이지"
                        )
                    )
                    inv.setItem(
                        48,
                        createGuiItem(
                            Material.BOOK,
                            "3"
                        )
                    )
                    inv.setItem(
                        49,
                        createGuiItem(
                            Material.BARRIER,
                            "뒤로가기"
                        )
                    )
                    inv.setItem(
                        53,
                        createGuiItem(
                            Material.FEATHER,
                            "다음페이지"
                        )
                    )
                }
            }
            return inv
        }

        fun getDecorationShopPage(inv:Inventory): Int?
        {
            val pageitem = inv.getItem(48)
            return pageitem?.itemMeta?.displayName?.toInt()
        }

        fun clickBuildingShopGui(player:Player,slot:Int,page:Int)
        {
            when(page)
            {
                1->
                    when(slot)
                    {
                        49->openStaticShopGui(player)
                        53->openBuildingShopGui(player,page+1)
                        else->return
                    }
                2->
                    when(slot)
                    {
                        45-> openBuildingShopGui(player,page-1)
                        49-> openStaticShopGui(player)
                        53-> openBuildingShopGui(player,page+1)
                        else->return
                    }
                3->
                    when(slot)
                    {
                        45-> openBuildingShopGui(player,page-1)
                        49-> openStaticShopGui(player)
                        else->return
                    }
                else->return
            }
        }
    }
}