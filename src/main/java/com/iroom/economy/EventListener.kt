package com.iroom.economy

import com.iroom.economy.data.money.Money
import com.iroom.economy.data.money.Money.Companion.updateBoard
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class EventListener : Listener {
    @EventHandler
    fun OnPlayerJoin(event:PlayerJoinEvent)
    {
        val uid = event.player.uniqueId
        if(!Money.NP.containsKey(uid))
        {
            Money.setMoney(event.player,5000)
        }
        updateBoard(event.player)
    }

}