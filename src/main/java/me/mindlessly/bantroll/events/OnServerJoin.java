package me.mindlessly.bantroll.events;

import java.util.Timer;
import java.util.TimerTask;

import io.netty.util.internal.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class OnServerJoin {
	
	public static boolean sent = false;
	private Minecraft mc = Minecraft.getMinecraft();
	@SubscribeEvent
	public void onEntityJoinWorld(FMLNetworkEvent.ClientConnectedToServerEvent event) {
		int time = ThreadLocalRandom.current().nextInt(2000, 10000);
		if (event.manager.getRemoteAddress().toString().contains("hypixel.net")) {
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					event.manager.closeChannel(new ChatComponentText("Joe Biden"));
					sent = true;
				}
			}, time);
		}
	}
}
