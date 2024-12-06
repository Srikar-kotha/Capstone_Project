package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ExcelUtils(String sheetName) throws IOException {

        FileInputStream input = new FileInputStream("C:\\Users\\srikar.kotha\\IdeaProjects\\Capstone_Project\\src\\main\\resources\\ParaBankSheet_presentation.xlsx");
        workbook = new XSSFWorkbook(input);
        sheet= workbook.getSheet(sheetName);
    }

    public String getCellData(int rowNumber,int cellNumber)
    {
        Cell cell= sheet.getRow(rowNumber).getCell(cellNumber);
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue();
    }

    public int getRows()
    {
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColumns(int rowNumber) {
        Row row = sheet.getRow(rowNumber);
        if (row == null) {
            System.out.println("Row " + rowNumber + " is empty or does not exist.");
            return 0;
        }
        System.out.println("Row " + rowNumber + " contains up to column: " + row.getLastCellNum());
        return row.getLastCellNum();
    }

}
