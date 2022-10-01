
import java.io.*;

import java.util.Scanner;

public class XmlReader {

    private String xmlOutput;


    XmlReader(String path) throws FileNotFoundException {
        try {
            Scanner scanner = new Scanner(new FileInputStream(path));
            while (scanner.hasNextLine()) {
                this.xmlOutput = this.xmlOutput+scanner.nextLine();
                this.xmlOutput=this.xmlOutput+"\n";
            }
            scanner.close();
        } catch (FileNotFoundException ex) {

        }


    }


    public String getXmlOutput() {
        return xmlOutput;
    }
}
