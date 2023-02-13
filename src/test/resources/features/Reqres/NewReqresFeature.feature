Feature: Reqres API Automation Testing QE-9

#  Scenario 1 GET LIST USER
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user json schema
    Examples:
      |page|
      |1   |
      |2   |

#  Scenario 2 POST CREATE USER
  @Latihan
 Scenario: Post create new user with valid json file
    Given Create new user with valid json
    When Send request post create user
    Then Status code should be 201 Created
    And Response body name should be "Rizki Kurniawan" and job is "QA Engineer"

#  Scenario 3 PUT UPDATE USER
 @Latihan
 Scenario Outline:Put update user with valid json and parameter id
   Given Update user with valid json and parameter id <id>
   When Send request put update user
   Then Status code should be 200 OK
   And Response body name should be "Rizki Kurniawan" and job is "QA Engineer"
 Examples:
   | id |
   | 1  |
   | 2  |
   | 3  |

 #  Scenario 4 GET LIST USER
 @Latihan
 Scenario Outline: Delete user with valid parameter id
   Given Delete user with valid parameter id <id>
   When Send request delete user
   Then Status code should be 204 No Content
 Examples:
   | id |
   | 1  |
   | 2  |
   | 3  |