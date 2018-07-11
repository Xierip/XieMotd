package pl.xierip.xiemotd.commands;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.xierip.xiemotd.XieMotd;
import pl.xierip.xiemotd.util.Util;

/**
 * Created by Xierip on 2017-09-23.
 * Web: http://xierip.pl
 */
public class MotdCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!command.getName().equalsIgnoreCase("xiemotd")) return false;
        if (args.length > 0) {
            switch (args[0].toLowerCase()) {
                case "set":
                    if (args.length == 1) {
                        return Util.sendMessage(commandSender, "&8>> &c/xmotd set &6<text> <- ustawia motd, zmienna nowej linii {NEXT_LINE}");
                    }
                    XieMotd.setMotd(StringUtils.join(args, " ", 1, args.length));
                    return Util.sendMessage(commandSender, XieMotd.getMotd());
                case "show":
                    return Util.sendMessage(commandSender, XieMotd.getMotd());
                case "reload":
                    XieMotd.reloadMotd();
                    return Util.sendMessage(commandSender, "&aPrzeladowano!");
                default:
                    break;
            }
        }
        Util.sendMessage(commandSender, "    &8&l[&4&lXieMotd&8&l]&8:");
        Util.sendMessage(commandSender, "&8>> &c/xmotd set &6<text> <- ustawia motd, zmienna nowej linii {NEXT_LINE}");
        Util.sendMessage(commandSender, "&8>> &c/xmotd show &7<< pokazuje motd");
        return Util.sendMessage(commandSender, "&8>> &c/xmotd reload &7<< reload configu");

    }
}
