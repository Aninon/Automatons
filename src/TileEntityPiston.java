// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            TileEntity, PistonBlockTextures, Block, BlockPistonMoving, 
//            World, Entity, NBTTagCompound

public class TileEntityPiston extends TileEntity
{

    public TileEntityPiston()
    {
    }

    public TileEntityPiston(int i, int j, int k, boolean flag, boolean flag1)
    {
        storedBlockID = i;
        storedMetadata = j;
        facing = k;
        extending = flag;
        field_31023_j = flag1;
    }

    public int getStoredBlockID()
    {
        return storedBlockID;
    }

    public int getBlockMetadata()
    {
        return storedMetadata;
    }

    public boolean func_31015_b()
    {
        return extending;
    }

    public int func_31009_d()
    {
        return facing;
    }

    public boolean func_31012_k()
    {
        return field_31023_j;
    }

    public float func_31008_a(float f)
    {
        if(f > 1.0F)
        {
            f = 1.0F;
        }
        return progress + (field_31022_k - progress) * f;
    }

    public float func_31017_b(float f)
    {
        if(extending)
        {
            return (func_31008_a(f) - 1.0F) * (float)PistonBlockTextures.offsetsXForSide[facing];
        } else
        {
            return (1.0F - func_31008_a(f)) * (float)PistonBlockTextures.offsetsXForSide[facing];
        }
    }

    public float func_31014_c(float f)
    {
        if(extending)
        {
            return (func_31008_a(f) - 1.0F) * (float)PistonBlockTextures.offsetsYForSide[facing];
        } else
        {
            return (1.0F - func_31008_a(f)) * (float)PistonBlockTextures.offsetsYForSide[facing];
        }
    }

    public float func_31013_d(float f)
    {
        if(extending)
        {
            return (func_31008_a(f) - 1.0F) * (float)PistonBlockTextures.offsetsZForSide[facing];
        } else
        {
            return (1.0F - func_31008_a(f)) * (float)PistonBlockTextures.offsetsZForSide[facing];
        }
    }

    private void func_31010_a(float f, float f1)
    {
        if(!extending)
        {
            f--;
        } else
        {
            f = 1.0F - f;
        }
        AxisAlignedBB axisalignedbb = Block.pistonMoving.func_31035_a(worldObj, xCoord, yCoord, zCoord, storedBlockID, f, facing);
        if(axisalignedbb != null)
        {
            List list = worldObj.getEntitiesWithinAABBExcludingEntity(null, axisalignedbb);
            if(!list.isEmpty())
            {
                field_31018_m.addAll(list);
                Entity entity;
                for(Iterator iterator = field_31018_m.iterator(); iterator.hasNext(); entity.moveEntity(f1 * (float)PistonBlockTextures.offsetsXForSide[facing], f1 * (float)PistonBlockTextures.offsetsYForSide[facing], f1 * (float)PistonBlockTextures.offsetsZForSide[facing]))
                {
                    entity = (Entity)iterator.next();
                }

                field_31018_m.clear();
            }
        }
    }

    public void func_31011_l()
    {
        if(progress < 1.0F)
        {
            progress = field_31022_k = 1.0F;
            worldObj.removeBlockTileEntity(xCoord, yCoord, zCoord);
            func_31005_i();
            if(worldObj.getBlockId(xCoord, yCoord, zCoord) == Block.pistonMoving.blockID)
            {
                worldObj.setBlockAndMetadataWithNotify(xCoord, yCoord, zCoord, storedBlockID, storedMetadata);
            }
        }
    }

    public void updateEntity()
    {
        progress = field_31022_k;
        if(progress >= 1.0F)
        {
            func_31010_a(1.0F, 0.25F);
            worldObj.removeBlockTileEntity(xCoord, yCoord, zCoord);
            func_31005_i();
            if(worldObj.getBlockId(xCoord, yCoord, zCoord) == Block.pistonMoving.blockID)
            {
                worldObj.setBlockAndMetadataWithNotify(xCoord, yCoord, zCoord, storedBlockID, storedMetadata);
            }
            return;
        }
        field_31022_k += 0.5F;
        if(field_31022_k >= 1.0F)
        {
            field_31022_k = 1.0F;
        }
        if(extending)
        {
            func_31010_a(field_31022_k, (field_31022_k - progress) + 0.0625F);
        }
    }

    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        storedBlockID = nbttagcompound.getInteger("blockId");
        storedMetadata = nbttagcompound.getInteger("blockData");
        facing = nbttagcompound.getInteger("facing");
        progress = field_31022_k = nbttagcompound.getFloat("progress");
        extending = nbttagcompound.getBoolean("extending");
    }

    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setInteger("blockId", storedBlockID);
        nbttagcompound.setInteger("blockData", storedMetadata);
        nbttagcompound.setInteger("facing", facing);
        nbttagcompound.setFloat("progress", progress);
        nbttagcompound.setBoolean("extending", extending);
    }

    private int storedBlockID;
    private int storedMetadata;
    private int facing;
    private boolean extending;
    private boolean field_31023_j;
    private float field_31022_k;
    private float progress;
    private static List field_31018_m = new ArrayList();

}
