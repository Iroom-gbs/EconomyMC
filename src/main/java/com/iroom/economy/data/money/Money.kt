package com.iroom.economy.data.money

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.scoreboard.DisplaySlot
import org.bukkit.util.io.BukkitObjectInputStream
import org.bukkit.util.io.BukkitObjectOutputStream
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.lang.Exception
import java.util.*
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream

class Money {

    companion object
    {
        var NP = emptyMap<UUID,Int>().toMutableMap()

        //돈 데이터 저장
        fun saveMoney(path:String):Boolean = try {
                var out = BukkitObjectOutputStream(GZIPOutputStream(FileOutputStream(path)))
                out.writeObject(NP)
                out.close()
                Bukkit.getConsoleSender().sendMessage("Saved money...")
                true
            } catch (e: IOException) {
                e.printStackTrace()
                Bukkit.getConsoleSender().sendMessage("Failed to save money!")
                false
            }

        //돈 데이터 로드
        fun loadMoney(path:String):Boolean = try {
                var ins = BukkitObjectInputStream(GZIPInputStream(FileInputStream(path)))
                NP = ins.readObject() as MutableMap<UUID, Int>
                ins.close()
                Bukkit.getConsoleSender().sendMessage("Loaded money...")
                true
            } catch(e:Exception) {
                Bukkit.getConsoleSender().sendMessage("Failed to load money!")
                false
            }

        //플레이어의 보드를 업데이트
        fun updateBoard(player: Player)
        {
            var money = getMoney(player)
            val manager = Bukkit.getScoreboardManager()
            val board = manager?.newScoreboard
            val obj = board?.registerNewObjective("Scoreboard","Scoreboard","Test")
            obj?.displaySlot = DisplaySlot.SIDEBAR
            val score = obj?.getScore("돈")
            if (score != null) {
                if (money != null) {
                    score.score = money
                }
            }
            if (board != null) {
                player.scoreboard = board
            }
        }

        //플레이어의 돈을 설정
        fun setMoney(player: Player, money:Int)
        {
            NP[player.uniqueId] = money
            updateBoard(player)
        }

        //플레이어의 돈을 변경
        fun mutMoney(player: Player, money: Int):Boolean {
            val m = NP[player.uniqueId]
            if (m != null) {
                if(m>=(-money))
                    {
                        //돈이 충분할 경우
                        NP[player.uniqueId] = m + money
                        updateBoard(player)
                        return true
                    }
                else return false //돈이 부족할 경우
            }
            return false
        }

        //플레이어의 돈을 가져옴
        fun getMoney(player: Player): Int?
        {
            return NP[player.uniqueId]
        }
    }
}