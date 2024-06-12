/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

/**
 *
 * @author ADMIN
 */
public class GoldenHour {

    private static Scheduler scheduler = null;

    public static void setGoldenHour(int startHour, int startMinute, int endHour, int endMin) {
        try {
            JobDetail startJob = JobBuilder.newJob(StartDiscountJob.class)
                    .withIdentity("startDiscountJob", "group1")
                    .build();

            Trigger startTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("startDiscountTrigger", "group1")
                    .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(startHour, startMinute)) // 24:00 (00:00) hàng ngày
                    .build();

            JobDetail endJob = JobBuilder.newJob(EndDiscountJob.class)
                    .withIdentity("endDiscountJob", "group1")
                    .build();

            Trigger endTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("endDiscountTrigger", "group1")
                    .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(endHour, endMin)) // 01:00 hàng ngày
                    .build();

            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            scheduler.scheduleJob(startJob, startTrigger);
            scheduler.scheduleJob(endJob, endTrigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static void unsetGoldenHour() {
        try {
            if (scheduler != null) {
                scheduler.deleteJob(JobKey.jobKey("startDiscountJob", "group1"));
                scheduler.deleteJob(JobKey.jobKey("endDiscountJob", "group1"));

                if (scheduler.getJobKeys(GroupMatcher.anyJobGroup()).isEmpty()) {
                    scheduler.shutdown();
                }

                scheduler = null;
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static Date time(String val) {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return df.parse(val);
        } catch (ParseException ex) {
            Logger.getLogger(GoldenHour.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
