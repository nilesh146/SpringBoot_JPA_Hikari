Feature: enrole new user
  Scenario Outline: create new customer if customer not existed
    Given customer details
    When the client calls /version "<firstName>" and "<lastName>" and "<middleName>" and "<age>" and "<mobile>" and "<email>"
    Then the client receives status code of "<httpStatus>"
    
    Examples:
    |firstName|lastName|middleName|age|mobile    |email         |httpStatus|
    |karan    |sharma  |rahul    |20 |8787656543|karan@gmail.com|200       |
   
   