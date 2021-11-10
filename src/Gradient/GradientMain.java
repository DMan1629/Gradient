package Gradient;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradientMain {
	public static final int windowWidth = 800;
	public static final int windowHeight = 120;
	
	public static void main(String[] args) {
		List<Color> colors = new ArrayList<Color>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter numbers corresponding to colors.\nTo enter HEX value put \"0x\" in front, example: \"0x123abc\".\nIllegal value will end the input.");
		String input;
		int numInput;
		while (true) {
			input = scanner.next().toLowerCase();
			try {
				numInput = (int) (input.startsWith("0x") ? Long.parseLong(input.replace("0x",""),16) : Long.parseLong(input));
				if (numInput < 0) throw new Exception();
				colors.add(new Color(numInput));
			} catch (Exception e) {
				break;
			}
		}
		JFrame window = new JFrame();
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		Gradient gradient = new Gradient(colors);
		JPanel panel = new Panel(gradient,windowWidth,windowHeight,20);
		panel.setPreferredSize(new Dimension(windowWidth,windowHeight));
		window.setContentPane(panel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setTitle("Gradient");
		window.setVisible(true);
	}
}