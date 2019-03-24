package selenium;

import constants.Constants;
import model.TestDataModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.*;

public class SeleniumController {

    static ClassLoader classLoader = SeleniumController.class.getClassLoader();

    public String runTestCase(String testCaseId, TestDataModel model){

        // I will use Chrome, we can use other browser by change the key and driver. See the the details on Constants Class

        File driverPath = new File(classLoader.getResource(Constants.chromeDriverPath).getFile());

        System.setProperty(Constants.chromeDriverKey, driverPath.getPath());

        WebDriver driver = new ChromeDriver();
        driver.get(Constants.URL);

        String disabled = "";

        // fill name
        boolean isNamePass = false;

        String name = model.getName();
        // blank name
        if (name.equals("no")){

            disabled = driver.findElement(By.id(Constants.idSubmit)).getAttribute(Constants.disabled);
            if (disabled == Constants.true_ || disabled.length() > 0){
                isNamePass = true;
            } else {
                isNamePass = false;
            }
        } else {
            driver.findElement(By.id(Constants.idName)).sendKeys(model.getName());
        }


        // Checking unlocked submit button

        if (!driver.findElement(By.id(Constants.idName)).getAttribute(Constants.value).equals(Constants.empty)){
            disabled = driver.findElement(By.id(Constants.idSubmit)).getAttribute(Constants.disabled);
            if (disabled == "false" || disabled == null) {
                isNamePass = true; // expected result if name textbox is filled
            } else {
                writeError(testCaseId+ Constants.errorMsg+ Constants.name_);
            }
        } else {
            if (disabled == "true" ) {
                isNamePass = true;
            } else {
                writeError(testCaseId+ Constants.errorMsg+ Constants.name_);
            }
        }

        // fill feature
        boolean isFeaturePass = false;
        int featureId = model.getFeaturesId();
        switch (featureId){
            case 1:
                driver.findElement(By.id(Constants.idFeature1)).click();
                if (driver.findElement(By.id(Constants.idFeature1)).isSelected()){
                    isFeaturePass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.feature_);
                }
                break;
            case 2:
                driver.findElement(By.id(Constants.idFeature2)).click();
                if (driver.findElement(By.id(Constants.idFeature2)).isSelected()){
                    isFeaturePass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.feature_);
                }
                break;
            case 3:
                driver.findElement(By.id(Constants.idFeature3)).click();
                if (driver.findElement(By.id(Constants.idFeature3)).isSelected()){
                    isFeaturePass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.feature_);
                }
                break;
            case 4:
                driver.findElement(By.id(Constants.idFeature4)).click();
                if (driver.findElement(By.id(Constants.idFeature4)).isSelected()){
                    isFeaturePass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.feature_);
                }
                break;
            case 5:
                driver.findElement(By.id(Constants.idFeature5)).click();
                if (driver.findElement(By.id(Constants.idFeature5)).isSelected()){
                    isFeaturePass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.feature_);
                }
                break;
            case 6:
                driver.findElement(By.id(Constants.idFeature1)).click();
                driver.findElement(By.id(Constants.idFeature2)).click();
                if (driver.findElement(By.id(Constants.idFeature1)).isSelected()
                        && driver.findElement(By.id(Constants.idFeature2)).isSelected()){
                    isFeaturePass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.feature_);
                }
                break;
            case 7:
                driver.findElement(By.id(Constants.idFeature1)).click();
                driver.findElement(By.id(Constants.idFeature2)).click();
                driver.findElement(By.id(Constants.idFeature3)).click();
                if (driver.findElement(By.id(Constants.idFeature1)).isSelected()
                        && driver.findElement(By.id(Constants.idFeature2)).isSelected()
                        && driver.findElement(By.id(Constants.idFeature3)).isSelected()){
                    isFeaturePass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.feature_);
                }
                break;
            case 8:
                driver.findElement(By.id(Constants.idFeature1)).click();
                driver.findElement(By.id(Constants.idFeature2)).click();
                driver.findElement(By.id(Constants.idFeature3)).click();
                driver.findElement(By.id(Constants.idFeature4)).click();
                if (driver.findElement(By.id(Constants.idFeature1)).isSelected()
                        && driver.findElement(By.id(Constants.idFeature2)).isSelected()
                        && driver.findElement(By.id(Constants.idFeature3)).isSelected()
                        && driver.findElement(By.id(Constants.idFeature4)).isSelected()){
                    isFeaturePass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.feature_);
                }
                break;
            case 9:
                driver.findElement(By.id(Constants.idFeature1)).click();
                driver.findElement(By.id(Constants.idFeature2)).click();
                driver.findElement(By.id(Constants.idFeature3)).click();
                driver.findElement(By.id(Constants.idFeature4)).click();
                driver.findElement(By.id(Constants.idFeature5)).click();
                if (driver.findElement(By.id(Constants.idFeature1)).isSelected()
                        && driver.findElement(By.id(Constants.idFeature2)).isSelected()
                        && driver.findElement(By.id(Constants.idFeature3)).isSelected()
                        && driver.findElement(By.id(Constants.idFeature4)).isSelected()
                        && driver.findElement(By.id(Constants.idFeature5)).isSelected()){
                    isFeaturePass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.feature_);
                }
                break;
            case 0:
                isFeaturePass = true;
                break;
        }

        // fill os
        int osId = model.getOsId();
        boolean isOsPass = false;
        switch (osId){
            case 1:
                driver.findElement(By.id(Constants.idOSWindows)).click();
                if (driver.findElement(By.id(Constants.idOSWindows)).isSelected()){
                    isOsPass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.os_);
                }
                break;
            case 2:
                driver.findElement(By.id(Constants.idOSMac)).click();
                if (driver.findElement(By.id(Constants.idOSMac)).isSelected()){
                    isOsPass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.os_);
                }

            case 3:
                driver.findElement(By.id(Constants.idOSLinux)).click();
                if (driver.findElement(By.id(Constants.idOSLinux)).isSelected()){
                    isOsPass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.os_);
                }
                break;
            case 0:
                isOsPass = true;
                break;
        }

        // fill interface
        int interfaceId = model.getInterfacesId();
        boolean isInterfacePass = false;
        Select dropdown = new Select(driver.findElement(By.id(Constants.idInterface)));
        switch (interfaceId){
            case 1:
                dropdown.selectByIndex(interfaceId-1);
                if(driver.findElement(By.id(Constants.idInterface)).getAttribute(Constants.value)
                        .equals(Constants.interface1)){
                    isInterfacePass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.interface_);
                }
                break;
            case 2:
                dropdown.selectByIndex(interfaceId-1);
                if(driver.findElement(By.id(Constants.idInterface)).getAttribute(Constants.value)
                        .equals(Constants.interface2)){
                    isInterfacePass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.interface_);
                }
                break;
            case 3:
                dropdown.selectByIndex(interfaceId-1);
                if(driver.findElement(By.id(Constants.idInterface)).getAttribute(Constants.value)
                        .equals(Constants.interface3)){
                    isInterfacePass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.interface_);
                }
                break;
            case 0:
                dropdown.getFirstSelectedOption();
                isInterfacePass = true;
                break;
        }

        // is try and fill scale / slider and comment
        boolean isTryPass = false;
        String sliderOn = "";
        disabled = "";

        // slider
        boolean isScalePass = false;
        int sliderId = model.getScale();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(Constants.xScaleToggle));

        // comment
        String comment = model.getComment();
        boolean isCommentPass = false;


        if (model.isTry() == true){

            driver.findElement(By.id(Constants.idTry)).click();
            disabled = driver.findElement(By.id(Constants.idComment)).getAttribute(Constants.disabled);
            sliderOn = driver.findElement(By.id(Constants.idScaleSlider)).getAttribute(Constants.class_);

            // Checking comment disable and slider after select try checkbox
            if (driver.findElement(By.id(Constants.idTry)).isSelected()
                    && (disabled == Constants.false_ || disabled == null)
                    && (!sliderOn.contains(Constants.disabled1_) || !sliderOn.contains(Constants.disabled2_))){
                isTryPass = true;
            } else {
                writeError(testCaseId+ Constants.errorMsg+ Constants.try_);
            }

            // Switch SLIDER
            switch (sliderId){
                case 0:
                    js.executeScript("arguments[0].setAttribute('style', '"+ Constants.toggle1+"')", element);
                    if (element.getAttribute(Constants.style).equals(Constants.toggle1+";")){
                        isScalePass = true;
                    } else {
                        writeError(testCaseId+ Constants.errorMsg+ Constants.scale_);
                    }
                    break;
                case 1:
                    js.executeScript("arguments[0].setAttribute('style', '"+ Constants.toggle1+"')", element);
                    if (element.getAttribute(Constants.style).equals(Constants.toggle1+";")){
                        isScalePass = true;
                    } else {
                        writeError(testCaseId+ Constants.errorMsg+ Constants.scale_);
                    }
                    break;
                case 2:
                    js.executeScript("arguments[0].setAttribute('style', '"+ Constants.toggle2+"')", element);
                    if (element.getAttribute(Constants.style).equals(Constants.toggle2+";")){
                        isScalePass = true;
                    } else {
                        writeError(testCaseId+ Constants.errorMsg+ Constants.scale_);
                    }
                    break;
                case 3:
                    js.executeScript("arguments[0].setAttribute('style', '"+ Constants.toggle3+"')", element);
                    if (element.getAttribute(Constants.style).equals(Constants.toggle3+";")){
                        isScalePass = true;
                    } else {
                        writeError(testCaseId+ Constants.errorMsg+ Constants.scale_);
                    }
                    break;
                case 4:
                    js.executeScript("arguments[0].setAttribute('style', '"+ Constants.toggle4+"')", element);
                    if (element.getAttribute(Constants.style).equals(Constants.toggle4+";")){
                        isScalePass = true;
                    } else {
                        writeError(testCaseId+ Constants.errorMsg+ Constants.scale_);
                    }
                    break;
                case 5:
                    js.executeScript("arguments[0].setAttribute('style', '"+ Constants.toggle5+"')", element);
                    if (element.getAttribute(Constants.style).equals(Constants.toggle5+";")){
                        isScalePass = true;
                    } else {
                        writeError(testCaseId+ Constants.errorMsg+ Constants.scale_);
                    }
                    break;
                case 6:
                    js.executeScript("arguments[0].setAttribute('style', '"+ Constants.toggle6+"')", element);
                    if (element.getAttribute(Constants.style).equals(Constants.toggle6+";")){
                        isScalePass = true;
                    } else {
                        writeError(testCaseId+ Constants.errorMsg+ Constants.scale_);
                    }
                    break;
                case 7:
                    js.executeScript("arguments[0].setAttribute('style', '"+ Constants.toggle7+"')", element);
                    if (element.getAttribute(Constants.style).equals(Constants.toggle7+";")){
                        isScalePass = true;
                    } else {
                        writeError(testCaseId+ Constants.errorMsg+ Constants.scale_);
                    }
                    break;
                case 8:
                    js.executeScript("arguments[0].setAttribute('style', '"+ Constants.toggle8+"')", element);
                    if (element.getAttribute(Constants.style).equals(Constants.toggle8+";")){
                        isScalePass = true;
                    } else {
                        writeError(testCaseId+ Constants.errorMsg+ Constants.scale_);
                    }
                    break;
                case 9:
                    js.executeScript("arguments[0].setAttribute('style', '"+ Constants.toggle9+"')", element);
                    if (element.getAttribute(Constants.style).equals(Constants.toggle9+";")){
                        isScalePass = true;
                    } else {
                        writeError(testCaseId+ Constants.errorMsg+ Constants.scale_);
                    }
                    break;
                case 10:
                    js.executeScript("arguments[0].setAttribute('style', '"+ Constants.toggle10+"')", element);
                    if (element.getAttribute(Constants.style).equals(Constants.toggle10+";")){
                        isScalePass = true;
                    } else {
                        writeError(testCaseId+ Constants.errorMsg+ Constants.scale_);
                    }
                    break;
            } // eof SLIDER

            // Comment
            if (comment.equals("no")){ // no = blank
                comment = Constants.empty;
                driver.findElement(By.id(Constants.idComment)).sendKeys(comment);
                if (driver.findElement(By.id(Constants.idComment)).getAttribute(Constants.value).equals(comment)){
                    isCommentPass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.comments_);
                }
            } else {
                driver.findElement(By.id(Constants.idComment)).sendKeys(comment);
                if (driver.findElement(By.id(Constants.idComment)).getAttribute(Constants.value).equals(comment)){
                    isCommentPass = true;
                } else {
                    writeError(testCaseId+ Constants.errorMsg+ Constants.comments_);
                }
            }

        } else {
            disabled = driver.findElement(By.id(Constants.idComment)).getAttribute(Constants.disabled);
            sliderOn = driver.findElement(By.id(Constants.idScaleSlider)).getAttribute(Constants.class_);

            if ((disabled == Constants.true_ || disabled.length() > 0)
                    && (sliderOn.contains(Constants.disabled1_) && sliderOn.contains(Constants.disabled2_))){
                isTryPass = true;
                isCommentPass = true;
                isScalePass = true;
            } else {
                writeError(testCaseId+ Constants.errorMsg+ Constants.try_);
            }
        }

        // Populate
        boolean isPopulatePass = false;
        if (model.isPopulated() == true){
            driver.findElement(By.id(Constants.idPopulate)).click();
            if (!model.getName().equals(driver.findElement(By.id(Constants.idName)).getAttribute(Constants.value))){
                isPopulatePass = true;
            } else {
                writeError(testCaseId+" : Error in populate button");
            }
        }



        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Submit
        if (isNamePass) {
            driver.findElement(By.id(Constants.idSubmit)).click();
        }

        String outputURL = driver.getCurrentUrl();
        String outputMSG = driver.findElement(By.id(Constants.idOutput)).getAttribute(Constants.innerHTML);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String status = "";
        if (isPopulatePass == true){
            status = Constants.PASS;
        } else {
            status = getResult(isNamePass,isFeaturePass,isOsPass,isInterfacePass,isTryPass,isScalePass,
                    isCommentPass,outputURL,outputMSG, model.getName());
        }

        driver.quit();
        return status;
    }

    public static void writeError(String error){
        try {

            FileOutputStream output = new FileOutputStream(Constants.ERROR_LOG, true);
            byte[] strToBytes = error.getBytes();
            output.write(strToBytes);
            output.write(System.getProperty("line.separator").getBytes());
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeResult(String result){
        try {

            FileOutputStream output = new FileOutputStream(Constants.TEST_RESULT, true);
            byte[] strToBytes = result.getBytes();
            output.write(strToBytes);
            output.write(System.getProperty("line.separator").getBytes());
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getResult(boolean name, boolean feature, boolean os, boolean interfaces, boolean istry,
                                   boolean scale, boolean comment, String url, String msg, String nameInput){
        String result = "";

        if (!name || !feature || !os || !interfaces || !istry || !scale || !comment){
            result = Constants.FAIL;
        } else if (url.equals(Constants.outputURL) && msg.contains(nameInput)){
            result = Constants.PASS;
        }

        return result;
    }


}
