# new feature

@all
@sentence

Feature: Testing api with parameter sentence


Scenario: Test default values for senteces
            When User send request to "https://fish-text.ru/get"
            Then User get message with status "success"
            And User get 3 "sentences"


Scenario: Test valid value for senteces
            Given type of parameter request "sentence"
            And count 20
            When User send request to "https://fish-text.ru/get"
            Then User get message with status "success"
            And User get 20 "sentences"



Scenario: Test maximum value for senteces
            Given type of parameter request "sentence"
            And count 500
            When User send request to "https://fish-text.ru/get"
            Then User get message with status "success"
            And User get 500 "sentences"


Scenario: Test over maximum value for senteces
            Given type of parameter request "sentence"
            And count 502
            When User send request to "https://fish-text.ru/get"
            Then User get message with status "error"
            And User get error code 11
