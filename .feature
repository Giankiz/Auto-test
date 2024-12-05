Feature: Recruitment Process

  As an HR manager,
  I want to add a new candidate to the system,
  So that I can track their application progress.

  Background:
    Given I am on the OrangeHRM login page

  Scenario: Add a candidate successfully
    When I log in with username "Admin" and password "admin123"
    And I navigate to the "Recruitment" module
    And I fill in the candidate's first name as "Juan"
    And I fill in the candidate's middle name as "Carlo"
    And I fill in the candidate's last name as "Pérez"
    And I select the job title "Senior QA Lead"
    And I fill in the candidate's email as "example_123@outlook.com"
    And I fill in the candidate's contact number as "+50766668471"
    And I fill in the candidate's keywords as "New member"
    And I add notes "This is the record of the new employee"
    And I upload the resume "example.txt"
    And I select the date available as "2024-10-14"
    And I submit the candidate form
    Then I should see a message "Successfully Saved"

i wanted to specify everything done in the process,i can write a shorter user history.