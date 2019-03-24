package model;

public class TestDataModel {

    int no;
    String testCaseId;
    String name;
    int featuresId;
    int osId;
    int interfacesId;
    boolean isTry;
    int scale;
    String comment;
    boolean isPopulated;

    public TestDataModel() {
    }

    public TestDataModel(int no, String testCaseId, String name, int featuresId, int osId,
                         int interfacesId, boolean isTry, int scale, String comment, boolean isPopulated) {
        this.no = no;
        this.testCaseId = testCaseId;
        this.name = name;
        this.featuresId = featuresId;
        this.osId = osId;
        this.interfacesId = interfacesId;
        this.isTry = isTry;
        this.scale = scale;
        this.comment = comment;
        this.isPopulated = isPopulated;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(String testCaseId) {
        this.testCaseId = testCaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFeaturesId() {
        return featuresId;
    }

    public void setFeaturesId(int featuresId) {
        this.featuresId = featuresId;
    }

    public int getOsId() {
        return osId;
    }

    public void setOsId(int osId) {
        this.osId = osId;
    }

    public int getInterfacesId() {
        return interfacesId;
    }

    public void setInterfacesId(int interfacesId) {
        this.interfacesId = interfacesId;
    }

    public boolean isTry() {
        return isTry;
    }

    public void setTry(boolean aTry) {
        isTry = aTry;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isPopulated() {
        return isPopulated;
    }

    public void setPopulated(boolean populated) {
        isPopulated = populated;
    }
}
