Feature: Address book

  Scenario: In the Detaljno pretraži function, more ads were found than the specified number, for the specified parameters
    Given go to the home address
    When in the header, click on the button Pretraži detalnjo
    And on the model Pretraži detaljno in the input element "CATEGORY" enter the parameter "Odeća | Ženska"
    And on the model Pretraži detaljno in the input element "GROUP" enter the parameter "Bluze"
    And on the model Pretraži detaljno in the input element "PRICE_TO" enter the parameter "100"
    And on the model Pretraži detaljno select checkbox Samo sa cenom
    And on the model Pretraži detaljno in the select element check the option "Novo"
    And on the model Pretraži detaljno in the select element check the option "Kao Novo"
    And on the model Pretraži detaljno click on the button Primeni filtere
    Then the search result is greater than "1000" ads


  Scenario: It is not possible to add a contact from an ad if the user is not logged in
    Given go to the home address
    When within a random ad that has an option
    And on the Oglas page, click the button Dodaj u adresar
    Then the login modal is displayed




