
package net.minecraft.src;
import java.util.Map;
import java.util.Arrays;
import java.io.File;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.Display;
import java.nio.ByteBuffer;
import org.lwjgl.BufferUtils;
import net.minecraft.client.Minecraft;
import java.util.Random;

public class mod_Automatons extends BaseMod
{                              
	public String Version()
	{
		return "v0.6";
	}
	
	//DERP DERP TEST MESSAGE GOES HERE
	
	public static AutomatonLogger self;
	static{
		self=new AutomatonLogger();
	}
	
	
	public static Item automaton = (new AM_ItemAutomaton(AutomatonLogger.automaton,true)).setIconCoord(0, 9).setItemName("automaton");
	public static Item itemOmni = (new AM_ItemBot(AutomatonLogger.itemOmni,0)).setIconCoord(2, 9).setItemName("itemOmni");
	public static Item itemBally = (new AM_ItemBot(AutomatonLogger.itemBally,3)).setIconCoord(3, 9).setItemName("itemBally");
	public static Item cheatStick = (new AM_ItemWerg(AutomatonLogger.cheatStick)).setIconCoord(5, 3).setItemName("cheatStick");
	public static Item automatonCore = (new AM_ItemGolem(AutomatonLogger.automatonCore)).setIconCoord(1, 9).setItemName("automatonCore");
	public static Item beacon = (new AM_ItemBeacon(AutomatonLogger.itemBeacon)).setIconCoord(1, 10).setItemName("beacon");
	public static Item biter = (new AM_ItemAutomaton(AutomatonLogger.biter,false)).setIconCoord(0, 10).setItemName("biter").setMaxStackSize(16);
	//public static Item automatonBack = (new Item(Logger.automaton)).setIconCoord(3, 10).setItemName("automatonBack");
	//public static Item biterHead = (new Item(Logger.automaton)).setIconCoord(2, 10).setItemName("biterHead");
	//public static Item rod = (new Item(Logger.automaton)).setIconCoord(4, 10).setItemName("rod");
	public static Item itemBot = (new AM_ItemBot(AutomatonLogger.itemBot,3)).setIconCoord(4, 10).setItemName("itemBot");
	public static Item superCore = (new Item(AutomatonLogger.superCore)).setIconCoord(3, 11).setItemName("superCore");
	//public static Item energy = (new Item(Logger.automaton)).setIconCoord(0, 11).setItemName("energy");
	public static Item blaster = (new AM_ItemBlaster(AutomatonLogger.blaster)).setIconCoord(1, 11).setItemName("blaster");
	public static Item guard = (new AM_ItemBot(AutomatonLogger.guard,1)).setIconCoord(2, 11).setItemName("guard").setMaxStackSize(64);
	public static Item stuffs = (new AM_ItemStuffs(AutomatonLogger.stuffs)).setIconCoord(5, 8).setItemName("stuffs");
	public static Item mortar;
	
	public static Item factotum = (new AM_ItemBot(AutomatonLogger.itemFactotum,4)).setIconCoord(4, 10).setItemName("factotum").setMaxStackSize(1);
	
	
	public static Item pickTech = (new AM_ItemAPickaxe(AutomatonLogger.pickTech, Arrays.asList("TECH",0,3,4,100f,2))).setIconCoord(2, 6).setItemName("pickTech");
	
	
	public static Item regulator = (new AM_ItemFunctional(AutomatonLogger.regulator,3)).setIconCoord(4, 10).setItemName("regulator").setMaxStackSize(1);
	public static Item daymaker = (new AM_ItemFunctional(AutomatonLogger.daymaker,1)).setIconCoord(4, 10).setItemName("daymaker");
	
	
	public static Item techifier = (new AM_ItemFunctional(AutomatonLogger.techifier,2)).setIconCoord(4, 10).setItemName("techifier");
	public static Item smack = (new AM_ItemSmack(AutomatonLogger.smack)).setIconCoord(4, 10).setItemName("smack");
	public static Item naturizer = (new AM_ItemFunctional(AutomatonLogger.naturizer,4)).setIconCoord(4, 10).setItemName("naturizer");
	public static Item misc =  (new AM_ItemMisc(AutomatonLogger.misc)).setIconCoord(5, 8).setItemName("misc");
	
	
	
	static 
	{
		
		mortar = (new Item(AutomatonLogger.mortar)).setIconCoord(4, 11).setMaxStackSize(1).setContainerItem(mortar).setItemName("mortar");
		mortar.setContainerItem(mortar);
	}
	
	
	
	
	
	
	
	
	public static Block tech = (new AM_BlockComplex(AutomatonLogger.tech)).setHardness(1.0F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setBlockName("tech");
	public static Block crystal = (new AM_BlockGlow(AutomatonLogger.crystal, 231)).setHardness(0.4F).setResistance(5F).setLightValue(0.625F).setStepSound(Block.soundGlassFootstep).setBlockName("crystal");
	
	public static Block crink = (new AM_BlockCrink(AutomatonLogger.crink,234)).setHardness(0.1F).setLightOpacity(1).setLightValue(0.5F).setStepSound(Block.soundGlassFootstep).setBlockName("crink");
	public static AM_BlockBad fakeCrystal=(AM_BlockBad)(new AM_BlockBad(AutomatonLogger.fakeCrystal, 231)).setHardness(0.4F).setResistance(5F).setLightValue(0.625F).setStepSound(Block.soundGlassFootstep).setBlockName("crystal");
	public static Block glowy= (new AM_BlockGlow(AutomatonLogger.glowy, 229)).setHardness(0.4F).setResistance(5F).setLightValue(0.95F).setStepSound(Block.soundGlassFootstep).setBlockName("glowy");
	public static Block frass = (new AM_BlockFrass(AutomatonLogger.frass)).setHardness(0.25F).setStepSound(Block.soundGlassFootstep).setBlockName("frass");
	public static Block dapling = (new AM_BlockDapling(AutomatonLogger.dapling, ModLoader.addOverride("/terrain.png", "/automatons/dapling.png"))).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("dapling").setRequiresSelfNotify();
	public static Block duplex = (new AM_BlockDuplex(AutomatonLogger.duplex,227)).setHardness(0.1F).setLightOpacity(1).setLightValue(0.5F).setStepSound(Block.soundGlassFootstep).setBlockName("duplex");
	public static Block boing = (new AM_BlockBoing(AutomatonLogger.boing)).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setBlockName("boing");
	public static Block heal = (new AM_BlockHeal(AutomatonLogger.heal)).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setBlockName("heal");
	
	public static Block frass2 = (new AM_BlockFrass2(AutomatonLogger.frass2)).setHardness(0.15F).setStepSound(Block.soundGlassFootstep).setBlockName("frass");
	
	public static Block grower = (new AM_BlockGrower(AutomatonLogger.grower,234)).setHardness(0.5F).setStepSound(Block.soundGlassFootstep).setBlockName("grower");
	
	public static Block hollow = (new AM_BlockHollow(AutomatonLogger.hollow)).setHardness(0f).setLightValue(0.3F).setBlockName("hollow");
	
	public static Block tv = (new AM_BlockTv(AutomatonLogger.tv)).setHardness(0.3f).setLightValue(0.3F).setBlockName("tv");
	public static Block sky= (new AM_BlockLumo(AutomatonLogger.sky)).setHardness(1F).setResistance(5F).setLightValue(1F).setStepSound(Block.soundGlassFootstep).setBlockName("sky");
	
	
	public static Block deployer= (new AM_BlockDeployer(AutomatonLogger.deployer)).setHardness(5f).setResistance(5F).setBlockName("deployer");
	public static Block techPlant= (new AM_BlockTechPlant(AutomatonLogger.techPlant,ModLoader.addOverride("/terrain.png", "/automatons/techPlant.png"))).setHardness(0f).setStepSound(Block.soundGlassFootstep).setBlockName("techPlant");
	
	public static Block importantBuildingThingy= (new AM_Buildo(AutomatonLogger.importantBuildingThingy)).setBlockUnbreakable().setStepSound(Block.soundGlassFootstep).setBlockName("techPlant");
	public static Block arbor = (new AM_BlockArbor(AutomatonLogger.arbor)).setHardness(0f).setStepSound(Block.soundGrassFootstep).setBlockName("arbor");
	
	
	public static Achievement techAchievement;
	
	

	
	public mod_Automatons()
	{


		(new AM_DimensionBot()).name = "Bot Land";
		
		
		techAchievement = (new Achievement(4281,"WERG",-4,-6,Item.appleRed,null)).registerAchievement();
		ModLoader.AddAchievementDesc(techAchievement, "YOU IS WINRAR!", "herpy derp derp?");
		
		itemOmni.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/itemOmni.png");
		ModLoader.AddName(itemOmni, "Omni Unit");
		
		cheatStick.iconIndex = 53;//ModLoader.addOverride("/gui/items.png", "/automatons/itemOmni.png");
		ModLoader.AddName(cheatStick, "CHEAT STICK!1!1ONE11!!");
		
		mortar.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/mortar.png");
		ModLoader.AddName(mortar, "Grinder");
		
		
		regulator.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/regulator.png");
		ModLoader.AddName(regulator, "Phase Regulator");
		
		daymaker.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/daymaker.png");
		ModLoader.AddName(daymaker, "Dawn");
		
		techifier.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/techifier.png");
		ModLoader.AddName(techifier, "Bionic Conversion System");
		
		smack.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/sliderpan.png");
		ModLoader.AddName(smack, "Slider Pan");
		
		naturizer.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/naturizer.png");
		ModLoader.AddName(naturizer, "Organic Conversion System");
		
		//itemBally
		
		//itemBot
		
		//stuffs
		
		
		
		
		automaton.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/automaton.png");
		ModLoader.AddName(automaton, "Worker");
		
		
		//automatonHead.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/automatonHead.png");
		//ModLoader.AddName(automatonHead, "Worker Head");
		
		//automatonBod.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/automatonBod.png");
		//ModLoader.AddName(automatonBod, "Automaton Body");
		
		//automatonLeg.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/automatonLeg.png");
		// ModLoader.AddName(automatonLeg, "Automaton Leg");
		
		automatonCore.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/automatonCore.png");
		ModLoader.AddName(automatonCore, "Blue Core");
		
		beacon.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/beacon.png");
		ModLoader.AddName(beacon, "Beacon");
		
		biter.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/biter.png");
		ModLoader.AddName(biter, "Sentry");
		
		//automatonBack.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/automatonBack.png");
		//ModLoader.AddName(automatonBack, "Automaton Back");
		
		//biterHead.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/biterHead.png");
		//ModLoader.AddName(biterHead, "Sentry Head");
		
		//rod.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/rod.png");
		//ModLoader.AddName(rod, "Iron Rod");
		
		superCore.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/superCore.png");
		ModLoader.AddName(superCore, "Red Core");
		
		guard.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/guard.png");
		ModLoader.AddName(guard, "Guard Turret");
		
		blaster.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/blaster.png");
		ModLoader.AddName(blaster, "Pulse Rifle");
		
		
		factotum.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/itemfactotum.png");
		ModLoader.AddName(factotum, "Factotum");
		
		pickTech.iconIndex = ModLoader.addOverride("/gui/items.png", "/automatons/picktech.png");
		ModLoader.AddName(pickTech, "Charged Pick");
		
		
		ModLoader.AddName(new ItemStack(stuffs,1,0), "Adaptive Bionic Conglomerate");
		ModLoader.AddName(new ItemStack(stuffs,1,1), "Automaton Body");
		ModLoader.AddName(new ItemStack(stuffs,1,2), "Worker Head");
		ModLoader.AddName(new ItemStack(stuffs,1,3), "Automaton Leg");
		ModLoader.AddName(new ItemStack(stuffs,1,4), "Iron Rod");
		ModLoader.AddName(new ItemStack(stuffs,1,5), "Automaton Back");
		ModLoader.AddName(new ItemStack(stuffs,1,6), "Sentry Head");
		ModLoader.AddName(new ItemStack(stuffs,1,7), "Cybernetic Particulate");
		ModLoader.AddName(new ItemStack(stuffs,1,8), "Plant Matter");
		ModLoader.AddName(new ItemStack(stuffs,1,9), "Coal Dust");
		ModLoader.AddName(new ItemStack(stuffs,1,10), "Salt Petre");
		ModLoader.AddName(new ItemStack(stuffs,1,11), "Sulfur");
		ModLoader.AddName(new ItemStack(stuffs,1,12), "Factotum Head");
		ModLoader.AddName(new ItemStack(stuffs,1,13), "Furnace Chunk");
		ModLoader.AddName(new ItemStack(stuffs,1,14), "Greater Automaton Body");
		
		ModLoader.RegisterBlock(tech,AM_ItemComplex.class);
		ModLoader.RegisterBlock(crink);
		ModLoader.RegisterBlock(duplex);
		ModLoader.RegisterBlock(crystal);
		ModLoader.RegisterBlock(glowy);
		ModLoader.RegisterBlock(fakeCrystal);
		ModLoader.RegisterBlock(frass,AM_ItemFrass.class);
		ModLoader.RegisterBlock(heal);
		ModLoader.RegisterBlock(boing);
		ModLoader.RegisterBlock(dapling);
		ModLoader.RegisterBlock(grower);
		ModLoader.RegisterBlock(frass2);
		ModLoader.RegisterBlock(tv);
		ModLoader.RegisterBlock(sky,AM_ItemLumo.class);
		ModLoader.RegisterBlock(techPlant);
		ModLoader.RegisterBlock(importantBuildingThingy);
		ModLoader.RegisterBlock(arbor);
		ModLoader.RegisterBlock(deployer);
		
		ModLoader.AddName(new ItemStack(tech,1,0), "Ancient Construct");
		ModLoader.AddName(new ItemStack(tech,1,1), "Bionic Mass");
		ModLoader.AddName(new ItemStack(tech,1,2), "Domestic Tile");
		ModLoader.AddName(new ItemStack(tech,1,3), "Domestic Tile2");
		
		ModLoader.AddName(new ItemStack(sky,1,0), "Atmospheric simulator");
		ModLoader.AddName(new ItemStack(sky,1,1), "Walkway Tile");
		
		ModLoader.AddName(crink, "Foliage Array");
		ModLoader.AddName(duplex, "Duplex");
		ModLoader.AddName(crystal, "Power Shard");
		ModLoader.AddName(glowy, "Illuminator");
		ModLoader.AddName(fakeCrystal, "Power Shard");
		ModLoader.AddName(frass, "Frass");
		ModLoader.AddName(heal, "Biomatter Regenerator");
		ModLoader.AddName(boing, "Slider Shell");
		ModLoader.AddName(dapling, "Dapling");
		ModLoader.AddName(grower, "Bionic Stalk");
		
		//tech.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/automatons/tech.png");
		//crystal.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/automatons/tech.png");
		//crink.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/automatons/crink.png");
		duplex.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/automatons/duplex.png");
		frass2.blockIndexInTexture =ModLoader.addOverride("/terrain.png", "/automatons/frass5.png");
		hollow.blockIndexInTexture =ModLoader.addOverride("/terrain.png", "/automatons/crink3.png");
		//techPlant.blockIndexInTexture =ModLoader.addOverride("/terrain.png", "/automatons/techPlant.png");
		
		//sky.blockIndexInTexture =ModLoader.addOverride("/terrain.png", "/automatons/sky.png");
		//dapling.blockIndexInTexture = 
		
		//tech.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/automatons/tech.png");
		AM_BlockComplex.loadSprites();
		AM_BlockBoing.loadSprites();
		AM_BlockFrass.loadSprites();
		AM_BlockHeal.loadSprites();
		AM_BlockGrower.loadSprites();
		AM_BlockCrink.loadSprites();
		AM_BlockHollow.loadSprites();
		AM_BlockLumo.loadSprites();
		AM_BlockDeployer.loadSprites();
		AM_BlockArbor.loadSprites();
		//Item.itemsList[frass.blockID] = (new ItemFrass(frass.blockID - 256)).setItemName("frass");
		
		((AM_BlockGlow)crystal).loadSprites1();
		fakeCrystal.loadSprites(((AM_BlockGlow)crystal).D[0],((AM_BlockGlow)crystal).D[1]);
		
		
		AM_BlockFrass.setAllowed();
		
		ModLoader.AddSpawn(AM_EntityWatcher.class, 12,4,4, EnumCreatureType.monster);
		ModLoader.AddSpawn(AM_EntitySlider.class, 4,4,4 ,EnumCreatureType.creature);
		
		ModLoader.AddSpawn(AM_EntityChopper.class, 14,4,4, EnumCreatureType.creature);
		ModLoader.AddSpawn(AM_EntityBobby.class, 16,4,4, EnumCreatureType.creature);
		ModLoader.AddSpawn(AM_EntityGolem.class, 5,4,4, EnumCreatureType.creature);
		
		//ModLoader.AddSpawn(AM_EntityArborist.class, 2,1,1 EnumCreatureType.creature);

		
		//ModLoader.getUniqueEntityId()
		ModLoader.RegisterEntityID(AM_EntityWatcher.class, "AM_Watcher", AutomatonLogger.watcher);
		ModLoader.RegisterEntityID(AM_EntityWorker.class, "AM_Worker", AutomatonLogger.worker);
		ModLoader.RegisterEntityID(AM_EntityBeacon.class, "AM_Beacon", AutomatonLogger.beacon);
		ModLoader.RegisterEntityID(AM_EntitySentry.class, "AM_Sentry", AutomatonLogger.sentry);
		ModLoader.RegisterEntityID(AM_EntitySlider.class, "AM_Slider", AutomatonLogger.slider);
		ModLoader.RegisterEntityID(AM_EntityGuard.class, "AM_Guard", AutomatonLogger.guardTurret);
		ModLoader.RegisterEntityID(AM_EntityChopper.class, "AM_Chopper", AutomatonLogger.chopper);	
		ModLoader.RegisterEntityID(AM_EntityBobby.class, "AM_Bobby", AutomatonLogger.bobby);		
		ModLoader.RegisterEntityID(AM_EntityGolem.class, "AM_Golem",AutomatonLogger.golem1);		
		ModLoader.RegisterEntityID(AM_EntityGolem2.class, "AM_Golem2",AutomatonLogger.golem2);		
		ModLoader.RegisterEntityID(AM_EntityOmni.class, "Omni",AutomatonLogger.omni);		
		ModLoader.RegisterEntityID(AM_EntityFactotum.class, "AM_Factotum",AutomatonLogger.factotum);	
		ModLoader.RegisterEntityID(AM_EntityRemnant.class, "AM_Remnant",AutomatonLogger.remnant);	
		ModLoader.RegisterEntityID(AM_EntityArborist.class, "AM_Arborist",AutomatonLogger.arborist);	
		ModLoader.RegisterEntityID(AM_EntityHydra.class, "AM_Hydra",AutomatonLogger.hydra);
		//ModLoader.RegisterEntityID(EntityAZiz.class, "AZiz",AutomatonLogger.ziz);
		
		
		ModLoader.AddRecipe(new ItemStack(automatonCore, 1), new Object[] { //core
			"###", "OOO","OOO", Character.valueOf('#'), Block.stone,Character.valueOf('O'),Item.redstone
		});
		
		ModLoader.AddRecipe(new ItemStack(stuffs, 1,3), new Object[] { //leg
			"#O"," O", Character.valueOf('#'),new ItemStack(stuffs, 1, 4) ,Character.valueOf('O'),Block.cobblestone
		});
		ModLoader.AddRecipe(new ItemStack(stuffs, 1,3), new Object[] {//leg
			"O#","O ", Character.valueOf('#'),new ItemStack(stuffs, 1, 4) ,Character.valueOf('O'),Block.cobblestone
		});
		ModLoader.AddRecipe(new ItemStack(stuffs, 1,2), new Object[] {//workerhead
			"OIO","#OO"," s ", Character.valueOf('s'),new ItemStack(stuffs, 1, 4),Character.valueOf('I'),Block.torchWood,Character.valueOf('#'),Block.glass ,Character.valueOf('O'),Block.cobblestone
		});
		ModLoader.AddRecipe(new ItemStack(stuffs, 1,1), new Object[] {//bod
			"O#O","OHO","O#O", Character.valueOf('H'),automatonCore,Character.valueOf('#'),Block.glass ,Character.valueOf('O'),Block.cobblestone
		});
		
		ModLoader.AddRecipe(new ItemStack(stuffs, 1,14), new Object[] {//bod2
			"O#O","OHO","O#O", Character.valueOf('H'),superCore,Character.valueOf('#'),Block.glass ,Character.valueOf('O'),Block.cobblestone
		});
		
		ModLoader.AddRecipe(new ItemStack(automaton, 1), new Object[] {//automaton
			" A ","CBC", Character.valueOf('A'),new ItemStack(stuffs, 1, 2),Character.valueOf('B'),new ItemStack(stuffs, 1, 1) ,Character.valueOf('C'),new ItemStack(stuffs, 1, 3)
		});
		
		ModLoader.AddRecipe(new ItemStack(beacon, 1), new Object[] {
			" O "," H ","OOO", Character.valueOf('H'),automatonCore ,Character.valueOf('O'),Block.cobblestone
		});
		ModLoader.AddRecipe(new ItemStack(stuffs, 1,5), new Object[] {//biter back
			"OsO","OsO",Character.valueOf('s'),new ItemStack(stuffs, 1, 4) ,Character.valueOf('O'),Block.cobblestone
		});
		ModLoader.AddRecipe(new ItemStack(stuffs, 1,6), new Object[] {//biter head
			"OOO","ssr","OOO",Character.valueOf('s'),new ItemStack(stuffs, 1, 4) ,Character.valueOf('r'),Block.torchWood,Character.valueOf('O'),Block.cobblestone
		});
		
		ModLoader.AddRecipe(new ItemStack(biter, 1), new Object[] {
			" ll","hbk"," ll",Character.valueOf('h'),new ItemStack(stuffs, 1, 6) ,Character.valueOf('b'),new ItemStack(stuffs, 1, 14),Character.valueOf('k'),new ItemStack(stuffs, 1, 5),Character.valueOf('l'),new ItemStack(stuffs, 1, 3)
		});
		
		ModLoader.AddRecipe(new ItemStack(blaster, 1), new Object[] {
			"OOs","DDD","  r",Character.valueOf('O'),Item.ingotIron ,Character.valueOf('s'),superCore,Character.valueOf('D'),crystal,Character.valueOf('r'),new ItemStack(stuffs, 1, 4)
		});
		
		ModLoader.AddShapelessRecipe(new ItemStack(stuffs, 9,4), new Object[] {
			Item.ingotIron
		});
		
		ModLoader.AddShapelessRecipe(new ItemStack(duplex, 1), new Object[] {
			crystal,crink
		});
		
		
		/*ModLoader.AddShapelessRecipe(new ItemStack(duplex, 9), new Object[] {
			duplex
		});*/
		
		ModLoader.AddShapelessRecipe(new ItemStack(guard, 1), new Object[] {
			blaster,beacon
		});
		
		ModLoader.AddShapelessRecipe(new ItemStack(superCore, 1), new Object[] {
			automatonCore,automatonCore,automatonCore
		});
		
		ModLoader.AddRecipe(new ItemStack(Item.ingotIron, 1), new Object[] {
			"OOO","OOO","OOO",Character.valueOf('O'),new ItemStack(stuffs, 1, 4)
		});
		
		ModLoader.AddRecipe(new ItemStack(stuffs,1, 4), new Object[] {
			"O","O","O",Character.valueOf('O'),new ItemStack(stuffs, 1, 0)
		});
		
		ModLoader.AddShapelessRecipe(new ItemStack(stuffs, 2,9), new Object[] {
			Item.coal, mortar
		});
		
		
		ModLoader.AddRecipe(new ItemStack(pickTech, 1), new Object[] {
			"i","L",Character.valueOf('i'),new ItemStack(stuffs, 1, 4),Character.valueOf('L'),grower
		});
		
		
		ModLoader.AddShapelessRecipe(new ItemStack(stuffs, 2,8), new Object[] {
			Block.sapling, mortar
		});
		
		ModLoader.AddShapelessRecipe(new ItemStack(stuffs, 2,8), new Object[] {
			Item.seeds, mortar
		});
		
		ModLoader.AddRecipe(new ItemStack(stuffs,2, 7), new Object[] {
			"O","M",Character.valueOf('O'),frass,Character.valueOf('M'),mortar
		});
		
		/*ddShapelessRecipe(new ItemStack(stuffs, 2,7), new Object[] {
		Block.frass, Item.mortar
		});*/
		ModLoader.AddShapelessRecipe(new ItemStack(stuffs, 2,7), new Object[] {
			crink, mortar
		});
		
		ModLoader.AddShapelessRecipe(new ItemStack(Item.redstone, 3), new Object[] {
			automatonCore, mortar
		});
		ModLoader.AddShapelessRecipe(new ItemStack(Item.redstone, 6), new Object[] {
			superCore, mortar
		});
		
		
		ModLoader.AddShapelessRecipe(new ItemStack(stuffs, 1,0), new Object[] {
			new ItemStack(stuffs, 2,8), new ItemStack(stuffs, 2,7)
		});
		
		
		ModLoader.AddRecipe(new ItemStack(techifier, 1), new Object[] {
			"OOO","OfO","i i",Character.valueOf('O'),new ItemStack(stuffs, 1,0),Character.valueOf('f'),frass,Character.valueOf('i'),new ItemStack(stuffs, 1,4)
		});
		
		ModLoader.AddRecipe(new ItemStack(naturizer, 1), new Object[] {
			"i i","OfO","OOO",Character.valueOf('O'),new ItemStack(stuffs, 1,0),Character.valueOf('f'),Block.sapling,Character.valueOf('i'),Item.stick
		});
		
		
		
		
		ModLoader.AddRecipe(new ItemStack(dapling, 1), new Object[] {
			" O ","OCO"," s ",Character.valueOf('O'),crink,Character.valueOf('C'),automatonCore,Character.valueOf('s'),new ItemStack(stuffs, 1,0)
		});
		
		ModLoader.AddRecipe(new ItemStack(itemOmni, 1), new Object[] {
			"OOO","OCO","OOO",Character.valueOf('O'),new ItemStack(stuffs, 1,0),Character.valueOf('C'),superCore
		});
		
		
		
		ModLoader.AddRecipe(new ItemStack(mortar, 1), new Object[] {
			"#-#", "#-#","#-#", Character.valueOf('#'), Block.stone,Character.valueOf('-'),new ItemStack(stuffs, 1, 4)
		});
		
		
		ModLoader.AddRecipe(new ItemStack(stuffs, 1,12), new Object[] {
			"OOO","gig","OOO",Character.valueOf('O'),Block.cobblestone ,Character.valueOf('g'),Block.glass,Character.valueOf('i'),Item.ingotIron
		});
		
		ModLoader.AddRecipe(new ItemStack(stuffs, 1,13), new Object[] {
			"FfF","iPi","OFO",Character.valueOf('O'),Block.cobblestone ,Character.valueOf('F'),Block.stoneOvenIdle,Character.valueOf('i'),Item.ingotIron,Character.valueOf('f'),Item.flintAndSteel,Character.valueOf('P'),crystal
		});
		
		ModLoader.AddRecipe(new ItemStack(factotum, 1), new Object[] {
			" ll","hbk"," ll",Character.valueOf('h'),new ItemStack(stuffs, 1, 12) ,Character.valueOf('b'),new ItemStack(stuffs, 1, 14),Character.valueOf('k'),new ItemStack(stuffs, 1, 13),Character.valueOf('l'),new ItemStack(stuffs, 1, 3)
		});
		
		
		ModLoader.AddRecipe(new ItemStack(Block.workbench, 1), new Object[] {
			"DD","DD",Character.valueOf('D'),new ItemStack(tech, 1, 1) 
		});
		
		ModLoader.AddRecipe(new ItemStack(smack, 1), new Object[] {
			" S","i ",Character.valueOf('S'),boing,Character.valueOf('i'),new ItemStack(stuffs, 1, 4) 
		});
		
		
		
		ModLoader.AddShapelessRecipe(new ItemStack(Item.gunpowder, 3), new Object[] {
			new ItemStack(stuffs, 1, 10), new ItemStack(stuffs, 1, 11),new ItemStack(stuffs, 1, 9)
		});
		
		
		
		
		///BAD///
		ModLoader.AddRecipe(new ItemStack(frass, 1,1), new Object[] {
			"##", "##", Character.valueOf('#'), Item.redstone
		});
		
		ModLoader.AddRecipe(new ItemStack(frass, 64,1), new Object[] {
			"##", "##", Character.valueOf('#'),Block.dirt
		});
		
		ModLoader.AddRecipe(new ItemStack(cheatStick, 1), new Object[] {
			"##", "##", Character.valueOf('#'), frass
		});
		
		ModLoader.AddRecipe(new ItemStack(Block.reed, 50), new Object[] {
			"##", "# ", Character.valueOf('#'), Block.dirt
		});
		ModLoader.AddRecipe(new ItemStack(stuffs, 10,10), new Object[] {
			"#", "#", Character.valueOf('#'),frass
		});
		ModLoader.AddRecipe(new ItemStack(Item.ingotIron, 10,0), new Object[] {
			" #", "##", Character.valueOf('#'),Block.dirt
		});
		ModLoader.AddRecipe(new ItemStack(arbor, 64), new Object[] {
			"##", Character.valueOf('#'),frass
		});
		ModLoader.AddRecipe(new ItemStack(stuffs, 10,11), new Object[] {
			"# "," #", Character.valueOf('#'),frass
		});
		

		
		/*
		System.out.println("\nall tech biomes is " +((AutomatonLogger.allTech==1)?"on":"off"));
		if(AutomatonLogger.allTech==1){
			BiomeGenBase.generateBiomeLookup();
		}*/
	


		//defaultTerrain=ModLoader.getMinecraftInstance().renderEngine.getTexture("/terrain.png");

		//AutomatonLogger.tvRenderId=ModLoader.getUniqueBlockModelID(this,true);
		//ModLoader.SetInGameHook(this,true,true);
		
	} 
	
	
	//public static int defaultTerrain=0;

	
	public void AddRenderer(Map map)
	{  
		
		map.put(AM_EntityWorker.class, new AM_RenderWorker(new AM_ModelWorker(), 0.5F));
		map.put(AM_EntityBeacon.class, new AM_RenderBeacon(new AM_ModelBeacon(), 0.5F));
		map.put(AM_EntitySentry.class, new AM_RenderSentry(new AM_ModelSentry(), 0.75F));
		map.put(AM_EntitySlider.class, new AM_RenderSentry(new AM_ModelSlider(), 1F));
		map.put(AM_EntityWatcher.class, new AM_RenderWatcher(new AM_ModelWatcher(), 0.5F));
		map.put(AM_EntityGuard.class, new AM_RenderBeacon(new AM_ModelGuard(), 0.3F));
		map.put(AM_EntityChopper.class, new AM_RenderChopper(new AM_ModelChopper(), 0.3F));
		map.put(AM_EntityBobby.class, new AM_RenderChopper(new AM_ModelBobby(), 0.25F));
		map.put(AM_EntityOmni.class, new AM_RenderChopper(new AM_ModelOmni(), 0.25F));
		map.put(AM_EntityGolem.class, new AM_RenderGolem(new AM_ModelGolem(), 0.25F));
		map.put(AM_EntityFactotum.class, new AM_RenderFactotum(new AM_ModelFactotum(), 1.5F));
		map.put(AM_EntityHydra.class, new AM_RenderHydra(new  AM_ModelHydra(), 5F));
		map.put(AM_EntityLaser.class, new AM_RenderLaser());
		
		map.put(AM_EntityRemnant.class, new AM_RenderSentry(new  AM_ModelRemnant(), 0.25F));
		
	}


	/*
	public boolean RenderWorldBlock(RenderBlocks renderblocks, IBlockAccess iblockaccess, int i, int j, int k, Block block, int l)
	{
	
		if (l == AutomatonLogger.tvRenderId){
		
			return AM_RenderTv(block, i, j, k, renderblocks);
		}
		return false;
	}
	
	int DERK=1;
	
	public boolean AM_RenderTv(Block block, int i, int j, int k, RenderBlocks renderblocks){
		renderFire(block,i,j,k);
		return true;
	}
	
	public boolean OnTickInGame(Minecraft minecraft)
    {
	
	
	if(AutomatonLogger.tvOut){
	redoTexture();
	
	AutomatonLogger.tvOut=false;
	}
        return true;
    }

	public void redoTexture(){
	GL11.glBindTexture(3553  ,at.textureID);
		
		
		
		
		 GL11.glReadBuffer(GL11.GL_FRONT);
		int width = Display.getDisplayMode().getWidth();
		int height= Display.getDisplayMode().getHeight();
		int bpp = 3; // Assuming a 32-bit display with a byte each for red, green, blue, and alpha.
		ByteBuffer buffer = BufferUtils.createByteBuffer(width * height * bpp);
		GL11.glReadPixels(0, 0, width, height, GL11.GL_RGB, GL11.GL_UNSIGNED_BYTE, buffer );
		
		
		
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 
				0, 
				GL11.GL_RGB, 
				width, 
				height, 
				0, 
				GL11.GL_RGB, 
				GL11.GL_UNSIGNED_BYTE, 
				buffer );
				
				//int hj =defaultTerrain;
       // GL11.glBindTexture(3553  , hj);
	}

	public boolean renderFire(Block block, int i, int j, int k)
    {
        Tessellator tessellator = Tessellator.instance;
		
	 //G++;
		
		tessellator.instance.draw();
		tessellator.instance.startDrawingQuads();
		RenderBlocks.cfgGrassFix = false;
		
		//at.B.createGraphics().drawLine(G/100000, 0, 20, 20);
		
		
		GL11.glBindTexture(3553  ,at.textureID);

        int l = block.getBlockTextureFromSide(0);
		
	   
	   tessellator.setColorOpaque_F(1f,1f,1f);
        int i1 = (l & 0xf) << 4;
        int j1 = l & 0xf0;
        double d = (float)i1 / 16f;
        double d1 = ((float)i1 + 15.99F) / 16F;
        double d2 = (float)j1 / 16f;
        double d3 = ((float)j1 + 15.99F) / 16f;
        float f1 = 1.4F;
		
		
		
		
		
        
			float wid=0.5f;
            tessellator.addVertexWithUV((float)i-wid,(float)j-wid,(float)k, d1, d2);
            tessellator.addVertexWithUV((float)i-wid,(float)j+1f+wid,(float)k, d1, d3);
            tessellator.addVertexWithUV((float)i+1f+wid,(float)j+1f+wid,(float)k, d, d3);
            tessellator.addVertexWithUV((float)i+1f+wid,(float)j-wid,(float)k, d, d2);
			
	
		
		RenderBlocks.cfgGrassFix = true;

        tessellator.instance.draw();
        tessellator.instance.startDrawingQuads();
       

		
		int hj =defaultTerrain;
        GL11.glBindTexture(3553  , hj);
		
		
		
        return true;
    }
	
	
	
	
	public static boolean renderFire2(Block block, int i, int j, int k)
    {
        Tessellator tessellator = Tessellator.instance;
		
		
		tessellator.instance.draw();
		tessellator.instance.startDrawingQuads();
		RenderBlocks.cfgGrassFix = false;

		
		GL11.glBindTexture(3553  ,at.textureID);

		 GL11.glReadBuffer(GL11.GL_FRONT);
		int width = Display.getDisplayMode().getWidth();
		int height= Display.getDisplayMode().getHeight();
		int bpp = 4; // Assuming a 32-bit display with a byte each for red, green, blue, and alpha.
		ByteBuffer buffer = BufferUtils.createByteBuffer(width * height * bpp);
		GL11.glReadPixels(0, 0, width, height, GL11.GL_RGB, GL11.GL_UNSIGNED_BYTE, buffer );
		
		
		
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 
				0, 
				GL11.GL_RGB, 
				width, 
				height, 
				0, 
				GL11.GL_RGB, 
				GL11.GL_UNSIGNED_BYTE, 
				buffer );

		
        int l = block.getBlockTextureFromSide(0);
		
	   tessellator.setColorOpaque_F(1f,1f,1f);
        int i1 = (l & 0xf) << 4;
        int j1 = l & 0xf0;
        double d = (float)i1 / 16f;
        double d1 = ((float)i1 + 15.99F) / 16F;
        double d2 = (float)j1 / 16f;
        double d3 = ((float)j1 + 15.99F) / 16f;
        float f1 = 1.4F;
		
		
		
		
		
        
            double d4 = (double)i + 0.5D + 0.20000000000000001D;
            double d5 = ((double)i + 0.5D) - 0.20000000000000001D;
            double d8 = (double)k + 0.5D + 0.20000000000000001D;
            double d10 = ((double)k + 0.5D) - 0.20000000000000001D;
            double d12 = ((double)i + 0.5D) - 0.29999999999999999D;
            double d14 = (double)i + 0.5D + 0.29999999999999999D;
            double d16 = ((double)k + 0.5D) - 0.29999999999999999D;
            double d18 = (double)k + 0.5D + 0.29999999999999999D;
            tessellator.addVertexWithUV(d12, (float)j + f1, k + 1, d1, d2);
            tessellator.addVertexWithUV(d4, j + 0, k + 1, d1, d3);
            tessellator.addVertexWithUV(d4, j + 0, k + 0, d, d3);
            tessellator.addVertexWithUV(d12, (float)j + f1, k + 0, d, d2);
			
            tessellator.addVertexWithUV(d14, (float)j + f1, k + 0, d1, d2);
            tessellator.addVertexWithUV(d5, j + 0, k + 0, d1, d3);
            tessellator.addVertexWithUV(d5, j + 0, k + 1, d, d3);
            tessellator.addVertexWithUV(d14, (float)j + f1, k + 1, d, d2);

		
		RenderBlocks.cfgGrassFix = true;

        tessellator.instance.draw();
        tessellator.instance.startDrawingQuads();
       

		
		int hj =defaultTerrain;
        GL11.glBindTexture(3553  , hj);
		
		
		
        return true;
    }*/
	
}
