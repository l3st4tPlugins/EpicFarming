package com.songoda.epicfarming.commands;

import com.songoda.epicfarming.EpicFarming;
import com.songoda.epicfarming.command.AbstractCommand;
import com.songoda.epicfarming.utils.Methods;
import org.bukkit.command.CommandSender;

public class CommandReload extends AbstractCommand {

    public CommandReload(AbstractCommand parent) {
        super("reload", parent, false);
    }

    @Override
    protected ReturnType runCommand(EpicFarming instance, CommandSender sender, String... args) {
        instance.reload();
        sender.sendMessage(Methods.formatText(instance.getReferences().getPrefix() + "&7Configuration and Language files reloaded."));
        return ReturnType.SUCCESS;
    }

    @Override
    public String getPermissionNode() {
        return "epicfarming.admin";
    }

    @Override
    public String getSyntax() {
        return "/efa reload";
    }

    @Override
    public String getDescription() {
        return "Reload the Configuration and Language files.";
    }
}