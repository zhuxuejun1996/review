package org.hzero.train.demoscheduler;

import org.hzero.autoconfigure.scheduler.EnableHZeroScheduler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@EnableHZeroScheduler
@SpringBootApplication
public class DemoSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSchedulerApplication.class, args);
    }

}
