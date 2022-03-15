package pages;

import org.openqa.selenium.By;
import utils.GeralPage;

public class HomePage extends GeralPage {

    private By lbl_menu = By.cssSelector("div.left-side > button");

    public void acessarMenu(){
        clickAndHighlight(lbl_menu);
    }

}
