import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GradientGenerator {

    public static List<Color> generateGradient(Color startColor, Color endColor, int steps) {
        List<Color> gradientColors = new ArrayList<>();

        int startRed = startColor.getRed();
        int startGreen = startColor.getGreen();
        int startBlue = startColor.getBlue();

        int endRed = endColor.getRed();
        int endGreen = endColor.getGreen();
        int endBlue = endColor.getBlue();

        for (int i = 0; i < steps; i++) {
            float ratio = (float) i / (steps - 1);
            int red = (int)(startRed + ratio * (endRed - startRed));
            int green = (int)(startGreen + ratio * (endGreen - startGreen));
            int blue = (int)(startBlue + ratio * (endBlue - startBlue));

            gradientColors.add(new Color(red, green, blue));
        }

        return gradientColors;
    }
}