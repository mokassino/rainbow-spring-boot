package org.github.moka.rainbowspringboot;


public class RgbModel {
    private int[] rgb;

    public RgbModel(){
        this.rgb = new int[3];
    }

    public RgbModel(int red, int green, int blue){
        this.rgb = new int[3];
        rgb[0] = red;
        rgb[1] = green;
        rgb[2] = blue;
    }

    public int[] getModel(){
        return this.rgb;
    }

    public void setModel(int red, int green, int blue){
        this.rgb[0] = red; this.rgb[1] = green; this.rgb[2] = blue;
    }
}