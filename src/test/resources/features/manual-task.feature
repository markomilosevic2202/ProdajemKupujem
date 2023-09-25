Feature: Address book


  #1
  Scenario: Displaying an empty address book page when user has no contacts
    Given  logged-in user with no contacts in their address book
    When entering the address book
    Then page is opened that contains the text "Trenutno nemate kontakta u adresaru"
  #2
  Scenario: Address book displays a list of contacts When a User Has Contacts
    Given a logged-in user with multiple contacts
    When entering the address book
    Then a list containing all the contacts is displayed.
  #3
  Scenario: Displaying an empty address book page after deleting all contacts
    Given a logged-in user with multiple contacts
    When entering the address book
    And delete all contacts
    Then a page is opened that contains the text "Trenutno nemate kontakta u adresaru"
  #4
  Scenario: Adding a New Contact to the Address Book from ad
    Given a logged-in user
    When finding a random listing that has the option 'Dodaj u adresar'
    And clicking on the 'Dodaj u adresar' button
    And entering "abc" in the comment field
    And clicking the 'Sačuvaj' button
    Then verify that on the listing, the 'Dodaj u adresar' button has changed to 'Ukloni iz adresara'
    And verify that the contact with all the parameters from the listing has appeared on the address book page.
  #5
  Scenario: A character must be entered to save a comment
    Given a logged-in user
    When finding a random listing that has the option 'Dodaj u adresar'
    And clicking on the 'Dodaj u adresar' button
    And clicking the 'Sačuvaj' button
    Then the button 'Sačuvaj' is disabled
    And a window with the message 'Dodat u adresar' is opened
  #6
  Scenario: We can save a comment when entering a single letter
    Given a logged-in user
    When finding a random listing that has the option 'Dodaj u adresar'
    And clicking on the 'Dodaj u adresar' button
    And entering in input field for comment 'a'
    Then the 'Sačuvaj' button is enabled
    And the comment is saved
  #7
  Scenario: We can save a comment when entering a maximum number of characters
    Given a logged-in user
    When finding a random listing that has the option 'Dodaj u adresar'
    And clicking on the 'Dodaj u adresar' button
    And entering in input field for comment 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa...'
    Then the 'Sačuvaj' button is enabled
    And the comment is saved
  #8
  Scenario: Comment is not remembered if the X button is clicked on the modal, but the contact is saved
    Given a logged-in user
    When finding a random listing that has the option 'Dodaj u adresar'
    And clicking on the 'Dodaj u adresar' button
    And entering in input field for comment 'abc'
    And clicking on the 'X' button
    Then the comment is not saved
    And the contact is saved
  #9
  Scenario: Comment is not remembered if the 'Odustani' button is clicked on the modal, but the contact is saved
    Given a logged-in user
    When finding a random listing that has the option 'Dodaj u adresar'
    And clicking on the 'Dodaj u adresar' button
    And entering in input field for comment 'abc'
    And clicking on the 'Odustani' button
    Then the comment is not saved
    And the contact is saved
   #10
  Scenario: Comment is not remembered if the 'Nazad' button is clicked on the modal, but the contact is saved
    Given a logged-in user
    When finding a random listing that has the option 'Dodaj u adresar'
    And clicking on the 'Dodaj u adresar' button
    And entering in input field for comment 'abc'
    And clicking on the 'Nazad' button
    Then the comment is not saved
    And the contact is saved
  #11
  Scenario: Modal confirmation for deleting a contact
    Given a logged-in user with multiple contacts
    When clicking on the 'Obrisi kontakt' button
    Then the modal is opened that has the name of the contact in the title
    And the modal contains text 'Da li ste sigurni?'
  #12
  Scenario: Displaying an animation when deleting a connection
    Given a logged-in user with multiple contacts
    When clicking on the 'Obrisi kontakt' button
    And clicking on the 'Obrisi' button
    Then a deletion animation is displayed
    And then the connection with that name is deleted
  #13
  Scenario: Contact is not deleted when clicking the 'X' button
    Given a logged-in user with multiple contacts
    When clicking on the 'Obrisi kontakt' button
    And clicking on the 'X' button
    Then then the connection with that name is not deleted
  #14
  Scenario: Contact is not deleted when clicking the 'Odustani' button
    Given a logged-in user with multiple contacts
    When clicking on the 'Obrisi kontakt' button
    And clicking on the 'Odustani' button
    Then then the connection with that name is not deleted
  #15
  Scenario: Contact is not deleted when clicking the 'Nazad' button
    Given a logged-in user with multiple contacts
    When clicking on the 'Obrisi kontakt' button
    And clicking on the 'Nazad' button
    Then then the connection with that name is not deleted
  #16
  Scenario: Display 'Ukloni iz adresar' Button When Adding a Contact via a Listing
    Given a logged-in user
    When finding a random listing that has the option 'Dodaj u adresar'
    And clicking on the 'Dodaj u adresar' button
    And clicking on the 'Ukloni iz adresar' button
    And clicking on the 'Obrisi' button
    Then a deletion animation appears
    And the contact is deleted from the address book.
  #17
  Scenario: In the input field for editing a note, it says 'Dodaj belesku'
    Given a logged-in user with multiple contacts
    When they click on the placeholder 'izmeni belesku'
    Then a window with the user's name is opened
    And in the input field, it says 'Dodaj belesku'
  #18
  Scenario: Adding a note to a contact who doesn't have one
    Given I am logged in with multiple contacts
    When clicking on "izmeni belesku"
    And entering a note "dfsdfsd"
    And clicking the 'Sačuvaj' button
    Then the note for the contact we are testing is updated.
  #19
  Scenario: Edit a note for a contact that already has one
    Given a logged-in user
    When clicking on the button that says 'beleska'
    And entering the note "dfsdfsd"
    And clicking the 'Sačuvaj' button
    Then the note for the contact we are testing is updated
  #20
  Scenario: Edit note to an empty string
    Given a logged-in user with multiple contacts with notes
    When clicking on note
    And entering the note " "
    And clicking the 'Sačuvaj' button
    Then in the note field, the placeholder is "Dodaj belesku".
  #21
  Scenario: Edit note to an empty string
    Given a logged-in user with multiple contacts with notes
    When clicking on note
    And entering the note " "
    And clicking the 'Sačuvaj' button
    Then in the note field, the placeholder is "Dodaj belesku".
  #22
  Scenario: Note doesn't change when the button 'Odustani' clicked
    Given a logged-in user with multiple contacts with notes
    When clicking on note
    And entering the note "abc"
    And clicking the 'Odustani' button
    Then the note has not changed
  #23
  Scenario: Viewing a user's full details by clicking on their username
    Given a logged-in user with multiple connections and notes
    When clicking on the username of the user
    Then all their details are correctly displayed
  #24
  Scenario: Calling a contact from the user modal
    Given logged-in user with multiple contacts and notes
    When clicking on the username of the user
    And clicking on the 'Pozovi' button
    Then calling application is opened
    And  phone number entered in that field is correct
  #25
  Scenario: Sorting contacts by 'Po imenu' criterion
    Given a logged-in user with multiple contacts and notes
    When sorting by the 'Po imenu' criterion
    Then the contacts are sorted by the 'Po imenu' criterion
  #26
  Scenario: Sorting contacts by 'Najnovije' criterion
    Given a logged-in user with multiple contacts and notes
    When sorting by the 'Najnovije' criterion
    Then the contacts are sorted by the 'Najnovije' criterion
  #27
  Scenario: Sorting contacts by 'Po broju pozitivnih ocena' criterion
    Given a logged-in user with multiple contacts and notes
    When sorting by the 'Po broju pozitivnih ocena' criterion
    Then the contacts are sorted by the 'Po broju pozitivnih ocena' criterion
  #28
  Scenario: Sorting contacts by 'Prvo sa beleškama' criterion
    Given a logged-in user with multiple contacts and notes
    When sorting by the 'Prvo sa beleškama' criterion
    Then the contacts are sorted by the 'Prvo sa beleškama' criterion
  #29
  Scenario: it is sorted by the time of addition when the first sorting criterion is the same
    Given a logged-in user with multiple contacts and notes
    When sorting by the 'Prvo sa beleškama' criterion
    Then the contacts are sorted by the 'Prvo sa beleškama' criterion
    And all who have notes are sorted by time of addition
  #30
  Scenario: Sorting is not lost when clicking anywhere
    Given a logged-in user with multiple contacts and notes
    When sorting by the 'Prvo sa beleškama' criterion
    And clicking outside the modal
    Then the sorting criterion is not lost.
  #31
  Scenario: It is not possible to add a contact from an ad if the user is not logged in
    Given go to the home address
    When within a random ad that has an option
    And on the Oglas page, click the button 'Dodaj u adresar'
    Then the login modal is displayed
  #32
  Scenario: You cannot add a user who has disabled it in their profile
    Given two logged-in users
    And one user has disabled the option to be added to the address book
    When logging in as one of the users
    And going to the listing of the user who has disabled being added to the address book
    Then the button to add to the address book does not exist on the page.
  #33
  Scenario: User data disappears from the address book when they disable others from adding them
    Given two logged-in users who have enabled adding each other to their address books
    And both users are in each other's address books
    When one user disables visibility to others
    Then their data is removed from the other user's address book.
  #34
  Scenario: Notes are not lost when disabling user addition
    Given two logged-in users who have enabled adding each other to their address books
    And both users are in each other's address books
    When one user disables the option for others to add them to their address book
    And they are removed from the other user's address book
    And the first user enables the option again to allow others to add them to their address book
    Then the user is visible again in the other user's address book
    And the notes associated with the user are not lost.
  #35
  Scenario: A user can add other users to their address book even when they disable others from adding them
    Given a logged-in user
    When they disable the option for other users to add them to their address book
    Then they can still add other users to their address book.


















