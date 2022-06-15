


import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author fucalex
 */
public class Game extends JPanel{
    Maze maze=new Maze();
    Avatar avatar=new Avatar();
    public static int level=1;
        
    public  Game(){
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                avatar.teclaPresionada(e);
            }
        
             @Override
            public void keyReleased(KeyEvent e) {
            
            }
        
    });
        setFocusable(true);
    }

    public void paint(Graphics grafico){
        maze.paint(grafico);
        avatar.paint(grafico);
    }

    public static int changeLevel(){
        return level++;
    }

    public static int getLevel(){
        return level;
    }
    

    public static void main(String[]args){
       JOptionPane.showMessageDialog(null, "ready?");
       JFrame myWindow=new JFrame("Avatar Run");
       Game game =new Game();
       myWindow.add(game);
       myWindow.setSize(920,540);
       myWindow.setLocation(300,200);
       myWindow.setVisible(true);
       myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       while (true){
           try {
               Thread.sleep(10);
        } catch (InterruptedException ex) {
             Logger.getLogger(Game.class.getName()).log(Level.SEVERE, "you lose");
        }
        game.repaint();   

        if(getLevel()>3){
            JOptionPane.showMessageDialog(null, "you did it! see you soon.");
            System.exit(0);
            }
        }
    }
}



