// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet27Position extends Packet
{

    public Packet27Position()
    {
    }

    public void readPacketData(DataInputStream datainputstream)
        throws IOException
    {
        strafeMovement = datainputstream.readFloat();
        fowardMovement = datainputstream.readFloat();
        pitchRotation = datainputstream.readFloat();
        yawRotation = datainputstream.readFloat();
        field_22043_c = datainputstream.readBoolean();
        field_22042_d = datainputstream.readBoolean();
    }

    public void writePacketData(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeFloat(strafeMovement);
        dataoutputstream.writeFloat(fowardMovement);
        dataoutputstream.writeFloat(pitchRotation);
        dataoutputstream.writeFloat(yawRotation);
        dataoutputstream.writeBoolean(field_22043_c);
        dataoutputstream.writeBoolean(field_22042_d);
    }

    public void processPacket(NetHandler nethandler)
    {
        nethandler.func_22185_a(this);
    }

    public int getPacketSize()
    {
        return 18;
    }

    private float strafeMovement;
    private float fowardMovement;
    private boolean field_22043_c;
    private boolean field_22042_d;
    private float pitchRotation;
    private float yawRotation;
}
