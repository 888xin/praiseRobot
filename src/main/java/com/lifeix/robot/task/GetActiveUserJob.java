package com.lifeix.robot.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by lhx on 15-2-4 上午9:55
 *
 * @project praiseRobot
 * @package com.lifeix.robot.task
 * @Description 任务一获取活跃用户，更新数据库表
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class GetActiveUserJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("获取活跃用户");
        System.out.println("更新数据库表");
    }
}
