package com.hrznstudio.infinityfix;

import org.sandboxpowered.sandbox.api.SandboxAPI;
import org.sandboxpowered.sandbox.api.addon.Addon;
import org.sandboxpowered.sandbox.api.enchant.Enchantments;
import org.sandboxpowered.sandbox.api.event.EnchantmentEvent;
import org.sandboxpowered.sandbox.api.event.EventResult;
import org.sandboxpowered.sandbox.api.event.ItemEvent;
import org.sandboxpowered.sandbox.api.item.ItemStack;
import org.sandboxpowered.sandbox.api.item.Items;

public class InfinityFix implements Addon {
    @Override
    public void init(SandboxAPI api) {
        api.on(ItemEvent.GetArrowType.class,
                ev -> ev.getArrow().isEmpty(),
                ev -> ev.setArrow(ItemStack.of(Items.ARROW))
        );
        api.on(EnchantmentEvent.Compatible.class,
                ev -> ev.matches(Enchantments.INFINITY, Enchantments.MENDING),
                ev -> ev.setResult(EventResult.SUCCESS)
        );
    }
}