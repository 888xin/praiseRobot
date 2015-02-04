package com.lifeix.robot.quartz;

import com.lifeix.robot.task.CheckIsActiveUserJob;
import com.lifeix.robot.task.GetActiveUserJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * Created by lhx on 15-2-4 上午10:21
 *
 * @project praiseRobot
 * @package com.lifeix.robot.quartz
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class SchedulerQuartz {

    public void run() throws Exception{


        //作业新建
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        //任务一
        JobDetail job1 = newJob(GetActiveUserJob.class).withIdentity("job1","group1").build();
        //任务二
        JobDetail job2 = newJob(CheckIsActiveUserJob.class).withIdentity("job2","group1").build();

        //触发器一，测试用，cron表达式可以随时改 每天凌晨3点执行一次：0 0 3 * * ?   每隔10分钟执行一次：0 */10 * * * ?
        CronTrigger trigger1 = newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("0/5 * * * * ?"))
                .build();
        //触发器二
        CronTrigger trigger2 = newTrigger().withIdentity("trigger2", "group1")
                .withSchedule(cronSchedule("0 */1 * * * ?"))
                .build();

        //3-10之间
        int minutes = (int)Math.round(Math.random()*7) + 3 ;
        //未来3-10分钟内触发
        Date startTime = DateBuilder.nextGivenMinuteDate(null, minutes);
        //3-15的点赞数
        int repeatcounts = (int)Math.round(Math.random()*15) + 3 ;
        //点赞间隔intervalSeconds
        int intervalSeconds = (int)Math.round(Math.random()*60) + 20 ;

        //触发器三
        SimpleTrigger trigger3 = newTrigger().withIdentity("trigger3", "group1")
                .startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(intervalSeconds).withRepeatCount(repeatcounts))
                .build();


        //加入任务一到作业中，用触发器一
        Date date = scheduler.scheduleJob(job1, trigger1);
        //加入任务二到作业中，用触发器二
        Date date2 = scheduler.scheduleJob(job2, trigger2);
        System.out.println(date);
        System.out.println(date2);
        //开启作业
        scheduler.start();
        try {
            Thread.sleep(120L * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //关闭作业
        scheduler.shutdown(true);
    }

    public static void main(String[] args) throws Exception {
        SchedulerQuartz schedulerQuartz = new SchedulerQuartz();
        schedulerQuartz.run();
    }
}
