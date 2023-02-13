Feature: Get Single User Automation Testing

#  Positif
  @Tugas
  Scenario Outline: Get single user with valid parameter
    Given Get single user with valid parameter id <id>
    When Send request get single user
    Then Status code should be 200 OK
    And Get single user json schema validator
    Examples:
      | id |
      | 1  |
      | 6  |

#    Negatif
  @Tugas
  Scenario Outline: Get single user with invalid parameter
    Given Get single user with invalid parameter id <id>
    When Send request get single user
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | 200 |
      | 300 |
