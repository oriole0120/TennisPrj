package com.htmtennis.prj.taglib;

public class Functions {
	public static int parseInt(double value){
		return (int)value;
	}
	
	public static int lastNum(double total){
		int _total = (int)total;
		int last = _total/20;
		
		if(_total%20 > 0)
			last++;
		
		return last;
	}
}