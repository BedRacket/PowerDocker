package org.bedracket.powerdocker.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.bedracket.entity_events.event.EntityJoinWorldEvent;
import org.bedracket.eventbus.event.EventHandler;
import org.bedracket.eventbus.event.Listener;

public class PlayerEvents implements Listener {

    @EventHandler
    public void onPlayerLogin(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof PlayerEntity) {
            entity.sendMessage(Text.literal("Hellow World!"));
        }
    }
}
