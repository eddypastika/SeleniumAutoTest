package constants;

public class Constants {

    // URL and web Element
    public static final String URL = "https://devexpress.github.io/testcafe/example/";

    // name
    public static final String name_ = "name";
    public static final String idName = "developer-name";
    public static final String idPopulate = "populate";
    public static final String disabled = "disabled";
    public static final String value = "value";


    // features
    public static final String feature_ = "feature";
    public static final String idFeature1 = "remote-testing";
    public static final String xFeature1 = "//*[@id=\"main-form\"]/div/div[1]/div[1]/fieldset[2]/p[1]/label";
    public static final String idFeature2 = "reusing-js-code";
    public static final String xFeature2 = "//*[@id=\"main-form\"]/div/div[1]/div[1]/fieldset[2]/p[2]/label";
    public static final String idFeature3 = "background-parallel-testing";
    public static final String xFeature3 = "//*[@id=\"main-form\"]/div/div[1]/div[1]/fieldset[2]/p[3]/label";
    public static final String idFeature4 = "continuous-integration-embedding";
    public static final String xFeature4 = "//*[@id=\"main-form\"]/div/div[1]/div[1]/fieldset[2]/p[4]/label";
    public static final String idFeature5 = "traffic-markup-analysis";
    public static final String xFeature5 = "//*[@id=\"main-form\"]/div/div[1]/div[1]/fieldset[2]/p[5]/label";

    // os
    public static final String os_ = "os";
    public static final String idOSWindows = "windows";
    public static final String xOSWindows = "//*[@id=\"main-form\"]/div/div[1]/div[2]/fieldset[1]/p[1]/label";
    public static final String idOSMac = "macos";
    public static final String xOSMac = "//*[@id=\"main-form\"]/div/div[1]/div[2]/fieldset[1]/p[2]/label";
    public static final String idOSLinux = "linux";
    public static final String xOSLinux = "//*[@id=\"main-form\"]/div/div[1]/div[2]/fieldset[1]/p[3]/label";

    // interface
    public static final String interface_ = "interface";
    public static final String idInterface = "preferred-interface";
    public static final String xInterface = "//*[@id=\"preferred-interface\"]";

    // isTry
    public static final String try_ = "isTry";
    public static final String idTry = "tried-test-cafe";
    public static final String xTry = "//*[@id=\"tried-section\"]/label";
    public static final String class_ = "Class";
    public static final String true_ = "true";
    public static final String false_ = "false";
    public static final String disabled1_ = "ui-slider-disabled";
    public static final String disabled2_ = "ui-state-disabled";

    // scale
    public static final String scale_ = "scale";
    public static final String idScaleSlider = "slider";
    public static final String xScaleToggle = "//*[@id=\"slider\"]/span";
    public static final String style = "style";
    public static final String toggle1 = "left: 0%";
    public static final String toggle2 = "left: 11.1111%";
    public static final String toggle3 = "left: 22.2222%";
    public static final String toggle4 = "left: 33.3333%";
    public static final String toggle5 = "left: 44.4444%";
    public static final String toggle6 = "left: 55.5556%";
    public static final String toggle7 = "left: 66.6667%";
    public static final String toggle8 = "left: 77.7778%";
    public static final String toggle9 = "left: 88.8889%";
    public static final String toggle10 = "left: 100%";

    // comment
    public static final String comments_ = "comments";
    public static final String idComment = "comments";

    // Submit button
    public static final String submit_ = "submit";
    public static final String idSubmit = "submit-button";

    // CHROME
    public static final String chromeDriverKey = "webdriver.chrome.driver";
    public static final String chromeDriverPath = "webdriver/chromedriver.exe";

    // FIREFOX
    public static final String geckoDriverKey = "webdriver.gecko.driver";
    public static final String geckoDriverPath = "webdriver/eckodriver.exe"; // need to download the file first and copy to webdriver folder

    // IE
    public static final String ieDriverKey = "webdriver.ie.driver";
    public static final String ieDriverPath = "webdriver/IEDriverServer.exe"; // need to download the file first and copy to webdriver folder

    // EXCEL FILE PATH
    public static final String TEST_DATA = "inputFile/TestData.xlsx";
    public static final String TEST_CASE = "inputFile/TestCase.xlsx";
    public static final String ERROR_LOG = "C:\\Users\\ig.eddy.p.putra\\Documents\\EDDY\\SeleniumProjects\\SeleniumAutoTest\\src\\main\\resources\\log\\FAILED_LOG.txt";
    public static final String TEST_RESULT = "C:\\Users\\ig.eddy.p.putra\\Documents\\EDDY\\SeleniumProjects\\SeleniumAutoTest\\src\\main\\resources\\log\\RESULT.txt";


    // Test Case
    public static int startIndexTC = 18;
    public static int columnIndexTC = 1;
    public static int columnIndexStatus = 8;

    // Test Data
    public static int no = 0;
    public static int tcId = 1;
    public static int name = 2;
    public static int featureId = 3;
    public static int osId = 4;
    public static int interfaceId = 5;
    public static int isTry = 6;
    public static int scale = 7;
    public static int comment = 8;
    public static String empty = "";

    public static int zero = 0;

    // feature code
    public static int featureOne = 1; // related with idFeature1
    public static int featureTwo = 2; // related with idFeature2
    public static int featureThree = 3; // related with idFeature3
    public static int featureFour = 4; // related with idFeature4
    public static int featureFive = 5; // related with idFeature5
    public static int featureSix = 6; // 2 features selected
    public static int featureSeven = 7; // 3 features selected
    public static int featureEight = 8; // 4 features selected
    public static int featureNine = 9; // all features selected

    // ERROR
    public static final String errorMsg = " : Error in ";

    // OS value
    public static final String interface1 = "Command Line";
    public static final String interface2 = "JavaScript API";
    public static final String interface3 = "Both";

    // Output
    public static final String outputURL = "https://devexpress.github.io/testcafe/example/thank-you.html";
    public static final String idOutput = "article-header";
    public static final String innerHTML = "innerHTML";
    public static final String PASS = "PASS";
    public static final String FAIL = "FAIL";




}
