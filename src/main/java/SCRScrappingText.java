import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.*;

import java.io.IOException;

/**
 * Created by Attila_Toth1 on 2017-09-11.
 */
public class SCRScrappingText {
    public static void main(String[] args) throws IOException {
        PdfReader pdfReader = new PdfReader("report.pdf");

        Rectangle sideBar = new Rectangle(0, 0, 500, 100);
        Rectangle title = new Rectangle(100, 160, 50, 150);
        Rectangle interval = new Rectangle(150, 150, 100, 150);

        RenderFilter[] filter = {new RegionTextRenderFilter(interval)};
        TextExtractionStrategy strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
        String text = PdfTextExtractor.getTextFromPage(pdfReader, 5, strategy);

        System.out.println(text);

        pdfReader.close();
    }
}
