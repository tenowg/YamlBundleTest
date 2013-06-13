package com.thedemgel.yamlbundletest;

import com.thedemgel.yamlbundletest.commands.PlayerCommands;
import com.thedemgel.yamlbundletest.configuration.YamlBundleTestConfiguration;
import com.thedemgel.yamlresourcebundle.YamlResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;
import org.spout.api.command.annotated.AnnotatedCommandExecutorFactory;
import org.spout.api.plugin.Plugin;

/**
 * If you have found this useful, please let me know.
 * @author Craig <tenowg at thedemgel.com>
 */
public class YamlBundleTest extends Plugin {
	private static YamlBundleTest instance;
	private YamlBundleTestConfiguration config;
	private ResourceBundle rb;
	
	@Override
	public void onLoad() {
		setInstance(this);
		config = new YamlBundleTestConfiguration(getDataFolder());
		config.load();
		getLogger().info("loaded.");
	}

	@Override
	public void onEnable() {
		//Commands
		AnnotatedCommandExecutorFactory.create(new PlayerCommands(this));

		getEngine().getEventManager().registerEvents(new EListener(this), this);
		
		//YamlResourceBundle yrb = new YamlResourceBundle();
		//rb = YamlResourceBundle.getBundle("lang.lang", Locale.forLanguageTag(YamlBundleTestConfiguration.LANG_TEST.getString()), getDataFolder());
		rb = YamlResourceBundle.getBundle("lang.lang", Locale.forLanguageTag(YamlBundleTestConfiguration.LANG_TEST.getString()), new YamlResourceBundle.Control());
		getLogger().info("enabled.");
	}

	@Override
	public void onDisable() {
		getLogger().info("disabled.");
	}
	
	private static void setInstance(YamlBundleTest plugin) {
		instance = plugin;
	}

	public static YamlBundleTest getInstance() {
		return instance;
	}

	public YamlBundleTestConfiguration getConfig() {
		return config;
	}
	
	public ResourceBundle getLang() {
		return rb;
	}
}
