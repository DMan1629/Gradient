package Gradient;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Panel extends JPanel {
	private final Gradient gradient;
	private final int windowWidth;
	private final int windowHeight;
	private final int height;
	
	public Panel(Gradient gradient, int windowWidth, int windowHeight, int height) {
		this.gradient = gradient;
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.height = height < 0 ? 20 : height;
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		setBackground(Color.WHITE);
		List<Color> colors = this.gradient.getGradientTextColors(1024);
		float width = (this.windowWidth - 100f) / colors.size();
		int y = (this.windowHeight - this.height) / 2;
		for (int j = 0; j < colors.size(); j++) {
			int x = Math.round(50 + j * width);
			graphics.setColor(colors.get(j));
			graphics.drawRect(x,y,Math.round(width),this.height);
			graphics.fillRect(x,y,Math.round(width),this.height);
		}
	}
}