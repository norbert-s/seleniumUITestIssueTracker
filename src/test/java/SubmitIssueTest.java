import PageObject.SubmitIssue;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testdatamanipulation.CreateFile;
import testdatamanipulation.SubData;
import testdatamanipulation.SubWord;

import java.io.IOException;

public class SubmitIssueTest extends SubData{
    String value,jsonText;
    boolean errOk=false;
    boolean success=false;

    public SubmitIssue submit;

    private WebDriverWait wait;

    SubWord a;
    CreateFile file;

//    public SubmitIssue getSubmitIssue(){
//        return submit;
//    }

    SubmitIssueTest() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {

        submit = new SubmitIssue(d);
        d.navigate().to(url);
    }
    @BeforeMethod
    public void setupMethod(){
        d.navigate().refresh();
    }

    @Test
    public void validValuesForTheAPI_C1() throws InterruptedException {
        submit.getTitle().sendKeys(getValidTitle());
        submit.getText().sendKeys(getValidText());
        submit.getCreatedBy().sendKeys(getValidCreatedBy());
        submit.getSubmit().click();

        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
        //System.out.println(jsonText);
        boolean containsSuccess=false;
        if(jsonText.contains(getSuccess())){
            containsSuccess=true;
        }

        Assert.assertTrue(containsSuccess);
    }

    @Test
    public void nonValidTitle_C2() throws InterruptedException {
        submit.getTitle().sendKeys(getInvalidShortTitle());
        submit.getSubmit().click();
        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTitleShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }

    @Test
    public void nothingIsEnteredToBeSubmitted_C3() throws InterruptedException {
        submit.getSubmit().click();
        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTitleShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }

    @Test
    public void mandatoryFieldsAreEnteredExceptTitle_C4() throws InterruptedException {
        submit.getText().sendKeys(getValidText());
        submit.getCreatedBy().sendKeys(getValidCreatedBy());
        submit.getSubmit().click();
        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTitleShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
    @Test
    public void titleIsProvidedButNoTextField_C5() throws InterruptedException {
        submit.getTitle().sendKeys(getValidTitle());
        submit.getSubmit().click();
        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTextShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
    @Test
    public void noTextisEntered_C6() throws InterruptedException {
        submit.getTitle().sendKeys(getValidTitle());
        submit.getCreatedBy().sendKeys(getValidCreatedBy());
        submit.getSubmit().click();
        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTextShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
    @Test
    public void firstTwoButNotThird_C7() throws InterruptedException {
        submit.getTitle().sendKeys(getValidTitle());
        submit.getText().sendKeys(getValidText());
        submit.getSubmit().click();
        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrCreatedByShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
    @Test
    public void firstIsTwoChars_C9() throws InterruptedException {
        submit.getTitle().sendKeys(getInvalidShortTitle());
        submit.getText().sendKeys(getValidText());
        submit.getCreatedBy().sendKeys(getValidCreatedBy());
        submit.getSubmit().click();
        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTitleShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
    @Test
    public void secondIsTwoChars_C10() throws InterruptedException {
        submit.getTitle().sendKeys(getValidTitle());
        submit.getText().sendKeys(getInvalidShortText());
        submit.getCreatedBy().sendKeys(getValidCreatedBy());
        submit.getSubmit().click();
        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
       // //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTextShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }

    @Test
    public void thirdIsTwoChars_C11() throws InterruptedException {
        submit.getTitle().sendKeys(getValidTitle());
        submit.getText().sendKeys(getValidText());
        submit.getCreatedBy().sendKeys(getInvalidShortCreatedBy());
        submit.getSubmit().click();
        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrCreatedByShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
    @Test
    public void FourEntered_C12() throws InterruptedException {
        submit.getTitle().sendKeys(getValidTitle());
        submit.getText().sendKeys(getValidText());
        submit.getCreatedBy().sendKeys(getValidCreatedBy());
        submit.getAssignedTo().sendKeys(getAssignedTo());
        submit.getSubmit().click();
        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getSuccess())){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test
    public void allFiveEntered_C14() throws InterruptedException, IOException {


        submit.getTitle().sendKeys(getValidTitle());
        submit.getText().sendKeys(getValidText());
        submit.getCreatedBy().sendKeys(getValidCreatedBy());
        submit.getAssignedTo().sendKeys(getAssignedTo());
        submit.getStatus().sendKeys(getStatus());
        submit.getSubmit().click();
        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getSuccess())){
            success=true;
        }
        Assert.assertTrue(success);

    }
    @Test
    public void title256Chars_C15() throws InterruptedException, IOException {
        a = new SubWord();
        String chars256 = a.getString(256);
        submit.getTitle().sendKeys(chars256);
        submit.getText().sendKeys(getValidText());
        submit.getCreatedBy().sendKeys(getValidCreatedBy());
        submit.getAssignedTo().sendKeys(getAssignedTo());
        submit.getStatus().sendKeys(getStatus());
        submit.getSubmit().click();
        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getErrTitleShort())){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test
    public void text3001Chars_C16() throws InterruptedException, IOException {
        file = new CreateFile();

        String data = file.createData(3001);
        submit.getTitle().sendKeys(getValidTitle());
        submit.getText().sendKeys(data);
        submit.getCreatedBy().sendKeys(getValidCreatedBy());
        submit.getSubmit().click();
        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getErrTextShort())){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test
    public void text3000Chars_C17() throws InterruptedException, IOException {
        file = new CreateFile();
        String data = file.createData(3000);
        submit.getTitle().sendKeys(getValidTitle());
        submit.getText().sendKeys(data);
        submit.getCreatedBy().sendKeys(getValidCreatedBy());
        submit.getSubmit().click();
        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getSuccess())){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test
    public void title255Chars_C18() throws InterruptedException, IOException {
        a = new SubWord();
        String chars256 = a.getString(255);
        submit.getTitle().sendKeys(chars256);
        submit.getText().sendKeys(getValidText());
        submit.getCreatedBy().sendKeys(getValidCreatedBy());
        submit.getAssignedTo().sendKeys(getAssignedTo());
        submit.getStatus().sendKeys(getStatus());
        submit.getSubmit().click();

//        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getSuccess())){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test
    public void createdBy256Chars_C20() throws InterruptedException, IOException {
//        a = new SubWord();
//        String chars256 = a.getString(256);
        file = new CreateFile();
        String data = file.createData(256);
        submit.getTitle().sendKeys(getValidTitle());
        submit.getText().sendKeys(getValidText());
        submit.getCreatedBy().sendKeys(data);
        submit.getSubmit().click();

//        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getErrCreatedByShort())){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test
    public void createdBy255Chars_C21() throws InterruptedException, IOException {
//        a = new SubWord();
//        String chars256 = a.getString(255);
        file = new CreateFile();
        String data = file.createData(255);
        submit.getTitle().sendKeys(getValidTitle());
        submit.getText().sendKeys(getValidText());
        submit.getCreatedBy().sendKeys(data);
        submit.getSubmit().click();


//        wait = callWait(submit.getJson());
        String jsonText = submit.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getSuccess())){
            success=true;
        }
        Assert.assertTrue(success);
    }

    @AfterTest
    public void tearDown(){

    }
}
