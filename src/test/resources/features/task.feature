Feature: Automatic Testing

  Scenario: In the Detaljno pretraži function, more ads were found than the specified number, for the specified parameters
    Given go to the home address
    When in the header, click on the button Pretraži detalnjo
    And on the model Pretraži detaljno in the input element "" enter the parameter "Pretražite detaljno"
    And on the model Pretraži detaljno in the input element "" enter the parameter "Odeća | Ženska"
    And on the model Pretraži detaljno in the input element "" enter the parameter "Bluze"
    And on the model Pretraži detaljno select checkbox Samo sa cenom
    And on the model Pretraži detaljno in the select element check the option "Novo"
    And on the model Pretraži detaljno in the select element check the option "Kao Novo"
    And on the model Pretraži detaljno click on the button Primeni filtere
    Then the search result is greater than "1000" ads




