Feature: Delete User Testing Automation

# Positif
  @Tugas
  Scenario Outline: Delete user with valid parameter id
    Given Delete user with valid parameter id <id>
    When Send request delete user
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
      | 4  |

# Negatif
  @Tugas
  Scenario Outline: Delete user with invalid parameter id
    Given Delete user with invalid id "<invalidId>"
    When Send request delete user invalid parameter
    Then Status code should be 400 Bad Request
    Examples:
      | invalidId |
      | xxxxx     |
      | 78779     |

  @Tugas
  Scenario: Delete without parameter id
    Given Delete user without id
    When Send request delete user without parameter id
    Then Status code should be 400 Bad Request