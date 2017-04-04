package com.alyuksel.builder;

import java.util.List;

import com.commands.Command;
import com.commands.FileCommand;

public interface Builder {

	public void build(String[] args, List<Command> cmdList) throws Exception;
}
