package od.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import od.classes.ExecuteShellCommand;
import od.classes.ReaderFromFile;
import od.pages.*;
import org.hamcrest.Matchers;

import java.io.FileNotFoundException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SubutaiSteps extends ScenarioSteps {

    //region IMPORT: Imports
    LoginPage loginPage;
    CommonPages commonPage;
    ExecuteShellCommand executeShellCommand;
    MonitoringPage monitoringPage;
    BlueprintsPage blueprintsPage;
    EnvironmentsPage environmentsPage;
    ContainersPage containersPage;
    KurjunPage kurjunPage;
    ConsolePage consolePage;
    UserManagementPage userManagementPage;
    RoleManagementPage roleManagementPage;
    AccountSettings accountSettingsPage;
    TokensPage tokensPage;
    PeerRegistrationPage peerRegistrationPage;
    ResourceHostsPage resourceHostsPage;
    TrackerPage trackerPage;
    BazaarPage bazaarPage;
    PeerSettingsPage peerSettingsPage;
    KurjunSettingsPage kurjunSettingsPage;
    NetworkSettings networkSettingsPage;
    AdvancedPage advancedPage;
    AboutPage aboutPage;
    PgpPlugin pgpPlugin;
    PluginsPage pluginsPage;
    private Object environmentData;
    private Object token;
    private Object peerID;
    //endregion

    //region ACTION: Open Page

    @Step
    public void open_mng_h1() throws FileNotFoundException {
        loginPage.setDefaultBaseUrl(String.format("https://%s:8443/", ReaderFromFile.readDataFromFile("src/test/resources/parameters/mng_h1")));
        loginPage.open();
    }

    @Step
    public void open_mng_h2() throws FileNotFoundException {
        loginPage.setDefaultBaseUrl(String.format("https://%s:8443/", ReaderFromFile.readDataFromFile("src/test/resources/parameters/mng_h2")));
        loginPage.open();
    }

    @Step
    public void open_domain_test() throws FileNotFoundException {
        loginPage.setDefaultBaseUrl(String.format("http://%s/", ReaderFromFile.readDataFromFile("src/test/resources/parameters/test")));
        loginPage.open();
    }

    //endregion

    //region ACTION: Type

    @Step
    public void inputLogin(String login) {
        loginPage.inputLogin.type(login);
    }

    @Step
    public void inputPassword(String password) {
        loginPage.inputPassword.type(password);
    }

    @Step
    public void inputNewPassword(String password) {
        loginPage.inputNewPassword.type(password);
    }

    @Step
    public void inputConfirmPasswordOnLogin(String password) {
        loginPage.inputConfirmPassword.type(password);
    }

    @Step
    public void inputEnvironmentName(String env_name) {
        environmentsPage.inputEnvironmentName.type(env_name);
    }

    @Step
    public void inputNewUserUsername(String username) {
        userManagementPage.fieldUsername.type(username);
    }

    @Step
    public void inputNewUserFullName(String fullname) {
        userManagementPage.fieldFullName.type(fullname);
    }

    @Step
    public void inputNewUserEmail(String email) {
        userManagementPage.fieldEmail.type(email);
    }

    @Step
    public void inputNewUserPassword(String password) {
        userManagementPage.fieldPassword.type(password);
    }

    @Step
    public void inputNewUserConfirmPassword(String confirmPassword) {
        userManagementPage.fieldConfirmPassword.type(confirmPassword);
    }

    @Step
    public void inputLoginPeerRegistrationOnHub(String login) {
        commonPage.fieldLogin.type(login);
    }

    @Step
    public void inputPasswordPeerRegistrationOnHub(String password) {
        commonPage.fieldPassword.type(password);
    }

    @Step
    public void inputPeerIP(String ip) {
        peerRegistrationPage.fieldPeerIp.type(ip);
    }

    @Step
    public void inputPeerKeyPhrase(String key) {
        peerRegistrationPage.fieldPeerKeyPhrase.type(key);

    }

    @Step
    public void inputApprovePeerKeyPhrase(String key) {
        peerRegistrationPage.fieldPeerApprove.type(key);
    }

    @Step
    public void inputTemplateNameInSearchField(String name) {
//        environmentsPage.waitTemplateCassandra();
        waitABit(3000);
        environmentsPage.fieldSearch.type(name);
    }

    @Step
    public void inputPluginName(String plugin) {
        bazaarPage.fieldSearch.type(plugin);
    }

    @Step
    public void inputClusterName(String cluster) {
        pluginsPage.fieldClusterName.type(cluster);
    }

    @Step
    public void inputProfileName(String profile) {
        pluginsPage.fieldProfile.type(profile);
    }

    @Step
    public void inputDomainName(String name) {
        pluginsPage.fieldDomainName.type(name);
    }

    @Step
    public void inputOperationName(String operation) {
        pluginsPage.fieldOperationName.type(operation);
    }

    @Step
    public void inputOperation(String ls) {
        pluginsPage.fieldOperation.type(ls);
    }

    @Step
    public void inputDomain(String name) {
        pluginsPage.fieldDomain.type(name);
    }

    @Step
    public void inputAppScaleEnvironmentName(String name) {
        pluginsPage.fieldEnvironmentName.type(name);
    }

    @Step
    public void inputOldPassword(String oldpass) {
        accountSettingsPage.fieldOldPassword.type(oldpass);
    }

    @Step
    public void inputNepPassword(String password) {
        accountSettingsPage.fieldNewPassword.type(password);
    }

    @Step
    public void inputConfirmPassword(String confpass) {
        accountSettingsPage.fieldConfirmPassword.type(confpass);
    }

    @Step
    public void inputTheRoleName(String role) {
        roleManagementPage.fieldRoleName.type(role);
    }

    @Step
    public void inputNameInSearchField(String iManagement) {
        commonPage.fieldSearch.type(iManagement);
    }

    @Step
    public void inputSetDomainName(String s) {
        environmentsPage.fieldDomainName.type(s);
    }
    //endregion

    //region ACTION: Click

    @Step
    public void clickOnButtonLogin() {
        loginPage.buttonLogin.click();
        if (loginPage.LoginError.containsText("Wrong Auth Credentials")) {
            inputPassword("secret1");
            loginPage.buttonLogin.click();
        } else {
            inputNewPassword("secret1");
            inputConfirmPasswordOnLogin("secret1");
            clickOnButtonSaveAndLogin();
        }
    }

    @Step
    public void clickOnButtonSaveAndLogin() {
        loginPage.buttonSaveAndLogin.click();
    }

    @Step
    public void clickOnMenuItemMonitoring() {
        assertThat(commonPage.linkMonitoring.isVisible(), is(true));
        commonPage.linkMonitoring.click();
    }

    @Step
    public void clickOnSelectorHostsMonitoringPage() {
        waitABit(2000);
        assertThat(monitoringPage.selectorHosts.isVisible(), is(true));
        monitoringPage.selectorHosts.waitUntilClickable().click();
    }

    @Step
    public void clickOnMenuEnvironment() {
        assertThat(commonPage.linkEnvironment.isVisible(), is(true));
        commonPage.linkEnvironment.click();
    }

    @Step
    public void clickOnMenuItemBlueprints() {
        commonPage.linkBlueprint.click();
    }

    @Step
    public void clickOnMenuItemEnvironments() {
        assertThat(commonPage.linkEnvironments.isVisible(), is(true));
        commonPage.linkEnvironments.click();
    }

    @Step
    public void clickOnMenuItemContainers() {
        commonPage.linkContainers.click();
    }

    @Step
    public void clickOnMenuItemConsole() {
        commonPage.linkConsole.click();
    }

    @Step
    public void clickOnSelectorHostsConsolePage() {
        consolePage.itemSelectorHost.click();
    }

    @Step
    public void clickOnManagementHost() {
        consolePage.selectorHostsItemManagementHost.click();
    }


    @Step
    public void clickOnLocalHost() {
        consolePage.selectorHostsItemRecourceHost.click();
    }

    public void clickOnMenuUserIdentity() {
        commonPage.linkUserIdentity.click();
    }

    @Step
    public void clickOnMenuItemRoleManagement() {
        commonPage.linkRoleManagement.click();
    }

    @Step
    public void clickOnMenuItemTokens() {
        commonPage.linkTokens.click();
    }

    @Step
    public void clickOnMenuItemPeerRegistration() {
        commonPage.linkPeerRegistration.click();
    }

    @Step
    public void clickOnMenuItemResourceHosts() {
        commonPage.linkResourceNode.click();
    }

    @Step
    public void clickOnMenuItemTracker() {
        commonPage.linkTracker.click();
    }

    @Step
    public void clickOnMenuItemBazaar() {
        commonPage.linkPlugins.click();
        waitABit(4000);
    }

    @Step
    public void clickOnMenuItemSystemSettings() {
        commonPage.linkPluginIntegrator.click();
    }

    @Step
    public void clickOnMenuItemAbout() {
        commonPage.linkAbout.click();
    }

    @Step
    public void clickOnIconTemplateMongo() {
        environmentsPage.waitFor(environmentsPage.sikuliTemplateMongo);
    }


    @Step
    public void clickOnButtonApply() {
        assertThat(environmentsPage.buttonApply.isVisible(), is(true));
        environmentsPage.buttonApply.click();
    }

    @Step
    public void clickOnButtonBuild() {
        assertThat(environmentsPage.buttonBuild.isVisible(), is(true));
        environmentsPage.buttonBuild.click();
    }

    @Step
    public void clickOnButtonCloseBuildPopup() {
//        commonPage.waitFor(environmentsPage.buttonClose);
        environmentsPage.waitForCloseButton();
        environmentsPage.buttonClose.click();
    }

    @Step
    public void clickOnIconDeleteEnvironment(String env_name) {
        assertThat(environmentsPage.EnvironmentLine.findBy(
                org.openqa.selenium.By.xpath("tr[.//a[contains(text(),'" + env_name + "')]]/*//a[@class='b-icon b-icon_remove ng-scope']")
        ).isVisible(), is(true));

        environmentsPage.EnvironmentLine.findBy(
                org.openqa.selenium.By.xpath("tr[.//*[contains(text(),'" + env_name + "')]]/*//a[@class='b-icon b-icon_remove ng-scope']")
        ).click();
    }

    @Step
    public void clickOnButtonDelete() {
        waitABit(3000);
        assertThat(environmentsPage.buttonDelete.isVisible(), is(true));
        environmentsPage.buttonDelete.click();
        waitABit(3000);
//        waitABit(1000000);
    }

    @Step
    public void clickOnButtonOkPopupEnvironmentHasBeenDestroyed() {
        commonPage.waitFor(commonPage.textEnvironmentHasBeenDestroyed);
    }

    @Step
    public void clickOnIconPgp() {
    }

    @Step
    public void clickOnButtonOptions() {
    }

    @Step
    public void clickOnButtonGenerate() {
    }

    @Step
    public void typeInFieldsPgp() {
    }

    @Step
    public void typeInFieldConfirmPasswordE2EKey() {
    }

    @Step
    public void clickOnButtonSubmit() {
    }

    @Step
    public void clickOnButtonOkPGP() {
        //screen.click(pgpPlugin.sikuliButtonOk);
        //screen.wait(pgpPlugin.sikuliMessageKeyPairSuccessfullyGenerated, 60000);
        //screen.click(pgpPlugin.sikuliButtonOk);
    }

    @Step
    public void clickOnSubutaiSocialTab() {
        //screen.click(pgpPlugin.sikuliSubutaiSocialTab);
    }

    @Step
    public void clickOnMenuItemAccountSettings() {
        //screen.click(commonPage.sikuliMenuItemAccountSettings);
    }

    @Step
    public void clickOnButtonSetPublicKey() {
        //screen.click(userManagementPage.sikuliButtonSetPublicKey);
    }

    @Step
    public void clickOnUpperMenuItemRegisterPeer() {
        assertThat(commonPage.titleUpperMenuRegisterPeer.isVisible(), is(true));
        commonPage.titleUpperMenuRegisterPeer.click();
////        screen.click(commonPage.sikuliUpperMenuItemRegisterPeer);
    }

    @Step
    public void clickOnIconNotifications() {
        assertThat(commonPage.upperMenuNotificationsBody.isCurrentlyEnabled(), is(true));
        commonPage.upperMenuNotificationsBody.click();
////        screen.click(commonPage.sikuliIconNotifications);
    }

    @Step
    public void clickOnAdvancedMode() {
        ////screen.click(environmentsPage.sikuliButtonAdvanced);
        assertThat(environmentsPage.checkboxEnvironmentMode.isVisible(), is(true));
        environmentsPage.checkboxEnvironmentMode.click();
    }

    @Step
    public void clickOnTitleTemplates() {
        assertThat(environmentsPage.titleTemplates.isVisible(), is(true));
        environmentsPage.titleTemplates.click();
////        screen.click(environmentsPage.sikuliTitleTemplates);
    }

    @Step
    public void clickOnMenuItemKurjun() {
        //screen.click(commonPage.sikuliMenuItemKurjun);
        waitABit(5000);
    }

    @Step
    public void clickOnTitleAPT() {
        //screen.click(kurjunPage.sikuliTitleAPT);
    }

    @Step
    public void clickOnMenuItemUserIdentity() {
        //screen.click(commonPage.sikuliMenuItemUserIdentity);
    }

    @Step
    public void clickOnTitleChangePassword() {
        //screen.click(accountSettingsPage.sikuliTitleChangePassword);
    }

    @Step
    public void clickOnTitleInstalled() {
        //screen.click(bazaarPage.sikuliMenuTitleInstalled);
    }

    @Step
    public void clickOnTitleAdvanced() {
        //screen.click(bazaarPage.sikuliMenuTitleAdvanced);
    }

    @Step
    public void clickOnMenuItemPeerSettings() {
        //screen.click(commonPage.sikuliMenuItemPeerSettings);
    }

    @Step
    public void clickOnTitlePolicy() {
        //screen.click(peerSettingsPage.sikuliTitlePolicy);
    }

    @Step
    public void clickOnMenuItemKurjunSettings() {
        //screen.click(commonPage.sikuliMenuItemKurjunSettings);
    }

    @Step
    public void clickOnTitleQuotas() {
        //screen.click(kurjunSettingsPage.sikuliTitleQuotas);
    }

    @Step
    public void clickOnMenuItemNetworkSettings() {
        //screen.click(commonPage.sikuliMenuItemNetworkSettings);
    }

    @Step
    public void clickOnMenuItemAdvanced() {
        //screen.click(commonPage.sikuliMenuItemAdvanced);
    }

    @Step
    public void clickOnTitleEnvironment() {
        assertThat(monitoringPage.EnvironmentTab.isVisible(), is(true));
        monitoringPage.EnvironmentTab.click();
    }

    @Step
    public void clickOnTitleLogs() {
        //screen.click(advancedPage.sikuliTitleLogs);
    }

    @Step
    public void clickOnTemplateWebdemo() {
        //screen.click(environmentsPage.sikuliTemplateWebdemo);
    }

    @Step
    public void clickOnIconDeleteEnvironmentNotSikuli() {
        environmentsPage.iconDeleteEnvironment.click();
    }

    @Step
    public void clickOnButtonAddUser() {
        //screen.click(userManagementPage.sikuliButtonAddUser);
    }

    @Step
    public void clickOnTrustedLevel() {
        userManagementPage.selectorTrustedLevel.click();
    }

    @Step
    public void clickOnUltimateTrust() {
        userManagementPage.pickerUltimateTrust.click();
        userManagementPage.pickerUltimateTrust.click();
    }

    @Step
    public void clickOnButtonChooseAll() {
        userManagementPage.buttonChooseAll.click();
    }

    @Step
    public void clickOnButtonSaveUser() {
        //screen.click(userManagementPage.sikuliButtonSaveUser);
    }

    @Step
    public void clickOnIconDeleteRoleInternalSystem() {
        userManagementPage.roleInternalSystem.click();
    }

    @Step
    public void clickOnRemoveRoleButton() {
        //screen.click(userManagementPage.sikuliButtonRemove);
    }

    @Step
    public void clickOnButtonOkRoleRemoved() {
        //screen.click(userManagementPage.sikuliButtonOk);
//        waitABit(5000);
    }

    @Step
    public void clickOnButtonRemoveUser() {
        userManagementPage.buttonRemoveUser.click();
    }

    @Step
    public void clickOnButtonOkDeleteUser() {
        //screen.click(userManagementPage.sikuliButtonOk);
    }

    @Step
    public void clickOnButtonCreatePeer() {
        //screen.click(peerRegistrationPage.sikuliButtonCreatePeer);
    }

    @Step
    public void clickOnButtonCreate() {
        //screen.click(peerRegistrationPage.sikuliButtonCreate);
    }

    @Step
    public void clickbuttonApprovePopUp() {
        //screen.click(peerRegistrationPage.sikuliButtonApprovePopUp);
    }

    @Step
    public void clickOnIconTemplateCasandra() {
        //screen.click(environmentsPage.sikuliTemplateCasandra);
    }

    @Step
    public void clickbuttonApprove() {
        //screen.click(peerRegistrationPage.sikuliButtonApprove);
    }

    @Step
    public void clickOnButtonUnregister() {
        peerRegistrationPage.waitButtonUnregister();
        //screen.click(peerRegistrationPage.sikuliButtonUnregister);
    }

    @Step
    public void clickOnButtonUnregisterPopup() {
        //screen.click(peerRegistrationPage.sikuliButtonUnregisterPopup);
    }

    @Step
    public void clickOnButtonOkUnregisterPeer() {
        //screen.click(commonPage.sikuliButtonOk);
    }

    @Step
    public void clickOnPeer1() {
        environmentsPage.waitPeer1();
        //screen.click(environmentsPage.sikuliPeer1);
    }

    @Step
    public void clickOnPeer2() {
        //screen.click(environmentsPage.sikuliPeer2);
    }

    @Step
    public void clickOnResourceHost1() {
        //screen.click(environmentsPage.sikuliResourceHost1);
    }

    @Step
    public void clickOnTitleManagement() {
        assertThat(monitoringPage.ManagementTab.isVisible(), is(true));
        monitoringPage.ManagementTab.click();
////        screen.click(monitoringPage.sikuliTitleManagement);
    }

    @Step
    public void clickOnMenuButtonInstall() {
        //screen.click(bazaarPage.sikuliMenuButtonInstall);
    }

    @Step
    public void clickOnIconTemplateMaster() {
        assertThat(environmentsPage.templateMaster.isVisible(), is(true));
        environmentsPage.templateMaster.click();
////        screen.click(environmentsPage.sikuliTemplateMaster);
    }

    @Step
    public void clickOnButtonLaunch() {
        bazaarPage.waitButtonLaunch();
        //screen.click(bazaarPage.sikuliButtonLaunch);
    }

    @Step
    public void clickOnTitleRawFiles() {
        //screen.click(kurjunPage.sikuliTitleRawFiles);
    }

    @Step
    public void clickOnTitleUrlsList() {
        //screen.click(kurjunSettingsPage.sikuliTitleUrlsList);
    }

    @Step

    public void clickOnSelectorEnvironment() {
        //screen.click(pluginsPage.sikuliSelectorEnvironment);
    }

    @Step
    public void clickOnEnvironmentFromSelector() {
        pluginsPage.selectorEnvironmentMaster.click();
    }

    @Step
    public void clickOnTitleManage() {
        //screen.click(pluginsPage.sikuliTitleManage);
    }

    @Step
    public void clickOnButtonConfigureOperations() {
        //screen.click(pluginsPage.sikuliButtonConfigureOperations);
    }

    @Step
    public void clickOnButtonAddOperation() {
        //screen.click(pluginsPage.sikuliButtonAddOperation);
    }

    @Step
    public void clickOnButtonExecute() {
        //screen.click(pluginsPage.sikuliButtonExecute);
    }

    @Step
    public void clickOnTitleCreate() {
        //screen.click(pluginsPage.sikuliTitleCreate);
    }

    @Step
    public void clickOnButtonUninstall() {
        //screen.click(pluginsPage.sikuliButtonUninstall);
    }

    @Step
    public void clickOnButtonQuickInstall() {
        //screen.click(pluginsPage.sikuliButtonQuickInstall);
    }

    @Step
    public void clickOnButtonConsole() {
        //screen.click(pluginsPage.sikuliButtonConsole);
    }

    @Step
    public void clickOnButtonInstall() {
        //screen.click(pluginsPage.sikuliButtonInstall);
        waitABit(50000);
    }

    @Step
    public void clickOnButtonOk() {
        //screen.click(commonPage.sikuliButtonOk);
    }

    @Step
    public void clickOnButtonSave() {
        //screen.click(pluginsPage.sikuliButtonSave);
    }

    @Step
    public void clickOnButtonCheck() {
        //screen.click(containersPage.sikuliButtonCheck);
    }

    @Step
    public void clickOnButtonStop() {
        //screen.click(containersPage.sikuliButtonStop);
    }

    @Step
    public void clickOnButtonRemove() {
        //screen.click(containersPage.sikuliButtonRemove);
    }

    @Step
    public void clickOnButtonDestroy() {
        //screen.click(containersPage.sikuliButtonDestroy);
    }

    @Step
    public void clickOnButtonStart() {
        //screen.click(containersPage.sikuliButtonStart);
        waitABit(4000);
    }

    @Step
    public void clickOnButtonAddTemplate() {
        //screen.click(kurjunPage.sikuliButtonAddTemplate);
    }

    @Step
    public void clickOnButtonBrowse() {
        //screen.click(kurjunPage.sikuliButtonBrowse);
    }

    @Step
    public void clickOnButtonOpen() {
        //screen.click(commonPage.sikuliButtonOpen);
    }

    @Step
    public void clickOnButtonAdd() {
        //screen.click(commonPage.sikuliButtonAdd);
        waitABit(8000);
    }

    @Step
    public void clickOnButtonEdit() {
        //screen.click(environmentsPage.sikuliButtonEdit);
    }

    @Step
    public void clickOnButtonNext() {
        //screen.click(environmentsPage.sikuliButtonNext);
    }

    @Step
    public void clickOniconAdmin() {
        //screen.click(commonPage.sikuliIconAdmin);
    }

    @Step
    public void clickOnIconTest() {
        //screen.click(commonPage.sikuliIconTest);
    }

    @Step
    public void clickOnButtonShare() {
        //screen.click(environmentsPage.sikuliIconShare);
    }

    @Step
    public void clickOnAddTheUserTest() {
        //screen.click(environmentsPage.sikuliButtonAddUserTest);
    }

    @Step
    public void clickOnCheckBoxDeleteRoleFromUser() {
        //screen.click(environmentsPage.sikuliCheckBoxDeleteInShareEnvi);
    }

    @Step
    public void clickOnIconAddIdentityManagement() {
        //screen.click(roleManagementPage.sikuliIconAddIdentityManagement);
    }

    @Step
    public void clickOnIconDeleteRole() {
        //screen.click(roleManagementPage.sikuliIconDeleteRole);
    }

    @Step
    public void clickOnIconTemplateApache() {
        //screen.click(environmentsPage.sikuliTemplateApache);
    }

    @Step
    public void clickOnButtonConfigure() {
        //screen.click(environmentsPage.sikuliButtonConfigure);
    }

    @Step
    public void clickOnCheckboxAddDomain() {
        //screen.click(environmentsPage.sikuliCheckBoxAddDomain);
    }

    @Step
    public void clickOnIconSettingsFirstCont() {
        //screen.click(environmentsPage.sikuliIconSettingsFirstCont);
    }

    @Step
    public void clickOnIconSettingsSecondCont() {
        //screen.click(environmentsPage.sikuliIconSettingsSecondCont);
    }

    @Step
    public void clickOnIconSettingsThirdContCass() {
        //screen.click(environmentsPage.sikuliIconSettingsThirdContCass);
    }

    @Step
    public void clickOnPickerSmall() {
        //screen.click(environmentsPage.sikuliPickerSmall);
    }

    @Step
    public void clickOnPickerMedium() {
        //screen.click(environmentsPage.sikuliPickerMedium);
    }

    @Step
    public void clickOnIconSettingsCont() {
        //screen.click(environmentsPage.sikuliIconSettingsCassandra);
    }

    @Step
    public void clickOnButtonShowToken() {
        //screen.click(tokensPage.sikuliButtonShowToken);
    }
    //endregion

    //region Action: Drag And Drop

    @Step
    public void dragAndDropTemplateCassandra() {
        //screen.dragDrop(environmentsPage.sikuliTemplateCasandra, environmentsPage.sikuliPeerRH1);
//        waitABit(5000);
    }

    @Step
    public void dragAndDropTemplateMasterToRH1() {
        //screen.dragDrop(environmentsPage.sikuliTemplateMaster, environmentsPage.sikuliPeerRH1);
    }

    @Step
    public void dragAndDropTemplateMasterToRH2() {
        //screen.dragDrop(environmentsPage.sikuliTemplateMaster, environmentsPage.sikuliPeerRH2);
    }

    //endregion

    //region ACTION: Wait

    @Step
    public void waitGeneratedE2EKey() throws InterruptedException {
        waitABit(30000);
    }

    @Step
    public void userShouldWaitAFewSeconds() {
        waitABit(3000);
    }
    //endregion

    //region VERIFICATION: AssertThat

    @Step
    public void userShouldObserveHeaderLogin() {
        assertThat(loginPage.headerLogin.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveNewPassword() {
        assertThat(loginPage.inputNewPassword.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveConfirmPassword() {
        assertThat(loginPage.inputConfirmPassword.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveFieldLogin() {
        assertThat(loginPage.inputLogin.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveFieldPassword() {
        assertThat(loginPage.inputPassword.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveHeaderMonitoring() {
        assertThat(monitoringPage.headerMonitoring.isVisible(), is(true));
    }


    @Step
    public void userShouldObserveManagementHost() {
        assertThat(monitoringPage.selectorHostsItemManagementHost.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveResourceHost() {
        assertThat(monitoringPage.selectorHostsItemRecourceHost.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveHeaderBlueprints() {
        assertThat(blueprintsPage.headerBlueprints.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonCreateBlueprints() {
        assertThat(blueprintsPage.buttonCreateBlueprint.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveHeaderEnvironments() {
        assertThat(environmentsPage.headerEnvironments.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveFieldSearch() {
        assertThat(commonPage.fieldSearch.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveHeaderContainers() {
        assertThat(containersPage.headerContainers.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveHeaderUserManagement() {
        assertThat(userManagementPage.headerUserManagement.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonAddUser() {
        assertThat(userManagementPage.buttonAddUser.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveHeaderRoleManagement() {
        assertThat(roleManagementPage.headerRoleManagement.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonAddRole() {
        assertThat(roleManagementPage.buttonAddRole.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveHeaderTokens() {
        assertThat(tokensPage.headerTokens.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonAddToken() {
        assertThat(tokensPage.buttonAddToken.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveHeaderPeerRegistration() {
        assertThat(peerRegistrationPage.headerPeerRegistration.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonCreatePeer() {
        assertThat(peerRegistrationPage.buttonCreatePeer.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveHeaderResourceHosts() {
        assertThat(resourceHostsPage.headerResourceHosts.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveHeaderTracker() {
        assertThat(trackerPage.headerTracker.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveHeaderPeerSettings() {
        assertThat(peerSettingsPage.headerPeerSettings.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonUploadNewPlugin() {
        assertThat(bazaarPage.buttonUploadNewPlugin.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveHeaderAbout() {
        assertThat(aboutPage.headerAbout.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonCreateEnvironment() {
        assertThat(environmentsPage.buttonCreateEnvironment.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveTitleRegisterPeer() {
        assertThat(commonPage.titleUpperMenuRegisterPeer.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveUpperMenuBody() {
        assertThat(commonPage.upperMenuLoginBody.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveLinkSignUp() {
        assertThat(commonPage.linkSignUp.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonRegister() {
        assertThat(commonPage.buttonRegister.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveNotificationsBody() {
        assertThat(commonPage.upperMenuNotificationsBody.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveLinkClear() {
        assertThat(commonPage.linkClear.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveUserNameAdmin() {
        assertThat(commonPage.linkAdmin.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonModes() {
        assertThat(environmentsPage.buttonModes.isVisible(), is(true));
    }

    @Step
    public void userShouldObservePluginMongo() {
        environmentsPage.waitTemplateMongo();
        assertThat(environmentsPage.templateMongo.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonApply() {
        assertThat(environmentsPage.buttonApply.isVisible(), is(true));
        waitABit(20000);
    }

    @Step
    public void userShouldObserveTitlePeers() {
        assertThat(environmentsPage.titlePeers.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveGreenButton() {
        assertThat(commonPage.buttonGreen.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveFieldPGP() {
        assertThat(accountSettingsPage.fieldPGP.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonSetPublicKey() {
        assertThat(accountSettingsPage.buttonSetPublicKey.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonSave() {
        assertThat(accountSettingsPage.buttonSave.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonSetPeerOwner() {
        assertThat(peerSettingsPage.buttonSetPeerOwner.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonSaveOnPolicyPage() {
        assertThat(peerSettingsPage.buttonSave.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonSaveOnKurjunSettingsPage() {
        assertThat(kurjunSettingsPage.buttonSave.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonAddOnKurjunSettingsPage() {
        assertThat(kurjunSettingsPage.buttonAdd.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveHeaderNetworkSettings() {
        assertThat(networkSettingsPage.headerNetworkSettings.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonSaveOnNetworkSettingsPage() {
        assertThat(networkSettingsPage.buttonSave.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveHeaderAdvanced() {
        assertThat(advancedPage.headerAdvancedSettings.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonExport() {
        assertThat(advancedPage.buttonExport.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveSelectorEnvironment() {
        assertThat(monitoringPage.selectorSelectEnvironment.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveSelectorEnvironmentConsole() {
        assertThat(consolePage.selectorEnvironment.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonSaveOnKurjunSettingsQuotasPage() {
        assertThat(kurjunSettingsPage.buttonSaveQuotas.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveANewUsersEmail() {
        assertThat(userManagementPage.usersEmail.isVisible(), is(true));
    }

    @Step
    public void userShouldNotObserveRoleInternalSystem() {
        assertThat(userManagementPage.roleInternalSystem.isVisible(), is(false));
    }

    @Step
    public void assertButtonCancelPeerRequest() {
        assertThat(peerRegistrationPage.buttonCancelPeerRequest.isVisible(), is(true));
    }

    @Step
    public void assertButtonUnregister() {
        assertThat(peerRegistrationPage.buttonUnregister.isVisible(), is(true));
    }

    @Step
    public void userShouldObservePNGs() {
        environmentsPage.waitTemplateCassandra();
        //screen.find(environmentsPage.sikuliTemplateMaster);
        //screen.find(environmentsPage.sikuliPeerRH1);
    }

    @Step
    public void userShouldObserveButtonUploadFile() {
        assertThat(kurjunPage.buttonUploadFile.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonRefresh() {
        assertThat(kurjunPage.buttonRefresh.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonAddUrl() {
        assertThat(kurjunSettingsPage.buttonAddUrl.isVisible(), is(true));
    }

    @Step
    public void userShouldObservePluginCassandra() {
        assertThat(environmentsPage.templateCassandra.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveProfileName() {
        assertThat(pluginsPage.titleOfProfileName.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveButtonConsole() {
        assertThat(pluginsPage.buttonConsole.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveThreeContainers() {
        assertThat(containersPage.containersThree.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveTwoContainers() {
        assertThat(containersPage.containersTwo.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveIManagement() {
        assertThat(roleManagementPage.roleIManagement.isVisible(), is(true));
    }

    @Step
    public void userShouldObserveHeaderApache() {
        assertThat(environmentsPage.headerApache.isVisible(), is(true));
    }

    @Step
    public void observeEnvironmentPGPKey() {
        assertThat(tokensPage.environmentPGPKey.isVisible(), Matchers.is(true));
    }
    //endregion

    //region ACTION: Getter

    @Step
    public Object getToken() {
        token = tokensPage.token.getText();
        return token;
    }

    @Step
    public Object getPeerID() {
        peerID = tokensPage.peerID.getText();
        return peerID;
    }

    @Step
    public Object getEnvironmentData() {
        environmentData = tokensPage.environmentData.getText().substring(19, 55);
        return environmentData;
    }

    //endregion
    //region ACTION: Shell command

    @Step
    public void executeConsoleCommand(String command) {
        executeShellCommand.executeConsoleCommand(command);
    }

    @Step
    public void seeOutputOfPwdCommand() {
        assertThat(consolePage.outputOfPwdCommand.isVisible(), Matchers.is(true));
    }

    @Step
    public void seeOutputOfLsCommand() {
        assertThat(pluginsPage.outputOfLsCommand.isVisible(), Matchers.is(true));
    }


    //endregion

    @Step
    public void inputConfirmPasswordE2E() {
//        screen.type(pgpPlugin.sikuliFieldConfirmPasswordPopup, "239668a");
    }

    @Step
    public void clickOnButtonOkE2EKeyPopup() {
        //screen.click(pgpPlugin.sikuliButtonOkE2EPopup);
    }

    @Step
    public void run_bash_script(String file) throws FileNotFoundException {
        ExecuteShellCommand executeShellCommand = new ExecuteShellCommand();
        System.out.println(executeShellCommand.executeCommand(file));
    }

    @Step
    public void clickOnButtonRegister() {
        //screen.click(commonPage.sikuliButtonRegister);
    }

    @Step
    public void assertButtonGoToHUB() {
        commonPage.waitFor(commonPage.buttonGoToHUB);
        assertThat(commonPage.buttonGoToHUB.isVisible(), is(true));
    }

    @Step
    public void clickOnButtonGoToHUBGreen() {
        //screen.click(commonPage.sikuliButtonGoToHUBGreen);
    }

    @Step
    public void assertMessageHeartbeatSentSuccessfully() {
        commonPage.waitFor(commonPage.textEnvironmentHasBeenBuiltSuccessfully);
        assertThat(commonPage.textEnvironmentHasBeenBuiltSuccessfully.isVisible(), is(true));
    }

    @Step
    public void clickButtonClose() {
        //screen.click(commonPage.sikuliButtonClose);
    }

    @Step
    public void clickOnButtonPeerRegistrationOnline() {
        //screen.click(commonPage.sikuliButtonPeerRegistrationOnline);
    }

    @Step
    public void assertButtonSendHeartbeat() {
        commonPage.waitFor(commonPage.buttonSendHeartbeat);
        assertThat(commonPage.buttonSendHeartbeat.isVisible(), is(true));
    }

    @Step
    public void clickOnButtonSendHeartbeat() {
        //screen.click(commonPage.sikuliButtonSendHearbeat);
    }

    @Step
    public void clickOnButtonOkHeartbeat() {
        //screen.click(commonPage.sikuliButtonOk);
    }

    @Step
    public void clickOnButtonGoToHUBWhite() {
        //screen.click(commonPage.sikuliButtonGoToHUBWhite);
    }

    @Step
    public void clickOnButtonAddRole() {
        //screen.click(roleManagementPage.sikuliButtonAddRole);
    }

    @Step
    public void observeLocalPeerID() throws FileNotFoundException {
        loginPage.setDefaultBaseUrl(String.format("https://%s:8443/rest/v1/security/keyman/getpublickeyfingerprint?sptoken=" + token, ReaderFromFile.readDataFromFile("src/test/resources/parameters/mng_h1")));
        loginPage.open();
    }

    @Step
    public void observeRemotePeerID() throws FileNotFoundException {
        loginPage.setDefaultBaseUrl(String.format("https://%s:8443/rest/v1/security/keyman/getpublickeyfingerprint?sptoken=" + token, ReaderFromFile.readDataFromFile("src/test/resources/parameters/mng_h2")));
        loginPage.open();
    }

    @Step
    public void ownPGPKey() throws FileNotFoundException {
        loginPage.setDefaultBaseUrl(String.format("https://%s:8443/rest/v1/security/keyman/getpublickeyring?hostid=" + peerID, ReaderFromFile.readDataFromFile("src/test/resources/parameters/mng_h1")));
        loginPage.open();
    }

    @Step
    public void observeOwnPGPKey() {
        assertThat(tokensPage.remotePGPKey.isVisible(), Matchers.is(true));
    }

    @Step
    public void remotePGPKey() throws FileNotFoundException {
        loginPage.setDefaultBaseUrl(String.format("https://%s:8443/rest/v1/security/keyman/getpublickeyring?hostid=" + peerID, ReaderFromFile.readDataFromFile("src/test/resources/parameters/mng_h2")));
        loginPage.open();
    }

    @Step
    public void observeEnvironmentData() throws FileNotFoundException {
        loginPage.setDefaultBaseUrl(String.format("https://%s:8443/rest/v1/environments?sptoken=" + token, ReaderFromFile.readDataFromFile("src/test/resources/parameters/mng_h1")));
        loginPage.open();
    }

    @Step
    public void environmentPGPKey() throws FileNotFoundException {
        loginPage.setDefaultBaseUrl(String.format("https://%s:8443/rest/v1/security/keyman/getpublickeyring?hostid=" + peerID + "_" + environmentData, ReaderFromFile.readDataFromFile("src/test/resources/parameters/mng_h1")));
        loginPage.open();
    }
}