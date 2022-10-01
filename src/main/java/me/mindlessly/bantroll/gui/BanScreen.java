package me.mindlessly.bantroll.gui;

import org.lwjgl.input.Mouse;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;

public class BanScreen extends GuiScreen {

	private GuiButton newButton = null;
	private ScaledResolution resolution;
	private String[] strings = { EnumChatFormatting.GRAY + "Failed to connect to server",
			EnumChatFormatting.RED + "You are temporarily banned for " + EnumChatFormatting.WHITE + "89d 23h 59m 59s "
					+ EnumChatFormatting.RED + "from this server",
			EnumChatFormatting.GRAY + "Reason: " + EnumChatFormatting.WHITE
					+ "Boosting detected on one or more Skyblock profiles.",
			EnumChatFormatting.GRAY + "Find out more: " + EnumChatFormatting.AQUA + EnumChatFormatting.UNDERLINE
					+ "https://hypixel.net/appeal.",
			EnumChatFormatting.GRAY + "Ban ID: " + EnumChatFormatting.WHITE + "#AE09D95B",
			EnumChatFormatting.GRAY + "Sharing your Ban ID may affect the processing of your appeal!" };

	@Override
	public void initGui() {
		resolution = new ScaledResolution(mc);
		newButton = new GuiButton(0, (int) (resolution.getScaledWidth() / 2.7) - 30 , resolution.getScaledHeight() / 3 + 120,
				"Back to server list");
		buttonList.add(newButton);
	
		super.initGui();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawBackground(1);
		super.drawScreen(mouseX, mouseY, partialTicks);
		resolution = new ScaledResolution(mc);
		double base = resolution.getScaledWidth() / 2.7;
		fontRendererObj.drawString(strings[0], (int) base, resolution.getScaledHeight() / 3, 0);
		fontRendererObj.drawString(strings[1], (int) base - 95, resolution.getScaledHeight() / 3 + 20, 0);
		fontRendererObj.drawString(strings[2], (int) base - 85, resolution.getScaledHeight() / 3 + 40, 0);
		fontRendererObj.drawString(strings[3], (int) base - 45, resolution.getScaledHeight() / 3 + 50, 0);
		fontRendererObj.drawString(strings[4], (int) base + 20, resolution.getScaledHeight() / 3 + 70, 0);
		fontRendererObj.drawString(strings[5], (int) base - 88, resolution.getScaledHeight() / 3 + 80, 0);
		Mouse.setGrabbed(false);
	}

}
