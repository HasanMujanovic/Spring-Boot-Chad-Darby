package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;

import java.util.List;

public interface AccountDao {
    // add a new method: findAccount()
    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripWire);

    void addAccount(Account account, boolean vipFlag);
    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

}
