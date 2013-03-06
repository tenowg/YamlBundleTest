package com.thedemgel.yamlbundletest;

import com.thedemgel.yamlbundletest.commands.PlayerCommands;
import com.thedemgel.yamlbundletest.configuration.YamlBundleTestConfiguration;
import com.thedemgel.yamlresourcebundle.YamlResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;
import org.spout.api.command.CommandRegistrationsFactory;
import org.spout.api.command.RootCommand;
import org.spout.api.command.annotated.AnnotatedCommandRegistrationFactory;
import org.spout.api.command.annotated.SimpleAnnotatedCommandExecutorFactory;
import org.spout.api.plugin.CommonPlugin;

/**
 * If you have found this useful, please let me know.
 * @author Craig <tenowg at thedemgel.com>
 */
public class YamlBundleTest extends CommonPlugin {
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
		CommandRegistrationsFactory<Class<?>> commandRegFactory = new AnnotatedCommandRegistrationFactory(getEngine(), new SimpleAnnotatedCommandExecutorFactory());
		RootCommand root = getEngine().getRootCommand();
		root.addSubCommands(this, PlayerCommands.class, commandRegFactory);

		getEngine().getEventManager().registerEvents(new EListener(this), this);
		
		YamlResourceBundle yrb = new YamlResourceBundle();
		rb = yrb.getBundle("lang", Locale.forLanguageTag(YamlBundleTestConfiguration.LANG_TEST.getString()), getDataFolder());
		
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
