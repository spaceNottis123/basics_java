//CelltoString Function
// This method takes a HSSFCell value (a field in Excel file) and returns the value in String format
private static String cellToString(HSSFCell cell) {
		int type = cell.getCellType();
		Object result;
		switch (type) {
			case HSSFCell.CELL_TYPE_NUMERIC: //0
				result = cell.getNumericCellValue();
				break;
			case HSSFCell.CELL_TYPE_STRING: //1
				result = cell.getStringCellValue();
				break;
			case HSSFCell.CELL_TYPE_FORMULA: //2
				throw new RuntimeException("We can't evaluate formulas in Java");
			case HSSFCell.CELL_TYPE_BLANK: //3
				result = "-";
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN: //4
				result = cell.getBooleanCellValue();
				break;
			case HSSFCell.CELL_TYPE_ERROR: //5
				throw new RuntimeException ("This cell has an error");
			default:
				throw new RuntimeException("We don't support this cell type: " + type);
			}
		return result.toString();
	}