/*******************************************************************************
 * Copyright 2021, the Glitchfiend Team.
 * All rights reserved.
 ******************************************************************************/
package biomesoplenty.common.block.trees;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class BigTreeDefaultConfig extends AbstractMegaTreeGrower
{
    @Override
    @Nullable
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random random, boolean hasFlowers)
    {
        return null;
    }

    @Override
    @Nullable
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredMegaFeature(Random random)
    {
        return null;
    }

    protected abstract Feature<? extends TreeConfiguration> getFeature(Random random);
    protected abstract Feature<? extends TreeConfiguration> getBigFeature(Random random);

    @Override
    public boolean growTree(ServerLevel world, ChunkGenerator generator, BlockPos pos, BlockState state, Random random)
    {
        for (int i = 0; i >= -1; --i)
        {
            for (int j = 0; j >= -1; --j)
            {
                if (isTwoByTwoSapling(state, world, pos, i, j))
                {
                    return this.placeMega(world, generator, pos, state, random, i, j);
                }
            }
        }

        Feature<TreeConfiguration> feature = (Feature<TreeConfiguration>)this.getFeature(random);

        if (feature == null)
        {
            return false;
        }
        else
        {
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 4);
            return false;
// TODO:
//            if (feature.place(new FeaturePlaceContext<>(world, generator, random, pos, TreeFeatures.OAK.config())))
//            {
//                return true;
//            }
//            else
//            {
//                world.setBlock(pos, state, 4);
//                return false;
//            }
        }
    }

    @Override
    public boolean placeMega(ServerLevel world, ChunkGenerator generator, BlockPos pos, BlockState state, Random random, int x, int z)
    {
        Feature<TreeConfiguration> feature = (Feature<TreeConfiguration>)this.getBigFeature(random);
        if (feature == null)
        {
            return false;
        }
        else
        {
            BlockState blockstate = Blocks.AIR.defaultBlockState();
            world.setBlock(pos.offset(x, 0, z), blockstate, 4);
            world.setBlock(pos.offset(x + 1, 0, z), blockstate, 4);
            world.setBlock(pos.offset(x, 0, z + 1), blockstate, 4);
            world.setBlock(pos.offset(x + 1, 0, z + 1), blockstate, 4);
            return false;
// TODO:
//            if (feature.place(new FeaturePlaceContext<>(world, generator, random, pos.offset(x, 0, z), TreeFeatures.OAK.config())))
//            {
//                return true;
//            }
//            else
//            {
//                world.setBlock(pos.offset(x, 0, z), state, 4);
//                world.setBlock(pos.offset(x + 1, 0, z), state, 4);
//                world.setBlock(pos.offset(x, 0, z + 1), state, 4);
//                world.setBlock(pos.offset(x + 1, 0, z + 1), state, 4);
//                return false;
//            }
        }
    }

}