package com.example.interv.demo;


import java.util.ArrayList;
import java.util.List;

public class ControllerUnitTest {

	FileUploadController cntr=new FileUploadController();
	
	  //@Test
	public void testcalculateResultBasesOnColumnandLinesPassed() {
		
		String column="number";
		List<String> lst=new ArrayList<String>();
		lst.add("name,number"); 
		lst.add("A,11");
		lst.add("B,13");
	    //assertEquals(12.0,cntr.calculateResult(column, lst));
		
	}
	
}
