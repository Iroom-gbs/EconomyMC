package com.iroom.economy.shop.GUI.StaticShop.Category

import com.iroom.economy.shop.GUI.StaticShop.StaticShopGUI.Companion.createStaticShopItem
import com.iroom.economy.shop.GUI.StaticShop.StaticShopGUI.Companion.openStaticShopGui
import com.iroom.economy.shop.Shop.Companion.createGuiItem
import com.iroom.economy.shop.Shop.Companion.openInventory
import com.iroom.economy.shop.ShopItem.Companion.ItemList
import com.iroom.economy.shop.ShopItem.Companion.NumberOfBuildingBlock
import com.iroom.economy.shop.ShopItem.Companion.NumberOfDecorationBlock
import com.iroom.economy.shop.ShopItem.Companion.NumberOfFoodBlock
import com.iroom.economy.shop.ShopItem.Companion.NumberOfMiscellaneousBlock
import com.iroom.economy.shop.ShopItem.Companion.NumberOfRedStoneBlock
import com.iroom.economy.shop.ShopItem.Companion.NumberOfToolBlock
import com.iroom.economy.shop.ShopItem.Companion.NumberOfTransportaionBlock
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

class ToolShopGUI {
    companion object
    {
        fun openToolShopGui(player: Player,page:Int) {
            openInventory(player, setToolShopGui(page))
        }

        fun setToolShopGui(page:Int): Inventory {
            val inv = Bukkit.createInventory(null,54,"도구및전투 상점")
            val noii = NumberOfBuildingBlock+ NumberOfDecorationBlock+ NumberOfRedStoneBlock + NumberOfTransportaionBlock + NumberOfMiscellaneousBlock + NumberOfFoodBlock
            val koii = NumberOfBuildingBlock + NumberOfDecorationBlock+ NumberOfRedStoneBlock + NumberOfTransportaionBlock + NumberOfMiscellaneousBlock + NumberOfFoodBlock + NumberOfToolBlock
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
                2->
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


            }
            return inv
        }

        fun getToolShopPage(inv:Inventory): Int?
        {
            val pageitem = inv.getItem(48)
            return pageitem?.itemMeta?.displayName?.toInt()
        }

        fun clickToolShopGui(player:Player,slot:Int,page:Int)
        {
            when(page)
            {
                1->
                    when(slot)
                    {
                        49->openStaticShopGui(player)
                        53-> openToolShopGui(player,page+1)
                        else->return
                    }
                2->
                    when(slot)
                    {
                        45-> openToolShopGui(player,page-1)
                        49-> openStaticShopGui(player)
                        else->return
                    }
                else->return
            }
        }
    }
}