package xyz.survsmc.ms0ur.srtp;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class commandRtp implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args){
        if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage(Main.Lang_str.noConsole); return true;
        }
        Player player = (Player) sender;
        //player.getName();
        player.teleport(new Location(player.getWorld(), randomCoordGen.genX(), 300, randomCoordGen.genZ()), PlayerTeleportEvent.TeleportCause.UNKNOWN);
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,600,100));
        return true;
    }
}
