/**
 * Predicts a future value by recursively applying a series of historical
 * (past) annual growth rates to a current value, one year at a time.
 *
 * Recursive relation:
 *      predict(value, rates, i) = value                                   if i == rates.length
 *      predict(value, rates, i) = predict(value * (1 + rates[i]), rates, i+1)   otherwise
 */
public class GrowthRateForecast {

    public static double predict(double currentValue, double[] pastGrowthRates, int index) {
        // Base case: every historical growth rate has been applied
        if (index == pastGrowthRates.length) {
            return currentValue;
        }
        // Recursive case: apply this year's growth rate, then move to the next year
        double grownValue = currentValue * (1 + pastGrowthRates[index]);
        return predict(grownValue, pastGrowthRates, index + 1);
    }

    /** Convenience overload so callers don't need to pass the starting index. */
    public static double predict(double currentValue, double[] pastGrowthRates) {
        return predict(currentValue, pastGrowthRates, 0);
    }

    /** Prints a year-by-year breakdown while recursing, for reporting purposes. */
    public static void printYearByYear(double currentValue, double[] pastGrowthRates, int index) {
        if (index == pastGrowthRates.length) {
            return;
        }
        double grownValue = currentValue * (1 + pastGrowthRates[index]);
        System.out.printf("  Year %d: %.2f (growth rate %.1f%%)%n",
                index + 1, grownValue, pastGrowthRates[index] * 100);
        printYearByYear(grownValue, pastGrowthRates, index + 1);
    }
}
