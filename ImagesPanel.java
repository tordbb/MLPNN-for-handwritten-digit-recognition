
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagesPanel extends JPanel {
	
	public ImagesPanel() {
		setPreferredSize(new Dimension(710, 430));
		setBounds(0, 0, 710, 430);
	}
	
	public void paint(Graphics g) {
		BufferedImage image = Shared.recognitionWin.getImage();
		int[] rCoords = Shared.recognitionWin.getRectangleCoords();
		for (int i = 0; i < rCoords.length; i++) rCoords[i] += 50;
		boolean[][] bits = Shared.recognitionWin.getImageBits();
		if (image != null)
			g.drawImage(image, 50, 50, this);
		g.setColor(Color.BLACK);
		g.fillRect(380, 50, 280, 280);
		g.setColor(Color.WHITE);
		for (int i = 408; i < 660; i+= 28) {
			g.drawLine(i, 50, i, 330);
			g.drawLine(380, i - 330, 660, i - 330);
		}
		if (bits != null)
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < 10; j++)
					if (bits[i][j])
						g.fillRect(380 + 28*i, 50 + 28*j, 28, 28);
		if (rCoords != null) {
			g.setColor(Color.RED);
			g.drawRect(rCoords[0] - 1, rCoords[1] - 1,
				rCoords[2] - rCoords[0] + 1, rCoords[3] - rCoords[1] + 2);	
		}
	}
	
}
