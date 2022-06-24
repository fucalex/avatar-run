/**
 * PANEL DE JUEGO Y OPCIONES DE BASE
 * @author fucalex
 */

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * El panel de juego (Game) hereda atributos y métodos de la clase principal
 * (o clase base) "JPanel", sin embargo, "Game", al ser una subclase, puede 
 * agregar sus propios campos y métodos. (Pilar fundamental de la POO).
 */
public class Game extends JPanel{
    Maze maze=new Maze();
    Avatar avatar=new Avatar();
    public static int level=1;
    
   /**
    * Para leer del teclado es necesario registrar un objeto que se encargue de 
    * "escuchar" si una tecla es presionada. Este objeto es conocido como 
    * "Listener", con metodos que seran llamados cuando se presione una tecla. 
    * Aqui, el Listener se registra en "Game" usando el método addKeyListener.
    * 
    * Nota: la (e), significa "event"
    */
        
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
    
   /**
    * Las caracteristicas visibles del laberinto y el personaje, son definidas 
    * en sus respectivos archivos
    */

    public void paint(Graphics grafico){
        maze.paint(grafico);
        avatar.paint(grafico);
    }
   /**
    * Para cambiar de nivel, cuando el avatar llegue a una posicion determinada
    * en el laberinto (definido en avatar.java), al nivel actual se le sumará 
    * una unidad para indicar que se debe cargar el siguiente nivel.
    */    
    public static int changeLevel(){
        return level++;
    }
    
   /**
    * Para cargar el laberinto, cuando se cargue la base del siguiente nivel,
    * dependiendo el número de la misma (1, 2 o 3), se cargará el laberinto
    * (definido en maze.java), por medio de "return level".
    */  

    public static int getLevel(){
        return level;
    }
    
   /**
    * Aqui definimos el tamaño y el titulo de la ventana del juego 
    * (en pixeles (ancho, alto), qué va a ir en ella (el juego en sí y su 
    * localizacion ["setlocation", definido en coordenadas]), y la forma en la 
    * que cerraremos el juego.
    */ 

    public static void main(String[]args){
       JOptionPane.showMessageDialog(null, "ready?");
       JFrame myWindow=new JFrame("Avatar Run");
       Game game =new Game();
       myWindow.add(game);
       myWindow.setSize(920,540);
       myWindow.setLocation(300,200);
       myWindow.setVisible(true);
       myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
   /**
    * FIN DEL JUEGO
    * 
    * Mediante la declaracion try/catch, por medio de la cual podemos manejar
    * errores de tiempo de ejecucion, cuando el jugador pierde, intentamos 
    * ejecutar una pequeña espera. Como esta espera termina en error, entonces 
    * se indica a traves de un mensaje que el jugador perdio y se recarga el
    * laberinto usando "game.repaint".
    */ 
       
       
       while (true){
           try {
               Thread.sleep(10);
        } catch (InterruptedException ex) {
             Logger.getLogger(Game.class.getName()).log(Level.SEVERE, "you lose");
        }
        game.repaint();   
        
   /**
    * Por otro lado, si el jugador llegó al final del ultimo laberinto sin 
    * dificultades, entonces se mostrará un mensaje de victoria. Esto debido a 
    * que al llegar al final del laberinto, se carga un o nuevo, pero como hay 
    * un numero limitado de laberintos, si se va a cargar uno mas alla del limite 
    * (getLevel), entonces se muestra el mensaje y se cierra el juego.
    */ 

        if(getLevel()>3){
            JOptionPane.showMessageDialog(null, "you did it! see you soon.");
            System.exit(0);
            }
        }
    }
}



