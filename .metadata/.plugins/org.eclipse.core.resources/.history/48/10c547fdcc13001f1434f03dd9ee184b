Feature: Login

@sanity
Scenario: Successful Login with Valid Credential
      
Given User Launch Chrome browser
When  User opens URL "https://admin-demo.nopcommerce.com/login"
And   User Enter Email as "admin@yourstore.com" and password as "admin"
And   Click on Login
Then  Page Title should be "Dashboard / nopCommerce administration"
When  User click on Logout link
Then  Page Title should be "Your store. Login"
And   close browser

@sanity
Scenario Outline: Successful Login with Valid Credential DDT

Given User Launch Chrome browser
When  User opens URL "https://admin-demo.nopcommerce.com/login"
And   User Enter Email as "<email>" and password as "<password>"
And  Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on Logout link
Then Page Title should be "Your store. Login"
And close browser


Examples: 

|email|password|
|admin@yourstore.com|admin|
|admin@yourstore.com|admin|