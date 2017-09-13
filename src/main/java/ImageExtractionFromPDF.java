import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ImageExtractionFromPDF {
    public static void main(String[] args) throws Exception{
        PDDocument document = null;
        document = PDDocument.load("proba2.pdf");
        List pages = document.getDocumentCatalog().getAllPages();
        Iterator iter = pages.iterator();
        int i = 0;
        while (iter.hasNext()) {
            PDPage page = (PDPage) iter.next();
            PDResources resources = page.findResources();
            Map pageImages = resources.getImages();
            if (pageImages != null) {
                Iterator imageIter = pageImages.keySet().iterator();
                while (imageIter.hasNext()) {
                    String key = (String) imageIter.next();
                    PDXObjectImage image = (PDXObjectImage) pageImages.get(key);
                    FileOutputStream out = new FileOutputStream(new File(new File("proba2.pdf").getParentFile(), String.format("%1$05d", i) + ".gif"));
                    image.write2OutputStream(out);
                    i++;
                }
            }
        }
    }
}
