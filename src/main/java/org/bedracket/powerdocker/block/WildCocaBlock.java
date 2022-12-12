package org.bedracket.powerdocker.block;

import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.bedracket.powerdocker.init.ModItems;

public class WildCocaBlock extends FlowerBlock implements Fertilizable {

    public WildCocaBlock() {
        super(StatusEffects.SPEED, 8, AbstractBlock.Settings.copy(Blocks.DANDELION));
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return (double) random.nextFloat() < 0.3F;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        dropStack(world, pos, new ItemStack(ModItems.COCA));
        world.setBlockState(pos, Blocks.AIR.getDefaultState());
    }
}
