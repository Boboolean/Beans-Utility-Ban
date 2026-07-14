package com.boboolean.beansutilityban.mixin;

//import com.beansgalaxy.backpacks.container.UtilitySlot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "com.beansgalaxy.backpacks.container.UtilitySlot")
public abstract class UtilitySlotMixin {

    @Inject(
        method = "mayPlace",
        at = @At("HEAD"),
        cancellable = true
    )
    private void denyConduit(
            ItemStack stack,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (stack.is(Items.CONDUIT) || stack.is(Items.FIREWORK_ROCKET)) {
        cir.setReturnValue(false);
        }
    }
}