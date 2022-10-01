package me.mindlessly.bantroll.events;

import java.util.Timer;
import java.util.TimerTask;

import org.lwjgl.input.Mouse;

import io.netty.util.internal.ThreadLocalRandom;
import me.mindlessly.bantroll.gui.BanScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class OnServerJoin {
	@SubscribeEvent
	public void onEntityJoinWorld(FMLNetworkEvent.ClientConnectedToServerEvent event) {
		int time = ThreadLocalRandom.current().nextInt(2000, 10000);
		if (event.manager.getRemoteAddress().toString().contains("hypixel.net")) {
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					Minecraft.getMinecraft().displayGuiScreen(new BanScreen());
				}
			}, time);
		}
	}
}
