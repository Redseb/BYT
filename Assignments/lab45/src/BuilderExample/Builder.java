package BuilderExample;

import java.awt.*;

public interface Builder {
    public void setOS(String OS);
    public void setModelName(String modelname);
    public void setColor(Color color);
    public void setWidth(float width);
    public void setHeight(float height);
    public void setThickness(float thickness);
    public void setScreenSize(float screenSize);
    public void setScreenWidthPixels(int width);
    public void setScreenHeightPixels(int height);
    public void setRamGb(int ram);
    public void setInternalStorageGb(int storage);
    public void setCPU(String cpu);
    public Phone buildPhone();
}
