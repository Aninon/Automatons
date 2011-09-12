// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, EnumToolMaterial, Material

public class AM_ItemAPickaxe extends AM_ItemATool
{

    protected AM_ItemAPickaxe(int i, List L)
    {
	
	//GOLD("GOLD", 4, 0, 32, 12F, 0);
        super(i, 2, L, blocksEffectiveAgainst);
    }

    public boolean canHarvestBlock(Block block)
    {
	return block.getHardness()<=3;
	/*
        if(block == Block.obsidian)
        {
            return getHarvestLevel() == 3;
        }
        if(block == Block.blockDiamond || block == Block.oreDiamond)
        {
            return getHarvestLevel() >= 2;
        }
        if(block == Block.blockGold || block == Block.oreGold)
        {
            return getHarvestLevel() >= 2;
        }
        if(block == Block.blockSteel || block == Block.oreIron)
        {
            return getHarvestLevel() >= 1;
        }
        if(block == Block.blockLapis || block == Block.oreLapis)
        {
            return getHarvestLevel() >= 1;
        }
        if(block == Block.oreRedstone || block == Block.oreRedstoneGlowing)
        {
            return getHarvestLevel() >= 2;
        }
        if(block.blockMaterial == Material.rock)
        {
            return true;
        }*/
        //return block.blockMaterial == Material.iron;
		//return true;
    }

    private static Block blocksEffectiveAgainst[];

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            Block.cobblestone, Block.stairDouble, Block.stairSingle, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold, 
            Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis,
			
			Block.blocksList[AutomatonLogger.tech],Block.blocksList[AutomatonLogger.frass],Block.blocksList[AutomatonLogger.deployer]
			
			
        });
    }
}
