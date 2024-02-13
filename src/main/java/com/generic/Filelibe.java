package com.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Filelibe {
	
public String  getproperty(String key) throws Exception 
{
	FileInputStream fl=new FileInputStream("./src/main/resources/commondata.property");
	Properties prop=new Properties();
	prop.load(fl);
	key=prop.getProperty(key);
	return key;
	
}
	



}
