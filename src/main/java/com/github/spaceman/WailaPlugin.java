package com.github.spaceman;

import mcp.mobius.waila.api.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class WailaPlugin implements IWailaPlugin, IBlockComponentProvider {
    @Override
    public void register(IRegistrar registrar) {
        registrar.addOverride(this, Block.class);
    }

    @Override
    public BlockState getOverride(IBlockAccessor accessor, IPluginConfig config) {
        return SecretRooms.wailaOverrides.get(accessor.getBlock());
    }
}
