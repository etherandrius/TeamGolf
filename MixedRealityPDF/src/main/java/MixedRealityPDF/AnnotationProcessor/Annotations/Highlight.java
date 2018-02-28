package MixedRealityPDF.AnnotationProcessor.Annotations;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup;

import java.io.IOException;
import java.util.List;

public final class Highlight extends Annotation {

  private final float width;
  private final float height;

  public Highlight(float x, float y, float width, float height, int pageNumber){
    super(x, y, pageNumber);
    this.width = width;
    this.height = height;
  }

  public float getWidth() {
    return width;
  }

  public float getHeight() {
    return height;
  }

  @Override
  public void applyAnnotation(PDPage doc) throws IOException{
    List<PDAnnotation> ann = doc.getAnnotations();
    PDAnnotationTextMarkup highlight;
    highlight = new PDAnnotationTextMarkup(
            PDAnnotationTextMarkup.SUB_TYPE_HIGHLIGHT);
    highlight.setColor(super.YELLOW);

    PDRectangle position = new PDRectangle();
    position.setLowerLeftX(getX());
    position.setLowerLeftY(getY());
    position.setUpperRightX(getX()+getWidth());
    position.setUpperRightY(getY()+getHeight());
    highlight.setRectangle(position);
    float[] quads = super.getQuads(position);
    highlight.setQuadPoints(quads);

    ann.add(highlight);
  }
}





