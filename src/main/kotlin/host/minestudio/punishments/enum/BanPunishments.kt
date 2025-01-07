package host.minestudio.punishments.enum

enum class BanPunishments(
    val shortReason: String,
    val longReason: String,
    val duration: List<String>? = listOf("forever"),
    val ipBased: Boolean = false,
    val forceGlobal: Boolean = false,
) {

    GDPR(
        "GDPR",
        "You requested to be forgotten.",
        forceGlobal = true
    ),
    NSFW(
        "NSFW",
        "You were banned for NSFW content or inappropriate behavior",
        duration = listOf("3d", "1w", "1mo", "3mo", "forever")
    ),
    HARASSMENT(
        "Harassment",
        "You were banned for harassment.",
        duration = listOf("3d", "1w", "1mo", "3mo", "forever")
    ),
    IMPERSONATION(
        "Impersonation",
        "You were banned for impersonating Team Members or other players.",
        duration = listOf("3d", "1w", "1mo", "3mo", "forever"),
        ipBased = true
    ),
    DOX(
        "Dox",
        "You were banned for doxing or sharing personal information.",
        ipBased = true
    ),
    DEATH_THREATS(
        "Death Threats",
        "You were banned for making death threats.",
        ipBased = true
    ),
    PREDATOR(
        "Predator",
        "You were banned for predatory behavior.",
        ipBased = true,
        forceGlobal = true
    ),
    UNDERAGE(
        "Underage",
        "You were banned for violating MineStudio's age policies (you must be 13 years or older to play)",
        forceGlobal = true
    ),
    EVASION(
        "Ban Evasion",
        "You were banned for evading a previous ban.",
        ipBased = true
    ),
    OTHER(
        "Other",
        "You were banned for other reasons",
    );

}