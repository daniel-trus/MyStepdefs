@search
  Feature: Google Search

    Scenario Outline: Search in Google
      Given I have WebBrowser opened
      When I go to google.com
      And I submit the pop upp
      And Type <keysearch> in search engine
      And I submit the search
      Then Browser is navigated to search results
      Examples:
      |keysearch|
      |Selenium |
      |Cucumber |
      |Git      |

      And I enter new alias <alias> address <address>  city <city> state <state> zip code <postal code> country <country> phone <phone>
      Examples:
        | alias | address     | city | state   | postal code | country        | phone     |
        | Zenio | Cucumber 28 | Ohio | Arizona | 23867       | United Kingdom | 234089654 |
