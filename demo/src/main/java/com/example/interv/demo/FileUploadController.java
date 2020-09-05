package com.example.interv.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController(value = "/")
public class FileUploadController {

	@PostMapping("/")
	public Result readCSVAndCalculateAverage(@RequestParam("data") MultipartFile readExcelDataFile,
			@RequestParam("column") String column) throws IOException {

		InputStream inputStream = readExcelDataFile.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		List<String> list =  br.lines().collect(Collectors.toList());
		
		Result rs=  new Result();
		rs.setData(calculateResult(column, list));

		return rs;
	}

	
	 double calculateResult(String column, List<String> list) {
		

		String headers = list.get(0);
		String[] columNames = headers.split(",");
		int index = 0;

		for (int i = 0; i < columNames.length; i++) {
			if (column.equalsIgnoreCase(columNames[i])) {
				index = i;
				break;
			}
		}

		Iterator<String> it = list.iterator();
		it.next();
		double sum = 0.0;
		int row = 0;

		while (it.hasNext()) {
			String s1 = (String) it.next();
			String str = s1.split(",")[index];
			sum += Integer.parseInt(str);
			row++;
		}
		
		return sum/row;
	}
	
	
	

}
