package com.jb;

/**
 * Listening to the oven end reading.
 */
public interface OnOvenCompleteListener {

    /**
     * Which will be called as soon as the oven has finished baking all the breads
     * and according to the employee's command the oven must be turned off.
     */
    void onOvenListener();

}
