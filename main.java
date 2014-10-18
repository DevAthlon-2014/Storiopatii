package main.java;
public class ItemfireopalSword extends Item
{
public ItemfireopalSword(int i, EnumTmcMaterial enumtmcmaterial)
{
super(i);
maxStackSize = 1;
setMaxDamage(enumtmcmaterial.getMaxUses());
weaponDamage = 4 + enumtmcmaterial.getDamageVsEntity() * 2;
}
public float getStrVsBlock(ItemStack itemstack, Block block)
{
return 1.5F;
}

 public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        if(!isActive)
        {
            return;
        }
        int l = world.getBlockMetadata(i, j, k);
        float f = (float)i + 0.5F;
        float f1 = (float)j + 0.0F + (random.nextFloat() * 6F) / 16F;
        float f2 = (float)k + 0.5F;
        float f3 = 0.52F;
        float f4 = random.nextFloat() * 0.6F - 0.3F;
        if(l == 4)
        {
            world.spawnParticle("flame", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 5)
        {
            world.spawnParticle("flame", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 2)
        {
           world.spawnParticle("flame", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 3)
        {
            world.spawnParticle("flame", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
        }
    }
public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
{
itemstack.damageItem(10, entityliving1);
.dealFireDamage(5);
entityliving.fire = 100;
		return true;
		}
		public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
		{
		itemstack.damageItem(2, entityliving);
return true;
		}
		public int getDamageVsEntity(Entity entity)
		{
		return weaponDamage;
	}
		public boolean isFull3D()
	{
		return true;
	}
		private int weaponDamage;
		}
