
import java.awt.Color;



/**
 *
 * @author fucalex
 */
public class Avatar {
    Maze lab=new Maze();
    int x=40;
    int y=40;
    int width=40;
    int height=40;
    int movement=40;
    
    public void paint(Graphics grafico){
        grafico.setColor(Color.red);
        grafico.fillOval(x, y, width, height);
        grafico.setColor(Color.BLACK);
        grafico.drawOval(x, y, width, height);
    }
    
    public void pressedKey(KeyEvent event){
        int[][]maze.lab.getMaze();
        
        if(event.getKeyCode()==37){//Mover a la izquierda
            if(maze[y/40][(x/40)-1]!=1){
                x=x-movement;
            }
        }
        if(event.getKeyCode()==39){//Mover a la derecha
            if(maze[y/40][(x/40)+1]!=1){
                x=x+movement;
            }
        }
        if(event.getKeyCode()==40){//Mover abajo
            if(maze[(y/40)+1][(x/40)-1]!=1){
                y=y+movement;
            }
        }
        if(event.getKeyCode()==38){//Mover arriba
            if(maze[(y/40)-1][(x/40)-1]!=1){
                y=y-movement;
            }
        }
        
        if(x==840 && y==440){
            Game.changeLevel();
            x=40;
            y=40;
        }
    }
}
