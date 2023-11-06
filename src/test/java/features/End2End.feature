Feature: Automated End2End Test
	Description: The purpose of this feature is to test End 2 End Integration
	
	Scenario Outline: Customer place an order by purchasing an item from scratch
		Given user is on Home Page
		When he search for "<productname>"
		And choose to buy two items
		And move to checkout cart and enter personal details on checkout page and place order
		Then he can view the order and download the invoice 
		
		
		
		Examples:
			| productname |
			| Apple MacBook Pro 13-inch | 
