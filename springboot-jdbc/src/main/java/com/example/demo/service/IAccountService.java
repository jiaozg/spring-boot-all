package com.example.demo.service;

import com.example.demo.entity.Account;

import java.util.List;

/**
 * Created by jiaozhiguang on 2017/8/21.
 */
public interface IAccountService {


    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();

}