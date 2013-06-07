package com.thedemgel.yamlbundletest.commands;

import com.thedemgel.yamlbundletest.YamlBundleTest;
import org.spout.api.command.CommandArguments;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Command;
import org.spout.api.command.annotated.Permissible;
import org.spout.api.exception.CommandException;

public class PlayerCommands {
	private final YamlBundleTest plugin;

	public PlayerCommands(YamlBundleTest instance) {
		this.plugin = instance;
	}

	@Command(aliases = {"command", "cmd"}, usage = "No Usage, replace this command", desc = "This is just an Example. Replace it.", min = 0, max = 0)
	@Permissible("YamlBundleTest.some.permission")
	public void aCommand(CommandSource source, CommandArguments args) throws CommandException {
		// Do Some Command
	}
}
