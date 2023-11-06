Feature: User Registration 
	I want to check that the user can register in our e-commerce website.
	
	Scenario Outline: User Registration
	Given The User is in the Home Page
	When I click on regsiter Link
	And I entered "<firstname>", "<lastname>", "<email>", "<password>"
	Then The registration page displayed successfully and user login with "<email>", "<password>"
	
	Examples:
	 | firstname | lastname | email | password |
	 | omar | saad | omar23944saad@gmail.com | 123456 |
	 | omar | saad | omar344445saad@gmail.com | 234567 |
	 | omar | saad | omar454446saad@gmail.com | 345678 |
	 | omar | saad | omar564447saad@gmail.com | 456789 |