package com.wjx.hkfm_mod.objects.tools.specialtool;

import com.wjx.hkfm_mod.objects.item.ItemBase;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderTippedArrow;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

import static com.wjx.hkfm_mod.hkfm_mod.honkai_tab;

public class basic_bow extends ItemBase {
    public basic_bow(String name) {
        super(name,honkai_tab);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityLivingBase entityLivingBase, int timeLeft) {
        if (!world.isRemote && entityLivingBase instanceof EntityPlayerMP) {
            EntityPlayerMP entity = (EntityPlayerMP) entityLivingBase;
            int slotID = -1;
            for (int i = 0; i < entity.inventory.mainInventory.size(); i++) {
                ItemStack stack = entity.inventory.mainInventory.get(i);
                if (stack != null && stack.getItem() == new ItemStack(Items.ARROW, (int) (1)).getItem()
                        && stack.getMetadata() == new ItemStack(Items.ARROW, (int) (1)).getMetadata()) {
                    slotID = i;
                    break;
                }
            }
            if (entity.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, itemstack) > 0
                    || slotID != -1) {
                float power = 2f;
                EntityTippedArrow entityarrow = new EntityTippedArrow(world, entity);
                entityarrow.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, power * 2, 0);
                entityarrow.setSilent(true);
                entityarrow.setIsCritical(false);
                entityarrow.setDamage(4);
                int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, itemstack);
                if (j > 0)
                {
                    entityarrow.setDamage(4 + (double)j * 0.5D + 0.5D);
                }
                entityarrow.setKnockbackStrength(0);
                int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, itemstack);

                if (k > 0)
                {
                    entityarrow.setKnockbackStrength(k);
                }

                if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, itemstack) > 0)
                {
                    entityarrow.setFire(100);
                }
                itemstack.damageItem(1, entity);
                int x = (int) entity.posX;
                int y = (int) entity.posY;
                int z = (int) entity.posZ;
                world.playSound((EntityPlayer) null, (double) x, (double) y, (double) z,
                        net.minecraft.util.SoundEvent.REGISTRY
                                .getObject(new ResourceLocation(("entity.arrow.shoot"))),
                        SoundCategory.NEUTRAL, 1, 1f / (itemRand.nextFloat() * 0.5f + 1f) + (power / 2));
                if (entity.capabilities.isCreativeMode) {
                    entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
                } else {
                    if (new ItemStack(Items.ARROW, (int) (1)).isItemStackDamageable()) {
                        ItemStack stack = entity.inventory.getStackInSlot(slotID);
                        if (stack.attemptDamageItem(1, itemRand, entity)) {
                            stack.shrink(1);
                            stack.setItemDamage(0);
                        }
                    } else {
                        entity.inventory.clearMatchingItems(new ItemStack(Items.ARROW, (int) (1)).getItem(), -1, 1, null);
                    }

                }
                world.spawnEntity(entityarrow);

                }
            }
        }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
        entity.setActiveHand(hand);
        return new ActionResult(EnumActionResult.SUCCESS, entity.getHeldItem(hand));
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemstack) {
        return EnumAction.BOW;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemstack) {
        return 72000;
    }

    }



