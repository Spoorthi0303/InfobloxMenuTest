package com.infoblox.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ExcelUtil {

    private static final String FILE_PATH = "InfobloxDropdowns.xlsx";
    private static Workbook workbook = new XSSFWorkbook();

    public static String toTitleCase(String input) {
    if (input == null || input.isEmpty()) return input;
    return Arrays.stream(input.trim().toLowerCase().split("\\s+"))
            .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
            .collect(Collectors.joining(" "));
}
public static String normalizeSheetName(String sheetName) {
    if (sheetName == null || sheetName.isEmpty()) return "Sheet";

    String cleaned = sheetName.trim().toLowerCase().replaceAll("[_\\s]+", " ");

    // Map similar/duplicate names to a single normalized name
    Map<String, String> map = new HashMap<>();
    map.put("products test", "Products");
    map.put("product test", "Products");
    map.put("products", "Products");
    map.put("support and services", "Support Services");
    map.put("support services", "Support Services");
    map.put("company", "Company");
    map.put("why infoblox", "Why Infoblox");
    map.put("resources", "Resources");
    map.put("solutions", "Solutions");

    if (map.containsKey(cleaned)) {
        return map.get(cleaned);
    }

    // Fallback: Title Case
    return Arrays.stream(cleaned.split(" "))
            .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
            .reduce((a, b) -> a + " " + b).orElse("Sheet");
}


    
    public static void writeToSheet(String sheetName, List<String> data) {
        // Normalize sheet name: uppercase and no underscores
        String normalizedSheetName = toTitleCase(sheetName.trim());
        String cleanName = normalizedSheetName.trim().toUpperCase().replace("_", " ");
        //String cleanName = sheetName.trim().toUpperCase().replace("_", " ");
    
        Sheet sheet = workbook.getSheet(cleanName);
    
        if (sheet == null) {
            sheet = workbook.createSheet(cleanName);
        } else {
            // Clear existing data
            int lastRow = sheet.getLastRowNum();
            for (int i = lastRow; i >= 0; i--) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    sheet.removeRow(row);
                }
            }
        }
    
        // Write data
        for (int i = 0; i < data.size(); i++) {
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(data.get(i));
        }
    }
    

    public static void saveExcel() {
        try (FileOutputStream out = new FileOutputStream("ExcelOutput/InfobloxDropdowns.xlsx");
        ) {
            workbook.write(out);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
