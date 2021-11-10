package Gradient;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Gradient {
	private final List<Color> colors = new ArrayList<Color>();
	
	public Gradient(Color ... colors) {
		for (Color color : colors) if (color != null) this.colors.add(color);
	}
	
	public Gradient(List<Color> colors) {
		if (colors != null) for (Color color : colors) if (color != null) this.colors.add(color);
	}
	
	public List<Color> getGradientTextColors(int num) {
		List<Color> gradient = new ArrayList<Color>();
		if (num == 0 || this.colors.size() == 0) return gradient;
		else if (num == 1) gradient.add(this.colors.get(0));
		else if (num == 2) {
			gradient.add(this.colors.get(0));
			gradient.add(this.colors.get(this.colors.size() - 1));
		} else {
			Color current;
			Color next;
			current = num > 0 ? this.colors.get(0) : this.colors.get(this.colors.size() - 1);
			for (int i = 1; i < this.colors.size(); i++) {
				int idx = num > 0 ? i : this.colors.size() - 1 - i;
				next = this.colors.get(idx);
				gradient.addAll(gradient(current,next,num));
				current = next;
			}
			gradient.add(num > 0 ? this.colors.get(this.colors.size() - 1) : this.colors.get(0));
		}
		return gradient;
	}
	
	private List<Color> gradient(Color start, Color end, int num) {
		List<Color> gradient = new ArrayList<Color>();
		for (int i = 0; i < num; i++) {
			float ratio = (float) i / (float) num;
			int red = Math.round(end.getRed() * ratio + start.getRed() * (1 - ratio));
			int green = Math.round(end.getGreen() * ratio + start.getGreen() * (1 - ratio));
			int blue = Math.round(end.getBlue() * ratio + start.getBlue() * (1 - ratio));
			gradient.add(new Color(red,green,blue));
		}
		return gradient;
	}
}