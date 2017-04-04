package com.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.PrintStream;

public class FileCommand {

	String input;
	String search;
	PrintStream writer;
	
	String[] fileList ;
	String filePath;
	BufferedReader reader = null;
	
	int fileIndis = -1;
	
	public FileCommand(String filePath, String[] fileList){
		this.fileList = fileList;
		this.filePath = filePath;
	}

	
	
	public String getLine() throws Exception {
		
		if(reader == null) {
			fileIndis ++;
			reader = new BufferedReader(new FileReader(filePath+"\\"+fileList[fileIndis]));
		}
		
		do{
			String line = reader.readLine();
			if(line != null){
				return line;
			}
		
			reader.close();
			fileIndis ++;
			if(fileIndis == fileList.length){
				return null;
			}
			reader = new BufferedReader(new FileReader(filePath+"\\"+fileList[fileIndis]));
		}while(true);
		
	}



	public String getFileName() {
		
		return fileList[fileIndis];
	}
}
