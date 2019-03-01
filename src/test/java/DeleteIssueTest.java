import PageObject.DeleteIssue;
import PageObject.SubmitIssue;
import PageObject.UpdateIssue;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testdatamanipulation.ReadTxt;
import testdatamanipulation.SubData;
import utility.Utility;


import java.io.IOException;

public class DeleteIssueTest extends SubData {
    private String value,jsonText,id;
    private boolean errOk=false;
    private boolean success=false;

    private WebDriverWait wait;

    private ReadTxt txt;

    private DeleteIssue delete;

    SubmitIssue submit = new SubmitIssue(d);

    public DeleteIssueTest() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        delete= new DeleteIssue(d);
        d.navigate().to(url);
    }
    @BeforeMethod
    public void setupMethod() throws IOException {
        errOk=false;
        success=false;
        jsonText="";
        d.navigate().refresh();

    }

    @Test
    public void nothingIsEnteredAndThenSubmitted_C27() throws InterruptedException {
        delete.getSubmit().click();
        sleep();
        callWait(delete.getJson());
        jsonText = delete.getJson().getText();
        if(jsonText.contains(getErrDeleteId())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }

    @Test
    public void invalidIdEntered_C28() throws InterruptedException {
        delete.getIdField().sendKeys(getValidText());
        delete.getSubmit().click();

        callWait(delete.getJson());
        jsonText = delete.getJson().getText();
        if(jsonText.contains(getErrDeleteId())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }

    @Test
    public void validIdEntered_26(){

        submit.getTitle().sendKeys(getValidTitle());
        submit.getText().sendKeys(getValidText());
        submit.getCreatedBy().sendKeys(getValidCreatedBy());
        submit.getSubmit().click();


        callWait(submit.getJson());

        String json = submit.getJson().getText();
        String [] tomb = json.split(" ");
        json = tomb[4];
        tomb = json.split("t");
        String id = tomb[0];
        d.navigate().refresh();
        jsonText="";
        delete.getIdField().sendKeys(id);
        delete.getSubmit().submit();
        callWait(delete.getJson());
        jsonText = delete.getJson().getText();
        System.out.println(jsonText);
        if(jsonText.contains("and the record below has been")){
            success = true;
        }
        Assert.assertTrue(success);

    }





}
