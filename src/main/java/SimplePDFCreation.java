import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;


/**
 * Created by Attila_Toth1 on 2017-09-11.
 */

public class SimplePDFCreation {

    public static void main(String[] args) {
        System.out.println("Create a simple PDF file");

        String fileName = "MySimplePDF.pdf";

        try {
            PDDocument document = new PDDocument();

            document.addPage(new PDPage());
//            document.addPage(new PDPage());   to create one more page

            document.save(fileName);

            document.close();
            System.out.println("My first PDF file is created into: " + System.getProperty("user.dir"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
