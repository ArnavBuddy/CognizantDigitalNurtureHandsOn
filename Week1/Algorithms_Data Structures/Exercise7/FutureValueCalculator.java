/**
 * Calculates the future value of an investment using a plain recursive
 * implementation of the compound growth formula:
 *
 *      FV = P * (1 + r)^n
 *
 * Recursive relation:
 *      futureValue(P, r, 0) = P
 *      futureValue(P, r, n) = futureValue(P, r, n-1) * (1 + r)
 */
public class FutureValueCalculator {

    public static double futureValue(double principal, double growthRate, int years) {
        // Base case: no more years to grow, return the value as-is
        if (years == 0) {
            return principal;
        }
        // Recursive case: grow the value from one year earlier by one more year
        return futureValue(principal, growthRate, years - 1) * (1 + growthRate);
    }
}
