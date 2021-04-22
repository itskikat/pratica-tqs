Feature: Book Search
  To allow a customer to find his favourite books quickly, the library must offer multiple ways to search for a book

  Scenario: Search books by publication year
    Given a book with the title 'One good book', written by 'Anonymous', published in 2013-03-14
      And a book with the title 'Some other good book', written by 'Tim Tomson', published in 2014-08-24
      And a book with the title 'How to cook a dino', written by 'Fred Flintstone', published in 2016-01-01

    When the customer searches for books published between 2013 and 2014
    Then 2 books should have been found
      And Book 1 should have the title 'Some other good book'
      And Book 2 should have the title 'One good book'


  Scenario: Search books by author
    Given a book with the title 'One good book', written by 'Anonymous', published in 2013-03-14
      And a book with the title 'Some other good book', written by 'Tim Tomson', published in 2014-08-24

    When the customer searches for books written by 'Anonymous'
    Then 1 books should have been found
      And Book 1 should have the title 'One good book'


  Scenario: Search books by book title
    Given a book with the title 'One good book', written by 'Anonymous', published in 2013-03-14
      And a book with the title 'Some other good book', written by 'Tim Tomson', published in 2014-08-24

    When the customer searches for books with the title 'Some other good book'
    Then 1 books should have been found
      And Book 1 should have been written by 'Tim Tomson'