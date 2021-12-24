package com.iroom.test.economy.Shop.GUI

import com.iroom.test.economy.Shop.GUI.DebugGUI.Companion.openDebugGui
import com.iroom.test.economy.Shop.Shop.Companion.openInventory
import com.iroom.test.economy.Shop.GUI.StaticShop.StaticShopGUI.Companion.openStaticShopGui
import com.iroom.test.economy.Shop.Shop
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

class MenuGUI {
    companion object
    {
        fun openMenuGui(player: Player) {
            openInventory(player, setMenuGui())
        }

        fun setMenuGui(): Inventory {
            var inv: Inventory
            inv = Bukkit.createInventory(null, 9, "메뉴")
            inv.setItem(
                0,
                Shop.createGuiItem(
                    Material.APPLE,
                    "상점",
                    "물품을 즉시 판매하거나 살 수 있는 곳입니다.",
                    "시세에 따라 물품 가격이 오르내립니다."
                )
            )
            inv.setItem(
                1,
                Shop.createGuiItem(
                    Material.CHEST,
                    "유저상점",
                    "내 아이템을 판매하고, 다른 아이템을 살 수 있습니다.",
                    "현재수수료 : 0%"
                )
            )
            inv.setItem(
                2,
                Shop.createGuiItem(
                    Material.BOOK,
                    "투표소",
                    "정책카드, 법률카드, 긴급카드를 보고 투표할 수 있습니다.",
                    "히루에 한번 업데이트 됩니다."
                )
            )
            inv.setItem(
                8,
                Shop.createGuiItem(
                    Material.BEDROCK,
                    "디버그",
                    "개발용 디버그 옵션"
                )
            )
            return inv
        }

        fun clickMenuGui(player: Player, slot: Int)
        {
            when(slot)
            {
                0->openStaticShopGui(player)
                1->return
                2->return
                8->openDebugGui(player)
                else->return
            }
        }
    }
}