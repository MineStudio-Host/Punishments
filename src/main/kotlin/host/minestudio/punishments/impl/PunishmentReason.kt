package host.minestudio.punishments.impl

data class PunishmentReason(
    val shortReason: String,
    val longReason: String = shortReason,
    val action: String,
    val duration: List<String>? = null
)