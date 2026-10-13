package demo;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {	
	
	
	public static void main(String[] args) throws Exception{
		
		FileInputStream fi  = new FileInputStream("D:\\SeleniumExcel\\Book1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi); 
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		int row = sheet.getLastRowNum();
		
		for(int i=0;i<=row;i++) {
			XSSFRow r = sheet.getRow(i);
			int cell =r.getLastCellNum();
			for(int j=0;j<cell;j++) {
				String data = r.getCell(j).getStringCellValue();
				System.out.print(data+" ");
			}
			System.out.println();
		}
		
	}

}
