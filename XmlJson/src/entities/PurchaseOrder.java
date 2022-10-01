package entities;

import entities.Address;
import entities.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PurchaseOrder {

    private String deliveryNotes;

    private List<Address> addressList;
    private List<Item> itemList;


    public PurchaseOrder(String xmlOutput) {
        addressList = new ArrayList<>();
        itemList = new ArrayList<>();
        String trimmedStr = null;
        String str = null;
        String substr = null;
        Scanner scanner = new Scanner(xmlOutput);
        str = scanner.nextLine();

        int latestAddressIndex = -1;
        int latestItemIndex = -1;
        while (!str.contains("</PurchaseOrder>")) {
            str = scanner.nextLine();
            if (str.contains("<Address Type")) {
                addressList.add(new Address());
                latestAddressIndex++;
                for (int i = 0; i < 6; i++) {
                    str = scanner.nextLine();
                    trimmedStr = str.trim();

                    if (trimmedStr.contains("<Name>")) {


                        substr = trimmedStr.substring(6, trimmedStr.length() - 7);

                        addressList.get(latestAddressIndex).setName(substr);

                    }
                    if (trimmedStr.contains("<Street>")) {
                        substr = trimmedStr.substring(8, trimmedStr.length() - 9);

                        addressList.get(latestAddressIndex).setStreet(substr);
                    }

                    if (trimmedStr.contains("<City>")) {
                        substr = trimmedStr.substring(6, trimmedStr.length() - 7);

                        addressList.get(latestAddressIndex).setCity(substr);
                    }
                    if (trimmedStr.contains("<State>")) {
                        substr = trimmedStr.substring(7, trimmedStr.length() - 8);
                        addressList.get(latestAddressIndex).setState(substr);

                    }
                    if (trimmedStr.contains("<Zip>")) {
                        substr = trimmedStr.substring(5, trimmedStr.length() - 6);
                        addressList.get(latestAddressIndex).setZip(substr);

                    }
                    if (trimmedStr.contains("<Country>")) {
                        substr = trimmedStr.substring(9, trimmedStr.length() - 10);
                        addressList.get(latestAddressIndex).setCountry(substr);

                    }
                }
            }
            if (str.contains("<DeliveryNotes>")) {
                trimmedStr = str.trim();
                this.deliveryNotes = trimmedStr.substring(15, trimmedStr.length() - 16);

            }

            if (str.contains("<Item PartNumber")) {
                itemList.add(new Item());
                latestItemIndex++;
                for (int i = 0; i < 5; i++) {
                    str = scanner.nextLine();
                    trimmedStr = str.trim();

                    if (str.contains("<ProductName>")) {
                        substr = trimmedStr.substring(13, trimmedStr.length() - 14);
                        itemList.get(latestItemIndex).setProductName(substr);

                    }
                    if (str.contains("<Quantity>")) {
                        substr = trimmedStr.substring(10, trimmedStr.length() - 11);
                        itemList.get(latestItemIndex).setQuantity(substr);

                    }

                    if (str.contains("<USPrice>")) {
                        substr = trimmedStr.substring(9, trimmedStr.length() - 10);
                        itemList.get(latestItemIndex).setUsPrice(substr);

                    }
                    if (str.contains("<ShipDate>")) {
                        substr = trimmedStr.substring(10, trimmedStr.length() - 11);
                        itemList.get(latestItemIndex).setShipDate(substr);

                    }
                    if (str.contains("<Comment>")) {
                        substr = trimmedStr.substring(9, trimmedStr.length() - 10);
                        itemList.get(latestItemIndex).setComment(substr);

                    }

                }


            }
        }
    }

    public String getDeliveryNotes() {
        return deliveryNotes;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public List<Item> getItemList() {
        return itemList;
    }


}







