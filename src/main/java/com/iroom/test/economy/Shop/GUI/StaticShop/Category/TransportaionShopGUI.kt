package com.iroom.test.economy.Shop.GUI.StaticShop.Category

import com.iroom.test.economy.Shop.GUI.StaticShop.StaticShopGUI.Companion.createStaticShopItem
import com.iroom.test.economy.Shop.GUI.StaticShop.StaticShopGUI.Companion.openStaticShopGui
import com.iroom.test.economy.Shop.Shop.Companion.createGuiItem
import com.iroom.test.economy.Shop.Shop.Companion.openInventory
import com.iroom.test.economy.Shop.ShopItem.Companion.ItemList
import com.iroom.test.economy.Shop.ShopItem.Companion.NumberOfBuildingBlock
import com.iroom.test.economy.Shop.ShopItem.Companion.NumberOfDecorationBlock
import com.iroom.test.economy.Shop.ShopItem.Companion.NumberOfRedStoneBlock
import com.iroom.test.economy.Shop.ShopItem.Companion.NumberOfTransportaionBlock
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

class TransportaionShopGUI {
    companion object
    {
        fun openTransportationShopGui(player: Player,page:Int) {
            openInventory(player, setTransportaionGui(page))
        }

        fun setTransportaionGui(page:Int): Inventory {
            val inv = Bukkit.createInventory(null,54,"수송 상점")
            val noii = NumberOfBuildingBlock+ NumberOfDecorationBlock + NumberOfRedStoneBlock
            val koii = NumberOfBuildingBlock + NumberOfDecorationBlock+ NumberOfRedStoneBlock + NumberOfTransportaionBlock
            when(page)
            {
                1->
                {
                    for(i:Int in 0..44)
                    {
                        if(i+noii+(page-1)*45 < koii)
                        {
                            val item = ItemList[i+noii+(page-1)*45]
                            inv.setItem(
                                i,
                                createStaticShopItem(item)
                            )
                        }
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

            }
            return inv
        }

        fun getTransportationShopPage(inv:Inventory): Int?
        {
            val pageitem = inv.getItem(48)
            return pageitem?.itemMeta?.displayName?.toInt()
        }

        fun clickTransportationShopGui(player:Player,slot:Int,page:Int)
        {
            when(page)
            {
                1->
                    when(slot)
                    {
                        49->openStaticShopGui(player)
                        else->return
                    }
                else->return
            }
        }
    }
}