package com.example.demo.test;

import com.codahale.metrics.ConsoleReporter;

import java.util.concurrent.TimeUnit;
/**   
 * 控制台打印输出   
 */    
public class MyConsoleReport     
{    
    public static void startReport()    
    {    
        final ConsoleReporter reporter = ConsoleReporter.forRegistry(MetricConstant.REGISTER)    
                .convertRatesTo(TimeUnit.SECONDS)    
                .convertDurationsTo(TimeUnit.SECONDS)    
                .build();    
        //一秒钟执行一次    
        reporter.start(1, TimeUnit.SECONDS);    
    }    
}    