/**
 * Created by jon on 15/10/30.
 */
package com.helloworld.jon.mythirdapplication;

public class Fruit {
    private String name;
    private int imageId;
    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }
    public int getImageId() {
        return imageId;
    }
    public String getName() {
        return name;
    }
}
