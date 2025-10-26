package kr.entree.samplespigot

import org.bukkit.plugin.PluginDescriptionFile
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.java.JavaPluginLoader
import java.io.File

class SpigradleSample : JavaPlugin {
    constructor() : super()

    // Constructor for MockBukkit. if you don't need it, use: "class SpigradleSample() : JavaPlugin()" without both constructors.
    constructor(loader: JavaPluginLoader, description: PluginDescriptionFile, dataFolder: File, file: File?) : super(loader, description, dataFolder, file
            ?: File(""))

    override fun onEnable() {
        logger.info("This is Spigot plugin!");
    }
}