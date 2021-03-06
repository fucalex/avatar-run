
import java.awt.Color;
import java.awt.Graphics;

/**
 * MAZE (Laberinto)
 * En este archivo definimos la forma del laberinto y los niveles de juego. 
 * Inicialmente se definen la cantidad de filas y columnas donde se formará el 
 * laberinto, asi como las dimensiones de los bloques que rellenaran las 
 * intersecciones fila/columna
 * @author fucalex
 * 
 */
public class Maze {
    int[][]lab=new int[13][23];
    int row=0;
    int col=0;
    int rownumber=13;
    int colnumber=23;
    int blockwidth=40;
    int blockheight=40;
    
    /**
    * Definicion de colores de fondo para los laberintos segun nivel
    * con el fin de ayudar a diferenciar el paso por los multiples niveles.
    */
    
    public void paint(Graphics grafico){
        int [][]maze=getMaze();
        
        for(row=0;row<rownumber;row++){
            for(col=0;col<colnumber;col++){
                if(maze[row][col]==1){
                    if(Game.getLevel()==1){grafico.setColor(Color.darkGray);}
                    if(Game.getLevel()==2){grafico.setColor(Color.green);}
                    if(Game.getLevel()>=3){grafico.setColor(Color.blue);}

                    grafico.fillRect(col*40,row*40,blockwidth,blockheight);
                    grafico.setColor(Color.black);
                    grafico.drawRect(col*40,row*40,blockwidth,blockheight);
                }
            }
        }
        grafico.drawString("Start", 5, 62);
        grafico.drawString("End", 850, 462);
    }
    
    public int [][] getMaze(){
        if(Game.getLevel()==1){
            
        /**
        * FORMACION DE LABERINTOS
        * - Ancho: colnumber=23 (columnas)
        * - Alto: rownumber=13 (filas)
        *Notese que los "1", forman bloques sólidos
        *los cuales no pueden ser traspasados por el personaje.
        *Esos mismos bloques se usan para formar los bordes del laberinto.
        *
        * El jugador entonces, moverá el avatar, por los espacios "vacios" 
        * indicados por los "0".
        */
        
            //Level 1
            int maze[][]=
            {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            { 1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,1,1},
            { 1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1},
            { 1,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,0,1,1},
            { 1,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,1,0,1,0,1,1},
            { 1,1,0,0,1,0,1,0,1,1,1,0,1,0,1,0,0,0,0,1,0,1,1},
            { 1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1,1,1},
            { 1,1,0,1,0,0,0,0,1,0,0,0,1,0,0,1,1,1,0,1,0,1,1},
            { 1,1,0,1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1},
            { 1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,0,1,1},
            { 1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1},
            { 1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
            { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
            
            lab=maze;
        }
        
        if(Game.getLevel()==2){
            
            //Level 2
            int maze[][]=
            {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            { 1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
            { 1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1},
            { 1,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,1},
            { 1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1},
            { 1,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,1,1},
            { 1,1,1,0,1,0,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1},
            { 1,1,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,1},
            { 1,1,0,1,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1},
            { 1,1,0,1,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,1,0,1,1},
            { 1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,1},
            { 1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
            { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
            
            lab=maze;
        }
        
        if(Game.getLevel()==3){
            
            //Level 3
            int maze [][]=
            {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            { 1,0,0,0,1,0,0,0,0,0,0,1,1,1,0,0,1,1,3,0,0,1,1},
            { 1,1,1,0,1,0,1,0,1,1,1,0,0,0,1,0,0,0,1,1,0,1,1},
            { 1,1,0,0,0,0,1,0,0,1,0,0,1,0,1,0,1,0,0,1,0,1,1},
            { 1,1,0,1,1,1,1,0,1,0,0,1,1,0,1,0,0,1,0,1,0,1,1},
            { 1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,1,0,0,1,0,1,1},
            { 1,1,1,0,1,0,1,1,1,1,0,0,0,0,1,0,0,1,0,1,0,1,1},
            { 1,1,0,0,0,1,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,1,1},
            { 1,1,0,1,1,0,0,1,0,1,0,0,0,0,0,1,0,0,1,1,0,1,1},
            { 1,1,0,1,0,0,1,1,0,1,0,1,1,1,1,0,0,1,0,0,0,1,1},
            { 1,1,0,0,0,1,1,1,0,1,0,0,0,0,0,1,0,0,0,1,0,1,1},
            { 1,1,0,1,0,0,0,1,0,0,0,1,1,1,1,0,0,1,0,1,0,0,1},
            { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
            
            lab=maze;
        }
        
        return lab;
        
    }
}
