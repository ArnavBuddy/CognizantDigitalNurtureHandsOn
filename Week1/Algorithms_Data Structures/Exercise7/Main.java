import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // ---- Step 2: Recursive future value using compound growth ----
        double principal = 10000;
        double growthRate = 0.08;
        int years = 5;
        double fv = FutureValueCalculator.futureValue(principal, growthRate, years);
        System.out.println("=== Future Value Calculator ===");
        System.out.printf("FV(P=%.2f, r=%.0f%%, n=%d years) = %.2f%n%n",
                principal, growthRate * 100, years, fv);

        // ---- Step 3: Recursive prediction from past growth rates ----
        double currentValue = 50000;
        double[] pastGrowthRates = {0.05, 0.07, 0.06, 0.08, 0.09};
        double predicted = GrowthRateForecast.predict(currentValue, pastGrowthRates);
        System.out.println("=== Growth Rate Forecast ===");
        System.out.println("Year-by-year growth-based forecast:");
        GrowthRateForecast.printYearByYear(currentValue, pastGrowthRates, 0);
        System.out.printf("Predicted value after 5 years = %.2f%n%n", predicted);

        // ---- Step 4: Naive vs memoized recursion (complexity & optimization) ----
        int n = 30;
        ScenarioForecast.naiveCalls = 0;
        ScenarioForecast.memoCalls = 0;

        long startNaive = System.nanoTime();
        double naiveResult = ScenarioForecast.naiveForecast(n);
        long endNaive = System.nanoTime();

        long startMemo = System.nanoTime();
        double memoResult = ScenarioForecast.memoForecast(n, new HashMap<Integer, Double>());
        long endMemo = System.nanoTime();

        System.out.println("=== Naive vs Memoized Recursive Forecast (n = " + n + ") ===");
        System.out.printf("Naive result    = %.1f  |  calls = %d  |  time = %.3f ms%n",
                naiveResult, ScenarioForecast.naiveCalls, (endNaive - startNaive) / 1_000_000.0);
        System.out.printf("Memoized result = %.1f  |  calls = %d  |  time = %.3f ms%n",
                memoResult, ScenarioForecast.memoCalls, (endMemo - startMemo) / 1_000_000.0);
    }
}
