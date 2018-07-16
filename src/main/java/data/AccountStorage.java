package data;

import model.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountStorage
{
    private static AccountStorage instance = null;
    private final Map<String, Account> accounts;

    private AccountStorage()
    {
        this.accounts = new HashMap<>();
    }

    public static AccountStorage getInstance()
    {
        if(instance == null)
            instance = new AccountStorage();

        return instance;

    }

    public Map<String, Account> getAccounts()
    {
        return accounts;
    }
}
