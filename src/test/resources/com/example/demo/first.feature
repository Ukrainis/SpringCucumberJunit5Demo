Feature: First api test feature

    Feature Description
Scenario: First api scenario
Given I preparing GET, DELETE request specification
When I make GET request to /users endpoint
Then I should see 200 response code with json body

Scenario: Second api scenario
Given I preparing GET, DELETE request specification
When I make GET request to /users endpoint
Then I should see 200 response code with json body
When I am taking username using [0].userName json path
Then I preparing GET, DELETE request specification
When I make DELETE request to remove previously found user
Then I should see 204 response code without json body