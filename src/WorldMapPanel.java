import java.awt.*;
import javax.swing.*;

public class WorldMapPanel extends JPanel {

    Image backgroundImage = new ImageIcon(getClass().getClassLoader().getResource("imgon.png")).getImage();


    @Override
    protected void paintComponent(final Graphics g) {

        g.drawImage(backgroundImage,0,0,null);
    }
}
