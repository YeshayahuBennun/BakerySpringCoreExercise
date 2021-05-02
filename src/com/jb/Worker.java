package com.jb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Component
@EnableScheduling
public class Worker {
    private Oven oven;
    private int totalBread;
    private int breadsInTheOven;



    @Autowired
    public Worker(Oven oven, @Value("${total.bread}") int totalBread) {

        this.oven = oven;
        this.totalBread = totalBread;
    }


    @Scheduled(fixedDelay =1500)
    public void feedTheOven() {
        if (totalBread > 0) {

        oven.getBreads().add(new Bread("#"+(breadsInTheOven+1),0));
            System.out.println("Worker - Putting bread number " + (breadsInTheOven + 1) + " in the oven");
            totalBread--;
        breadsInTheOven++;
        }else{
            oven.turnOffBakeComplete();
        }
    }
}
