
Feature: Language Learning

  Scenario: Look for Language Learning
    Given open the Website again coursera
    And Search for "Language Learning" in search box
    And Extract all the languages with total count
    And Extract  different levels with its total count
    Then Display them
	