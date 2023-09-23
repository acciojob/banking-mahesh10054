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
    public void findNDigitNumbers(String result, int n, int target)
    {
        if (n > 0 && target >= 0)
        {
            char d = '0';
            if (result.equals("")) {
                d = '1';
            }
            while (d <= '9')
            {
                findNDigitNumbers(result + d, n - 1, target - (d - '0'));
                d++;
            }
        }
        else if (n == 0 && target == 0) {
            accountNumber = result;
        }
    }
    public String generateAccountNumber(int digits, int sum) throws Exception{
        findNDigitNumbers("",digits,sum);
        if(accountNumber != null)
        {
            return accountNumber;
        }

        throw new Exception("Account Number can not be generated");
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