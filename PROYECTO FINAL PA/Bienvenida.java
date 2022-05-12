import javax.swing.*; //Ventanas
import java.awt.event.*; //Botones y Combo, Menus
import java.awt.*;  //Fuente,Color,Imagenes
//import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Bienvenida extends JFrame implements ActionListener, MouseListener {

    public JLabel eFondo;
    public Font fuente4 = new Font("Goudy Stout", Font.BOLD, 32);

    public Bienvenida() {
        super();                   
        configurarMenuG();        
        inicializarComponentes();   
    }

    public void configurarMenuG()
    {
        setLayout(null);
        setTitle("MENU");
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        this.setUndecorated(true);
        this.setBounds(600,200,600,600);
    }

    public void inicializarComponentes (){
        
        ImageIcon bienvenida;
        bienvenida = new ImageIcon(getClass().getResource("BIENVENIDO2.png"));
        
        eFondo = new JLabel(bienvenida);
        eFondo.setBounds(0,0,600,600);
        add(eFondo);
        eFondo.addMouseListener(this);
        
        //addMouseListener(this);

    }

    public void actionPerformed (ActionEvent e){
        
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==eFondo)
        {
            this.setVisible(false);
            Principal pagP = new Principal();
            pagP.setBounds(210,100,1500,800);
            pagP.setVisible(true);
            pagP.setResizable(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==eFondo)
        {
            this.setVisible(false);
            Principal pagP = new Principal();
            pagP.setBounds(210,100,1500,800);
            pagP.setVisible(true);
            pagP.setResizable(false);
        }
            
        
    }

}
