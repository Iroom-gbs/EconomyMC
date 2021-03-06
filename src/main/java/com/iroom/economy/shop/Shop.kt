package com.iroom.economy.shop

import com.iroom.economy.shop.GUI.DebugGUI.Companion.clickDebugGui
import com.iroom.economy.shop.GUI.MenuGUI.Companion.clickMenuGui
import com.iroom.economy.shop.GUI.MenuGUI.Companion.openMenuGui
import com.iroom.economy.shop.GUI.StaticShop.Category.BrewingShopGUI.Companion.clickBrewingShopGui
import com.iroom.economy.shop.GUI.StaticShop.Category.BrewingShopGUI.Companion.getBrewingShopPage
import com.iroom.economy.shop.GUI.StaticShop.Category.BuildingShopGUI.Companion.clickBuildingShopGui
import com.iroom.economy.shop.GUI.StaticShop.Category.BuildingShopGUI.Companion.getDecorationShopPage
import com.iroom.economy.shop.GUI.StaticShop.Category.DecorationShopGUI.Companion.clickDecorationShopGui
import com.iroom.economy.shop.GUI.StaticShop.Category.DecorationShopGUI.Companion.getBuildingShopPage
import com.iroom.economy.shop.GUI.StaticShop.Category.FoodShopGUI.Companion.clickFoodShopGui
import com.iroom.economy.shop.GUI.StaticShop.Category.FoodShopGUI.Companion.getFoodShopPage
import com.iroom.economy.shop.GUI.StaticShop.Category.MiscellaneousShopGUI.Companion.clickMiscellaneousShopGui
import com.iroom.economy.shop.GUI.StaticShop.Category.MiscellaneousShopGUI.Companion.getMiscellaneousShopPage
import com.iroom.economy.shop.GUI.StaticShop.Category.RedStoneShopGUI.Companion.clickRedStoneShopGui
import com.iroom.economy.shop.GUI.StaticShop.Category.RedStoneShopGUI.Companion.getRedStoneShopPage
import com.iroom.economy.shop.GUI.StaticShop.StaticShopGUI.Companion.clickStaticShopGui
import com.iroom.economy.shop.GUI.StaticShop.Category.ToolShopGUI.Companion.clickToolShopGui
import com.iroom.economy.shop.GUI.StaticShop.Category.ToolShopGUI.Companion.getToolShopPage
import com.iroom.economy.shop.GUI.StaticShop.Category.TransportaionShopGUI.Companion.clickTransportationShopGui
import com.iroom.economy.shop.GUI.StaticShop.Category.TransportaionShopGUI.Companion.getTransportationShopPage
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.HumanEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import java.util.*


class Shop:Listener {

    @EventHandler
    fun ShopClick(event:PlayerInteractEvent)
    {
        if(event.action == Action.RIGHT_CLICK_AIR||event.action == Action.RIGHT_CLICK_BLOCK)
        {
            if(event.player.inventory.itemInMainHand.itemMeta?.hasEnchant(Enchantment.LUCK)==true)
            {
                openMenuGui(event.player)
            }
        }
    }

    @EventHandler
    fun shopEvent(event: InventoryClickEvent)
    {
        val clickitem: ItemStack? = event.currentItem
        if(event.click == ClickType.DOUBLE_CLICK) return
        if(clickitem == null || clickitem.type == Material.AIR) return
        when(event.view.title)
        {
            "??????" ->
            {
                clickMenuGui(event.whoClicked as Player, event.rawSlot)
                event.isCancelled = true
            }
            "?????????" ->
            {
                clickDebugGui(event.whoClicked as Player, event.rawSlot)
                event.isCancelled = true
            }
            "????????????" ->
            {
                clickStaticShopGui(event.whoClicked as Player, event.rawSlot)
                event.isCancelled = true
            }
            "???????????? ??????" ->
            {
                getBuildingShopPage(event.inventory)?.let {
                    clickBuildingShopGui(event.whoClicked as Player, event.rawSlot,
                        it
                    )
                }
                event.isCancelled = true
            }
            "???????????? ??????" ->
            {
                getDecorationShopPage(event.inventory)?.let {
                    clickDecorationShopGui(event.whoClicked as Player, event.rawSlot,
                    it)
                }
                event.isCancelled = true
            }
            "???????????? ??????" ->
            {
                getRedStoneShopPage(event.inventory)?.let {
                    clickRedStoneShopGui(event.whoClicked as Player, event.rawSlot,
                        it)
                }
                event.isCancelled = true
            }
            "?????? ??????" ->
            {
                getTransportationShopPage(event.inventory)?.let {
                    clickTransportationShopGui(event.whoClicked as Player, event.rawSlot,
                    it)
                }
                event.isCancelled = true
            }
            "??????????????? ??????" ->
            {
                getMiscellaneousShopPage(event.inventory)?.let{
                    clickMiscellaneousShopGui(event.whoClicked as Player, event.rawSlot,
                    it)
                }
                event.isCancelled = true
            }
            "????????? ??????" ->
            {
                getFoodShopPage(event.inventory)?.let {
                    clickFoodShopGui(event.whoClicked as Player, event.rawSlot,
                    it)
                }
                event.isCancelled = true
            }
            "??????????????? ??????" ->
            {
                getToolShopPage(event.inventory)?.let {
                    clickToolShopGui(event.whoClicked as Player, event.rawSlot,
                    it)
                }
                event.isCancelled = true
            }
            "?????? ??????" ->
            {
                getBrewingShopPage(event.inventory)?.let {
                    clickBrewingShopGui(event.whoClicked as Player,event.rawSlot,
                        it)
                }
                event.isCancelled = true
            }
            else -> return
        }
    }

    @EventHandler
    fun shopEvent(event: InventoryDragEvent)
    {
        when(event.view.title)
        {
            "??????" -> event.isCancelled = true
            "?????????" -> event.isCancelled = true
            "????????????" -> event.isCancelled = true
            "???????????? ??????" -> event.isCancelled = true
            "???????????? ??????" -> event.isCancelled = true
            "???????????? ??????" -> event.isCancelled = true
            "?????? ??????" -> event.isCancelled = true
            "??????????????? ??????" -> event.isCancelled = true
            "????????? ??????" -> event.isCancelled = true
            "??????????????? ??????" -> event.isCancelled = true
            "?????? ??????" -> event.isCancelled = true
            else -> return
        }
    }

    companion object
    {
        fun createGuiItem(material: Material?, name: String?, vararg lore: String?): ItemStack? {
            val item = ItemStack(material!!, 1)
            val meta = item.itemMeta

            meta!!.setDisplayName(name)
            meta.lore = Arrays.asList(*lore)
            item.itemMeta = meta
            return item
        }
        fun createShopItem(material: Material?, vararg lore: String?): ItemStack? {
            val item = ItemStack(material!!, 1)
            val meta = item.itemMeta

            meta!!.lore = Arrays.asList(*lore)
            item.itemMeta = meta
            return item
        }

        fun openInventory(ent: HumanEntity, inv:Inventory) {
            ent.openInventory(inv)
        }
    }

}