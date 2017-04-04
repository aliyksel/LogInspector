package com.commands;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AfterDateCmd implements Command{

	SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss,SSS");
	
	Date afterDate = null; 
	
	public AfterDateCmd(String date) throws Exception {
		afterDate = dateFormatter.parse(date);
	}
	
	@Override
	public boolean execute(String line) throws Exception {
		if(afterDate.after(dateFormatter.parse(line.substring(0, 12)))){
			return false;
		}
		return true;
	}
	

}
