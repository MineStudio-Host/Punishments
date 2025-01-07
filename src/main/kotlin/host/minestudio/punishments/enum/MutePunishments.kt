package host.minestudio.punishments.enum

enum class MutePunishments(
    val shortReason: String,
    val longReason: String,
    val duration: List<String>? = listOf("forever"),
    val ipBased: Boolean = false,
    val forceGlobal: Boolean = false,
) {

    SPAM(
        "Spam/Flood",
        "Try to slow down your messages a bit.",
        duration = listOf("3h", "12h", "1d", "3d", "1w", "1mo", "3mo", "forever")
    ),
    ARGUE(
        "Instigating Arguments",
        "You were muted for instigating/continuing arguments, being disrespectful to others, or trying to evade rules",
        duration = listOf("3h", "12h", "1d", "3d", "1w", "1mo", "3mo", "forever")
    ),
    SWEAR(
        "Swearing/Bypassing Filter",
        "You were muted for excessive profanity or bypassing the filter",
        duration = listOf("3h", "12h", "1d", "3d", "1w", "1mo", "3mo", "forever")
    ),
    ADVERTISING(
        "Advertising",
        "You were muted for advertising other servers or services",
        duration = listOf("3h", "12h", "1d", "3d", "1w", "1mo", "3mo", "forever")
    ),
    INAPPROPRIATE(
        "Inappropriate Content",
        "You were muted for posting inappropriate content",
        duration = listOf("3h", "12h", "1d", "3d", "1w", "1mo", "3mo", "forever")
    ),
    DISRESPECT(
        "Disrespectful Behavior",
        "You were muted for being disrespectful to others",
        duration = listOf("3h", "12h", "1d", "3d", "1w", "1mo", "3mo", "forever")
    ),
    DISCRIMINATION(
        "Discrimination",
        "You were muted for discrimination/hate speech.",
        duration = listOf("3d", "1w", "1mo", "3mo", "forever")
    ),
    SELF_HARM(
        "Self Harm",
        "Please seek help if you are feeling the need to self-harm.",
        duration = listOf("3d", "1w", "1mo", "3mo", "forever")
    ),
    OTHER(
        "Other",
        "You were muted for other reasons",
    );

}