package entities;

public class Item {

    private String productName;
    private String quantity;
    private String usPrice;
    private String comment;
    private String shipDate;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUsPrice() {
        return usPrice;
    }

    public void setUsPrice(String usPrice) {
        this.usPrice = usPrice;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }


}
