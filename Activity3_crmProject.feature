
@Activity3
Feature: Schedule a meeting and invite members

  @tag1
  Scenario: Go to schedule a meeting page and include at least 3 invitees
   Given User is on CRM login page3
	When user enters username and password3
	Then Navigate to Activities -> Meetings -> Schedule a Meeting
	And close the browser3