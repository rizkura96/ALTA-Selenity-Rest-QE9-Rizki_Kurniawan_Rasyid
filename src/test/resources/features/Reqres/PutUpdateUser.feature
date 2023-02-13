Feature: Put Update User Automation Testing

# Positif
  @Tugas
  Scenario: Put update user with valid json and valid parameter
    Given Update user with valid json and parameter id 2
    When Send request put update user
    Then Status code should be 200 OK
    And Response body name should be "Rizki Kurniawan" and job is "QA Engineer"
    And Validate update user json schema

# Negatif
  @Tugas
  Scenario: Put update user with invalid parameter
    Given Update user with invalid parameter id "parametersalah"
    When Send request put update user
    Then Status code should be 400 Bad Request

  @Tugas
  Scenario: Put update user without parameter
    Given Put update user without parameter
    When Send request put update user without parameter
    Then Status code should be 404 Not Found
