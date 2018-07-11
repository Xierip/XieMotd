package pl.xierip.xiemotd.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import pl.xierip.xiemotd.XieMotd;

/**
 * Created by Xierip on 2017-09-23.
 * Web: http://xierip.pl
 */
public class ServerListPingListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
    public void onEvent(final ServerListPingEvent event) {
        event.setMotd(XieMotd.getMotd());
    }
}