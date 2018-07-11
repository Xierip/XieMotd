package pl.xierip.xiemotd.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Xierip on 2016-06-25.
 * DarkElite.pl ©
 */
public class Util {

    public static boolean sendMessage(CommandSender commandSender, String message) {
        commandSender.sendMessage(fixColors(message));
        return true;
    }

    public static String fixColors(final String string) {
        return replace(replace(ChatColor.translateAlternateColorCodes('&', string), ">>", "\u00bb"), "<<", "\u00ab");
    }

    public static String replace(final String text, final String searchString, final String replacement) {
        if (text == null || text.isEmpty() || searchString.isEmpty() || replacement == null) {
            return text;
        }
        int start = 0;
        int max = -1;
        int end = text.indexOf(searchString, start);
        if (end == -1) {
            return text;
        }
        final int replacedLength = searchString.length();
        int increase = replacement.length() - replacedLength;
        increase = (increase < 0 ? 0 : increase);
        increase *= (max < 0 ? 16 : (max > 64 ? 64 : max));
        final StringBuilder sb = new StringBuilder(text.length() + increase);
        while (end != -1) {
            sb.append(text.substring(start, end)).append(replacement);
            start = end + replacedLength;
            if (--max == 0) {
                break;
            }
            end = text.indexOf(searchString, start);
        }
        sb.append(text.substring(start));
        return sb.toString();
    }

}
