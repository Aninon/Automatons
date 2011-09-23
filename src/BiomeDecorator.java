// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenClay, WorldGenSand, Block, WorldGenMinable, 
//            WorldGenFlowers, BlockFlower, WorldGenReed, WorldGenCactus, 
//            World, WorldGenerator, BiomeGenBase, WorldGenTallGrass, 
//            BlockTallGrass, WorldGenDeadBush, BlockDeadBush, WorldGenPumpkin, 
//            WorldGenLiquids

public class BiomeDecorator
{

    public BiomeDecorator(BiomeGenBase biomegenbase)
    {
        clayGen = new WorldGenClay(4);
        sandGen = new WorldGenSand(7, Block.sand.blockID);
        gravelAsSandGen = new WorldGenSand(6, Block.gravel.blockID);
        dirtGen = new WorldGenMinable(Block.dirt.blockID, 32);
        gravelGen = new WorldGenMinable(Block.gravel.blockID, 32);
        coalGen = new WorldGenMinable(Block.oreCoal.blockID, 16);
        ironGen = new WorldGenMinable(Block.oreIron.blockID, 8);
        goldGen = new WorldGenMinable(Block.oreGold.blockID, 8);
        redstoneGen = new WorldGenMinable(Block.oreRedstone.blockID, 7);
        diamondGen = new WorldGenMinable(Block.oreDiamond.blockID, 7);
        lapisGen = new WorldGenMinable(Block.oreLapis.blockID, 6);
        plantYellowGen1 = new WorldGenFlowers(Block.plantYellow.blockID);
        plantYellowGen2 = new WorldGenFlowers(Block.plantYellow.blockID);
        mushroomBrownGen = new WorldGenFlowers(Block.mushroomBrown.blockID);
        mushroomRedGen = new WorldGenFlowers(Block.mushroomRed.blockID);
        reedGen = new WorldGenReed();
        cactusGen = new WorldGenCactus();
        field_35911_r = 0;
        field_35910_s = 2;
        field_35909_t = 1;
        field_35908_u = 0;
        field_35907_v = 0;
        field_35906_w = 0;
        field_35916_x = 0;
        field_35915_y = 1;
        field_35914_z = 3;
        field_35888_A = 1;
        biome = biomegenbase;
    }

    public void decorate(World world, Random random, int i, int j)
    {
        if(currentWorld != null)
        {
            throw new RuntimeException("Already decorating!!");
        } else
        {
            currentWorld = world;
            field_35890_C = random;
            chunk_X = i;
            chunk_Z = j;
            decorate_do();
            currentWorld = null;
            field_35890_C = null;
            return;
        }
    }

    private void decorate_do()
    {
        generateOres();
        for(int i = 0; i < field_35914_z; i++)
        {
            int i1 = chunk_X + field_35890_C.nextInt(16) + 8;
            int i5 = chunk_Z + field_35890_C.nextInt(16) + 8;
            sandGen.generate(currentWorld, field_35890_C, i1, currentWorld.getTopSolidOrLiquidBlock(i1, i5), i5);
        }

        for(int j = 0; j < field_35888_A; j++)
        {
            int j1 = chunk_X + field_35890_C.nextInt(16) + 8;
            int j5 = chunk_Z + field_35890_C.nextInt(16) + 8;
            clayGen.generate(currentWorld, field_35890_C, j1, currentWorld.getTopSolidOrLiquidBlock(j1, j5), j5);
        }

        for(int k = 0; k < field_35915_y; k++)
        {
            int k1 = chunk_X + field_35890_C.nextInt(16) + 8;
            int k5 = chunk_Z + field_35890_C.nextInt(16) + 8;
            sandGen.generate(currentWorld, field_35890_C, k1, currentWorld.getTopSolidOrLiquidBlock(k1, k5), k5);
        }

        int l = field_35911_r;
        if(field_35890_C.nextInt(10) == 0)
        {
            l++;
        }
        for(int l1 = 0; l1 < l; l1++)
        {
            int l5 = chunk_X + field_35890_C.nextInt(16) + 8;
            int k9 = chunk_Z + field_35890_C.nextInt(16) + 8;
            WorldGenerator worldgenerator = biome.getRandomWorldGenForTrees(field_35890_C);
            worldgenerator.func_517_a(1.0D, 1.0D, 1.0D);
            worldgenerator.generate(currentWorld, field_35890_C, l5, currentWorld.getHeightValue(l5, k9), k9);
        }

        for(int i2 = 0; i2 < field_35910_s; i2++)
        {
            int i6 = chunk_X + field_35890_C.nextInt(16) + 8;
            currentWorld.getClass();
            int l9 = field_35890_C.nextInt(128);
            int j13 = chunk_Z + field_35890_C.nextInt(16) + 8;
            plantYellowGen1.generate(currentWorld, field_35890_C, i6, l9, j13);
            if(field_35890_C.nextInt(4) == 0)
            {
                int j6 = chunk_X + field_35890_C.nextInt(16) + 8;
                currentWorld.getClass();
                int i10 = field_35890_C.nextInt(128);
                int k13 = chunk_Z + field_35890_C.nextInt(16) + 8;
                plantYellowGen2.generate(currentWorld, field_35890_C, j6, i10, k13);
            }
        }

        for(int j2 = 0; j2 < field_35909_t; j2++)
        {
            int k6 = 1;
            int j10 = chunk_X + field_35890_C.nextInt(16) + 8;
            currentWorld.getClass();
            int l13 = field_35890_C.nextInt(128);
            int i16 = chunk_Z + field_35890_C.nextInt(16) + 8;
            (new WorldGenTallGrass(Block.tallGrass.blockID, k6)).generate(currentWorld, field_35890_C, j10, l13, i16);
        }

        for(int k2 = 0; k2 < field_35908_u; k2++)
        {
            int l6 = chunk_X + field_35890_C.nextInt(16) + 8;
            currentWorld.getClass();
            int k10 = field_35890_C.nextInt(128);
            int i14 = chunk_Z + field_35890_C.nextInt(16) + 8;
            (new WorldGenDeadBush(Block.deadBush.blockID)).generate(currentWorld, field_35890_C, l6, k10, i14);
        }

        for(int l2 = 0; l2 < field_35907_v; l2++)
        {
            if(field_35890_C.nextInt(4) == 0)
            {
                int i7 = chunk_X + field_35890_C.nextInt(16) + 8;
                int l10 = chunk_Z + field_35890_C.nextInt(16) + 8;
                int j14 = currentWorld.getHeightValue(i7, l10);
                mushroomBrownGen.generate(currentWorld, field_35890_C, i7, j14, l10);
            }
            if(field_35890_C.nextInt(8) == 0)
            {
                int j7 = chunk_X + field_35890_C.nextInt(16) + 8;
                int i11 = chunk_Z + field_35890_C.nextInt(16) + 8;
                currentWorld.getClass();
                int k14 = field_35890_C.nextInt(128);
                mushroomRedGen.generate(currentWorld, field_35890_C, j7, k14, i11);
            }
        }

        if(field_35890_C.nextInt(4) == 0)
        {
            int i3 = chunk_X + field_35890_C.nextInt(16) + 8;
            currentWorld.getClass();
            int k7 = field_35890_C.nextInt(128);
            int j11 = chunk_Z + field_35890_C.nextInt(16) + 8;
            mushroomBrownGen.generate(currentWorld, field_35890_C, i3, k7, j11);
        }
        if(field_35890_C.nextInt(8) == 0)
        {
            int j3 = chunk_X + field_35890_C.nextInt(16) + 8;
            currentWorld.getClass();
            int l7 = field_35890_C.nextInt(128);
            int k11 = chunk_Z + field_35890_C.nextInt(16) + 8;
            mushroomRedGen.generate(currentWorld, field_35890_C, j3, l7, k11);
        }
        for(int k3 = 0; k3 < field_35906_w; k3++)
        {
            int i8 = chunk_X + field_35890_C.nextInt(16) + 8;
            int l11 = chunk_Z + field_35890_C.nextInt(16) + 8;
            currentWorld.getClass();
            int l14 = field_35890_C.nextInt(128);
            reedGen.generate(currentWorld, field_35890_C, i8, l14, l11);
        }

        for(int l3 = 0; l3 < 10; l3++)
        {
            int j8 = chunk_X + field_35890_C.nextInt(16) + 8;
            currentWorld.getClass();
            int i12 = field_35890_C.nextInt(128);
            int i15 = chunk_Z + field_35890_C.nextInt(16) + 8;
            reedGen.generate(currentWorld, field_35890_C, j8, i12, i15);
        }

        if(field_35890_C.nextInt(32) == 0)
        {
            int i4 = chunk_X + field_35890_C.nextInt(16) + 8;
            currentWorld.getClass();
            int k8 = field_35890_C.nextInt(128);
            int j12 = chunk_Z + field_35890_C.nextInt(16) + 8;
            (new WorldGenPumpkin()).generate(currentWorld, field_35890_C, i4, k8, j12);
        }
        for(int j4 = 0; j4 < field_35916_x; j4++)
        {
            int l8 = chunk_X + field_35890_C.nextInt(16) + 8;
            currentWorld.getClass();
            int k12 = field_35890_C.nextInt(128);
            int j15 = chunk_Z + field_35890_C.nextInt(16) + 8;
            cactusGen.generate(currentWorld, field_35890_C, l8, k12, j15);
        }

        for(int k4 = 0; k4 < 50; k4++)
        {
            int i9 = chunk_X + field_35890_C.nextInt(16) + 8;
            currentWorld.getClass();
            int l12 = field_35890_C.nextInt(field_35890_C.nextInt(128 - 8) + 8);
            int k15 = chunk_Z + field_35890_C.nextInt(16) + 8;
            (new WorldGenLiquids(Block.waterMoving.blockID)).generate(currentWorld, field_35890_C, i9, l12, k15);
        }

        for(int l4 = 0; l4 < 20; l4++)
        {
            int j9 = chunk_X + field_35890_C.nextInt(16) + 8;
            currentWorld.getClass();
            int i13 = field_35890_C.nextInt(field_35890_C.nextInt(field_35890_C.nextInt(128 - 16) + 8) + 8);
            int l15 = chunk_Z + field_35890_C.nextInt(16) + 8;
            (new WorldGenLiquids(Block.lavaMoving.blockID)).generate(currentWorld, field_35890_C, j9, i13, l15);
        }

    }

    protected void func_35884_a(int i, WorldGenerator worldgenerator, int j, int k)
    {
        for(int l = 0; l < i; l++)
        {
            int i1 = chunk_X + field_35890_C.nextInt(16);
            int j1 = field_35890_C.nextInt(k - j) + j;
            int k1 = chunk_Z + field_35890_C.nextInt(16);
            worldgenerator.generate(currentWorld, field_35890_C, i1, j1, k1);
        }

    }

    protected void func_35883_b(int i, WorldGenerator worldgenerator, int j, int k)
    {
        for(int l = 0; l < i; l++)
        {
            int i1 = chunk_X + field_35890_C.nextInt(16);
            int j1 = field_35890_C.nextInt(k) + field_35890_C.nextInt(k) + (j - k);
            int k1 = chunk_Z + field_35890_C.nextInt(16);
            worldgenerator.generate(currentWorld, field_35890_C, i1, j1, k1);
        }

    }

    protected void generateOres()
    {
        currentWorld.getClass();
        func_35884_a(20, dirtGen, 0, 128);
        currentWorld.getClass();
        func_35884_a(10, gravelGen, 0, 128);
        currentWorld.getClass();
        func_35884_a(20, coalGen, 0, 128);
        currentWorld.getClass();
        func_35884_a(20, ironGen, 0, 128 / 2);
        currentWorld.getClass();
        func_35884_a(2, goldGen, 0, 128 / 4);
        currentWorld.getClass();
        func_35884_a(8, redstoneGen, 0, 128 / 8);
        currentWorld.getClass();
        func_35884_a(1, diamondGen, 0, 128 / 8);
        currentWorld.getClass();
        currentWorld.getClass();
        func_35883_b(1, lapisGen, 128 / 8, 128 / 8);
    }

    private World currentWorld;
    private Random field_35890_C;
    private int chunk_X;
    private int chunk_Z;
    private BiomeGenBase biome;
    protected WorldGenerator clayGen;
    protected WorldGenerator sandGen;
    protected WorldGenerator gravelAsSandGen;
    protected WorldGenerator dirtGen;
    protected WorldGenerator gravelGen;
    protected WorldGenerator coalGen;
    protected WorldGenerator ironGen;
    protected WorldGenerator goldGen;
    protected WorldGenerator redstoneGen;
    protected WorldGenerator diamondGen;
    protected WorldGenerator lapisGen;
    protected WorldGenerator plantYellowGen1;
    protected WorldGenerator plantYellowGen2;
    protected WorldGenerator mushroomBrownGen;
    protected WorldGenerator mushroomRedGen;
    protected WorldGenerator reedGen;
    protected WorldGenerator cactusGen;
    protected int field_35911_r;
    protected int field_35910_s;
    protected int field_35909_t;
    protected int field_35908_u;
    protected int field_35907_v;
    protected int field_35906_w;
    protected int field_35916_x;
    protected int field_35915_y;
    protected int field_35914_z;
    protected int field_35888_A;
}
