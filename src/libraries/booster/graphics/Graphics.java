package libraries.booster.graphics;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Graphics {
    public static Image rotate(Image image, double rotateStrong, int size) {
        ImageView imageView = new ImageView(image);
        imageView.setRotate(rotateStrong);
        SnapshotParameters sp = new SnapshotParameters();
        sp.setViewport(new Rectangle2D(0, 0, size, size));
        sp.setFill(Color.TRANSPARENT);
        return imageView.snapshot(sp, new WritableImage(size, size));
    }


    public static Image rotate(Image image, double rotateStrong) {
        return rotate(image, rotateStrong, (int) image.getWidth());
    }
}
