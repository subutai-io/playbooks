package od.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

    //region WEB ELEMENTS: Fields

    @FindBy(id = "subt-input__password")
    public WebElementFacade inputPassword;

    @FindBy(name = "new-password")
    public WebElementFacade inputNewPassword;

    @FindBy(name = "confirm-password")
    public WebElementFacade inputConfirmPassword;

    @FindBy(name = "login")
    public WebElementFacade inputLogin;

    //endregion

    //region WEB ELEMENTS: Buttons

    @FindBy(xpath = "*//button[contains(text(),\"Save and login\")]")
    public WebElementFacade buttonSaveAndLogin;

    @FindBy(id = "subt-button__login")
    public WebElementFacade buttonLogin;

    //endregion

    //region WEB ELEMENTS: Checkboxes

    //endregion

    //region WEB ELEMENTS: Links

    //endregion

    //region WEB ELEMENTS: Tables

    //endregion

    //region WEB ELEMENTS: Pickers

    //endregion

    //region WEB ELEMENTS: Selectors

    //endregion

    //region WEB ELEMENTS: Images

    //endregion

    //region WEB ELEMENTS: Icons

    //endregion

    //region WEB ELEMENTS: Headers

    @FindBy(xpath = "*//h1[contains(text(),\"Log in\")]")
    public WebElementFacade headerLogin;

    //endregion

    @FindBy(xpath = "*//div[@class=\"b-form__error-message ng-binding ng-scope\"]")
    public WebElementFacade LoginError;

}
