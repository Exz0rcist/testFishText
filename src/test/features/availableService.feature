# language: en
@all
Feature: Check service available

  Scenario: Service is available
    Given browser "Firefox"
    When User send request to "https://fish-text.ru/get"
    Then User get message with response code 200
