package BuilderExample;

import java.awt.*;

public class AndroidPhoneBuilder implements Builder{
    Phone androidPhone;

    public AndroidPhoneBuilder(){
        this.androidPhone = new Phone();
    }

    @Override
    public void setOS(String OS) {
        androidPhone.OS = OS;
    }

    @Override
    public void setModelName(String modelname) {
        androidPhone.modelName = modelname;
    }

    @Override
    public void setColor(Color color) {
        androidPhone.color = color;
    }

    @Override
    public void setWidth(float width) {
        androidPhone.width = width;
    }

    @Override
    public void setHeight(float height) {
        androidPhone.height = height;
    }

    @Override
    public void setThickness(float thickness) {
        androidPhone.thickness = thickness;
    }

    @Override
    public void setScreenSize(float screenSize) {
        androidPhone.screenSize = screenSize;
    }

    @Override
    public void setScreenWidthPixels(int width) {
        androidPhone.screenWidthPixels = width;
    }

    @Override
    public void setScreenHeightPixels(int height) {
        androidPhone.screenHeightPixels = height;
    }

    @Override
    public void setRamGb(int ram) {
        androidPhone.ramGb = ram;
    }

    @Override
    public void setInternalStorageGb(int storage) {
        androidPhone.internalStorageGb = storage;
    }

    @Override
    public void setCPU(String cpu) {
        androidPhone.CPU = cpu;
    }

    @Override
    public Phone buildPhone() {
        return new Phone(androidPhone.OS, androidPhone.modelName, androidPhone.color, androidPhone.width, androidPhone.height, androidPhone.thickness, androidPhone.screenSize, androidPhone.screenWidthPixels, androidPhone.screenHeightPixels,androidPhone.ramGb, androidPhone.internalStorageGb, androidPhone.CPU);
    }
}
