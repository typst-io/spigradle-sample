package kr.entree.samplespigot;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.File;

public class SpigradleSample extends JavaPlugin {
    public SpigradleSample() {
    }

    // Constructor for MockBukkit
    public SpigradleSample(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
    }

    @Override
    public void onEnable() {
        getLogger().info("This is Spigot plugin!");
    }
}
