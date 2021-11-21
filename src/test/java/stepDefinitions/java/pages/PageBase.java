package stepDefinitions.java.pages;

import org.openqa.selenium.support.PageFactory;
import stepDefinitions.java.utilities.Driver;

public  class PageBase {

    public PageBase(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
