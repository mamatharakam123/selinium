package e2logapi.e2logapi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

	public static String getDate(String format, int day) throws Exception{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, day);
		SimpleDateFormat format1 = new SimpleDateFormat(format);
		Date Output1 = cal.getTime();
		// Output "Wed Sep 26 14:23:28 EST 2012"
		
		String Output2 = format1.format(cal.getTime());
		// Output "2012-09-26"
		
		Date Output3 = format1.parse(Output2);
		// Output "Wed Sep 26 00:00:00 EST 2012"
		return Output2;
	}
	
	public static String fileNameForOutput(){
		//String fileName;
		//File file = new File("Output_"+new Date()+".json");
		Calendar c = Calendar.getInstance(); //automatically set to current time
		c.add(Calendar.HOUR, 0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String filename = dateFormat.format(c.getTime()).toString();	
		return "API_Output_"+filename+".json";	
	}

	public static String fileNameForDatabaseOutput(){
		//String fileName;
		//File file = new File("Output_"+new Date()+".json");
		Calendar c = Calendar.getInstance(); //automatically set to current time
		c.add(Calendar.HOUR, 0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String filename = dateFormat.format(c.getTime()).toString();	
		return "Database_Output_"+filename+".json";	
	}
//	public static void main(String[] args) throws Exception {
		
	
	

}
