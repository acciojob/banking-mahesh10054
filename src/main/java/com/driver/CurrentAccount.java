package com.driver;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name,balance,5000);
        if(balance < 5000)
        {
            throw new Exception("Insufficient Balance");
        }
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        this.tradeLicenseId = tradeLicenseId;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(!isValidateLicenseId(tradeLicenseId)){

            if(!canCreateLicenseId(tradeLicenseId))
            {
                throw new Exception("Valid License can not be generated");
            }

            rearrangeLicenseId(tradeLicenseId);
        }
        else{
            this.tradeLicenseId = tradeLicenseId;
        }
    }
    public boolean canCreateLicenseId(String licenseId)
    {
        HashMap<Character,Integer> hm = new HashMap<>();
        int n = licenseId.length();

        for(int i=0;i<n;i++)
        {
            char ch = licenseId.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        if(n % 2 == 0)
        {
            n = n/2;
        }
        else{
            n = (n+1)/2;
        }
        for(char ch : hm.keySet())
        {
            if(hm.get(ch) > n)
            {
                return false;
            }
        }
        return true;
    }
    public void rearrangeLicenseId(String licenseId)
    {
        int[] freq = new int[26];
        char maxFreqChar = '0';
        int maxFreq = 0;

        for(int i=0;i<licenseId.length();i++)
        {
            char ch = licenseId.charAt(i);
            freq[ch - 'A']++;

            if(freq[ch - 'A'] > maxFreq)
            {
                maxFreqChar = ch;
                maxFreq = freq[ch - 'A'];
            }
        }

        char[] result = new char[licenseId.length()];
        int index = 0;

        //put the maximum frequency character
        while(freq[maxFreqChar - 'A']-- > 0)
        {
            result[index] = maxFreqChar;
            index = index + 2;
        }

        for(int i=0;i<26;i++)
        {
            int frequency = freq[i];
            while(frequency > 0)
            {
                if(index >= licenseId.length())
                {
                    index = 1;
                }
                result[index] = (char) (i + 'A');
                index = index + 2;
            }
        }
    }
    public boolean isValidateLicenseId(String tradeLicense){

        for(int i=0;i<tradeLicense.length()-1;i++)
        {
            if(tradeLicense.charAt(i) == tradeLicense.charAt(i+1))
            {
                return false;
            }
        }
        return true;
    }
}
