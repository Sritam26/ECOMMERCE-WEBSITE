package Products;

public class Product {
    private String Product_id;
    private String Product_name;
    private double Price;
    private String Description;
    private String Photo_url;
    private int Quantity;
    private String Category;

    // Constructor (optional)
    public Product() {}

    // Getters and Setters

    public String getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(String Product_id) {
        this.Product_id = Product_id;
    }

    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String Product_name) {
        this.Product_name = Product_name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getPhoto_url() {
        return Photo_url;
    }

    public void setPhoto_url(String Photo_url) {
        this.Photo_url = Photo_url;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }
}