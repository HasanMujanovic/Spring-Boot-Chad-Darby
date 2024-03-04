package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;

public interface AccountDao {
    void addAccount(Account account, boolean vipFlag);
    boolean doWork();
}
