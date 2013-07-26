
package com.thedemgel.yamlbundletest.configuration;

import com.thedemgel.yamlbundletest.YamlBundleTest;
import java.io.File;
import java.util.logging.Level;
import org.spout.cereal.config.ConfigurationException;
import org.spout.cereal.config.ConfigurationHolder;
import org.spout.cereal.config.ConfigurationHolderConfiguration;
import org.spout.cereal.config.yaml.YamlConfiguration;

public class YamlBundleTestConfiguration extends ConfigurationHolderConfiguration {

	// Messages
	public static final ConfigurationHolder LANG_TEST = new ConfigurationHolder("en", "lang", "code");

	public YamlBundleTestConfiguration(File dataFolder) {
		super(new YamlConfiguration(new File(dataFolder, "config.yml")));
	}

	@Override
	public void load() {
		try {
			super.load();
			super.save();
		} catch (ConfigurationException e) {
			YamlBundleTest.getInstance().getLogger().log(Level.WARNING, "Error loading YamlBundleTest configuration: ", e);
		}
	}

	@Override
	public void save() {
		try {
			super.save();
		} catch (ConfigurationException e) {
			YamlBundleTest.getInstance().getLogger().log(Level.WARNING, "Error saving YamlBundleTest configuration: ", e);
		}
	}
}
