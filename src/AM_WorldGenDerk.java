
package net.minecraft.src;
import java.util.Random;

public class AM_WorldGenDerk extends WorldGenerator
{

    public AM_WorldGenDerk()
    {
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {

	int bb=world.getBlockId(i,j-1,k);
	if(bb==AutomatonLogger.frass){
	int h=random.nextInt(3)+1;
		for(int n=0;n<h;n++){
			world.setBlockAndMetadataWithNotify(i, j+n, k, AutomatonLogger.grower,5);
			
		}
		world.setBlockAndMetadataWithNotify(i, j+h, k, AutomatonLogger.crink,(7+h-1));
	}

        return true;
    }

}
