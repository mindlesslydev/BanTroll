package me.mindlessly.bantroll.events;

import me.mindlessly.bantroll.gui.BanScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GUIEvents {

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onButtonClick(GuiScreenEvent.ActionPerformedEvent event) {
		if (event.gui instanceof BanScreen) {
			if (event.button.id == 0) {
				Minecraft.getMinecraft().displayGuiScreen(new GuiMultiplayer(new GuiMainMenu()));
			}
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onOpen(GuiScreenEvent.InitGuiEvent event) {
		if (event.gui instanceof GuiDisconnected && OnServerJoin.sent) {
			Minecraft.getMinecraft().displayGuiScreen(new BanScreen());
			OnServerJoin.sent = false;
		}
	}
}
