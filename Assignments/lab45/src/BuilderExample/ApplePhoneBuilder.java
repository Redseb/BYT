package BuilderExample;

import java.awt.*;

public class ApplePhoneBuilder implements Builder{
    Phone applePhone;

    public ApplePhoneBuilder(){
        this.applePhone = new Phone();
    }

    @Override
    public void setOS(String OS) {
        if(OS.contains("iOS")){
            applePhone.OS = OS;
        } else {
            applePhone.OS = "iOS " + OS;
        }
    }

    @Override
    public void setModelName(String modelname) {
        if(modelname.contains("iPhone")){
            applePhone.modelName = modelname;
        } else {
            applePhone.modelName = "iPhone " + modelname;
        }
    }

    @Override
    public void setColor(Color color) {
        applePhone.color = color;
    }

    @Override
    public void setWidth(float width) {
        applePhone.width = width;
    }

    @Override
    public void setHeight(float height) {
        applePhone.height = height;
    }

    @Override
    public void setThickness(float thickness) {
        applePhone.thickness = thickness;
    }

    @Override
    public void setScreenSize(float screenSize) {
        applePhone.screenSize = screenSize;
    }

    @Override
    public void setScreenWidthPixels(int width) {
        applePhone.screenWidthPixels = width;
    }

    @Override
    public void setScreenHeightPixels(int height) {
        applePhone.screenHeightPixels = height;
    }

    @Override
    public void setRamGb(int ram) {
        applePhone.ramGb = ram;
    }

    @Override
    public void setInternalStorageGb(int storage) {
        applePhone.internalStorageGb = storage;
    }

    @Override
    public void setCPU(String cpu) {
        if(cpu.contains("A")){
            applePhone.CPU = cpu;
        } else {
            applePhone.CPU = "A"+cpu;
        }
    }

    @Override
    public Phone buildPhone() {
        return new Phone(applePhone.OS, applePhone.modelName, applePhone.color, applePhone.width, applePhone.height, applePhone.thickness, applePhone.screenSize, applePhone.screenWidthPixels, applePhone.screenHeightPixels,applePhone.ramGb, applePhone.internalStorageGb, applePhone.CPU);
    }
}
