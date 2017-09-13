import org.apache.pdfbox.pdmodel.font.PDType1Font;
import rst.pdfbox.layout.elements.Document;
import rst.pdfbox.layout.elements.Paragraph;
import rst.pdfbox.layout.elements.render.VerticalLayoutHint;
//import rst.pdfbox.layout.text.Alignment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Attila_Toth1 on 2017-09-11.
 */
public class PDFCreationWithAlignedText {
    public static void main(String[] args) {
        System.out.println("Create a PDF file with text, and aligned");

        String fileName = "MyPDFWithAlignedText.pdf";

        try {
            Document document = new Document(40, 60, 40, 60);

            Paragraph paragraph = new Paragraph();

            paragraph.addText("This is some left aligned text", 11, PDType1Font.HELVETICA);
//            paragraph.setAlignment(Alignment.Left);
            document.add(paragraph, VerticalLayoutHint.LEFT);

            final OutputStream outputStream = new FileOutputStream(fileName);
            document.save(outputStream);

            System.out.println("My second PDF file is created into: " + System.getProperty("user.dir"));

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
