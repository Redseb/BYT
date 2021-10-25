package BuilderExample;

import java.awt.*;

public class Director {
    public Phone makeCheapPhone(Builder apb){
        apb.setCPU("Snapdragon 5");
        apb.setHeight(11.5f);
        apb.setWidth(12.6f);
        apb.setInternalStorageGb(16);
        apb.setRamGb(2);
        apb.setModelName("Xiaomi phone thing");
        apb.setOS("Android 15");
        apb.setScreenWidthPixels(1080);
        apb.setScreenHeightPixels(1920);
        apb.setColor(Color.red);

        return apb.buildPhone();
    }

    public Phone makeExpensivePhone(Builder apb){
        apb.setCPU("A18");
        apb.setHeight(12.0f);
        apb.setWidth(15.2f);
        apb.setInternalStorageGb(512);
        apb.setRamGb(8);
        apb.setModelName("XR MAX");
        apb.setOS("18");
        apb.setScreenWidthPixels(4000);
        apb.setScreenHeightPixels(2000);
        apb.setColor(Color.white);

        return apb.buildPhone();
    }
}
