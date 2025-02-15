package com.willfp.libreforge.slot.impl

import com.willfp.eco.util.toSingletonList
import com.willfp.libreforge.isEcoEmpty
import com.willfp.libreforge.slot.SlotType
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object SlotTypeOffhand : SlotType("offhand") {
    override fun addToSlot(player: Player, item: ItemStack): Boolean {
        if (!player.inventory.itemInOffHand.isEcoEmpty) {
            return false
        }

        // 40 is the offhand slot
        player.inventory.setItem(40, item)
        return true
    }

    override fun getItems(player: Player): List<ItemStack> {
        return player.inventory.itemInOffHand.toSingletonList()
    }

    override fun getItemSlots(player: Player): List<Int> {
        return 40.toSingletonList()
    }
}
