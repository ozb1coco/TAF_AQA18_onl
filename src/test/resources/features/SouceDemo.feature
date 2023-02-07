Feature: SouceDemo successful order

    Scenario:
      Given open page of log in
      * user "standard_user" with password "secret_sauce" logged in
      * add stuff to the cart
      * open cart page
      * open data page
      When user input personal data firstname "Vitaly", lastname "Sch", zipcode "246029"
      Then finish page

