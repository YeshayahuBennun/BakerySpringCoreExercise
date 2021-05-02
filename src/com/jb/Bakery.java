package com.jb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Bakery {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(BakeryConfiguration.class);

        Oven oven = ctx.getBean("oven", Oven.class);

        oven.setOnOvenCompleteListener(new OnOvenCompleteListener() {
            @Override
            public void onOvenListener() {
                //Close the Bakery
                ctx.close();
            }
        });


    }
}
