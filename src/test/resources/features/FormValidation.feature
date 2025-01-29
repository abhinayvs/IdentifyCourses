
Feature: Form Validation

  Scenario: Validating Email field in the form
    Given opening the url coursera
    When click on For Universities
    And click on Solutions
    And Select any course
    When Filling form with invalid email as "admin#xyz"
    Then capturing the error message
