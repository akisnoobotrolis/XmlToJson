import entities.PurchaseOrder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Type the path of the XML file ");
        Scanner scanner = new Scanner(System.in);
        String inputPath = scanner.nextLine();
        String outPutPath=inputPath.substring(0, inputPath.length()-3)+"json";

       String xmlOutput=readXml(inputPath);
        PurchaseOrder purchaseOrder=new PurchaseOrder(xmlOutput);
        JsonConvert jsonConvert=new JsonConvert(purchaseOrder);

        writeJson(jsonConvert.getOutput(),outPutPath);




    }

    private static void writeJson(String input, String path) {

        File file = new File(path);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(input);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("xml to json completed");
    }

    private static String readXml(String path){

        String xmlOutput=null;

        try {

            XmlReader xmlReader = new XmlReader(path);
            xmlOutput=xmlReader.getXmlOutput();

        } catch (FileNotFoundException e) {
            System.out.println("path " + path + " was not correct");
        }
        return xmlOutput;
    }



}
