package com.rabbitmint.BlockSystem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class TouchBlock implements Listener {

    private String blockName;

    public TouchBlock(String blockName) {
        this.blockName = blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public void console(String command) {
        CommandSender console = Bukkit.getConsoleSender();
        Bukkit.dispatchCommand(console, command);
    }

    public void Title(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        player.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (blockName == null || blockName.isEmpty()) {
            return;
        }

        Player player = event.getPlayer();
        Material blockBelow = player.getLocation().subtract(0, 1, 0).getBlock().getType();

        if (blockBelow.name().equalsIgnoreCase(blockName)) {
            Bukkit.getLogger().warning(player.getName() + " 님이 " + blockName + " 블럭 위에 있습니다.");
            Bukkit.getLogger().warning(player.getName() + " 님에게 Kill 명령어를 전송합니다.");
            console("kill " + player.getName());

            String titleMessage = ChatColor.GOLD + player.getName() + "님" + ChatColor.GREEN + " 사망!";
            String subtitleMessage = "";

            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.sendTitle(titleMessage, subtitleMessage, 10, 70, 20);
            }
        }
    }
}
