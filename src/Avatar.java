
import java.awt.Color;



/**
 * AVATAR (CREACION DE PERSONAJE Y DEFINICION DE MOVIMIENTOS)
 * @author fucalex
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
    * del avatar. Java proporciona la clase Graphics, que permite dibujar
    * elipses, cuadrados, líneas, mostrar texto y también tiene muchos 
    * otros métodos de dibujo. Para poder pintar, debemos crear un componente 
    * y pasarlo al programa como un argumento al método paint().
    */
        //base (toma los valores de ubicacion y tamaño definidos en clase publica 
    public void paint(Graphics grafico){
        grafico.setColor(Color.red);
        grafico.fillOval(x, y, width, height);
        grafico.setColor(Color.BLACK);
        grafico.drawOval(x, y, width, height);
        
        //ojos (se hacen los graficos, se ubican en coordenadas y se les da color)
        grafico.setColor(Color.white);
        grafico.fillOval(x+7,y+8,13,13);
        grafico.fillOval(x+21,y+8,13,13);
        grafico.setColor(Color.black);
        grafico.fillOval(x+11,y+12,5,5);
        grafico.fillOval(x+25,+12,5,5);
        
        //boca
        grafico.setColor(Color.black);
        grafico.fillOval(x+7,y+24,27,7);
    }
    
    /**
    *CAPTURA DE MOVIMIENTO
    * Para indicar cuales son las teclas que funcionan en el juego, se indica
    * el codigo de las teclas de direccion. 
    * @see https://www.yoelprogramador.com/teclas-del-teclado-y-valores-de-codigos-de-tecla/
    */
    
    public void pressedKey(KeyEvent event){
        int[][]maze=lab.getMaze();
        
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
