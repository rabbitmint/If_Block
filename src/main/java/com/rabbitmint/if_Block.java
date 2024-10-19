package com.rabbitmint;

import com.rabbitmint.BlockSystem.TouchBlock;
import com.rabbitmint.BlockSystem.setBlock;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import static com.rabbitmint.info.*;

public final class if_Block extends JavaPlugin {

    private TouchBlock touchBlockListener;

    @Override
    public void onEnable() {
        setBlock blockSystem = new setBlock(this);
        touchBlockListener = new TouchBlock(blockSystem.getBlockName());
        getServer().getPluginManager().registerEvents(touchBlockListener, this);

        this.getCommand("if-block").setExecutor(blockSystem);
        this.getCommand("if-block").setTabCompleter(blockSystem);

        Bukkit.getLogger().info("[IF-Block] " + Name + " 가 활성화 되었습니다.");
        Bukkit.getLogger().info("[IF-Block] " + Version + " 버전을 사용중 입니다.");
        Bukkit.getLogger().warning("[경고] " + "플러그인은 항상 최신 버전으로 사용하는것을 추천드립니다.");
        Bukkit.getLogger().info("[IF-Block] " + Developer + "가 " + BuildDate + "에 빌드함.");
        Bukkit.getLogger().info("[IF-Block] 이 플러그인은 " + API + "를 사용합니다.");
        Bukkit.getLogger().warning("[경고] " + "서버를 열 때 Paper 1.20 이상 버전을 사용하시는 걸 권장합니다.");
        Bukkit.getLogger().info("[IF-Block] " + "------- 컴퓨터 정보 -------");
        Bukkit.getLogger().info("[IF-Block] CPU : " + CPU);
        Bukkit.getLogger().info("[IF-Block] RAM : " + RAM);
        Bukkit.getLogger().info("[IF-Block] OS : " + OS);
        Bukkit.getLogger().info("[IF-Block] JAVA : " + JAVA);
        Bukkit.getLogger().warning("[경고] " + "서버 컴퓨터의 성능이 부족할 경우 서버가 불안정할 수 있습니다.");
    }

    public void updateBlockListener(String newBlockName) {
        PlayerMoveEvent.getHandlerList().unregister(touchBlockListener);
        touchBlockListener = new TouchBlock(newBlockName);
        getServer().getPluginManager().registerEvents(touchBlockListener, this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().warning("[IF-Block] 서버 종료가 감지되었습니다.");
        Bukkit.getLogger().info("[IF-Block] 저장하고 서버를 종료합니다.");
        Bukkit.savePlayers();
        Bukkit.shutdown();
    }
}
