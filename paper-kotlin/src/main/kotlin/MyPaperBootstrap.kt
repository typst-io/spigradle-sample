import io.papermc.paper.plugin.bootstrap.BootstrapContext
import io.papermc.paper.plugin.bootstrap.PluginBootstrap

class MyPaperBootstrap : PluginBootstrap {
    override fun bootstrap(context: BootstrapContext) {
        println("bootstrap")
    }
}