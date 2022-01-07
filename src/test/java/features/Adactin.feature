Feature: End to end testing with Audactin Application 

Scenario Outline: Verifying Login feature 
	Given User opens url
	When User enters username "<username>" with valid credentials 
	And User enters password "<password>" with valid credentials 
	And User clicks login Button 
	Then Verifying the navigation from homepage to search hotel 
Examples:
|username|password|
|ijavub|ojdvsn|
|jsbvudousdb|iubvds|
|GathamGuardian|Martha|
	
Scenario: Verifying Search Hotel Page 
	Given User selects location from dropdown "Melbourne"
	Then User selects hotel from the list "Hotel Sunshine"
	And User selects room type "Super Deluxe"
	Then User selects number of rooms "5"
	Then User selects Adults per room "4"
	And User selects Children per room "2"
	And User clicks Search button 
	And Verifying the navigation from Search hotel to Select hotel 
	
Scenario: Verifying Select Hotel Page 
	Given User select a hotel from the list 
	And Clicks continue button 
	Then Verifying the navigation from Select hotel to Book a hotel 
	
Scenario: Verifying Book a Hotel Page 
	Given User enters First name "Bruce"
	And User enters last name "Wayne"
	Then User enters billing address "BatCave, Gautham City, United States Of America"
	And Credit card number 
	Then Credit card type from dropdown 
	And User selects expiry month from dropdown 
	Then Selects expiry year from dropdown 
	And User enters cvv number 
	And User clicks Book Now button 
	And Verifying the navigation from Book a  hotel Page to hotel Booking Confirmation Page 
	
Scenario: Verifying Booking Confirmation Page 
	Given User takes screenshot of Confirmation Page 
	And User clicks logout button 
	Then Verifying the navigation from Hotel Booking Confirmation Page to Logout Page 
	
Scenario: Teardown 
	Given User closes browser
	