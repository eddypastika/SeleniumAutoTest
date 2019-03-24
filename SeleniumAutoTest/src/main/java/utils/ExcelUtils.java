package utils;

import constants.Constants;
import model.TestDataModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {

    // Get All Test Cases in Excel file
    public List<String> getAllTestCases(int indexDataSheet){

        int countRow = 0;
        List<String> listTestCases = new ArrayList<String>();

        try {

            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(Constants.TEST_CASE).getFile());
            FileInputStream testCaseFile = new FileInputStream(new File(file.getPath()));
            Workbook workbook = new XSSFWorkbook(testCaseFile);
            Sheet dataSheet = workbook.getSheetAt(indexDataSheet);
            Iterator<Row> rowIterator = dataSheet.iterator();

            while (rowIterator.hasNext()){
                countRow++;
                Row currentRow = rowIterator.next();

                if (countRow >= Constants.startIndexTC){
                    Cell cellTC = currentRow.getCell(Constants.columnIndexTC);
                    listTestCases.add(cellTC.getStringCellValue());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listTestCases;
    }

    // Get Test Data Base on TestCaseID
    public HashMap<String, TestDataModel> getTestDataById(List<String> listTestCaseId, int indexDataSheet){

        int countRow = 0;
        HashMap<String, TestDataModel> hmapTestData = new HashMap<String, TestDataModel>();

        FileInputStream testDataFile = null;
        try {

            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(Constants.TEST_DATA).getFile());
            testDataFile = new FileInputStream(new File(file.getPath()));
            Workbook workbook = new XSSFWorkbook(testDataFile);
            Sheet dataSheet = workbook.getSheetAt(indexDataSheet);
            Iterator<Row> rowIterator = dataSheet.iterator();

            while (rowIterator.hasNext()){
                countRow++;
                Row currentRow = rowIterator.next();

                // Find match TestCaseId and store testdata to model class
                if (countRow >= 2) {
                    if (currentRow.getCell(Constants.tcId).getStringCellValue()
                            .equals(listTestCaseId.get(countRow - 2))) {

                        TestDataModel testDataModel = new TestDataModel();

                        testDataModel.setNo((int) currentRow.getCell(Constants.no).getNumericCellValue());
                        testDataModel.setTestCaseId(currentRow.getCell(Constants.tcId).getStringCellValue() == null ? "" : currentRow.getCell(Constants.tcId).getStringCellValue());
                        testDataModel.setName(currentRow.getCell(Constants.name).getStringCellValue() == null ? "" : currentRow.getCell(Constants.name).getStringCellValue());
                        testDataModel.setFeaturesId((int) currentRow.getCell(Constants.featureId).getNumericCellValue());
                        testDataModel.setOsId((int) currentRow.getCell(Constants.osId).getNumericCellValue());
                        testDataModel.setInterfacesId((int) currentRow.getCell(Constants.interfaceId).getNumericCellValue());
                        if (currentRow.getCell(Constants.isTry).getBooleanCellValue() == false) {
                            testDataModel.setTry(false);
                        } else {
                            testDataModel.setTry(true);
                        }
                        testDataModel.setScale((int) currentRow.getCell(Constants.scale).getNumericCellValue());
                        String comment = currentRow.getCell(Constants.comment).getStringCellValue();
                        if (comment == null){
                            testDataModel.setComment(Constants.empty);
                        } else {
                            testDataModel.setComment(comment);
                        }

                        // Store to HashMap
                        hmapTestData.put("" + listTestCaseId.get(countRow - 2), testDataModel);

                    }
                } //end if >=2
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return hmapTestData;
    }


}
