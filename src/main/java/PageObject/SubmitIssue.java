package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SubmitIssue {
    public WebDriver d;

    public WebElement title,text,createdBy,assignedTo,status,submit,json;

    public SubmitIssue(WebDriver d){
        this.d = d;
    }

    public By byTitle = By.cssSelector("form[method='post'] input[name='issue_title']");
    By  byText = By.cssSelector("form[method='post'] textarea[name='issue_text']");
    By  byCreatedBy = By.cssSelector("form[method='post'] input[name='created_by']");
    By  byAssignedTo = By.cssSelector("form[method='post'] input[name='assigned_to']");
    By  byStatusText = By.cssSelector("form[method='post'] input[name='status_text']");

    By bySubmit = By.cssSelector("form[method='post'] button[type='submit']");

    public By byJson = By.id("jsonResult");

    public WebElement getTitle(){
        title = d.findElement(byTitle);
        return title;
    }

    public WebElement getText(){
        text = d.findElement(byText);
        return text;
    }

    public WebElement getCreatedBy(){
        createdBy = d.findElement(byCreatedBy);
        return createdBy;
    }

    public WebElement getAssignedTo(){
        assignedTo = d.findElement(byAssignedTo);
        return assignedTo;
    }

    public WebElement getStatus(){
        status = d.findElement(byStatusText);
        return status;
    }

    public WebElement getSubmit() {
        submit = d.findElement(bySubmit);
        return submit;
    }

    public WebElement getJson(){
        json = d.findElement(byJson);
        return json;
    }
}
