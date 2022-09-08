import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        int filtered = 0;
        logger.log("Start filtering");
        for (int i : source) {
            if (i > threshold) {
                result.add(i);
                logger.log("Element: " + i + " has been added to the new list");
            } else {
                logger.log("Element: " + i + " filtered out");
                filtered++;
            }
        }
        logger.log("Filtered " + filtered + " elements out of " + source.size());
        return result;
    }
}