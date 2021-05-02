package com.jb;

/**
 * This Class purpose is to set bread in the bakery.
 */
public class Bread {
    private static final int COMPLETELY_BAKED_BRAD = 5;

    private String name;
    private int level;

    public Bread() {
        //empty
    }

    public Bread(String name, int currentLevelBaking) {
        this.name = name;
        this.level = currentLevelBaking;
    }

    /**
     * Increases the level of baking in a single unit
     */
    public void bake() {
        level++;
    }

    /**
     * Checks if the bread reaches a final level of baking
     *
     * @return true
     */
    public boolean isReady() {
        return level == COMPLETELY_BAKED_BRAD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "Level='" + level + '\'' +
                ",Name=" + name +
                '}';
    }
}
