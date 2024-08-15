import java.util.Scanner;

class BankAccount{
	
	String accountHolderName;
	String username;
	String passcode;
	String accountNumber;
	float currentBalance = 20000f;
	int numberOfTransactions = 0;
	String transactionRecord = "";
	
	public void registerAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter your Full Name: ");
		this.accountHolderName = sc.nextLine();
		System.out.println("\nCreate a Username: ");
		this.username = sc.nextLine();
		System.out.println("\nCreate a Password: ");
		this.passcode = sc.nextLine();
		System.out.println("\nEnter your Account Number: ");
		this.accountNumber = sc.nextLine();
		System.out.println("\nRegistration Completed. Please log in to your account.");
	}
	
	public boolean authenticateLogin() {
		boolean isLoggedIn = false;
		Scanner sc = new Scanner(System.in);
		while(!isLoggedIn) {
			System.out.println("\nEnter your Username: ");
			String inputUsername = sc.nextLine();
			if (inputUsername.equals(username)) {
				while(!isLoggedIn) {
					System.out.println("\nEnter your Password: ");
					String inputPassword = sc.nextLine();
					if(inputPassword.equals(passcode)) {
						System.out.println("\nLogin Successful!");
						isLoggedIn = true;
					} else {
						System.out.println("\nInvalid Password. Please try again.");
					}
				}
			} else {
				System.out.println("\nUsername not recognized.");
			}
		}
		return isLoggedIn;
	}
	
	public void withdrawFunds() {
		System.out.println("\nEnter the Amount to Withdraw: ");
		Scanner sc = new Scanner(System.in); 
		float withdrawalAmount = sc.nextFloat();
		try {
			if(currentBalance >= withdrawalAmount) {
				numberOfTransactions++;
				currentBalance -= withdrawalAmount;
				System.out.println("\nWithdrawal Successful.");
				String transactionDetails = withdrawalAmount + " Rs withdrawn.\n";
				transactionRecord = transactionRecord.concat(transactionDetails);
			} else {
				System.out.println("\nInsufficient Balance.");
			}
		} catch(Exception e) {
			System.out.println("\nAn error occurred during the withdrawal process.");
		}
	}
	
	public void depositFunds() {
		System.out.println("\nEnter the Amount to Deposit: ");
		Scanner sc = new Scanner(System.in); 
		float depositAmount = sc.nextFloat();
		try {
			if(depositAmount <= 20000f) {
				numberOfTransactions++;
				currentBalance += depositAmount;
				System.out.println("\nDeposit Successful.");
				String transactionDetails = depositAmount + " Rs deposited.\n";
				transactionRecord = transactionRecord.concat(transactionDetails);
			} else {
				System.out.println("\nSorry. The deposit limit is 20000 Rs.");
			}
		} catch(Exception e) {
			System.out.println("\nAn error occurred during the deposit process.");
		}
	}
	
	public void transferFunds() {
	    Scanner sc = new Scanner(System.in); 
		System.out.println("\nEnter Recipient's Name: ");
		String recipientName = sc.nextLine();
		System.out.println("\nEnter Amount to Transfer: ");
		float transferAmount = sc.nextFloat();
		try {
			if(currentBalance >= transferAmount) {
				if(transferAmount <= 50000f) {
					numberOfTransactions++;
					currentBalance -= transferAmount;
					System.out.println("\nTransfer Successful to " + recipientName);
					String transactionDetails = transferAmount + " Rs transferred to " + recipientName + ".\n";
					transactionRecord = transactionRecord.concat(transactionDetails);
				} else {
					System.out.println("\nSorry. The transfer limit is 50000 Rs.");
				}
			} else {
				System.out.println("\nInsufficient Balance.");
			}
		} catch(Exception e) {
			System.out.println("\nAn error occurred during the transfer process.");
		}
	}
		
	public void checkCurrentBalance() {
		System.out.println("\nYour Current Balance: " + currentBalance + " Rs");
	}
	
	public void viewTransactionHistory() {
		if(numberOfTransactions == 0) {
			System.out.println("No transactions have been made.");
		} else {
			System.out.print("\nTransaction History:\n" + transactionRecord);
		}
	}
}

public class ATMInterface {
	
	public static int getUserInput(int limit) {
		int userInput = 0;
		boolean isValid = false;
		
		while(!isValid) {
			try {
				Scanner sc = new Scanner(System.in);
				userInput = sc.nextInt();
				isValid = true;
				
				if(isValid && (userInput > limit || userInput < 1)) {
					System.out.println("Please select a number between 1 and " + limit);
					isValid = false;
				}
			} catch(Exception e) {
				System.out.println("Enter only an integer value.");
				isValid = false;
			}
		}
		return userInput;
	}
	
	public static void main(String[] args) {
		System.out.println("\n********************WELCOME TO SHUBHAM ATM INTERFACE*******************");
		System.out.println("\n1. Register \n2. Exit");
		System.out.println("Choose an option: ");
		int option = getUserInput(2);
		
		if(option == 1) {
			BankAccount userAccount = new BankAccount();
			userAccount.registerAccount();
			while(true) {
				System.out.println("\n1. Login \n2. Exit");
				System.out.println("Enter your choice: ");
				int choice = getUserInput(2);
				if(choice == 1) {
					if(userAccount.authenticateLogin()) {
						System.out.println("\n********************WELCOME BACK " + userAccount.accountHolderName + "*******************");
						boolean exitRequested = false;
						while(!exitRequested) {
							System.out.println("\n1. Withdraw \n2. Deposit \n3. Transfer \n4. Check Balance \n5. Transaction History \n6. Exit");
							System.out.println("Enter your choice: ");
							int action = getUserInput(6);
							switch(action) {
							  case 1:
								 userAccount.withdrawFunds();
								 break;
							  case 2:
								 userAccount.depositFunds();
								 break;
							  case 3:
								 userAccount.transferFunds();
								 break;
							  case 4:
								 userAccount.checkCurrentBalance();
								 break;
							  case 5:
								 userAccount.viewTransactionHistory();
								 break;
							  case 6:
								 exitRequested = true;
								 break;
							}
						}
					}
				} else {
					System.exit(0);
				}
			}
		} else {
			System.exit(0);
		}
	}
}
