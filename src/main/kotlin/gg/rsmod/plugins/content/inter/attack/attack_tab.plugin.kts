package gg.rsmod.plugins.content.inter.attack

import gg.rsmod.plugins.content.inter.attack.AttackTab.ATTACK_TAB_INTERFACE_ID
import gg.rsmod.plugins.content.inter.attack.AttackTab.DISABLE_AUTO_RETALIATE_VARP
import gg.rsmod.plugins.content.inter.attack.AttackTab.SPECIAL_ATTACK_VARP
import gg.rsmod.plugins.content.inter.attack.AttackTab.setEnergy
import gg.rsmod.game.model.attr.NEW_ACCOUNT_ATTR
import gg.rsmod.plugins.content.inter.attack.AttackTab.setAttackStyle

/**
 * First log-in logic (when accounts have just been made).
 */
on_login {
    if (player.attr.getOrDefault(NEW_ACCOUNT_ATTR, false)) {
        setEnergy(player, 100)
    }
}

/**
 * Attack style buttons
 */
on_button(interfaceId = ATTACK_TAB_INTERFACE_ID, component = 4) {
    setAttackStyle(player, 0)
}

on_button(interfaceId = ATTACK_TAB_INTERFACE_ID, component = 8) {
    setAttackStyle(player, 1)
}

on_button(interfaceId = ATTACK_TAB_INTERFACE_ID, component = 12) {
    setAttackStyle(player, 2)
}

on_button(interfaceId = ATTACK_TAB_INTERFACE_ID, component = 16) {
    setAttackStyle(player, 3)
}

/**
 * Toggle auto-retaliate button.
 */
on_button(interfaceId = ATTACK_TAB_INTERFACE_ID, component = 30) {
    player.toggleVarp(DISABLE_AUTO_RETALIATE_VARP)
}

/**
 * Toggle special attack.
 */
on_button(interfaceId = ATTACK_TAB_INTERFACE_ID, component = 36) {
    executeOnToggleSpecialAttack(player)
}

/**
 * Disable special attack when switching weapons.
 */
on_equip_to_slot(EquipmentType.WEAPON.id) {
    player.setVarp(SPECIAL_ATTACK_VARP, 0)
}

/**
 * Disable special attack on log-out.
 */
on_logout {
    player.setVarp(SPECIAL_ATTACK_VARP, 0)
}