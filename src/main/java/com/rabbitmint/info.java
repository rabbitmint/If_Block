package com.rabbitmint;

public interface info {
    String Name = "만약 ~ 블럭을 밟으면?";
    String Developer = "RabbitMint";
    String Version = "2.3";
    String BuildDate = "2024.11.01";
    String API = "SPIGOT 1.20";

    String RAM = SystemInfo.getTotalRAM();
    String CPU = SystemInfo.getCPUName();
    String OS = SystemInfo.getOSName();
    String JAVA = SystemInfo.getJAVAVersion();
}
