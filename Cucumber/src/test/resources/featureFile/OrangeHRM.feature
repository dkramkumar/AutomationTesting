Feature: Orange HRM
  
  Scenario: Orange HRM Login
    Given User is on Orange HRM Login page
    When User enters UserName and Password
    And User clicks on login button
    Then User navigates to home page
  @Test
  Scenario: checking tabs
    Given User is on Orange HRM Login page
    When User enters UserName and Password
    And User clicks on login button
    Then User navigates to home page
    When User clicks on "viewAdminModule" tab
    When User clicks on "UserManagement" tab
    When User clicks on "Job" tab
    When User clicks on "Organization" tab
    When User clicks on "Qualifications" tab
    When User clicks on "nationality" tab
    When User clicks on "addTheme" tab
    When User clicks on "Configuration" tab
    
  
  Scenario: Admin role
    Given User is on Orange HRM Login page
    When User enters UserName and Password
    And User clicks on login button
    When User clicks on "viewAdminModule" tab
    When User clicks on "UserManagement" tab
    When User clicks on "viewSystemUsers" tab
    Then Total number of users should display
  
  Scenario: Search Users
    Given User is on Orange HRM Login page
    When User enters UserName and Password
    And User clicks on login button
    When User clicks on "viewAdminModule" tab
    When User clicks on "UserManagement" tab
    When User clicks on "viewSystemUsers" tab
    And User enters the Username to search
    And User selects the user role
    And User selects the status as "Enabled"
    Then User clicks on Search button
   
  Scenario: Add Users
    Given User is on Orange HRM Login page
    When User enters UserName and Password
    And User clicks on login button
    When User clicks on "viewAdminModule" tab
    And User clicks on add button
    And User enters the employee name, UserName, Password and ConfirmPassword
