package useless.patches.mixins;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.world.chunk.ChunkLoaderLegacy;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(value = ChunkLoaderLegacy.class, remap = false)
public class ChunkLoaderLegacyMixin {
	@Redirect(method = "storeChunkInCompound(Lnet/minecraft/core/world/chunk/Chunk;Lnet/minecraft/core/world/World;Lcom/mojang/nbt/CompoundTag;)V", at = @At(value = "INVOKE", target = "Ljava/util/List;clear()V"))
	private static void removeClear(List<Entity> instance){
		return; // Implementation of BestSoft's entity fix as a babric mod
	}
}
