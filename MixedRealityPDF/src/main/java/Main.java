import MixedRealityPDF.AnnotationProcessor.Annotations.Annotation;
import MixedRealityPDF.AnnotationProcessor.Annotations.Highlight;
import MixedRealityPDF.AnnotationProcessor.Annotations.NewLine;
import MixedRealityPDF.AnnotationProcessor.Annotations.UnderLine;
import MixedRealityPDF.DocumentProcessor.Document;
import MixedRealityPDF.ImageProcessor.ImageProcessor;
import MixedRealityPDF.PDFPenAndPaper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {


  public static void main(String[] args) throws IOException{
    String imageFilepath = "";
    String pdfFilePath = "";

    BufferedImage scanImage = ImageIO.read(new File(imageFilepath));
    ImageProcessor scan = new ImageProcessor(scanImage);
    PDDocument pdf = PDDocument.load(new File(pdfFilePath));
    Document doc = new Document(pdf);

    PDFPenAndPaper document = new PDFPenAndPaper(scan, doc.getPageImageProcessor(0));

    List<Annotation> annotationList;
    document.getAnnotations();

    List<Highlight> highLightList;
    document.getHighlights();

    List<UnderLine> underlineList;
    document.getUnderlines();

    List<NewLine> newLineList;
    document.getNewLineAnnotations();
  }
}
