
package com.thedemgel.yamlbundletest;

import org.spout.api.event.EventHandler;
import org.spout.api.event.player.PlayerChatEvent;
import org.spout.api.event.Listener;
import org.spout.api.event.player.PlayerJoinEvent;

/**
 * A Basic Event Listener for Spout
 */
public class EListener implements Listener {
	private YamlBundleTest plugin;

	public EListener(YamlBundleTest instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().sendMessage(YamlBundleTest.getInstance().getLang().getString("test"));
	}
}
