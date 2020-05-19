package com.ssm.service.impl;

import com.ssm.dao.Accountdao;
import com.ssm.entity.Account;
import com.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private Accountdao accountdao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层的实现类AccountServiceImpl，findAll()方法");
        return accountdao.findAll();
    }

    @Override
    public void saveAccount(Account account) {

        System.out.println("业务层的实现类AccountServiceImpl，saveAccount()方法");
        accountdao.saveAccount(account);
    }
}
