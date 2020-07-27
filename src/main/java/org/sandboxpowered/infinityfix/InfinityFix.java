package org.sandboxpowered.infinityfix;

import org.sandboxpowered.api.SandboxAPI;
import org.sandboxpowered.api.addon.Addon;
import org.sandboxpowered.api.enchantment.Enchantments;
import org.sandboxpowered.api.events.ItemEvents;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.item.Items;
import org.sandboxpowered.api.registry.Registrar;

public class InfinityFix implements Addon {
    @Override
    public void init(SandboxAPI sandboxAPI) {
        ItemEvents.GET_ARROW_TYPE.subscribe((playerEntity, args) -> {
            if(args.getArrow().isEmpty() & args.getWeapon().getLevel(Enchantments.INFINITY.get())>0) {
                args.setArrow(ItemStack.of(Items.ARROW));
            }
        });
        //TODO waiting on more events PR
//        api.on(EnchantmentEvent.Compatible.class,
//                ev -> ev.matches(Enchantments.INFINITY, Enchantments.MENDING),
//                ev -> ev.setResult(EventResult.SUCCESS)
//        );
    }

    @Override
    public void register(Registrar registrar) {

    }
}