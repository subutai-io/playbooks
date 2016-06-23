Meta:

Narrative:
As a QA team
We want to verify Subutai web elements
So that We create smoke test for it

Scenario: The User should observe Subutai web elements (part 1)
Given the first user is on the Home page of Subutai
Given the user enters login and password: 'admin', 'test'
And the user clicks on the button: Login
When the user clicks on the menu item: Monitoring
Then the user should observe web elements on: Monitoring page
When the user clicks on the upper menu item: Register Peer
Then the user should observe web elements on drop down menu: Register Peer
When the user click on the upper menu icon: Notification
Then the user should observe web elements on drop down menu: Notifications
And the user should observe user name: admin
When the user clicks on the menu item: Environment
And the user clicks on the menu item: Environments

Scenario: the user should create the Local Environment
When the user should find template: Master
And the user creates environment using template: Master
Then the user destroys created environment
When the user clicks on the Environment's mode: Advanced
Then the user should observe web elements on: Advanced mode page