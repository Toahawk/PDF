import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * Created by Attila_Toth1 on 2017-09-13.
 */
public class PDFCreationWithText {
    public static void main(String[] args) throws COSVisitorException {
        System.out.println("Create a simple PDF file with text");

        String fileName = "MyPDFWithText.pdf";

        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();

            document.addPage(page);
//            document.addPage(new PDPage());   to create one more page

            PDPageContentStream content = new PDPageContentStream(document, page);

            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 26);
            content.moveTextPositionByAmount(250, 750);
            content.drawString("My first PDF with text!");
            content.endText();

            content.close();
            document.save(fileName);

            document.close();
            System.out.println("My first PDF file is created into: " + System.getProperty("user.dir"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
