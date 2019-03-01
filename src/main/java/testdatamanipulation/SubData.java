package testdatamanipulation;

import utility.Utility;

import java.io.IOException;

public class SubData extends Utility {
    public String txtLocation = "";

    public SubData() throws IOException {
        super();
    }

    public String getValidTitle() {
        return  prop.getProperty("validTitle");
    }

    public String getValidText() {
        return prop.getProperty("validText");
    }

    public String getValidCreatedBy() {
        return prop.getProperty("validCreatedBy");
    }

    public String getAssignedTo(){
        return prop.getProperty("assignedTo");
    }

    public String getStatus(){
        return prop.getProperty("status");
    }

    public String getInvalidShortTitle() {
        return prop.getProperty("invalidShortTitle");
    }

    public String getInvalidShortText() {
        return prop.getProperty("invalidShortText");
    }

    public String getInvalidShortCreatedBy() {
        return prop.getProperty("invalidShortCreatedBy");
    }

    public String getUpdateErrId(){
        return prop.getProperty("errIdShort");
    }

    public String getErrTitleShort(){
        return prop.getProperty("errTitleShort");
    }

    public String getErrTextShort(){
        return prop.getProperty("errTextShort");
    }

    public String getErrCreatedByShort(){
        return prop.getProperty("errCreatedByShort");
    }

    public String getErrDeleteId(){
        return prop.getProperty("errDeleteId");
    }

    public String getSuccess(){
        return prop.getProperty("success");
    }

    public String getSuccessUpdate(){
        return prop.getProperty("successUpdate");
    }

    public void getTxtLocation(){
         txtLocation= prop.getProperty("txtLocation");
    }

    public String getErrWhenDbEmptyAndStatusActive(){
        return prop.getProperty("QueryStatusActiveWhenDbIsEmpty");
    }
    public String getAssignedTo2(){
        return prop.getProperty("assignedTo2");
    }
    public String getInvalidAssignedTo(){
        return prop.getProperty("invalidAssignedTo");
    }

    public String getInvalidStatusText(){
        return prop.getProperty("invalidStatus");
    }


}
