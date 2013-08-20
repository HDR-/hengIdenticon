/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Heng;

import com.docuverse.identicon.IdenticonRenderer;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.math.BigInteger;

/**
 *
 * @author hdr
 */
public class MyIdenticonRenderer implements IdenticonRenderer{

    @Override
    public BufferedImage render(int code, int size) {
        
        //initial setup
        BufferedImage targetImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
	Graphics2D g = targetImage.createGraphics();

        
        int rotation=(0x3&code);
        //obtain color       
        Color color1=new Color((int)(255/((((0x3<<2)&code)>>>2)+1)),(int)(255/((((0x3<<4)&code)>>>4)+1)),(int)(255/((((0x3<<6)&code)>>>6)+1)));
        Color color2=new Color((int)(255/((((0x3<<8)&code)>>>8)+1)),(int)(255/((((0x3<<10)&code)>>>10)+1)),(int)(255/((((0x3<<12)&code)>>>12)+1)));
        Color color3=new Color((int)(255/((((0x3<<14)&code)>>>14)+1)),(int)(255/((((0x3<<16)&code)>>>16)+1)),(int)(255/((((0x3<<18)&code)>>>18)+1)));
        Color color4=new Color((int)(255/((((0x3<<20)&code)>>>20)+1)),(int)(255/((((0x3<<22)&code)>>>22)+1)),(int)(255/((((0x3<<24)&code)>>>24)+1)));
        Color color5=new Color((int)(255/((((0x3<<26)&code)>>>26)+1)),(int)(255/((((0x3<<28)&code)>>>28)+1)),(int)(255/((((0x3<<30)&code)>>>30)+1)));
         
        //rorate
        g.rotate(Math.toRadians(rotation*90),size/2,size/2);
        
        //paint
        g.setColor(color1);
        g.fillRect(0, 0, size, size/5+1);
        g.setColor(color2);
        g.fillRect(0, size/5+1, size, size/5*2);
        g.setColor(color3);
        g.fillRect(0, size/5*2+1, size, size/5*3);
        g.setColor(color4);
        g.fillRect(0, size/5*3+1, size, size/5*4);
        g.setColor(color5);
        g.fillRect(0, size/5*4+1, size, size);
                
        g.dispose();
        
	return targetImage;
    }

    @Override
    public BufferedImage render(BigInteger code, int size) {
        return render(code.intValue(),size);
    }
    
}
