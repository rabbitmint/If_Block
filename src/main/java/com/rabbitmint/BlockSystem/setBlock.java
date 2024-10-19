package com.rabbitmint.BlockSystem;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import com.rabbitmint.if_Block;

import java.util.ArrayList;
import java.util.List;

public class setBlock implements CommandExecutor, TabCompleter {
    private String block;
    private if_Block plugin;

    public setBlock(if_Block plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("if-block")) {
            if (args.length > 0 && args[0].equalsIgnoreCase("설정")) {
                if (args.length > 1) {
                    if (isValidBlock(args[1])) {
                        block = args[1];
                        sender.sendMessage(ChatColor.GOLD + block + ChatColor.GREEN + " 으로 지정되었습니다.");
                        plugin.updateBlockListener(block);
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.RED + args[1] + " 는 유효한 블럭 이름이 아닙니다.");
                        return false;
                    }
                } else {
                    sender.sendMessage("사용법: /if-block 설정 <블럭이름>");
                    return false;
                }
            }
        }
        return false;
    }

    private boolean isValidBlock(String blockName) {
        return Material.matchMaterial(blockName) != null;
    }

    public String getBlockName() {
        return block;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (command.getName().equalsIgnoreCase("if-block")) {
            if (args.length == 1) {
                completions.add("설정");
            } else if (args.length == 2 && args[0].equalsIgnoreCase("설정")) {
                for (Material material : Material.values()) {
                    if (material.isBlock()) {
                        completions.add(material.name());
                    }
                }
            }
        }
        return completions;
    }
}
