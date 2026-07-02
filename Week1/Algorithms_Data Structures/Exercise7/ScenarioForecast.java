import java.util.HashMap;
import java.util.Map;

/**
 * A recursive forecasting model in which the projected value at period n
 * depends on the two preceding periods:
 *
 *      F(0) = 100.0   (base index value)
 *      F(1) = 105.0   (first observed value)
 *      F(n) = F(n-1) + F(n-2)     for n >= 2
 *
 * This mirrors how naive multi-period recursive forecasts are often written:
 * each period's projection is built directly from earlier projections.
 * Implemented naively, the same sub-forecast gets recomputed many times.
 * A memoized version fixes this by caching each period's result.
 */
public class ScenarioForecast {

    // Counters so we can report how many recursive calls each version makes
    public static long naiveCalls = 0;
    public static long memoCalls = 0;

    /** Naive recursion: recomputes overlapping sub-forecasts repeatedly. */
    public static double naiveForecast(int n) {
        naiveCalls++;
        if (n == 0) return 100.0;
        if (n == 1) return 105.0;
        return naiveForecast(n - 1) + naiveForecast(n - 2);
    }

    /** Optimized recursion: memoized (top-down dynamic programming). */
    public static double memoForecast(int n, Map<Integer, Double> memo) {
        memoCalls++;
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        double result;
        if (n == 0) {
            result = 100.0;
        } else if (n == 1) {
            result = 105.0;
        } else {
            result = memoForecast(n - 1, memo) + memoForecast(n - 2, memo);
        }
        memo.put(n, result);
        return result;
    }

    public static double memoForecast(int n) {
        return memoForecast(n, new HashMap<>());
    }
}
