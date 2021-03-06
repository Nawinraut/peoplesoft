package com.cloud.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class DynamicTestNGXmlUtil {
	
	public XmlSuite tagsuite;
	public XmlTest tagtest=null;
	
	public TestNG tng=null;
    
	Map<String, String> parameters = new HashMap<String, String>();
	
	public void createTestXml(String suiteTagName,String testTagName,String packageName,String className,String browserName)
	{
		try
		{
			tagsuite = new XmlSuite();
			tagsuite.setName(suiteTagName);
			
			tagtest = new XmlTest(tagsuite);
			tagtest.setName(testTagName);
			parameters.put("browser", browserName);
			tagtest.setParameters(parameters);
			
			List<XmlClass> classes = new ArrayList<XmlClass>();
					System.out.println(packageName);
					System.out.println("class name is: "+className);
					System.out.println("browser Name is: "+browserName);
			classes.add(new XmlClass(packageName+""+className));
			tagtest.setClasses(classes);
			
			List<XmlSuite> suites = new ArrayList<XmlSuite>();
			suites.add(tagsuite);
			tng= new TestNG();
			tng.setXmlSuites(suites);
			tng.run();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public void createTestNGXml_Finance(String packageName,String className,String browserName)
	{
		try
		{
			tagsuite = new XmlSuite();
			tagsuite.setName("Finance Suite");
			
			tagtest = new XmlTest(tagsuite);
			tagtest.setName("Finanace Module Tests");
			parameters.put("browser", browserName);
			tagtest.setParameters(parameters);
			
			List<XmlClass> classes = new ArrayList<XmlClass>();
					System.out.println(packageName);
					System.out.println("class name is: "+className);
			classes.add(new XmlClass(packageName+""+className));
			tagtest.setClasses(classes);
			
			List<XmlSuite> suites = new ArrayList<XmlSuite>();
			suites.add(tagsuite);
			tng= new TestNG();
			tng.setXmlSuites(suites);
			tng.run();
			
			System.out.println("hello");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
