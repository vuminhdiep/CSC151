package javabook; 

import java.awt.*;

public class DrawingBoard extends MainWindow
{
    private Graphics g;
    private Image buffer_image;

    public DrawingBoard()
    {
       this("D R A W I N G   B O A R D");
    }

    public DrawingBoard(String title)
    {
        super(title);
        setResizable(false);
        setBackground(Color.white);
    }

    public void setVisible(boolean view)
    {
        super.setVisible(view);
        if (view) {
           buffer_image = createImage(getSize().width,getSize().height);
           g = buffer_image.getGraphics();
        }
    }

    public void show()
    {
        super.show();
        buffer_image = null;
        while (buffer_image == null)
        {
           buffer_image = createImage(getSize().width,getSize().height);
        }
        g = buffer_image.getGraphics();
    }

    public void setColor(Color c)
    {
        g.setColor(c);
    }
    
    public Color getColor()
    {
    	return g.getColor();
    }

    public void drawLine(int x1, int x2, int y1, int y2)
    {
        g.drawLine(x1,x2,y1,y2);
        repaint();
    }

    public void drawRectangle(int x, int y, int width, int height)
    {
        g.drawRect(x,y,width,height);
        repaint();
    }

    public void drawRectangle(Rectangle rect)
    {
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
        repaint();
    }

    public void drawCircle(int x, int y, int radius)
    {
        g.drawOval(x-radius,y-radius,2*radius,2*radius);
        repaint();
    }

    public void paint(Graphics real_g)
    {
    	super.paint(real_g);
    	real_g.drawImage(buffer_image, 0, 0, null);
    }
}

