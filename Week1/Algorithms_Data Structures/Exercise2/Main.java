import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Product[] products = {
                new Product(103, "Laptop", "Electronics"),
                new Product(101, "Shoes", "Fashion"),
                new Product(105, "Mobile", "Electronics"),
                new Product(102, "Watch", "Accessories"),
                new Product(104, "Book", "Education")
        };

        // Linear Search
        System.out.println("Linear Search:");

        Product result = LinearSearch.linearSearch(products, 102);

        if (result != null)
            result.display();
        else
            System.out.println("Product Not Found");

        // Sort array for Binary Search
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        System.out.println("\nBinary Search:");

        Product result2 = BinarySearch.binarySearch(products, 102);

        if (result2 != null)
            result2.display();
        else
            System.out.println("Product Not Found");
    }
}