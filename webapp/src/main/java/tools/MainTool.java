package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainTool {
	public String convert(Date d){
		String dateString = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		dateString = format.format(d);
		return dateString;
	}
	
	public Date convertStringToDate(String s){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = format.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public String convertIntToString(int i){
		return String.valueOf(i);
	}
	
	public int convertStringToInt(String s){
		return Integer.parseInt(s);
	}
}
