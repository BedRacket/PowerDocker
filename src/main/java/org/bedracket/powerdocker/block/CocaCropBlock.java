package org.bedracket.powerdocker.block;

import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.bedracket.powerdocker.init.ModItems;

public class CocaCropBlock extends CropBlock {

    private static final VoxelShape[] AGE_TO_SHAPE =
            new VoxelShape[]{
                    Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 8.0, 13.0),
                    Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 8.0, 13.0),
                    Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0),
                    Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0),
                    Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0),
                    Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0),
                    Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0),
                    Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0)};

    public CocaCropBlock() {
        super(Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.COCA;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
    }
}
