package main;

import constants.Constants;
import model.TestDataModel;
import selenium.SeleniumController;
import utils.ExcelUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppMain {

    public static void main(String[] args) {

        // Change the sheet number here! 0 or 1 or 2
        int sheetNumber = 0;

        // Get All Test Cases
        List<String> listTC = new ArrayList<String>();
        ExcelUtils excelUtils = new ExcelUtils();
        listTC = excelUtils.getAllTestCases(sheetNumber);


        // Get Test Data based on TestCaseID
        HashMap<String, TestDataModel> hmapTestData = new HashMap<String, TestDataModel>();
        hmapTestData = excelUtils.getTestDataById(listTC, sheetNumber);

        // Run Automation testing
        HashMap<String, String> result =  new HashMap<String, String>();
        List<String> key = new ArrayList(hmapTestData.keySet());
        for (int i = 0; i < listTC.size(); i++) {

            String status = "";
            TestDataModel model =  new TestDataModel();
            model = hmapTestData.get(listTC.get(i));

            SeleniumController auto = new SeleniumController();
            status = auto.runTestCase(listTC.get(i), model);

            // Store result
            result.put(listTC.get(i), status);

        }

        // Print Result
        int numberTC = listTC.size();
        int countFail = 0;
        List<String> listResult = new ArrayList(result.keySet());
        for (int i = 0; i < listResult.size(); i++) {
            SeleniumController.writeResult(listResult.get(i)+" : "+result.get(listResult.get(i)));
            System.out.println(listResult.get(i)+" : "+result.get(listResult.get(i)));
            if (result.get(listResult.get(i)).equals(Constants.FAIL)){
                countFail++;
            }
        }

        SeleniumController.writeResult("");
        SeleniumController.writeResult("REPORT: ");
        SeleniumController.writeResult("Test Successful Coverage: "+((numberTC-countFail)*100/numberTC)+"%");

    }
}
