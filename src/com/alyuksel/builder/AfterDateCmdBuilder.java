package com.alyuksel.builder;

import java.util.List;

import com.commands.AfterDateCmd;
import com.commands.Command;
import com.commands.FileCommand;

public class AfterDateCmdBuilder implements Builder{

	@Override
	public void build(String[] args, List<Command> cmdList) throws Exception {
		
		String key;
		String value;
		String[] l;
		AfterDateCmd cmd;
		for (String arg : args) {
			l = arg.split("=");
			key = l[0];
			value = l[1];
			if(!key.equals("afterDate")){
				continue;
			}
			cmd = new AfterDateCmd(value);
			cmdList.add(cmd);
			return;
		}
		
	}


}
