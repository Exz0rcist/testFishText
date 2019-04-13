# language: en
Feature: Check service available

  Scenario: Service is available
    Given browser "Firefox"
    When User send request to "https://fish-text.ru/api"
    Then User get message with response code 200
