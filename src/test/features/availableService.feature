# language: en

@all

Feature: Check service available

  Scenario: Service is available
    When User send request to "https://fish-text.ru/get"
    Then User get message with status "success"
