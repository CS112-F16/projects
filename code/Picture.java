/**
 * Staring Point Code for Image Processing Project
 * @author Richard Wicentowski and Tia Newhall (2005)
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Picture {

	public static int COLOR = BufferedImage.TYPE_INT_RGB;
	public static int GRAY = BufferedImage.TYPE_BYTE_GRAY;

	protected static int defaultImageType = BufferedImage.TYPE_INT_RGB;

	protected int imageType;
	protected BufferedImage bufferedImage;
	protected WritableRaster raster;

	public Picture() { 
		imageType = defaultImageType;
		bufferedImage = null;
		raster = null;
	}

	public Picture(int width, int height) {
		this(width, height, defaultImageType);
	}

	public Picture(int width, int height, int type) {
		bufferedImage = new BufferedImage(width, height, type);
		raster = bufferedImage.getRaster();
		imageType = type;
	}

	public Picture(String filename) {
		this(filename, defaultImageType);
	}

	public Picture(String filename, int type) {
		if ((type != COLOR) && (type != GRAY)) { type = defaultImageType; }
		imageType = type;
		load(filename);
	}

	public int getImageType() { return imageType; }

	public int getWidth() { return bufferedImage.getWidth(); }
	public int getHeight() { return bufferedImage.getHeight(); }

	public BufferedImage getBufferedImage() { return bufferedImage; }
	public WritableRaster getRaster() { return raster; }

	public void load(String filename) {
		ImageIcon icon = new ImageIcon(filename);
		Image image = icon.getImage();
		bufferedImage = new BufferedImage(image.getWidth(null),
				image.getHeight(null),
				imageType);
		Graphics g = bufferedImage.getGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		raster = bufferedImage.getRaster();
	}

	
	public Pixel getPixel(int x, int y) {
		int[] pixelArray = null;

		try {
			pixelArray = raster.getPixel(x, y, pixelArray); 
		} catch (Exception e) {
			System.out.println("("+x+", "+y+") out of bounds.");
			System.exit(1);
		}

		Pixel pixel = new Pixel(pixelArray);

		return pixel;
	}


	public void setPixel(int x, int y, Pixel pixel) {
		int[] pixelArray = pixel.getComponents();

		try {
			raster.setPixel(x, y, pixelArray);
		} catch (Exception e) {
			System.out.println("("+x+", "+y+") out of bounds.");
			System.exit(1);
		}
	}

	public void store(String filename) {
		try {
			ImageIO.write(bufferedImage, "GIF", new File(filename));
		} catch (IOException e) {
			System.out.println("Unable to open file: " + filename);
			System.exit(1);
		}
	}


}