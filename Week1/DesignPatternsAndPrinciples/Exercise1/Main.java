public class Main {
    public static void main(String[] args) {
        System.out.println("--- Testing Singleton Pattern ---");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started.");
        logger2.log("User successfully logged in.");

        System.out.println("\n--- Verification ---");

        if (logger1 == logger2) {
            System.out.println("Success: Both logger1 and logger2 refer to the exact same instance.");
        } else {
            System.out.println("Failure: Different instances were created.");
        }

        System.out.println("Hash code of logger1: " + logger1.hashCode());
        System.out.println("Hash code of logger2: " + logger2.hashCode());
    }
}