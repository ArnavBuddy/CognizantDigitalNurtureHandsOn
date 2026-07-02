public class LinearSearch {

    public static Product linearSearch(Product[] products, int key) {

        for (Product product : products) {
            if (product.productId == key) {
                return product;
            }
        }

        return null;
    }
}