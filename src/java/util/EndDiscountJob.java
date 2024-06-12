/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import dao.AdminDao;
import model.TimeSale;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author ADMIN
 */
public class EndDiscountJob implements Job {

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        System.out.println("Về giá cũ");
        AdminDao ad = new AdminDao();
        TimeSale ts = ad.getTimeSale();
        double amount = 1 - (double) ts.getDiscount()/100;
        ad.increase(amount);
    }
    
}
