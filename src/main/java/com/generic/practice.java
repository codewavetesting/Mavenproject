package com.generic;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hpsf.Array;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.markuputils.CodeBlock.CodeBlockBuilder;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class practice {
	public static void main(String[] args) throws Exception {
		ExtentReports extentreports = new ExtentReports();
		String path = "./practice/ report.html ";
		File file =new File(" report.html");
		ExtentSparkReporter report = new ExtentSparkReporter(file);
		extentreports.attachReporter(report);
//		Desktop.getDesktop().browse(file).toURI();
		ExtentTest test = extentreports.createTest("nan");
		test.log(Status.INFO, "<b>broswer</b>").log(Status.PASS, "pass").log(Status.FAIL, "fail")
		.log(Status.WARNING, "warning").log(Status.SKIP, "skip");
		String json="{\"menu\": {\r\n"
				+ "  \"id\": \"file\",\r\n"
				+ "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n"
				+ "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
				+ "    ]\r\n"
				+ "  }";
		String xml="<menu id=\"file\" value=\"File\">\r\n"
				+ "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
				+ "  </popup>\r\n"
				+ "</menu>";
//		logging diffrent info like when u have to pass the xml data or json data in the info it will give you correct data
		test.info(MarkupHelper.createCodeBlock(xml ,CodeLanguage.XML));
		test.info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
		
//		For highlighting  message string message in log
		
		test.info(MarkupHelper.createLabel("sample for colouring", ExtentColor.RED));
//		logging diffrent info like when u have to pass multiple data ----COLLECtion
		ArrayList list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		HashMap hm = new HashMap<>();		
		hm.put(101, "k");
		hm.put(102, "l");
		test.info(MarkupHelper.createOrderedList(list));
		test.info(MarkupHelper.createUnorderedList(hm));
		extentreports.flush();
	}
	
	
//	how to log exception in java
	
	
	
//	execution status this in order--- everthing is alomost same except colour code
//fail
//skip
//warn
//pass 
//info
	

//Tag	Description
//<b>	Defines bold text
//<em>	Defines emphasized text 
//<i>	Defines a part of text in an alternate voice or mood
//<small>	Defines smaller text
//<strong>	Defines important text
//<sub>	Defines subscripted text
//<sup>	Defines superscripted text
//<ins>	Defines inserted text
//<del>	Defines deleted text
//<mark>	Defines marked/highlighted text
	
	
	
	 
//  extent.setSystemInfo("Key", "Value"); // Set system info whatever you want to show in the report
//  String customReportName = "My Custom Report";
//  Map<String, String> customSystemInfo = new HashMap<>();
//  customSystemInfo.put("Browser", "Chrome");
//  customSystemInfo.put("Browser Version", "91.0");
//  customSystemInfo.put("OS", "Windows 10");
//  customSystemInfo.put("Environment", "QA");
//
//  ExtentReports extent = extentReportGenerator(customReportName, customSystemInfo);
	
//    reporter.filter().statusFilter().as(new Status[] {Status.PASS}).apply();
//  we can generate multiple reports
//  reporter.config().setTheme(Theme.DARK);
//  reporter.config().setReportName("Maven"); // Set report name
//  reporter.config().setDocumentTitle("document");
  
//  System.getProperties().list(System.out); it will give al the list of methods which are present like os ,javaversion,windows.
//
}
