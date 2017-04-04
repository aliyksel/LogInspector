package com.commands;

import java.util.ArrayList;
import java.util.List;

public class SearchCmd implements Command{
	
	static List<String> searchList = new ArrayList<String>();
	
	public SearchCmd(String search){
		searchList.add(search);
	}
	
	public boolean execute(String line) throws Exception{
		for (String search : searchList) {
			if (line.indexOf(search) > -1) {
				return true;
			}	
		}
		return false;
	}

	public void addSearch(String search){
		searchList.add(search);
	}
}
