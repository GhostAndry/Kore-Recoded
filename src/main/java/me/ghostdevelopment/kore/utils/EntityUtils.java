package me.ghostdevelopment.kore.utils;

public enum EntityUtils {

    ZOMBIE("Zombie", "net.minecraft.server.EntityZombie"),
    CREEPER("Creeper", "net.minecraft.server.EntityCreeper"),
    SKELETON("Skeleton", "net.minecraft.server.EntitySkeleton"),
    WITHER("Wither", "net.minecraft.server.EntityWither"),
    SPIDER("Spider", "net.minecraft.server.EntitySpider"),
    GHAST("Ghast", "net.minecraft.server.EntityGhast"),
    ENDERMAN("Enderman", "net.minecraft.server.EntityEnderman"),
    BLAZE("Blaze", "net.minecraft.server.EntityBlaze"),
    SLIME("Slime", "net.minecraft.server.EntitySlime"),
    MAGMA_CUBE("MagmaCube", "net.minecraft.server.EntityMagmaCube"),
    WITCH("Witch", "net.minecraft.server.EntityWitch"),
    VILLAGER("Villager", "net.minecraft.server.EntityVillager"),
    IRON_GOLEM("IronGolem", "net.minecraft.server.EntityIronGolem"),
    SNOW_GOLEM("SnowGolem", "net.minecraft.server.EntitySnowman"),
    ENDER_DRAGON("EnderDragon", "net.minecraft.server.EntityEnderDragon"),
    BAT("Bat", "net.minecraft.server.EntityBat"),
    PIG("Pig", "net.minecraft.server.EntityPig"),
    COW("Cow", "net.minecraft.server.EntityCow"),
    SHEEP("Sheep", "net.minecraft.server.EntitySheep"),
    CHICKEN("Chicken", "net.minecraft.server.EntityChicken"),
    HORSE("Horse", "net.minecraft.server.EntityHorse"),
    DONKEY("Donkey", "net.minecraft.server.EntityHorseDonkey"),
    MULE("Mule", "net.minecraft.server.EntityHorseMule"),
    SKELETON_HORSE("SkeletonHorse", "net.minecraft.server.EntityHorseSkeleton"),
    ZOMBIE_HORSE("ZombieHorse", "net.minecraft.server.EntityHorseZombie"),
    LLAMA("Llama", "net.minecraft.server.EntityLlama"),
    PARROT("Parrot", "net.minecraft.server.EntityParrot"),
    RABBIT("Rabbit", "net.minecraft.server.EntityRabbit"),
    POLAR_BEAR("PolarBear", "net.minecraft.server.EntityPolarBear"),
    OCELOT("Ocelot", "net.minecraft.server.EntityOcelot");

    private final String name;
    private final String nmsClassName;

    EntityUtils(String name, String nmsClassName) {
        this.name = name;
        this.nmsClassName = nmsClassName;
    }

    public String getName() {
        return name;
    }

    public String getNmsClassName() {
        return nmsClassName;
    }
}G:\Kore-Recoded\src\main\java\me\ghostdevelopment\kore\utils\EntityUtils.java