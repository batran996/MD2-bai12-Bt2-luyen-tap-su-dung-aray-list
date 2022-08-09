import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> listProduct;

    public ProductManager() {
        this.listProduct = new ArrayList<>();
    }

    public int addpProduct(Product p) {
        this.listProduct.add(p);
        return this.listProduct.size();
    }

    public int count() {
        return this.listProduct.size();
    }

    public Product getProduct(int index) {
        if (index < 0 || index > this.count()) {
            return null;
        }
        return this.listProduct.get(index);
    }

    public boolean removeProduct(int id) {
        int index = -1;
        for (int i = 0; i < count(); i++) {
            if (this.listProduct.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            listProduct.remove(index);
            return true;
        }
        return false;
    }


}
