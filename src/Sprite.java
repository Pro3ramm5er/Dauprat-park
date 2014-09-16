
import java.awt.Graphics;
import java.awt.Image;

public class Sprite {
     private Image image;
     
     public Sprite(Image image)
     {
    	 this.image = image;
     }
     
     public int Spr_get_Width()
     {
    	 return image.getWidth(null);
    	 
     }
     
     public int getHeight() {
    	 return image.getHeight(null);
     }
     public void draw(Graphics g,int x,int y) { //рисуем картинку
         g.drawImage(image,x,y,null);
     }


}
