package com.cloud.util;

import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;
import com.cloud.utils.DynamicTestNGXmlUtil;
import com.cloud.utils.ExcelUtil;
import com.cloud.utils.PropertiesReader;

@Test
public class DynamicTestNGSuite_Phase2 {
	
	public Properties configproperties;
	public ExcelUtil excel;
	public DynamicTestNGXmlUtil testngxml;
	
	public void setTestNGXml()
	{
		try
		{
			configproperties=PropertiesReader.readProperties("environments.properties");
			excel=new ExcelUtil(System.getProperty("user.dir")+configproperties.getProperty("cloud.excel.path_HCM_Phase2"));
			testngxml=new DynamicTestNGXmlUtil();
	
			for(int i=0;i<excel.getRowCount("Master_Tests");i++)
			{
				String execFlag=	excel.getCellData("Master_Tests",i,2);
                if(execFlag.equalsIgnoreCase("Y"))
                {
                	System.out.println("Execution Flag is: "+execFlag);
                	testngxml.createTestXml("TempSuitetag", "HCMModuleTests","com.cloud.test.HCM2.",excel.getCellData("Master_Tests", i, 1),excel.getCellData("Master_Tests", i, 3));
                }
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
