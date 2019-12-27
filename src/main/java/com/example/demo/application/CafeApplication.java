package com.example.demo.application;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

public class CafeApplication {
    
	public Map<String, List<Map<Object, Object>>> upload(MultipartFile file) throws Exception {

		Path tempDir = Files.createTempDirectory("");
		File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();
		file.transferTo(tempFile);
		Workbook workbook = WorkbookFactory.create(tempFile);
		Stream<Sheet> sheets = StreamSupport.stream(workbook.spliterator(), false);
		Map<String, List<Map<Object, Object>>> mapSheets = new HashMap<>();

		sheets.forEach(sheet -> {

			Stream<Row> rows = StreamSupport.stream(sheet.spliterator(), false);
			List<List<Object>> sheetValues = new ArrayList<>();

			rows.forEach(row -> {
	
				Stream<Cell> cells = StreamSupport.stream(row.spliterator(), false);
				List<Object> rowValues = new ArrayList<>();

				cells.forEach(cell -> {
					try {
						String cellValue = cell.getStringCellValue();
						if (cellValue != "") {
							rowValues.add(cellValue);
						}
					} catch (Exception e) {
						Double cellValue = cell.getNumericCellValue();
						rowValues.add(cellValue);
					}
				});

				if (!rowValues.isEmpty()) {
					sheetValues.add(rowValues);
				}
			});

			List<Map<Object, Object>> listRows = new ArrayList<>();
			List<Object> headers = sheetValues.remove(0);

			for (List<Object> sheetValue : sheetValues) {
				Map<Object, Object> mapCells = IntStream.range(0, headers.size()).boxed().collect(Collectors.toMap(headers::get, sheetValue::get));
				listRows.add(mapCells);
			}
			
			mapSheets.put(sheet.getSheetName(), listRows);
		});

		return mapSheets;
	}
}