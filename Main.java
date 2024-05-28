import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

public class Main {
    public static void main(String[] args) {

       String filepath = "C:\\Downloads\\laborator6_input.xlsx";
       File myFile = new File(filepath);
       Workbook workbook = new XSSFWorkbook();
        }
    }
