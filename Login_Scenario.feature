Feature: Login
  Scenario Outline: User can access profile when user login with complete and valid information
    Given The Login form is shown
     When The User attemp to login with valid username is <username> and valid password is "123456"
     Then The profile page will be shown
  
  Example: 	
      | username        | 
      | anhlt@gmail.com | 
      | 0391234567      | 
  
  Scenario Outline: The error message is shown when user login with incomplete information
    Given The Login form is shown
     When The User attemp to login with username is <username> and password is <password>
     Then The message "Thông tin này là bắt buộc" is shown below each input
  Example: 	
      | username       | password   | 
      |                | 0391234567 | 
      | anhltgmail.com |            | 
      |                |            | 
  
  Scenario Outline: The error message is shown when user login with invalid information
    Given The Login form is shown
     When The User attemp to login with username is <username> and password is <password>
     Then The message "Thông tin đăng nhập không hợp lệ" is showed for invalid password and account is not existed
  Example: 	
      | username        | password   | 
      | anhltgmail.com  | 0391234567 | 
      | anhlt@gmail.com | 123456     | 
      | anhltgmail.com  | 123456     | 
  
  Scenario: The password is shown by plain text when user click on Shown icon
    Given The Login form is shown
     When The User attemp to show password with password is "123456"
     Then The password is show by plain text is "123456"
  
  Scenario: The password is hiden by secret character when user click on Hide icon
    Given The Login form is shown
     When The User attemp to show password with password is "123456"
     Then The password is hiden by secret character
  
  Scenario Outline: User can authenticate with valid another account
    Given The Login form is shown
     When The User attemp to login with <another_account> and valid <username> and valid <password>
     Then The profile page will be shown
  
  Example: 
      | another_account  | username        | password | 
      | Facebook account | anhlt@gmail.com | 123456   | 
      | Google account   | anhlt@gmail.com | 123456   | 
  
  Scenario Outline: User cannot authenticate with invalid another account
    Given The Login form is shown
     When The User attemp to login with <another_account> and <username> and <password>
     Then The message "Thông tin đăng nhập không hợp lệ" is showed
  
  Example: 
      | another_account  | username   | password | 
      | Facebook account | @gmail.com | 123456   | 
      | Google account   | @gmail.com | 123456   | 
  
  Scenario: The forget password page is shown when user click on button "Quen mat khau"
    Given The Login form is shown
     When The User attemp to reset password
     Then The forget password page is shown
  
  Scenario: The Registration page is shown when user click on button "Dang ky"
    Given The Login form is shown
     When The User attemp to register an account
     Then The Registration page is shown