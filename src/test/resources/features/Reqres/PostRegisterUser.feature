Feature: Post Register User Automation Testing
# Positif
  @Tugas
  Scenario: Register user with valid email and password
    Given Register new user with valid email and valid password
    When Send request post register user
    Then Status code should be 200 OK
    And Validate register user json schema

# Negatif
  @Tugas
 Scenario: Register user with valid email and empty password
    Given Register new user without password
    When Send request post register user
    Then Status code should be 400 Bad Request
    And Respon body error should be "Missing password"
    And Validate register user json schema no password

  @Tugas
  Scenario: Register user with empty email and valid password
    Given Register new user without email
    When Send request post register user
    Then Status code should be 400 Bad Request
    And Respon body error should be "Missing email or username"
    And Validate register user json schema no email

  @Tugas
  Scenario: Register user with invalid email and password
    Given Register new user with invalid email and invalid password
    When Send request post register user
    Then Status code should be 400 Bad Request
    And Respon body error should be "Note: Only defined users succeed registration"
    And Validate register user json schema invalid data



