package hms.emc.practice;

import org.testng.annotations.Test;

import com.tyss.genericUtilities.AnnotationConfiguration;

import annotations.Report;
import hms.emc.practiceTestCases.testNGPractice;

public class Practice1 extends AnnotationConfiguration
{
	@Report(author = "Vishwas")
	@Test
	public void facebook()
	{
		seleniumutility.applicationUrl("https://www.facebook.com");
	}
}

