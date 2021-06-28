package rmc.mixins.metadata_fake_overlap.inject;

import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R3.metadata.PlayerMetadataStore;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraftforge.common.util.FakePlayer;

/**
 * Developed by RMC Team, 2021
 * @author KR33PY
 */
@Mixin(value = PlayerMetadataStore.class)
public abstract class PlayerMetadataStoreMixin {

    @Overwrite(remap = false)
    protected String disambiguate(OfflinePlayer player, String metadataKey) {
        String strId = player.getUniqueId().toString();
        if (player instanceof CraftPlayer
         && ((CraftPlayer) player).getHandle() instanceof FakePlayer) {
            strId = "fake_" + strId;
        }
        return strId + ":" + metadataKey;
    }

}