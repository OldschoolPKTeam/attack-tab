package gg.rsmod.plugins.content.inter.attack

import gg.rsmod.game.model.attr.UNLIMITED_SPECIAL_ATTACK
import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.api.ext.executeOnChangeAttackStylePostChange
import gg.rsmod.plugins.api.ext.executeOnChangeAttackStylePreChange
import gg.rsmod.plugins.api.ext.getVarp
import gg.rsmod.plugins.api.ext.setVarp

/**
 * @author Tom <rspsmods@gmail.com>
 */
object AttackTab {
    const val ATTACK_TAB_INTERFACE_ID = 593

    const val ATTACK_STYLE_VARP = 43
    const val DISABLE_AUTO_RETALIATE_VARP = 172

    private const val SPECIAL_ATTACK_ENERGY_VARP = 300
    const val SPECIAL_ATTACK_VARP = 301

    fun appendEnergy(p: Player, amount: Int) {
        var append = amount
        val current = p.getVarp(SPECIAL_ATTACK_ENERGY_VARP) / 10

        when {
            current >= 100 -> return
            current + append > 100 -> { append = 100 - current}
        }

        if (append > 0) {
            setEnergy(p, current + append)
        }
    }

    fun setEnergy(p: Player, amount: Int) {
        check(amount in 0..100)
        if(p.attr.has(UNLIMITED_SPECIAL_ATTACK))
            return@setEnergy
        p.setVarp(SPECIAL_ATTACK_ENERGY_VARP, amount * 10)
    }

    fun getEnergy(p: Player): Int = p.getVarp(SPECIAL_ATTACK_ENERGY_VARP) / 10

    fun disableSpecial(p: Player) {
        p.setVarp(SPECIAL_ATTACK_VARP, 0)
    }

    fun isSpecialEnabled(p: Player): Boolean = p.getVarp(SPECIAL_ATTACK_VARP) == 1

    fun setAttackStyle(p: Player, value: Int) {
        executeOnChangeAttackStylePreChange(p)
        p.setVarp(ATTACK_STYLE_VARP, value)
        executeOnChangeAttackStylePostChange(p)
    }
}