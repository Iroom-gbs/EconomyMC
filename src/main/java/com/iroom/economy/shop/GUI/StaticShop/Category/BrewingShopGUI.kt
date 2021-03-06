package com.iroom.economy.shop.GUI.StaticShop.Category

import com.iroom.economy.shop.GUI.StaticShop.StaticShopGUI.Companion.createStaticShopItem
import com.iroom.economy.shop.GUI.StaticShop.StaticShopGUI.Companion.openStaticShopGui
import com.iroom.economy.shop.Shop.Companion.createGuiItem
import com.iroom.economy.shop.Shop.Companion.openInventory
import com.iroom.economy.shop.ShopItem.Companion.ItemList
import com.iroom.economy.shop.ShopItem.Companion.NumberOfBrewingBlock
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

class BrewingShopGUI {
    companion object
    {
        fun openBrewingShopGui(player: Player,page:Int) {
            openInventory(player, setBrewingShopGui(page))
        }

        fun setBrewingShopGui(page:Int): Inventory {
            val inv = Bukkit.createInventory(null,54,"์์กฐ ์์ ")
            val noii = NumberOfBuildingBlock+ NumberOfDecorationBlock+ NumberOfRedStoneBlock + NumberOfTransportaionBlock + NumberOfMiscellaneousBlock + NumberOfFoodBlock + NumberOfToolBlock
            val koii = NumberOfBuildingBlock + NumberOfDecorationBlock+ NumberOfRedStoneBlock + NumberOfTransportaionBlock + NumberOfMiscellaneousBlock + NumberOfFoodBlock + NumberOfToolBlock + NumberOfBrewingBlock
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
                            "์ด์ ํ์ด์ง"
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
                            "๋ค๋ก๊ฐ๊ธฐ"
                        )
                    )
                    inv.setItem(
                        53,
                        createGuiItem(
                            Material.FEATHER,
                            "๋ค์ํ์ด์ง"
                        )
                    )
                }


            }
            return inv
        }

        fun getBrewingShopPage(inv:Inventory): Int?
        {
            val pageitem = inv.getItem(48)
            return pageitem?.itemMeta?.displayName?.toInt()
        }

        fun clickBrewingShopGui(player:Player,slot:Int,page:Int)
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