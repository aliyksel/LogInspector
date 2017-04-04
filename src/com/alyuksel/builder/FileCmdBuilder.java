package com.alyuksel.builder;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

import com.commands.Command;
import com.commands.FileCommand;

public class FileCmdBuilder {

	
	
	public FileCommand build(String[] args) throws Exception {
		
		String key;
		String value;
		String[] l;
		
		String filePath = null;
		String prefix = null;
		for (String arg : args) {
			l = arg.split("=");
			key = l[0];
			value = l[1];
			if(key.equals("file")){
				filePath = value;
			}else if (key.equals("prefix")){
				prefix = value;
			}
		}
		
		final String pre = prefix;
		File file = new File(filePath);
		String[] fileList = file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(pre == null || name.startsWith(pre)){
					return true;
				}else{
					return false;
				}
			}
		});
		
		return new FileCommand(filePath, fileList);
		
	}


}
