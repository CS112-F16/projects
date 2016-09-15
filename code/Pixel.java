/**
 * Staring Point Code for Image Processing Project
 * @author Richard Wicentowski and Tia Newhall (2005)
 */

public class Pixel {

	protected int[] component;

	Pixel() { this (0,0,0); }

	Pixel(int gray) {
		component = new int[1];
		component[0] = gray;
	}

	Pixel(int r, int g, int b) {
		component = new int[3];
		component[0] = r;
		component[1] = g;
		component[2] = b;
	}

	Pixel(int[] c) {
		component = new int[c.length];
		for (int i = 0; i < c.length; i++) {
			component[i] = c[i];
		}
	}

	public void info() {
		for (int i = 0; i < component.length; i++) {
			System.out.print(component[i] + "\t");
		}
		System.out.println();
	}

	public void toBlack() {
		for (int i = 0; i < component.length; i++) { component[i] = 0; }
	}

	public void toWhite() {
		for (int i = 0; i < component.length; i++) { component[i] = 255; }
	}

	public int getRed() { 
		return component[0];
	}

	public int getGreen() { 
		return component[1];
	}

	public int getBlue() { 
		return component[2];
	}

	public int getGray() {
		return component[0];
	}

	public void setRed(int red) { 
		if (red < 0) { red = 0; } else if (red > 255) { red = 255; }
		component[0] = red;
	}

	public void setGreen(int green) { 
		if (green < 0) { green = 0; } else if (green > 255) { green = 255; }
		component[1] = green;
	}

	public void setBlue(int blue) { 
		if (blue < 0) { blue = 0; } else if (blue > 255) { blue = 255; }
		component[2] = blue;
	}

	public void setGray(int gray) {
		component[0] = gray;
	}

	public int[] getComponents() {
		return component;
	}

	public String toString() {
		String s = "";
		for (int k = 0; k < component.length; k++) {
			if (k != 0) { s += "\t"; }
			s += component[k];
		}
		return s;
	}

	public boolean isSimilar(Pixel other) {
		int threshold = 30;
		if((Math.abs(component[0] - other.component[0]) > threshold) ||
			(Math.abs(component[1] - other.component[1]) > threshold) ||
			(Math.abs(component[2] - other.component[2]) > threshold)) {
			return false;
		}
		return true;

	}

	public boolean equals (Object other) {
		if (other instanceof Pixel) {
			Pixel o = (Pixel)other;
			if (o.component.length != component.length) {
				return false; 
			} else {
				for (int k = 0; k < component.length; k++) {
					if (o.component[k] != component[k]) {
						return false;
					}
				}
				return true;
			}
		} else {
			return false;
		}
	}

}