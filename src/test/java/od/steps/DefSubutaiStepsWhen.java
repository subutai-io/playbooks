package od.steps;

import net.thucydides.core.annotations.Steps;
import od.steps.serenity.SubutaiSteps;
import org.jbehave.core.annotations.When;

import java.io.FileNotFoundException;

public class DefSubutaiStepsWhen {

    @Steps
    SubutaiSteps subutaiSteps;

    @When("the user clicks on the menu item: Monitoring")
    public void user_clicks_monitoring() {
        subutaiSteps.clickOnMenuItemMonitoring();
    }

    @When("the user clicks on the menu item: Environment")
    public void user_click_environment() {
        subutaiSteps.clickOnMenuEnvironment();
    }

    @When("the user clicks on the menu item: Blueprints")
    public void user_clicks_blueprints() {
        subutaiSteps.clickOnMenuItemBlueprints();
    }

    @When("the user clicks on the menu item: Environments")
    public void user_clicks_environment() {
        subutaiSteps.clickOnMenuItemEnvironments();
    }

    @When("the user clicks on the menu item: Containers")
    public void user_clicks_containers() {
        subutaiSteps.clickOnMenuItemContainers();
    }

    @When("the user clicks on the menu item: Console")
    public void user_clicks_console() {
        subutaiSteps.clickOnMenuItemConsole();
    }

    @When("the user chooses: Management host")
    public void user_choose_management_host() {
        subutaiSteps.clickOnSelectorHostsConsolePage();
        subutaiSteps.clickOnManagementHost();
    }

    @When("the user enters console command: '$command'")
    public void executes_console_command(String command) {
        subutaiSteps.executeConsoleCommand(command);
    }

    @When("the user chooses: Local host")
    public void user_choose_local_host() {
        subutaiSteps.clickOnSelectorHostsConsolePage();
        subutaiSteps.clickOnLocalHost();
    }

    @When("the user clicks on the menu item: User management")
    public void user_clicks_user_management() {
//       subutaiSteps.clickOnMenuItemUserManagement();
    }

    @When("the user clicks on the menu item: Role management")
    public void user_clicks_role_management() {
        subutaiSteps.clickOnMenuItemRoleManagement();
    }

    @When("the user clicks on the menu item: Tokens")
    public void user_clicks_tokens() {
        subutaiSteps.clickOnMenuItemTokens();
    }

    @When("the user clicks on the menu item: Peer Registration")
    public void user_clicks_peer_registration() {
        subutaiSteps.clickOnMenuItemPeerRegistration();
    }

    @When("the user clicks on the menu item: Resource Hosts")
    public void user_clicks_resource_hosts() {
        subutaiSteps.clickOnMenuItemResourceHosts();
    }

    @When("the user clicks on the menu item: Tracker")
    public void user_clicks_tracker() {
        subutaiSteps.clickOnMenuItemTracker();
    }

    @When("the user clicks on the menu item: Bazaar")
    public void user_clicks_bazaar() {
        subutaiSteps.clickOnMenuItemBazaar();
    }

    @When("the user clicks on the menu item: System Settings")
    public void user_clicks_plugin_integrator() {
        subutaiSteps.clickOnMenuItemSystemSettings();
    }

    @When("the user clicks on the menu item: About")
    public void user_click_about() {
        subutaiSteps.clickOnMenuItemAbout();
    }

    @When("the user sets pgp Key")
    public void user_sets_pgp_key() {
//        subutaiSteps.clickOnMenuItemUserManagement();
        subutaiSteps.clickOnMenuItemAccountSettings();
        subutaiSteps.waitABit(5000);
//        subutaiSteps.clickOnButtonSetPublicKey();
//        subutaiSteps.waitABit(5000);
//        subutaiSteps.inputConfirmPasswordE2E();
//        subutaiSteps.clickOnButtonOkE2EKeyPopup();
    }

    @When("the user creates environment using template: Master")
    public void user_creates_environment_using_template_master() throws FileNotFoundException {
        subutaiSteps.clickOnIconTemplateMaster();
        subutaiSteps.clickOnIconTemplateMaster();
        subutaiSteps.clickOnButtonApply();
        subutaiSteps.inputEnvironmentName("TestEnvironmentMaster");
        subutaiSteps.clickOnButtonBuild();
        subutaiSteps.clickOnButtonCloseBuildPopup();
        subutaiSteps.waitFor(5000);
    }

    @When("the user grows environment using template: Master")
    public void user_grows_environment_using_template_master() throws FileNotFoundException {
        subutaiSteps.clickOnIconTemplateMaster();
        subutaiSteps.clickOnButtonApply();
        subutaiSteps.clickOnButtonNext();
        subutaiSteps.clickOnButtonCloseBuildPopup();
    }

    @When("the user enters login and password: '$login', '$password'")
    public void enter_login_and_password(String login, String password) throws FileNotFoundException {
        subutaiSteps.inputLogin(login);
        subutaiSteps.inputPassword(password);
    }

    @When("the user enters new password: '$password'")
    public void enter_new_password(String password) {
        subutaiSteps.inputNewPassword(password);
        subutaiSteps.inputConfirmPasswordOnLogin(password);
        subutaiSteps.clickOnButtonSaveAndLogin();
    }

    @When("the user clicks on the button: Login")
    public void clicks_button_login() {
        subutaiSteps.clickOnButtonLogin();
    }

    @When("the user creates environment with 3 containers using template: Master")
    public void user_creates_environment_with_3_containers() {
        subutaiSteps.clickOnIconTemplateMaster();
        subutaiSteps.clickOnIconTemplateMaster();
        subutaiSteps.clickOnIconTemplateMaster();
        subutaiSteps.clickOnButtonApply();
        subutaiSteps.inputEnvironmentName("Test Envi Master 3");
        subutaiSteps.clickOnButtonBuild();
        subutaiSteps.clickOnButtonCloseBuildPopup();
        subutaiSteps.waitFor(5000);
    }

    @When("the user clicks on the upper menu item: Register Peer")
    public void user_click_on_upper_menu_item() {
        subutaiSteps.clickOnUpperMenuItemRegisterPeer();
    }

    @When("the user click on the upper menu icon: Notification")
    public void user_click_on_icon_notification() {
        subutaiSteps.clickOnIconNotifications();
    }

    @When("the user clicks on the Environment's mode: Advanced")
    public void user_click_on_advance() {
        subutaiSteps.clickOnAdvancedMode();
    }

    @When("the user clicks on the menu item: Kurjun")
    public void user_clicks_on_kurjun() {
        subutaiSteps.clickOnMenuItemKurjun();
    }

    @When("the user clicks on the menu item: User Identity")
    public void user_clicks_on_user_identity() {
        subutaiSteps.clickOnMenuItemUserIdentity();
    }

    @When("the user clicks on the menu item: Account Settings")
    public void user_clicks_on_account_settings() {
        subutaiSteps.clickOnMenuItemAccountSettings();
    }

    @When("the user clicks on the menu item: Peer Settings")
    public void user_clicks_on_peer_settings() {
        subutaiSteps.clickOnMenuItemPeerSettings();
    }

    @When("the user clicks on the menu item: Kurjun Settings")
    public void user_clicks_on_kurjun_settings() {
        subutaiSteps.clickOnMenuItemKurjunSettings();
    }

    @When("the user clicks on the menu item: Network Settings")
    public void user_clicks_on_network_settings() {
        subutaiSteps.clickOnMenuItemNetworkSettings();
    }

    @When("the user clicks on the menu item: Advanced")
    public void user_clicks_on_advanced() {
        subutaiSteps.clickOnMenuItemAdvanced();
    }

    @When("the user enters login for Peer Registration on the Hub: '$login'")
    public void enters_login_peer_registration_on_the_hub(String login) {
        subutaiSteps.inputLoginPeerRegistrationOnHub(login);
    }

    @When("the user enters password for Peer Registration on the Hub: '$password'")
    public void enters_password_peer_registration_on_the_hub(String password) {
        subutaiSteps.inputPasswordPeerRegistrationOnHub(password);
    }

    @When("the user clicks on the button: Register")
    public void click_on_button_register() {
        subutaiSteps.clickOnButtonRegister();
    }

    @When("the user clicks on the button: Go to HUB")
    public void click_on_button_go_to_hub() {
        subutaiSteps.clickOnButtonGoToHUBGreen();
        subutaiSteps.waitABit(5000);
    }

    @When("user user clicks on the button: Close")
    public void click_button_close() {
        subutaiSteps.clickButtonClose();
    }

    @When("the user clicks on the button: Peer Registration Online")
    public void click_button_peer_registration_online() {
        subutaiSteps.clickOnButtonPeerRegistrationOnline();
    }

    @When("the user clicks on the button: Send Heartbeat")
    public void click_button_send_heartbeat() {
        subutaiSteps.clickOnButtonSendHeartbeat();
    }

    @When("the user clicks on the button: OK")
    public void click_button_ok() {
        subutaiSteps.clickOnButtonOkHeartbeat();
    }

    @When("the user click on the buton: Go to HUB White")
    public void click_on_the_button_go_to_hub_white() {
        subutaiSteps.clickOnButtonGoToHUBWhite();
        subutaiSteps.waitABit(5000);
    }

    @When("the user clicks on the button: Сreate peer")
    public void clicks_on_the_button_create_peer() {
        subutaiSteps.clickOnButtonCreatePeer();
    }

    @When("the user should wait a few seconds")
    public void user_should_wait_a_few_seconds() {
        subutaiSteps.userShouldWaitAFewSeconds();
    }

    @When("the user creates environment using template: Apache")
    public void user_creates_environment_using_template_apache() throws FileNotFoundException {
        subutaiSteps.clickOnIconTemplateApache();
        subutaiSteps.clickOnButtonApply();
        subutaiSteps.inputEnvironmentName("Test Environment Apache");
        subutaiSteps.clickOnButtonBuild();
        subutaiSteps.clickOnButtonCloseBuildPopup();
        subutaiSteps.waitFor(5000);
    }

    @When("the user clicks on templates")
    public void user_clicks_on_templates() {
        subutaiSteps.clickOnTitleTemplates();
    }

    @When("the user should find template: Master")
    public void user_finds_template_master() {
        subutaiSteps.inputTemplateNameInSearchField("Master");
    }

    @When("the user should find template: Cassandra")
    public void user_finds_template_casandra() {
        subutaiSteps.inputTemplateNameInSearchField("Cassandra");
    }

    @When("the user should find template: Apache")
    public void user_finds_template_apache() {
        subutaiSteps.inputTemplateNameInSearchField("Apache");
    }

    @When("the user should install plugin")
    public void user_install_plugin() {
        subutaiSteps.clickOnMenuButtonInstall();
        subutaiSteps.waitABit(5000);
    }

    @When("the user clicks on Launch button")
    public void user_clicks_launch_button() {
        subutaiSteps.clickOnButtonLaunch();
    }

    @When("the user input the cluster name: '$cluster'")
    public void user_search_plugin(String cluster) {
        subutaiSteps.inputClusterName(cluster);
    }

    @When("the user enters profile Domain name")
    public void user_enters_domain_name() {
        subutaiSteps.inputDomainName("testAppScale");
    }

    @When("the user clicks on the title manage")
    public void user_clicks_title_manage() {
        subutaiSteps.clickOnTitleManage();
    }

    @When("the user clicks on the buton: Configure operations")
    public void user_clicks_configure_operations() {
        subutaiSteps.clickOnButtonConfigureOperations();
    }

    @When("the user clicks on the buton: Add operation")
    public void user_clicks_button_add_operation() {
        subutaiSteps.clickOnButtonAddOperation();
    }

    @When("the user moves to page Manage")
    public void user_chooses_operation() {
        subutaiSteps.clickOnTitleManage();
    }

    @When("the user moves to page Create")
    public void user_moves_page_create() {
        subutaiSteps.clickOnTitleCreate();
    }

    @When("the user clicks on the buton: Quick install")
    public void user_clicks_button_quick_install() {
        subutaiSteps.clickOnButtonQuickInstall();
    }

    @When("the user should do container: check")
    public void user_check_container() {
        subutaiSteps.clickOnButtonCheck();
    }

    @When("the user should do container: stop")
    public void user_stop_container() {
        subutaiSteps.clickOnButtonStop();
    }

    @When("the user should do container: start")
    public void user_start_container() {
        subutaiSteps.clickOnButtonStart();
    }

    @When("the user removes one container")
    public void user_removes_container() {
        subutaiSteps.clickOnButtonRemove();
        subutaiSteps.clickOnButtonDestroy();
        subutaiSteps.clickOnButtonOk();
    }

    @When("the user click on the button: Add Template")
    public void user_click_add_template() {
        subutaiSteps.clickOnButtonAddTemplate();
    }

    @When("the user clicks on icon edit")
    public void user_clicks_on_icon_edit() {
        subutaiSteps.clickOnButtonEdit();
    }

    @When("the user should click on title: Change password")
    public void user_click_change_password() {
        subutaiSteps.clickOnTitleChangePassword();
    }

    @When("the user clicks on the button: share")
    public void user_clicks_on_button_share() {
        subutaiSteps.clickOnButtonShare();
    }

    @When("the user shares the environment with user: test")
    public void user_share_envi_with_user_test() {
        subutaiSteps.clickOnAddTheUserTest();
    }

    @When("the user removes the delete role from the user")
    public void user_removes_delete_role_from_user() {
        subutaiSteps.clickOnCheckBoxDeleteRoleFromUser();
    }

    @When("the user clicks on the button: Save")
    public void user_clicks_on_button_save() {
        subutaiSteps.clickOnButtonSave();
        subutaiSteps.waitABit(10000);
    }

    @When("the user clicks on the icon: delete")
    public void user_clicks_icon_delete() {
        subutaiSteps.clickOnIconDeleteEnvironment("TestEnvironmentMaster");
    }

    @When("the user clicks on the button: delete")
    public void user_clicks_on_button_delete() {
        subutaiSteps.clickOnButtonDelete();
    }

    @When("the user clicks on the button: Add role")
    public void user_clicks_on_button_add_role() {
        subutaiSteps.clickOnButtonAddRole();
    }

    @When("the user input the role name: '$role'")
    public void user_input_role_name(String role) {
        subutaiSteps.inputTheRoleName(role);
    }

    @When("the user click on icon add role: idenity-management")
    public void user_click_icon_add_idenity_management() {
        subutaiSteps.clickOnIconAddIdentityManagement();
    }

    @When("the user clicks on the button: Configure")
    public void user_clicks_button_configure() {
        subutaiSteps.clickOnButtonConfigure();
    }

    @When("the user clicks on the checkbox: Add domain")
    public void user_clicks_add_domain() {
        subutaiSteps.clickOnCheckboxAddDomain();
    }

    @When("the user clicks on temaplate: Cassandra")
    public void user_clicks_template_cassandra() {
        subutaiSteps.clickOnIconTemplateCasandra();
    }

    @When("the user gets Peer ID")
    public void user_gets_peer_id() {
        subutaiSteps.getPeerID();
    }

    @When("the user gets Environment ID")
    public void user_gets_environment_data() {
        subutaiSteps.getEnvironmentData();
    }
}
