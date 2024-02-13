package com.generic;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Javageneric {
	
	
	// it is used generate the random number 
	
	public int randomnumber()
	{
		Random ran = new Random();
		int randomnum = ran.nextInt(1);
		return randomnum;
	}
	public static String getSystemDateWithFormatForScreenShot() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return dateFormat.format(Calendar.getInstance().getTime());
    }
	
	
	/**
	 * its used to get the current System date & time
	 * @return
	 */
	public String getSystmeDate() {
		Date date = new Date();
		String systemDateAndTime = date.toString();
		return systemDateAndTime;
	}
	/**
	 * its used to get the current System date with YYYY-MM-DD format
	 * @return
	 */
	/*public String getSystmeDate_YYYY_MM__DD() {
		Date date = new Date();
		String systemDateAndTime = date.toString();
		System.out.println(systemDateAndTime);
		String[] arr = systemDateAndTime.split(" ");
        String DD = arr[2];
        String YYYY = arr[5];   
int MM = date.getMonth()+1;

        String finalFromat = YYYY+"-"+MM+"-"+DD;
		return finalFromat;	
	}*/
	
    /**
     * used to pass Virtual Key to OS
     * @throws Throwable
     */
    public void pressVurtualEnterKey() throws Throwable {
	
	Robot rc=new Robot();
	rc.keyPress(KeyEvent.VK_ENTER);
	rc.keyRelease(KeyEvent.VK_ENTER);
    }
    
    public String getTimeStamp()
    {
       
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 'Time' HH-mm-ss");
            String formattedTimestamp = currentTime.format(formatter);
            return formattedTimestamp;
        }
    }



