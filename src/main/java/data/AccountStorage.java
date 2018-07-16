package data;

import java.util.HashMap;
import java.util.Map;
import model.Account;

public class AccountStorage {

  private static AccountStorage instance = null;
  private final Map<String, Account> accounts;

  private AccountStorage() {
    this.accounts = new HashMap<>();
  }

  public static AccountStorage getInstance() {
    if (instance == null) {
      instance = new AccountStorage();
    }

    return instance;

  }

  public Map<String, Account> getAccounts() {
    return accounts;
  }
}
