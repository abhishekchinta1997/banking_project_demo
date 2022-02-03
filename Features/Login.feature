Feature: Login
  
  Scenario: Successful Login with valid Credentials
    Given User Launch Chrome Browser
    When User opens URL "https://demo.guru99.com/v4/"
    And User enters username "mngr382581" and password "EhezahY"
    And Click on Login
    Then Page Title should be "Guru99 Bank Manager HomePage"
    When User click Logout
    Then Page Title should be "Guru99 Bank Home Page"
    And close Browser
    
  #Scenario Outline: Successful Login with valid Credentials
    #Given User Launch Chrome Browser
    #When User opens URL "https://demo.guru99.com/v4/"
    #And User enters username "<username>" and password "<password>"
    #And Click on Login
    #Then Page Title should be "Guru99 Bank Manager HomePage"
    #When User click Logout
    #Then Page Title should be "Guru99 Bank Home Page"
    #And close Browser
    #
    #	Examples:
    #	|		username		|		password		|
    #	|		mngr382581	|		EhezahY			|
    #	|		ssfsfdf			|		sfdfz				|
