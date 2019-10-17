package com.songoda.epicfarming.listeners;

import com.songoda.epicfarming.EpicFarming;
import com.songoda.epicfarming.farming.Farm;
import com.songoda.epicfarming.settings.Settings;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

import java.util.ArrayList;

public class UnloadListeners implements Listener {

    private EpicFarming instance;

    public UnloadListeners(EpicFarming instance) {
        this.instance = instance;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onUnload(ChunkUnloadEvent event) {
        Material type = Settings.FARM_BLOCK_MATERIAL.getMaterial().getMaterial();
        for (Farm farm : new ArrayList<>(instance.getFarmManager().getFarms().values())) {
            int x = farm.getLocation().getBlockX() >> 4;
            int z = farm.getLocation().getBlockZ() >> 4;
            if (event.getChunk().getX() == x && event.getChunk().getZ() == z) {
                if (farm.getLocation().getBlock().getType() != type)
                    instance.getFarmManager().removeFarm(farm.getLocation());
            }
        }
    }
}