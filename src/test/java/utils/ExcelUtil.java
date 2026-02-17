package utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static String getCellData(String sheetName, int row, int col) throws Exception {

        FileInputStream fis = new FileInputStream("src/test/resources/testdata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        String data = sheet.getRow(row).getCell(col).getStringCellValue();
        workbook.close();
        return data;
}
}
