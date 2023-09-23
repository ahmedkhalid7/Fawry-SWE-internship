# Banking Application
This application serves as a basic example of implementing a banking system using OOP principles in Java.

## Classes
### Account class
The Account class is a superclass that contains:

<ul>
<li> accountNumber</li>
<li>accountHolderName</li>
<li>balance</li>
</ul>
It has a constructor to initialize these fields and methods for:

<ul>
<li> deposit()</li>
<li>withdraw()</li>
</ul>

### SavingsAccount class
The SavingsAccount class extends the Account class and includes:

<ul>
<li> interestRate</li>
</ul>
It also has a method to calculate interest on the balance.

### Bank class
The Bank class stores an array of Account objects and has methods for:

<ul>
<li> addAccount()</li>
<li>depositMoney()</li>
<li>withdrawMoney()</li>
<li>displayBalance()</li>
</ul>

### BankApplication class
The BankApplication class contains the main() method and allows customers to interact with the banking application through a command line interface.

## How to run
To run the application, compile and run the BankApplication.java file. You will be presented with a menu where you can:

<ol>
<li> Open a new savings account</li>
<li>Deposit money</li>
<li>Withdraw money</li>
<li>Check balance</li>
<li>Exit</li>
</ol>

Enter the corresponding number to perform that action.

## Usage
This basic banking application demonstrates OOP principles in Java:

<ul>
<li>The Account and SavingsAccount classes show inheritance</li>
<li>The Bank class uses composition by storing Account objects</li>
</ul>

