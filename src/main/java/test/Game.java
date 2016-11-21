package test;

import com.florianwoelki.twodengine.AbstractGame;
import com.florianwoelki.twodengine.GameContainer;
import com.florianwoelki.twodengine.gfx.Image;
import com.florianwoelki.twodengine.gfx.Renderer;
import com.florianwoelki.twodengine.light.Light;
import com.florianwoelki.twodengine.sfx.SoundClip;

import java.awt.event.KeyEvent;

/**
 * Created by Florian Woelki on 21.11.16.
 */
public class Game extends AbstractGame {

    private Image image = new Image( "/images/test.png" );
    private Light light0 = new Light( 0xffff0000, 60 );
    private Light light1 = new Light( 0xff00ff00, 60 );
    private Light light2 = new Light( 0xff0000ff, 60 );

    public static void main( String[] args ) {
        GameContainer gc = new GameContainer( new Game() );
        gc.setWidth( 320 );
        gc.setHeight( 240 );
        gc.setScale( 3 );
        gc.start();
    }

    int x = 0;
    int y = 0;

    @Override
    public void update( GameContainer gc, float dt ) {
        if ( gc.getInput().isKey( KeyEvent.VK_UP ) ) {
            y -= dt * 150;
        } else if ( gc.getInput().isKey( KeyEvent.VK_DOWN ) ) {
            y += dt * 150;
        } else if ( gc.getInput().isKey( KeyEvent.VK_LEFT ) ) {
            x -= dt * 150;
        } else if ( gc.getInput().isKey( KeyEvent.VK_RIGHT ) ) {
            x += dt * 150;
        }

        if ( gc.getInput().isKeyPressed( KeyEvent.VK_SPACE ) ) {
            SoundClip clip = new SoundClip( "/sfx/coin_pickup.wav" );
            clip.play();
        }
    }

    @Override
    public void render( GameContainer gc, Renderer renderer ) {
        renderer.drawImage( image, 0, 0 );
        renderer.drawLight( light0, gc.getInput().getMouseX(), gc.getInput().getMouseY() );
        renderer.drawLight( light1, 50, 50 );
        renderer.drawLight( light2, 75, 50 );
    }

}
