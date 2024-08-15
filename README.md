                  TASK 1
NUMBER GUESSING GAME

The Number Guessing Game is a Java-based console application where the player tries to guess a randomly generated number within a given range. The game offers multiple attempts to guess the correct number, and provides feedback on whether the guessed number is higher or lower than the secret number.

Key Features:
Random Number Generation: The game generates a random number between a predefined range (1 to 100).
Guessing Attempts: The player is given a maximum of 10 attempts to guess the correct number.
User Feedback: After each guess, the game informs the player whether the guessed number is higher or lower than the secret number.
Play Again Option: After the game ends, the player is prompted to either play again or exit the game.
Input Validation: The game checks that the player's input is a valid integer and prompts for re-entry if an invalid input is provided.

Game Flow:
The game starts by welcoming the player and explaining the rules.
The player is asked to guess the secret number within the given range.
After each guess, the game provides feedback and reduces the number of remaining attempts.
If the player guesses correctly, the game congratulates them; otherwise, it continues until the attempts are exhausted.
After the game ends, the player can choose to play again or quit.



            TASK 2
The ATM Interface is a Java-based console application that simulates basic banking operations such as account registration, login, withdrawal, deposit, fund transfer, balance inquiry, and transaction history viewing. The application mimics the functionality of an ATM, allowing users to interact with their bank account through a series of menu-driven options.

Key Features:
Account Registration:

Users can register by providing their full name, creating a username and password, and entering their account number.
A default initial balance of 20,000 Rs is set for every new account.
Login Authentication:

Users must log in with their registered username and password.
The application validates the credentials and provides access to account operations upon successful login.
Withdraw Funds:

Users can withdraw money from their account.
The application checks for sufficient balance before allowing the withdrawal.
Successful withdrawals are recorded in the transaction history.
Deposit Funds:

Users can deposit money into their account.
Deposits are limited to a maximum of 20,000 Rs per transaction.
Successful deposits are recorded in the transaction history.
Transfer Funds:

Users can transfer money to another individual by entering the recipient's name and the amount to transfer.
The application checks for sufficient balance and imposes a transfer limit of 50,000 Rs per transaction.
Successful transfers are recorded in the transaction history.
Check Balance:

Users can check their current account balance at any time.
Transaction History:

Users can view a history of all their transactions, including withdrawals, deposits, and transfers.
If no transactions have been made, the application informs the user accordingly.
User-Friendly Interface:

The application is menu-driven, making it easy for users to navigate through different banking operations.
Input validation ensures that users enter appropriate values and prevents errors.
Exit Options:

Users can exit the application at various stages, either after registration, login, or completing transactions.
Application Flow:
The user is greeted with an initial menu to either register a new account or exit the application.
Upon registration, the user can log in and access various banking operations through a secondary menu.
The application keeps running until the user chooses to exit, allowing multiple transactions in a single session.
