
Feature: Identify Web Development Course

  Scenario: Fetch First two beginner-level web development courses in English language
    Given open the Website coursera
    When Search for "Web Development" courses
    And filter for Beginners level & English Language courses
    Then extract the course names, total learning hours & rating for first two courses
