package me.mindlessly.bantroll;

import me.mindlessly.bantroll.events.GUIEvents;
import me.mindlessly.bantroll.events.OnServerJoin;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new OnServerJoin());
		MinecraftForge.EVENT_BUS.register(new GUIEvents());
	}
}
