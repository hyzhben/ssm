package com.ssm.test;

import com.ssm.dao.Accountdao;
import com.ssm.entity.Account;
import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void run1() throws IOException {
        Account account = new Account();
        account.setName("xiao han han");
        account.setMoney(99999d);

        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        Accountdao accountdao = session.getMapper(Accountdao.class);

        // 保存
        accountdao.saveAccount(account);

        // 提交事务
        session.commit();

        // 关闭资源
        session.close();
        in.close();
    }

    @Test
    public void run2() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        Accountdao accountdao = session.getMapper(Accountdao.class);
        List<Account> list = accountdao.findAll();

        for (Account account:list){
            System.out.println(account.getId());
            System.out.println(account.getName());
            System.out.println(account.getMoney());
        }
        session.close();
        in.close();



    }





}