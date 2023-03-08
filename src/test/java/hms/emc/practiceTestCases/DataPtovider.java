package hms.emc.practiceTestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DataPtovider extends testNGPractice
{
	@Test(dataProvider = "tro")
	public void example(String doctorSpecialisation, String doctorName, String doctorAddress, String doctorFees, String doctorContact, String doctorEmail, String doctorPassword)
	{
		System.out.println(doctorSpecialisation+"  "+ doctorName+" "+doctorAddress+"  "+ doctorFees+" "+doctorContact+"  "+ doctorEmail+" "+doctorPassword);
	}
	
	@DataProvider()
	public String[][] tro()
	{
		return excelutility.getData("Sheet2");
	}
}
