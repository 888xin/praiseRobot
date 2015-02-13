package com.lifeix.test;

import com.lifeix.robot.dao.PointLikeAccountDao;
import com.lifeix.robot.dao.PraiseUserDao;
import com.lifeix.robot.dao.UserDao;
import com.lifeix.robot.model.PointLikeAccount;
import com.lifeix.robot.model.PraiseUser;
import com.lifeix.robot.model.User;
import com.lifeix.robot.util.ReadFile;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.Date;

/**
 * Created by lhx on 15-2-3 上午11:35
 *
 * @project springmybatis
 * @package com.lifeix.test
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class UserTest {

    private UserDao userDao ;
    private PraiseUserDao praiseUserDao ;
    private PointLikeAccountDao pointLikeAccountDao ;

    @Before
    public void before(){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
                ,"classpath:conf/spring-mybatis.xml"});
        userDao = (UserDao) context.getBean("userDao");
        praiseUserDao = (PraiseUserDao) context.getBean("praiseUserDao");
        pointLikeAccountDao = (PointLikeAccountDao) context.getBean("pointLikeAccountDao");
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setArticlenumber(23);
        user.setLogintime(new Date());
        user.setPassword("123");
        user.setSex(true);
        user.setUsername("张三");
        System.out.println(userDao.insertUser(user));
    }

    @Test
    public void addAll(){
        File file = new File("C:\\Users\\Lifeix\\Desktop\\src\\新建文本文档.txt");
        String[] strs = ReadFile.readTxtByLine(file, "gbk");
        for (int i = 0; i < strs.length; i++) {
            String str[] = strs[i].split("\t");
            String accountid = str[0].trim();
            String sexStr = str[1].trim();
            boolean sex ;
            if ("1".equals(sexStr)){
                sex = true ;
            } else {
                sex = false ;
            }
            PraiseUser praiseUser = new PraiseUser();
            praiseUser.setAccountid(Integer.valueOf(accountid));
            praiseUser.setSex(sex);
            praiseUserDao.insertPraiseUser(praiseUser);
        }
    }

    @Test
    public void addAllPointLikeAccount(){
        File file = new File("C:\\Users\\Lifeix\\Desktop\\src\\新建文本文档 (2).txt");
        String[] strs = ReadFile.readTxtByLine(file, "gbk");
        for (int i = 0; i < strs.length; i++) {
            String str[] = strs[i].split("\t");
            String accountid = str[0].trim();
            String sexStr = str[1].trim();
            int sex = Integer.valueOf(sexStr);
            PointLikeAccount pointLikeAccount = new PointLikeAccount();
            pointLikeAccount.setPointAccountId(Long.valueOf(accountid));
            pointLikeAccount.setPointGender(sex);
            pointLikeAccountDao.insertpointLikeAccount(pointLikeAccount);
        }
    }

}
