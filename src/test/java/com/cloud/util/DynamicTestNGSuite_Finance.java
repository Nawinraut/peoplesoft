package com.cloud.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.cloud.utils.DynamicTestNGXmlUtil;
import com.cloud.utils.ExcelUtil;
import com.cloud.utils.PropertiesReader;

@Test
public class DynamicTestNGSuite_Finance {
	
	public Properties configproperties;
	public ExcelUtil excel;
	public DynamicTestNGXmlUtil testngXml;
	
	public XmlSuite tagsuite;
	public XmlTest tagtest;
	public TestNG tng;
    Map<String, String> parameters = new HashMap<String, String>();
	
	public void setTestNGXml()
	{
		try
		{
			configproperties=PropertiesReader.readProperties("environments.properties");
			excel=new ExcelUtil(System.getProperty("user.dir")+configproperties.getProperty("cloud.excel.path_Finance"));
			testngXml=new DynamicTestNGXmlUtil();
			
			
			int noOfTests=excel.getRowCount("Finance_Tests");
			System.out.println("Number of Tests is "+noOfTests);
			for(int i=0;i<noOfTests;i++)
			{
				String execFlag=	excel.getCellData("Finance_Tests",i,1);
				String className=excel.getCellData("Finance_Tests", i, 0);
            	String browserName=excel.getCellData("Finance_Tests",i, 2);
				if(execFlag.equalsIgnoreCase("Y"))
                {
                	System.out.println("Test Name is: "+className);
                	System.out.println("Execution Flag is: "+execFlag);
                	System.out.println("Selected Browser is: "+browserName);
                	//testngXml.createTestXml("TempSuitetag1", "FinanceModuleTests","com.cloud.test.Finance.",className,browserName);
                	//testngXml.createTestNGXml_Finance("com.cloud.test.Finance.",className,browserName);
                	
                	
                	
                		tagsuite = new XmlSuite();
            			tagsuite.setName("Finance Suite");
            			
            			tagtest = new XmlTest(tagsuite);
            			tagtest.setName("Finanace Module Tests");
            			parameters.put("browser", browserName);
            			tagtest.setParameters(parameters);
            			
            			List<XmlClass> classes = new ArrayList<XmlClass>();
            			classes.add(new XmlClass("com.cloud.test.Finance."+""+className));
            			tagtest.setClasses(classes);
            		
            			
            			List<XmlSuite> suites = new ArrayList<XmlSuite>();
            			suites.add(tagsuite);
            			tng= new TestNG();
            			tng.setXmlSuites(suites);
            			tng.run();
            			
            	}
				
			}
			
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	
}
