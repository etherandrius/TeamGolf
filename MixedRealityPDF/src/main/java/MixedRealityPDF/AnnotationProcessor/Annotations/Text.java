package MixedRealityPDF.AnnotationProcessor.Annotations;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public final class Text extends Annotation {

    private final float width;
    private final float height;
    private final BufferedImage image;

    public Text(BufferedImage image, float x, float y, float width, float height, int pageNumber){
        super(x, y, pageNumber);
        this.image = image;
        this.width = width;
        this.height = height;
    }

    public Text(BufferedImage image, Point2D.Float p, float width, float height, int pageNumber){
        super(p.x, p.y, pageNumber);
        this.image = image;
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
        //TODO: Implement
    }
}





