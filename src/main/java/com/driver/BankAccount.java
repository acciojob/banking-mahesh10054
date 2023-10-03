package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;
    private String accountNumber = "";

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        if(sum > digits*9)
        {
            throw new Exception("Account Number can not be generated");
        }

        String accountNo = "";

        int quotient = sum/9;
        int reminder = sum%9;

        while(quotient-- > 0)
        {
            accountNo += "9";
        }
        if(reminder != 0) {
            accountNo += reminder;
        }

        int remDigit = digits - accountNo.length();

        while(remDigit-- > 0)
        {
            accountNo += "0";
        }

        return accountNo;
    }

    public void deposit(double amount) {
        //add amount to balance
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if((balance - amount) < minBalance)
        {
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
    }

}