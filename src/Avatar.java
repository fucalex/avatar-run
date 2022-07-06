
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;



/**
 * AVATAR (CREACION DE PERSONAJE Y DEFINICION DE MOVIMIENTOS)
 * @author fucalex
 * 
 */
public class Avatar {
    Maze lab=new Maze();
    int x=40;
    int y=40;
    int width=40;
    int height=40;
    int movement=40;
        
    /**
    *FORMA Y COLOR DEL PERSONAJE
    * Se definen las caracteristicas tales como forma, tamaño y colores
    * del avatar.Java proporciona la clase Graphics, que permite dibujar
    * elipses, cuadrados, líneas, mostrar texto y también tiene muchos 
    * otros métodos de dibujo. Para poder pintar, debemos crear un componente 
    * y pasarlo al programa como un argumento al método paint().
     * @param grafico
    */
        /**
         * Base (Este es el "espacio personal" del avatar. 
         * Se toma los valores de ubicacion y tamaño definidos en clase publica. 
         */
    public void paint(Graphics grafico){
        grafico.setColor(Color.red);
        grafico.fillRect(x, y, width, height);
        grafico.setColor(Color.BLACK);
        grafico.drawRect(x, y, width, height);
        
        /**
         *Cabeza (Para todos los siguiente elementos, se hacen los graficos, 
         *se ubican en coordenadas y se les da color)
         */
        grafico.setColor(Color.black);
        grafico.fillOval(x+16,y+3,8,8);
        grafico.setColor(Color.black);
        
        //Brazos y hombros
        grafico.fillRect(x+9,y+12,4,14);
        grafico.fillRect(x+11,y+12,4,4);
        grafico.fillRect(x+28,y+12,4,14);
        grafico.fillRect(x+26,y+12,4,4);
         grafico.fillRect(x+14,y+12,13,14);
       
        //Piernas
        grafico.fillRect(x+14,y+24,6,14);
        grafico.fillRect(x+21,y+24,6,14);
    }
    
    /**
    *CAPTURA DE MOVIMIENTO
    * Para indicar cuales son las teclas que funcionan en el juego, se indica
    * el codigo de las teclas de direccion. 
    * Aqui tambien se indica por qué el avatar se debe mover a ciertos lados.
    * "!=" indica que puede moverse a cualquier elemento que no sea 1 (mas adelante
    * se explica que 1, corresponde a un bloque del laberinto).
    * @param event
    * @see https://www.yoelprogramador.com/teclas-del-teclado-y-valores-de-codigos-de-tecla/
    */
    
    public void teclaPresionada(KeyEvent event){
        int[][]maze=lab.getMaze();
        
        if(event.getKeyCode()==37){//Mover a la izquierda
            if(maze[y/40][(x/40)-1] !=1){
                x=x-movement;
            }
        }
        if(event.getKeyCode()==39){//Mover a la derecha
            if(maze[y/40][(x/40)+1]!=1){
                x=x+movement;
            }
        }
        if(event.getKeyCode()==40){//Mover abajo
            if(maze[(y/40)+1][x/40]!=1){
                y=y+movement;
            }
        }
        if(event.getKeyCode()==38){//Mover arriba
            if(maze[(y/40)-1][x/40]!=1){
                y=y-movement;
            }
        }
        
        /**
        *SIGUIENTE NIVEL
        * Para alcanzar el final del nivel, el jugador debe estar ubicado en la posicion de x, y, de la esquina
        * inferior derecha, donde se activará el cambio de nivel y el avatar será ubicado en la esquina
        * superior izquierda del siguiente nivel
        */
        if(x==840 && y==440){
            Game.changeLevel();
            x=40;
            y=40;
        }
    }
}   
