import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;

import java.io.FileInputStream;

/**
 * Created by Attila_Toth1 on 2017-09-11.
 */
public class PDFCreationWithImage {
    public static void main(String[] args) {
        String fileName = "pdfWithImage.pdf";
        String imageName = "epam.jpg";

        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();

            document.addPage(page);

            PDXObjectImage image = new PDJpeg(document, new FileInputStream(imageName));

            PDPageContentStream content = new PDPageContentStream(document, page);

            content.drawImage(image, 100, 600);

            content.close();

            document.save(fileName);

            document.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
