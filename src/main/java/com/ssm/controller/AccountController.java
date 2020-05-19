package com.ssm.controller;

import com.ssm.entity.Account;
import com.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class AccountController {

    @Autowired // 按类型注入
    private AccountService accountService;

    @RequestMapping("/account/findAll")
    public String findAll(Model model){ //存数据， Model对象
        System.out.println("AccountController：查询所有");


        // 调用Service的方法
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list"; // 在视图解析器中配置了前缀后缀
    }

    @RequestMapping("/account/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }

}
