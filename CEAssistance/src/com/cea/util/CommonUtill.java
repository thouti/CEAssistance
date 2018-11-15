package com.cea.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;


@Component
public class CommonUtill 
{
	public String formatDDMMYYYY() {
		final String METHOD_NAME = "formatDDMMYYYY";
		//logMgr.writeToLog(EsevaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME,EsevaConstants.ENTRY);
		DateFormat dateFormat = new SimpleDateFormat(
				CeaConstants.DATE_DD_MM_YYYY );
		String ret_date = dateFormat.format(new Date());
		//logMgr.writeToLog(EsevaConstants.LOG_INFO, CLASS_NAME, METHOD_NAME,EsevaConstants.EXIT);
		return ret_date;
	}
	public String getDateformatDD_MON_YYYY(String strdate) throws ParseException,Exception {
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
	    SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
	    Date date = format1.parse(strdate);
	    return format2.format(date);
	}
	public String formatDD_MM_YYYY24HRS() {
		final String METHOD_NAME = "formatDDMMYYYY24HRS";
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
		String ret_date = dateFormat.format(new Date());
		
		return ret_date;
	}
}
