import PageObject.SubmitIssue;
import PageObject.UpdateIssue;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testdatamanipulation.CreateFile;
import testdatamanipulation.ReadTxt;
import testdatamanipulation.SubData;
import testdatamanipulation.SubWord;

import java.io.IOException;

public class UpdateIssueTest extends SubData{
    private String value,jsonText,id;
    private boolean errOk=false;
    private boolean success=false;

    private WebDriverWait wait;

    private ReadTxt txt;

    private UpdateIssue update;

    public UpdateIssueTest() throws IOException {
    }

    @BeforeTest
    public void setup() throws IOException {
        update= new UpdateIssue(d);
        d.navigate().to(url);
    }
    @BeforeMethod
    public void setupMethod() throws IOException {
        errOk=false;
        success=false;
        d.navigate().refresh();
        id = ReadTxt.returnRandomLineNumberOfIds();
    }

    @Test
    public void nothingIsEnteredAndThenSubmitted_C22(){
        update.getSubmit().click();
        wait = callWait(update.getJson());
        jsonText = update.getJson().getText();
        if(jsonText.contains(getUpdateErrId())){
            errOk=true;
        }
        Assert.assertTrue(errOk);

    }

    @Test
    public void validIdIsNotEnteredButOtherFields_C23(){
        update.getTitle().sendKeys(getValidTitle());
        update.getText().sendKeys(getValidText());
        update.getSubmit().click();
        wait = callWait(update.getJson());
        jsonText = update.getJson().getText();
        if(jsonText.contains(getUpdateErrId())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
    @Test
    public void everythingIsValidEntered_C24() throws IOException {
        update.getId().sendKeys(id);
        update.getTitle().sendKeys(getValidTitle());
        update.getText().sendKeys(getValidText());
        update.getSubmit().click();
        wait = callWait(update.getJson());
        jsonText = update.getJson().getText();
        if(jsonText.contains(getSuccessUpdate())){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test
    public void everythingIsValidEntered_C25() throws IOException {
        update.getId().sendKeys(id);
        update.getTitle().sendKeys(getValidTitle());
        update.getText().sendKeys(getValidText());
        update.changeStatus().click();
        update.getSubmit().click();
        wait = callWait(update.getJson());
        jsonText = update.getJson().getText();
        if(jsonText.contains(getSuccessUpdate()) && jsonText.contains("status: false")){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test
    public void notValidIdIsEntered_C26(){
        update.getId().sendKeys(getInvalidShortText()); //providing not valid id
        update.getTitle().sendKeys(getValidTitle());
        update.getText().sendKeys(getValidText());
        update.getSubmit().click();
        wait = callWait(update.getJson());
        jsonText = update.getJson().getText();
        if(jsonText.contains(getUpdateErrId())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
}
