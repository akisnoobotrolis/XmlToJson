import entities.Address;
import entities.Item;
import entities.PurchaseOrder;

public class JsonConvert {

    private String output;

    public JsonConvert(PurchaseOrder purchaseOrder) {



        output = "{\n" + "\"PurchaseOrder\": {\n" + "\"Address\":";
        if (purchaseOrder.getAddressList().size() > 1) {
            output = output + "[\n";
            for (Address address : purchaseOrder.getAddressList()) {
                output = output + "{\n\"Name\":\"" +  address.getName() + "\",\n" +
                        "\"Street\":\"" + address.getStreet() + "\",\n" +
                        "\"City\":\"" + address.getCity() +  "\",\n" +
                        "\"State\":\"" + address.getState() +  "\",\n" +
                        "\"Zip\":\"" + address.getZip() +  "\",\n" +
                        "\"Country\":\"" + address.getCountry() +  "\"\n" ;
                if(address == purchaseOrder.getAddressList().get(purchaseOrder.getAddressList().size() - 1)) {
                    output = output+ "}\n";
                }
                else {
                    output = output+ "},\n";
                }
            }
            output = output + "],\n";
        } else if (purchaseOrder.getAddressList().size() == 1) {
            for (Address address : purchaseOrder.getAddressList()) {
                output = output + "{\n\"Name\":\"" +  address.getName() + "\",\n" +
                        "\"Street\":\"" + address.getStreet() + "\",\n" +
                        "\"City\":\"" + address.getCity() +  "\",\n" +
                        "\"State\":\"" + address.getState() +  "\",\n" +
                        "\"Zip\":\"" + address.getZip() +  "\",\n" +
                        "\"Country\":\"" + address.getCountry() +  "\"\n" +
                        "}\n";
            }
        }
        output = output + "\"DeliveryNotes\":" + "\"" + purchaseOrder.getDeliveryNotes() + "\",\n";
        if (purchaseOrder.getItemList().size() > 1) {
            output = output + "\"Item\":";
            output = output + "[\n";

            for (Item item : purchaseOrder.getItemList()) {
                output = output + "{\n\"ProductName\":\"" + item.getProductName() + "\",\n" +
                        "\"Quantity\":\"" + item.getQuantity() + "\",\n" +
                        "\"USPrice\":\"" + item.getUsPrice() + "\",\n" +
                        "\"ShipDate\":\"" + item.getShipDate() + "\",\n" +
                        "\"Comment\":\"" + item.getComment() + "\"\n" ;
                if(item == purchaseOrder.getItemList().get(purchaseOrder.getItemList().size() - 1)) {
                    output = output+ "}\n";
                }
                else {
                    output = output+ "},\n";
                }
            }
            output = output + "]\n";
        } else if (purchaseOrder.getItemList().size() == 1) {
            for (Item item : purchaseOrder.getItemList()) {
                output = output + "\"ProductName\":\"" + item.getProductName() + "\",\n" +
                        "\"Quantity\":\"" + item.getQuantity() + "\",\n" +
                        "\"USPrice\":\"" + item.getUsPrice() + "\",\n" +
                        "\"ShipDate\":\"" + item.getShipDate() + "\",\n" +
                        "\"Comment\":\"" + item.getComment() + "\"\n" +

                        "}\n";
            }
        }

        output=output+"}\n}\n";
    }


    public String getOutput() {
        return output;
    }
}
