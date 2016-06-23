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