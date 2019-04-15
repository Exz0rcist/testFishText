# new feature

@all
@sentece
    
Feature: Testing api with parameter sentence


Scenario: Test default values for senteces
          When User send request to "https://fish-text.ru/get"
          Then User get message with status "success"
          And User get 3 "sentences"


Scenario: Test zero value for senteces
            Given type of parameter request "sentence"
            And count 0
            When User send request to "https://fish-text.ru/get"
            Then User get message with status "success"
            And User get 0 "sentences"


Scenario: Test negative value for senteces
            Given type of parameter request "sentence"
            When User send request to "https://fish-text.ru/get"
            Then User get message with status "error"
