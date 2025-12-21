import io.papermc.paper.plugin.loader.PluginClasspathBuilder
import io.papermc.paper.plugin.loader.PluginLoader

class MyPaperLoader : PluginLoader {
    override fun classloader(classpathBuilder: PluginClasspathBuilder) {
        println("loader")
    }
}