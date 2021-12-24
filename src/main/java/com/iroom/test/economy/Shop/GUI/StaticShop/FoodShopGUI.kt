package com.iroom.test.economy.Shop.GUI.StaticShop

import com.iroom.test.economy.Shop.GUI.StaticShop.StaticShopGUI.Companion.createStaticShopItem
import com.iroom.test.economy.Shop.GUI.StaticShop.StaticShopGUI.Companion.openStaticShopGui
import com.iroom.test.economy.Shop.Shop
import com.iroom.test.economy.Shop.Shop.Companion.createGuiItem
import com.iroom.test.economy.Shop.Shop.Companion.openInventory
import com.iroom.test.economy.Shop.ShopItem
import com.iroom.test.economy.Shop.ShopItem.Companion.ItemList
import com.iroom.test.economy.Shop.ShopItem.Companion.NumberOfBuildingBlock
import com.iroom.test.economy.Shop.ShopItem.Companion.NumberOfDecorationBlock
import com.iroom.test.economy.Shop.ShopItem.Companion.NumberOfFoodBlock
import com.iroom.test.economy.Shop.ShopItem.Companion.NumberOfMiscellaneousBlock
import com.iroom.test.economy.Shop.ShopItem.Companion.NumberOfRedStoneBlock
import com.iroom.test.economy.Shop.ShopItem.Companion.NumberOfTransportaionBlock
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

class FoodShopGUI {
    companion object
    {
        fun openFoodShopGui(player: Player,page:Int) {
            openInventory(player,setFoodShopGui(page))
        }

        fun setFoodShopGui(page:Int): Inventory {
            val inv = Bukkit.createInventory(null,54,"식료품 상점")
            val noii = NumberOfBuildingBlock+ NumberOfDecorationBlock+ NumberOfRedStoneBlock + NumberOfTransportaionBlock + NumberOfMiscellaneousBlock
            val koii = NumberOfBuildingBlock + NumberOfDecorationBlock+ NumberOfRedStoneBlock + NumberOfTransportaionBlock + NumberOfMiscellaneousBlock + NumberOfFoodBlock
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

        fun getFoodShopPage(inv:Inventory): Int?
        {
            val pageitem = inv.getItem(48)
            return pageitem?.itemMeta?.displayName?.toInt()
        }

        fun clickFoodShopGui(player:Player,slot:Int,page:Int)
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