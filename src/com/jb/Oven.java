package com.jb;


import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

/**
 * Designates an oven in the application
 */
@Component
@EnableScheduling
public class Oven {


    private List<Bread> breads;
    private Boolean onOffStatus;
    private OnOvenCompleteListener onOvenCompleteListener;


    public Oven() {
        breads = new ArrayList<>();
        onOffStatus = true;
    }

    /**
     * Puts a Bread in the Oven
     *
     * @param bread
     */
    public void addBread(Bread bread) {
        breads.add(bread);
    }

    /**
     * It is performed every millisecond and bake all breads in a single baking level.
     * If bread in the list is ready, then the function removes it from the list and print text that declares his status
     */


    @Scheduled(fixedDelay = 500)
    public void bake() {

        for (int i = 0; i < breads.size(); i++) {

            breads.get(i).bake();
            System.out.println("Oven - baking Bread " + breads.get(i));

            if (breads.get(i).isReady()) {
                System.out.println("Oven - baking Bread " + breads.get(i) + " is ready");
                breads.remove(i);
            }

        }
    }

    /**
     * Defines that the oven should be turned off as soon as the baking process of all breads is complete.
     */
    public void turnOffBakeComplete() {
        onOffStatus = true;
    }

    public void setOnOvenCompleteListener(OnOvenCompleteListener onOvenCompleteListener) {
        this.onOvenCompleteListener = onOvenCompleteListener;
    }

    public List<Bread> getBreads() {
        return breads;
    }
}
