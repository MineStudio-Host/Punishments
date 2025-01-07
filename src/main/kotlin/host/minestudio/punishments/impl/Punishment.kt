package host.minestudio.punishments.impl

import host.minestudio.punishments.enum.PunishmentActions
import host.minestudio.punishments.utils.convertDate
import host.minestudio.punishments.utils.mm
import net.kyori.adventure.text.Component
import net.minestom.server.MinecraftServer
import org.jetbrains.annotations.ApiStatus.Internal
import org.slf4j.LoggerFactory
import java.util.UUID

data class User(
    val name: String,
    val uuid: UUID
)

data class Punishment(
    val mod: User,
    val offender: User,
    val reason: String,
    val type: PunishmentActions,
    val duration: String = "FOREVER",
    val notes: String = ""
) {

    private val LOGGER = LoggerFactory.getLogger(Punishment::class.java)

    /**
     * Generates a disconnect message for a banned player.
     *
     * @return A `Component` containing the disconnect message.
     * @author MineStudio
     */
    @Internal
    fun getDisconnect(): Component {
        return """
            <error>You have been banned from MineStudio.
            Depending on the severity, you may also be banned from servers in the network.
            <gray>$reason</gray>
            
            <white>Think this is a mistake? Appeal at <green>https://support.minestudio.host</green>.
        """.trimIndent().mm()
    }

    /**
     * Generates a mute message for a muted player.
     *
     * @return A `Component` containing the mute message.
     * @author MineStudio
     */
    @Internal
    fun getMuted(): Component {
        return """
            
            
            <error>You have been muted on MineStudio.
            Depending on the severity, you may also be muted on servers in the network.
            <gray>$reason</gray>
            
            <white>Think this is a mistake? Appeal at <green>https://support.minestudio.host</green>.
            
            
        """.trimIndent().mm()
    }


    fun handle() {
        val duration = convertDate(this.duration)

        // TODO: Send punishment to API

        LOGGER.info("Punishment ${this.type} applied to ${this.offender.name} by ${this.mod.name} for ${this.reason}.")

        val onlinePlayer = MinecraftServer.getConnectionManager().onlinePlayers.firstOrNull {
            it.uuid == this.offender.uuid
        }
        if(onlinePlayer === null) {
            LOGGER.warn("Player ${this.offender.name} was not online, but punishment was applied.")
            return
        }

        when(this.type) {
            PunishmentActions.BAN -> onlinePlayer.kick(this.getDisconnect())
            PunishmentActions.MUTE -> onlinePlayer.sendMessage(this.getMuted())
        }
    }

}