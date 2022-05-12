import java.applet.AudioClip;
import javax.swing.*; //Ventanas
import java.awt.event.*; //Botones y Combo, Menus
import java.awt.*;  //Fuente,Color,Imagenes
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Reproductor extends JFrame implements ActionListener {

    public JMenuBar menuBar;
    public JMenu menu1,menu2,menu3,submenu;
    public JMenuItem menu1item1,menu1item2, menu2item1,menu2item2,subitem1,subitem2,subitem3,menu3item1,menu3item2;
    public String opc;
    public JLabel eFondo;
    public Font fuente4 = new Font("Goudy Stout", Font.BOLD, 32);

    public Reproductor() {
        super();                   
        configurarMenuG();        
        inicializarComponentes();   
    }

    public void configurarMenuG()
    {
        setLayout(null);
        setTitle("MENU");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setBounds(100,50,5,5);
    }

    public void inicializarComponentes (){
        
        AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("CANCION.wav"));
        sonido.play();
        
        ImageIcon lobby;
        lobby = new ImageIcon(getClass().getResource("LOBBY.png"));
        ImageIcon cuenta;
        cuenta = new ImageIcon(getClass().getResource("MICUENTA.png"));
        ImageIcon productos;
        productos = new ImageIcon(getClass().getResource("PRODUCTOS.png"));
        ImageIcon servicios;
        servicios = new ImageIcon(getClass().getResource("SERVICIOS.png"));
        


    }

    public void actionPerformed (ActionEvent e){
        
    }

/*
    public static void main (String args[]){

        int t11;

        Principal pagP = new Principal();
        pagP.setBounds(210,100,1500,800);
        pagP.setVisible(true);
        pagP.setResizable(false);

    }*/

}
