package util;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ColorMap {
    static Map<Integer, Color> colorMap = new HashMap<>();

    //todo: complete the method to add other color
    public static void InitialColorMap() {
        colorMap.put(0, new Color(205, 194, 181));
        colorMap.put(2, new Color(238, 226, 213));
        colorMap.put(4, new Color(238, 222, 197));
        colorMap.put(8, new Color(238, 178, 115));
        colorMap.put(16, new Color(246, 149, 98));
        colorMap.put(32, new Color(246, 125, 90));
        colorMap.put(64, new Color(246, 93, 49));
        colorMap.put(128, new Color(244, 121, 63));
        colorMap.put(256, new Color(242, 149, 77));
        colorMap.put(512, new Color(240, 177, 91));
        colorMap.put(1024, new Color(238, 206, 106));
        colorMap.put(2048, new Color(235, 239, 77));

    }

    public static Color getColor(int i) {
        return colorMap.getOrDefault(i, Color.black);
    }
}
