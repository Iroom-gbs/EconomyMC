package com.iroom.test.economy.Shop.GUI.StaticShop

import com.iroom.test.economy.Shop.GUI.MenuGUI.Companion.openMenuGui
import com.iroom.test.economy.Shop.GUI.StaticShop.Category.BrewingShopGUI.Companion.openBrewingShopGui
import com.iroom.test.economy.Shop.GUI.StaticShop.Category.BuildingShopGUI.Companion.openBuildingShopGui
import com.iroom.test.economy.Shop.GUI.StaticShop.Category.DecorationShopGUI.Companion.openDecorationShopGui
import com.iroom.test.economy.Shop.GUI.StaticShop.Category.FoodShopGUI.Companion.openFoodShopGui
import com.iroom.test.economy.Shop.GUI.StaticShop.Category.MiscellaneousShopGUI.Companion.openMiscellaneousShopGui
import com.iroom.test.economy.Shop.GUI.StaticShop.Category.RedStoneShopGUI.Companion.openRedStoneShopGui
import com.iroom.test.economy.Shop.GUI.StaticShop.Category.ToolShopGUI.Companion.openToolShopGui
import com.iroom.test.economy.Shop.GUI.StaticShop.Category.TransportaionShopGUI.Companion.openTransportationShopGui
import com.iroom.test.economy.Shop.Shop
import com.iroom.test.economy.Shop.Shop.Companion.createShopItem
import com.iroom.test.economy.Shop.Shop.Companion.openInventory
import com.iroom.test.economy.Shop.ShopItem
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

class StaticShopGUI {
    companion object
    {
        fun createStaticShopItem(item: ShopItem): ItemStack?
        {
            val shopitem =  createShopItem(
                item.material,
                if(item.isCanBuy)
                    "현재 판매가: ".plus(item.getSellPrice().toString())
                else
                    "최초 판매가: ".plus(item.getSellPrice().toString()),
                if(item.isCanBuy)
                    "현재 구매가: ".plus(item.getBuyPrice().toString())
                else
                    "재고 없음!"
            )
            if(!item.isCanBuy)
                if (shopitem != null) {
                    val meta = shopitem.itemMeta
                    meta?.addEnchant(Enchantment.LUCK,1,true)
                    meta?.addItemFlags(ItemFlag.HIDE_ENCHANTS)
                    shopitem.itemMeta = meta
                }
            return shopitem
        }
        fun openStaticShopGui(player: Player)
        {
            openInventory(player, setStaticShopGui())
        }

        fun setStaticShopGui():Inventory
        {
            val inv = Bukkit.createInventory(null,9,"상점메뉴")
            inv.setItem(
                0,
                Shop.createGuiItem(
                    Material.BRICKS,
                    "건축블록"
                )
            )
            inv.setItem(
                1,
                Shop.createGuiItem(
                    Material.PEONY,
                    "장식블록"
                )
            )
            inv.setItem(
                2,
                Shop.createGuiItem(
                    Material.REDSTONE,
                    "레드스톤"
                )
            )
            inv.setItem(
                3,
                Shop.createGuiItem(
                    Material.POWERED_RAIL,
                    "수송"
                )
            )
            inv.setItem(
                4,
                Shop.createGuiItem(
                    Material.LAVA_BUCKET,
                    "기타아이템"
                )
            )
            inv.setItem(
                5,
                Shop.createGuiItem(
                    Material.APPLE,
                    "식료품"
                )
            )
            inv.setItem(
                6,
                Shop.createGuiItem(
                    Material.GOLDEN_SWORD,
                    "도구및전투"
                )
            )
            inv.setItem(
                7,
                    Shop.createGuiItem(
                        Material.POTION,
                        "양조"
                    )
            )
            inv.setItem(
                8,
                Shop.createGuiItem(
                    Material.BARRIER,
                    "뒤로가기"
                )
            )
            return inv
        }

        fun clickStaticShopGui(player:Player, slot:Int)
        {
            when(slot)
            {
                0->openBuildingShopGui(player,1)
                1->openDecorationShopGui(player,1)
                2->openRedStoneShopGui(player,1)
                3->openTransportationShopGui(player,1)
                4->openMiscellaneousShopGui(player,1)
                5->openFoodShopGui(player,1)
                6->openToolShopGui(player,1)
                7->openBrewingShopGui(player,1)
                8->openMenuGui(player)
                else->return
            }
        }
    }
}