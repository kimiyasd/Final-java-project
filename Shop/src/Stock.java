import java.util.ArrayList;

public class Stock {
    public Stock() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    private static ArrayList<Product> products;

    public static Product getProduct(String name) {
        for (Product product : products) {
            String pname = product.getName();
            if (pname.toLowerCase().equals(name.toLowerCase())) {
                return product;
            }
        }
        return null;
    }
    public static void addProduct(Product product) {
        products.add(product);
    }

}
