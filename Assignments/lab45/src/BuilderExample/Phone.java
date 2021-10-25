package BuilderExample;

import java.awt.*;

public class Phone {
    public String OS;
    public String modelName;
    public Color color;
    public float width;
    public float height;
    public float thickness;
    public float screenSize;
    public float screenWidthPixels;
    public float screenHeightPixels;
    public int ramGb;
    public int internalStorageGb;
    public String CPU;

    public Phone(){}

    public Phone(String OS, String modelName, Color color, float width, float height, float thickness, float screenSize, float screenWidthPixels, float screenHeightPixels, int ramGb, int internalStorageGb, String cpu){
        this.OS = OS;
        this.modelName = modelName;
        this.color = color;
        this.width = width;
        this.height = height;
        this.thickness = thickness;
        this.screenSize = screenSize;
        this.screenWidthPixels = screenWidthPixels;
        this.screenHeightPixels = screenHeightPixels;
        this.ramGb = ramGb;
        this.internalStorageGb = internalStorageGb;
        this.CPU = cpu;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "OS='" + OS + '\'' +
                ", modelName='" + modelName + '\'' +
                ", color=" + color +
                ", width=" + width +
                ", height=" + height +
                ", thickness=" + thickness +
                ", screenSize=" + screenSize +
                ", screenWidthPixels=" + screenWidthPixels +
                ", screenHeightPixels=" + screenHeightPixels +
                ", ramGb=" + ramGb +
                ", internalStorageGb=" + internalStorageGb +
                ", CPU='" + CPU + '\'' +
                '}';
    }
}
