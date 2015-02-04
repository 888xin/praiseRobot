package com.lifeix.robot.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by lhx on 15-2-4 上午10:14
 *
 * @project praiseRobot
 * @package com.lifeix.robot.task
 * @Description 任务二，查找发帖者是否为活跃用户
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class CheckIsActiveUserJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("到数据库中查找是否为活跃用户");
        String str = "是活跃用户" ;
        if (!"不是活跃用户".equals(str)){
            System.out.println("触发任务三");
        } else {
            return;
        }
    }
}
