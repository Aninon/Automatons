// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.PrintStream;

// Referenced classes of package net.minecraft.src:
//            Potion, EntityLiving

public class PotionEffect
{

    public PotionEffect(int i, int j, int k)
    {
        potionID = i;
        field_35803_b = j;
        field_35804_c = k;
    }

    public void func_35796_a(PotionEffect potioneffect)
    {
        if(potionID != potioneffect.potionID)
        {
            System.err.println("This method should only be called for matching effects!");
        }
        if(potioneffect.field_35804_c >= field_35804_c)
        {
            field_35804_c = potioneffect.field_35804_c;
            field_35803_b = potioneffect.field_35803_b;
        }
    }

    public int getPotionID()
    {
        return potionID;
    }

    public int func_35802_b()
    {
        return field_35803_b;
    }

    public int func_35801_c()
    {
        return field_35804_c;
    }

    public boolean func_35798_a(EntityLiving entityliving)
    {
        if(field_35803_b > 0)
        {
            if(Potion.potionArray[potionID].func_35660_a(field_35803_b, field_35804_c))
            {
                func_35800_b(entityliving);
            }
            func_35797_d();
        }
        return field_35803_b > 0;
    }

    private int func_35797_d()
    {
        return --field_35803_b;
    }

    public void func_35800_b(EntityLiving entityliving)
    {
        if(field_35803_b > 0)
        {
            Potion.potionArray[potionID].performEffect(entityliving, field_35804_c);
        }
    }

    public int hashCode()
    {
        return potionID;
    }

    private int potionID;
    private int field_35803_b;
    private int field_35804_c;
}
