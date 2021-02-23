package Tank;

import java.awt.image.BufferedImage;

public class Texture {
    SpriteSheet ss;
    private BufferedImage explosion_sheet = null;

    public BufferedImage[] explosion = new BufferedImage[16];
    public Texture(){
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            explosion_sheet = loader.loadImage("/Images/explosion.png");

        }catch (Exception e){
            e.printStackTrace();
        }

        ss = new SpriteSheet(explosion_sheet);

        getTextures();

    }

    private void getTextures(){
        explosion[0] = ss.grabImage(1, 1, 64, 64 );
        explosion[1] = ss.grabImage(2, 1, 64, 64 );
        explosion[2] = ss.grabImage(3, 1, 64, 64 );
        explosion[3] = ss.grabImage(4, 1, 64, 64 );
        explosion[4] = ss.grabImage(1, 2, 64, 64 );
        explosion[5] = ss.grabImage(2, 2, 64, 64 );
        explosion[6] = ss.grabImage(3, 2, 64, 64 );
        explosion[7] = ss.grabImage(4, 2, 64, 64 );
        explosion[8] = ss.grabImage(1, 3, 64, 64 );
        explosion[9] = ss.grabImage(2, 3, 64, 64 );
        explosion[10] = ss.grabImage(3, 3, 64, 64 );
        explosion[11] = ss.grabImage(4, 3, 64, 64 );
        explosion[12] = ss.grabImage(1, 4, 64, 64 );
        explosion[13] = ss.grabImage(2, 4, 64, 64 );
        explosion[14] = ss.grabImage(3, 4, 64, 64 );
        explosion[15] = ss.grabImage(4, 4, 64, 64 );
    }
}
