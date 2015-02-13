package com.lifeix.robot.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by lhx on 15-2-4 上午10:18
 *
 * @project praiseRobot
 * @package com.lifeix.robot.task
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class MyJob{

    public void work(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //点赞人随机性别 一方占70%，另一方占30%
        int sexrandom = (int)Math.round(Math.random()*10) ;
        boolean flag = true ; //判断用户性别：true为男 false为女
        //如果为男
        if (flag){
            if (sexrandom<8){
                System.out.println("获取女方点赞人");
            } else {
                System.out.println("获取男点赞人");
            }
        } else {
            if (sexrandom<8){
                System.out.println("获取男方点赞人");
            } else {
                System.out.println("获取女点赞人");
            }
        }
        //5个随机点赞态度
        int praiseStatus = (int)Math.round(Math.random()*5) ;
        System.out.println("点赞用户随机态度" + praiseStatus + "获取过来的点赞人：XX");
    }
}
