/*******************************************************************************
 * Copyright 2024, the Glitchfiend Team.
 * All rights reserved.
 ******************************************************************************/
package biomesoplenty.neoforge.client;

import biomesoplenty.core.BiomesOPlenty;
import biomesoplenty.neoforge.init.ModFluidTypes;
import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogParameters;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.joml.Vector3f;
import org.joml.Vector4f;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = BiomesOPlenty.MOD_ID)
public class FluidClientHandler
{
    @SubscribeEvent
    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event)
    {
        event.registerFluidType(new IClientFluidTypeExtensions()
        {
            private static final ResourceLocation BLOOD_UNDERWATER = ResourceLocation.parse("biomesoplenty:textures/block/blood_underwater.png"),
                    BLOOD_STILL = ResourceLocation.parse("biomesoplenty:block/blood_still"),
                    BLOOD_FLOW = ResourceLocation.parse("biomesoplenty:block/blood_flow");

            @Override
            public ResourceLocation getStillTexture()
            {
                return BLOOD_STILL;
            }

            @Override
            public ResourceLocation getFlowingTexture() { return BLOOD_FLOW; }

            @Override
            public ResourceLocation getRenderOverlayTexture(Minecraft mc) { return BLOOD_UNDERWATER; }

            @Override
            public Vector4f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector4f fluidFogColor)
            {
                return new Vector4f(0.407F, 0.121F, 0.137F, fluidFogColor.w);
            }

            @Override
            public FogParameters modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, FogParameters fogParameters)
            {
                return new FogParameters(0.125F, 5.0F, fogParameters.shape(), fogParameters.red(), fogParameters.green(), fogParameters.blue(), fogParameters.alpha());
            }
        }, ModFluidTypes.BLOOD_TYPE);

        event.registerFluidType(new IClientFluidTypeExtensions()
        {
            private static final ResourceLocation LIQUID_NULL_UNDERWATER = ResourceLocation.parse("biomesoplenty:textures/block/liquid_null_underwater.png"),
                    LIQUID_NULL_STILL = ResourceLocation.parse("biomesoplenty:block/liquid_null_still"),
                    LIQUID_NULL_FLOW = ResourceLocation.parse("biomesoplenty:block/liquid_null_flow");

            @Override
            public ResourceLocation getStillTexture()
            {
                return LIQUID_NULL_STILL;
            }

            @Override
            public ResourceLocation getFlowingTexture() { return LIQUID_NULL_FLOW; }

            @Override
            public ResourceLocation getRenderOverlayTexture(Minecraft mc) { return LIQUID_NULL_UNDERWATER; }

            @Override
            public Vector4f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector4f fluidFogColor)
            {
                return new Vector4f(0.0F, 0.0F, 0.0F, 0.0F);
            }

            @Override
            public FogParameters modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, FogParameters fogParameters)
            {
                return new FogParameters(0.1F, 2.5F, fogParameters.shape(), fogParameters.red(), fogParameters.green(), fogParameters.blue(), fogParameters.alpha());
            }
        }, ModFluidTypes.LIQUID_NULL_TYPE);
    }
}
