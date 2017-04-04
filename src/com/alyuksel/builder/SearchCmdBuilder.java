package com.alyuksel.builder;

import java.util.List;


import com.commands.Command;
import com.commands.SearchCmd;

public class SearchCmdBuilder implements Builder{

	@Override
	public void build(String[] args, List<Command> cmdList) throws Exception {
		String key;
		String value;
		String[] l;
		SearchCmd searchCmd = null;
		
		for (Command  cmd: cmdList) {
			if(cmd instanceof SearchCmd){
				searchCmd = (SearchCmd) cmd;
				break;
			}
		}
		
		for (String arg : args) {
			l = arg.split("=");
			key = l[0];
			value = l[1];
			if(!key.equals("search")){
				continue;
			}
			if(searchCmd == null){
				searchCmd = new SearchCmd(value);
				cmdList.add(searchCmd);
			}else{
				searchCmd.addSearch(value);
			}
			
		}
		
	}

}
