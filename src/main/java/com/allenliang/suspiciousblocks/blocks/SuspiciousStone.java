package com.allenliang.suspiciousblocks.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class SuspiciousStone extends Block{



    public SuspiciousStone() {
        super(AbstractBlock.Properties.create(Material.TNT, MaterialColor.STONE).zeroHardnessAndResistance());
    }

    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
        System.out.println("player clicked!!!!!!!");
    }

    public void catchFire(BlockState state, World world, BlockPos pos, @Nullable net.minecraft.util.Direction face, @Nullable LivingEntity igniter) {
        System.out.println("IT GOT CALLED!!!!!");
    }

    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!oldState.isIn(state.getBlock())) {
            System.out.println("BLOCK ADDED");
//            explode(worldIn, pos);
        }
    }

    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        explode(worldIn, pos);
    }

    public void explode(World worldIn, BlockPos pos) {
        worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 4.0F, Explosion.Mode.BREAK);
    }
}
