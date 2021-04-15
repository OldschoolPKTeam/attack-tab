package gg.rsmod.plugins.api.ext

import gg.rsmod.game.model.entity.Player

/**
 * Executed when special attacks is toggled.
 */
fun on_toggle_special_attack(unit: Player.() -> Unit) = onToggleSpecialAttack.add(unit)
val onToggleSpecialAttack = mutableListOf<Player.() -> Unit>()
fun executeOnToggleSpecialAttack(player: Player) = onToggleSpecialAttack.forEach { it(player) }

/**
 * Executed when a player selects a new attack style, but before the new style varp is set.
 */
fun on_change_attack_style_prechange(unit: Player.() -> Unit) = onChangeAttackStylePreChange.add(unit)
val onChangeAttackStylePreChange = mutableListOf<Player.() -> Unit>()
fun executeOnChangeAttackStylePreChange(player: Player) = onChangeAttackStylePreChange.forEach { it(player) }

/**
 * Executed when a player selects a new attack style, but before the new style varp is set.
 */
fun on_change_attack_style_postchange(unit: Player.() -> Unit) = onChangeAttackStylePostChange.add(unit)
val onChangeAttackStylePostChange = mutableListOf<Player.() -> Unit>()
fun executeOnChangeAttackStylePostChange(player: Player) = onChangeAttackStylePostChange.forEach { it(player) }