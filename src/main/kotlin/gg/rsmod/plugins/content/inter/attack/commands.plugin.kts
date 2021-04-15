package gg.rsmod.plugins.content.inter.attack

on_command("spec", Privilege.ADMIN_POWER) {
    AttackTab.setEnergy(player, 100)
    player.message("Restored special attack")
}
