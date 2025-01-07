package host.minestudio.punishments.utils

import host.minestudio.punishments.punishmentConfig
import java.time.Instant

/**
 * @author AzaleaTeam
 */
/**
 * Extracts a numeric value and its corresponding time unit from the given input string.
 *
 * The input string is expected to contain a numeric value followed by a non-numeric time unit.
 * For example, "10d" would be parsed into the numeric value 10 and the time unit "d".
 *
 * @param input the input string containing a numeric value and a time unit
 * @return a Pair containing the numeric value as an Int and the time unit as a String
 * @throws IllegalArgumentException if the input format is invalid
 * @author AzaleaTeam
 */
private fun getNumericValue(input: String): Pair<Int, String> {
    val regex = Regex("(\\d+)(\\D+)")
    val matchResult = regex.find(input)
    val (numericValue, timeUnit) = matchResult?.destructured ?: throw IllegalArgumentException("Invalid input format: $input")
    return Pair(numericValue.toInt(), timeUnit)
}


/**
 * Converts a given input string representing a duration into its equivalent value in seconds.
 *
 * The input string can be a numeric value followed by a time unit (e.g., "10d" for 10 days) or the string "forever".
 * Supported time units are:
 * - "min" for minutes
 * - "h" for hours
 * - "d" for days
 * - "w" for weeks
 * - "mo" for months
 *
 * @param input the input string representing the duration
 * @return the equivalent duration in seconds
 * @throws IllegalArgumentException if the input format is invalid or the time unit is not supported
 * @author AzaleaTeam
 */
fun convertDate(input: String): Long {
    if(input.lowercase() == "forever") return Instant.MAX.epochSecond

    val (numericValue, timeUnit) = getNumericValue(input)

    val minute = 60L
    val hour = minute * 60
    val day = hour * 24
    val week = day * 7
    val month = week * 4

    val timeUnits: Map<String, Long> = mapOf(
        "min" to minute,
        "h" to hour,
        "d" to day,
        "w" to week,
        "mo" to month
    )

    val secondValue =
        timeUnits[timeUnit] ?: throw IllegalArgumentException("Invalid time unit specified $timeUnit")

    return numericValue * secondValue
}

/**
 * Retrieves the short and long reason descriptions for a given punishment reason.
 *
 * If the provided reason exists in the punishment configuration, the corresponding short and long reasons
 * are retrieved and returned. Otherwise, the input reason is returned as both the short and long reasons.
 *
 * @param reason the input reason for which to retrieve the descriptions
 * @return a Pair containing the short reason as the first element and the long reason as the second element
 * @author AzaleaTeam
 */
fun getReasonInfo(reason: String): Pair<String, String> {
    var shortReason = reason
    var longReason = reason

    if(reason.lowercase() in punishmentConfig.punishments.keys) {
        val punishmentInfo = punishmentConfig.punishments[reason.lowercase()]!!
        shortReason = punishmentInfo.shortReason.capitalize()
        longReason = punishmentInfo.longReason
    }

    return Pair(shortReason, longReason)
}