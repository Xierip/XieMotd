package pl.xierip.xiemotd;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.xierip.xiemotd.commands.MotdCommand;
import pl.xierip.xiemotd.listeners.ServerListPingListener;
import pl.xierip.xiemotd.util.Util;

/**
 * Created by Xierip on 2017-09-23.
 * Web: http://xierip.pl
 */
public class XieMotd extends JavaPlugin {
    @Getter
    private static XieMotd instance;
    @Getter
    private static String motd;

    public XieMotd() {
        XieMotd.instance = this;
    }

    public static void setMotd(String newMotd) {
        instance.getConfig().set("Xierip.XieMotd.Motd", newMotd);
        instance.saveConfig();
        motd = Util.replace(Util.fixColors(newMotd), "{NEW_LINE}", "\n");
    }

    public static boolean reloadMotd() {
        try {
            instance.reloadConfig();
            motd = Util.replace(Util.fixColors(instance.getConfig().getString("Xierip.XieMotd.Motd")), "{NEW_LINE}", "\n");
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        motd = Util.replace(Util.fixColors(getConfig().getString("Xierip.XieMotd.Motd")), "{NEW_LINE}", "\n");
        getCommand("xiemotd").setExecutor(new MotdCommand());
        Bukkit.getPluginManager().registerEvents(new ServerListPingListener(), this);
    }

    @Override
    public void onDisable() {

    }
}