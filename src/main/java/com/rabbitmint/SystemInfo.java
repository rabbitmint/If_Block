package com.rabbitmint;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class SystemInfo {
    public static String getTotalRAM() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        long totalRamMB = osBean.getTotalPhysicalMemorySize() / (1024 * 1024);
        return totalRamMB + " MB";
    }

    public static String getCPUName() {
        String cpuName = System.getenv("PROCESSOR_IDENTIFIER");
        if (cpuName == null) {
            cpuName = "Unknown CPU";
        }
        return cpuName;
    }

    public static String getOSName() {
        return System.getProperty("os.name");
    }

    public static String getJAVAVersion() {
        return System.getProperty("java.version");
    }
}
