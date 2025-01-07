package host.minestudio.punishments

import host.minestudio.punishments.impl.PunishmentReason

data class PunishmentsConfig(
    val punishments: Map<String, PunishmentReason>
)
lateinit var punishmentConfig: PunishmentsConfig

class MineStudioPunishments {
}