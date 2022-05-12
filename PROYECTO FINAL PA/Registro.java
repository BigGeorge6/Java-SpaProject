import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.*;
//import AppPackage.AnimationClass;
import java.sql.Connection;
import java.applet.AudioClip;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registro extends JFrame implements ActionListener, MouseListener,FocusListener, KeyListener{

    public JLabel eFondo,eRegistro,eNombre,eCorreo,eDireccion,eTelefono,ePass;
    public JTextField tfNombre,tfCorreo,tfDireccion,tfTelefono,tfPass;
    public JButton bRegistrar,bRegresar,bTerminos;
    public String nombre,pass,direccion,correo,telefono;

    public Registro() {
        super();                   
        configurarTiendaRopa();        
        inicializarComponentes();
        
    }

    public void configurarTiendaRopa()
    {
        this.setLayout(null);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(70,48,231));
    }

    public void inicializarComponentes()
    {

        ////////////////////  FUENTES  ///////////////////////////////  
        
        Font fuente1 = new Font("Harlow Solid Italic", Font.PLAIN, 20);
        Font fuente2 = new Font("Copperplate Gothic Bold", Font.PLAIN, 16);
        Font fuente3 = new Font("Goudy Stout", Font.PLAIN, 28);
        Font fuente4 = new Font("Cooper Black", Font.PLAIN, 16);
        Font fuente5 = new Font("Comic Sans MS", Font.PLAIN, 18);
        Font fuente6 = new Font("Copperplate Gothic Bold", Font.PLAIN, 40);
        Font fuente7 = new Font("Adobe Heiti Std R", Font.PLAIN, 12);
        Font fuente8 = new Font("Goudy Stout", Font.PLAIN, 20);

        ////////////////////  IMAGENES  /////////////////////////////
        
        ImageIcon fondo;
        fondo = new ImageIcon(getClass().getResource("REGISTROF.png"));
        
        ImageIcon registrarse;
        registrarse = new ImageIcon(getClass().getResource("REGISTRA.png"));
        ImageIcon registrarse2;
        registrarse2 = new ImageIcon(getClass().getResource("REGISTRA_1.png"));
        
        ImageIcon terminos;
        terminos = new ImageIcon(getClass().getResource("TERMINOS.png"));
        ImageIcon terminos2;
        terminos2 = new ImageIcon(getClass().getResource("TERMINOS_1.png"));
        
        ImageIcon regresar;
        regresar = new ImageIcon(getClass().getResource("REGRESAR.png"));
        ImageIcon regresar2;
        regresar2 = new ImageIcon(getClass().getResource("REGRESAR_1.png"));
        
        //////////////////////////  ETIQUETAS  /////////////////////////////////

        eRegistro = new JLabel("CREAR CUENTA");
        eRegistro.setFont(fuente3);
        eRegistro.setBounds(50,200,400,50);
        //eRegistro.setBorder(BorderFactory.createLineBorder(Color.black));
        eRegistro.setForeground(new Color(236, 90, 164));
        add(eRegistro);
        
        eNombre = new JLabel("USUARIO:");
        eNombre.setFont(fuente8);
        eNombre.setBounds(25,280,200,30);
        //eNombre.setBorder(BorderFactory.createLineBorder(Color.black));
        eNombre.setForeground(new Color(236, 90, 164));
        add(eNombre);
        
        tfNombre = new JTextField();
        tfNombre.setFont(fuente4);
        tfNombre.setBounds(230,280,250,30);
        //tfNombre.setBorder(null);
        tfNombre.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        tfNombre.setBackground(new Color(234, 220, 223));
        tfNombre.setForeground(new Color(234, 77, 103));
        add(tfNombre);
        tfNombre.addActionListener(this);
        tfNombre.addMouseListener(this);
        tfNombre.addFocusListener(this);
        
        ePass = new JLabel("CONTRASEÑA:");
        ePass.setFont(fuente8);
        ePass.setBounds(25, 320, 250, 30);
        //ePass.setBorder(BorderFactory.createLineBorder(Color.black));
        ePass.setForeground(new Color(236, 90, 164));
        add(ePass);
        
        tfPass = new JTextField();
        tfPass.setFont(fuente4);
        tfPass.setBounds(280,320,200,30);
        tfPass.setBorder(null);
        tfPass.setBackground(new Color(234, 220, 223));
        tfPass.setForeground(new Color(234, 77, 103));
        add(tfPass);
        tfPass.addActionListener(this);
        tfPass.addMouseListener(this);
        tfPass.addFocusListener(this);
        
        eDireccion = new JLabel("DIRECCIÓN:");
        eDireccion.setFont(fuente8);
        eDireccion.setBounds(25,360,220,30);
        //eDireccion.setBorder(BorderFactory.createLineBorder(Color.black));
        eDireccion.setForeground(new Color(236, 90, 164));
        add(eDireccion);
        
        tfDireccion = new JTextField();
        tfDireccion .setFont(fuente4);
        tfDireccion .setBounds(250,360,230,30);
        tfDireccion .setBorder(null);
        tfDireccion .setBackground(new Color(234, 220, 223));
        tfDireccion .setForeground(new Color(234, 77, 103));
        add(tfDireccion );
        tfDireccion.addActionListener(this);
        tfDireccion.addMouseListener(this);
        tfDireccion.addFocusListener(this);
        
        eCorreo = new JLabel("CORREO:");
        eCorreo.setFont(fuente8);
        eCorreo.setBounds(25,400,200,30);
        //eCorreo.setBorder(BorderFactory.createLineBorder(Color.black));
        eCorreo.setForeground(new Color(236, 90, 164));
        add(eCorreo);
        
        tfCorreo = new JTextField();
        tfCorreo.setFont(fuente4);
        tfCorreo.setBounds(200,400,280,30);
        tfCorreo.setBorder(null);
        tfCorreo.setBackground(new Color(234, 220, 223));
        tfCorreo.setForeground(new Color(234, 77, 103));
        add(tfCorreo);
        tfCorreo.addActionListener(this);
        tfCorreo.addMouseListener(this);
        tfCorreo.addFocusListener(this);
        
        eTelefono = new JLabel("TELÉFONO:");
        eTelefono.setFont(fuente8);
        eTelefono.setBounds(25,440,220,30);
        //eTelefono.setBorder(BorderFactory.createLineBorder(Color.black));
        eTelefono.setForeground(new Color(236, 90, 164));
        add(eTelefono);
        
        tfTelefono = new JTextField();
        tfTelefono .setFont(fuente4);
        tfTelefono .setBounds(250,440,230,30);
        tfTelefono .setBorder(null);
        tfTelefono .setBackground(new Color(234, 220, 223));
        tfTelefono .setForeground(new Color(234, 77, 103));
        add(tfTelefono );
        tfTelefono.addActionListener(this);
        tfTelefono.addMouseListener(this);
        tfTelefono.addFocusListener(this);
        
        /////////////////////////  BOTON  /////////////////////////////////
        
        bRegistrar = new JButton(registrarse);
        bRegistrar.setBounds(110,495,280,75);
        bRegistrar.setBorder(null);
        add(bRegistrar);
        bRegistrar.addActionListener(this);
        bRegistrar.addMouseListener(this);
        bRegistrar.addKeyListener(this);
        
        bTerminos = new JButton(terminos);
        bTerminos.setBounds(414,771,86,79);
        bTerminos.setBorder(null);
        add(bTerminos);
        bTerminos.addActionListener(this);
        bTerminos.addMouseListener(this);
        
        bRegresar = new JButton(regresar);
        bRegresar.setBounds(0,794,142,56);
        bRegresar.setBorder(null);
        add(bRegresar);
        bRegresar.addActionListener(this);
        bRegresar.addMouseListener(this);
        
        ////////////////////////   REDES   //////////////////////////////
        
        
        

        ////////////////////////  SLIDER  ////////////////////////////////
        
        eFondo = new JLabel(fondo);
        eFondo.setBounds(0,0,500,850);
        add(eFondo);
        

        
    }
     
        
    
    

    public void actionPerformed (ActionEvent e) {
        
        boolean bNombre,bPass,bDireccion,bCorreo,bTelefono;
        Pattern patCorreo = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Pattern patNombre = Pattern.compile("^([A-Z]{1}[a-z]+[ ]*){1,2}$");
        Pattern patTelefono = Pattern.compile("^[0-9]{10}$");
        Pattern patDireccion = Pattern.compile("^([A-Z]{1}[a-z]+[ ]*){1,9}+[0-9]{1,4}$");
        Pattern patPass = Pattern.compile("^([A-Z]{1}[a-z]{8,24}){1}+[!|-|*|+]{1}+[0-9]{1}$");
        
        Matcher mat;// = pat.matcher(email);
        
        if(e.getSource()==bRegistrar)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("CLICK.wav"));
            sonido.play();
            nombre=tfNombre.getText();
            pass=tfPass.getText();
            direccion=tfDireccion.getText();
            correo=tfCorreo.getText();
            telefono=tfTelefono.getText();
            
            if(nombre.length()==0)
            {
                tfNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                JOptionPane.showMessageDialog(this, "¡Necesita ingresar un nombre!");
                tfNombre.requestFocus();
            }else if(pass.length()==0){
                tfPass.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                JOptionPane.showMessageDialog(this, "¡Necesita ingresar una contraseña!");
                tfPass.requestFocus();
            }else if(direccion.length()==0){
                tfDireccion.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                JOptionPane.showMessageDialog(this, "¡Necesita ingresar una direccion!");
                tfDireccion.requestFocus();
            }else if(correo.length()==0){
                tfCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                JOptionPane.showMessageDialog(this, "¡Necesita ingresar un correo!");
                tfCorreo.requestFocus();
            }else if(telefono.length()==0)
            {
                tfTelefono.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                JOptionPane.showMessageDialog(this, "¡Necesita ingresar un telefono!");
                tfTelefono.requestFocus();
            }else{
                JOptionPane.showMessageDialog(this, "¡BIEN!");
                
                bNombre=nombre.matches("^([A-Z]{1}[a-z]+[ ]*){1,2}$");
                bPass=pass.matches("^([A-Z]{1}[a-z]{8,24}){1}+[!|-|*|+]{1}+[0-9]{1}$");
                bDireccion=direccion.matches("^([A-Z]{1}[a-z]+[ ]*){1,9}+[0-9]{1,4}$");
                bCorreo=correo.matches("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                bTelefono=telefono.matches("^[0-9]{10}$");
                
                if(bNombre==false)
                {
                    tfNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                    JOptionPane.showMessageDialog(this, "El formato para el nombre es:\nNombre Apellido");
                    tfNombre.setText("");
                    tfNombre.requestFocus();
                }else if(bPass==false){
                    tfPass.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                    JOptionPane.showMessageDialog(this, "El formato para la contraseña es:\nAaaaaaaaaaaaa(!+-*)(0-9)");
                    tfPass.setText("");
                    tfPass.requestFocus();
                }else if(bDireccion==false){
                    tfDireccion.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                    JOptionPane.showMessageDialog(this, "El formato para la direccion es:\nCalle de Ejemplo 24");
                    tfDireccion.setText("");
                    tfDireccion.requestFocus();
                }else if(bCorreo==false){
                    tfCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                    JOptionPane.showMessageDialog(this, "El formato para el correo es:\nAaaaaaaaa@dominio.com");
                    tfCorreo.setText("");
                    tfCorreo.requestFocus();
                }else if(bTelefono==false){
                    tfTelefono.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                    JOptionPane.showMessageDialog(this, "El formato para el telefono es es:\n0123456789");
                    tfTelefono.setText("");
                    tfTelefono.requestFocus();
                }else
                {
                    JOptionPane.showMessageDialog(this, "YA CASIIIII");
                    Connection con;
                    try {
                        //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/estetica","root","");
                        con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net/sql9380136","sql9380136","UFbzlaVNRt");
                        PreparedStatement pst = con.prepareStatement("INSERT INTO clientes (nombre,pass,domicilio,telefono,email) VALUES"
                                + "(?, ?, ?, ?, ?)");
                        pst.setString(1,nombre);
                        pst.setString(2,pass);
                        pst.setString(3, direccion);
                        pst.setString(4,telefono);
                        pst.setString(5, correo);
                        pst.executeUpdate();
                        this.setVisible(false);
                        Inicio menu = new Inicio();
                        menu.setBounds(210,100,1500,800);
                        menu.setVisible(true);
                        
                    } catch (SQLException ex) {
                        //Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
	JOptionPane.showMessageDialog(this, "Algo salió mal...");
                    }
                    
                }
                
            }
            
              /* if(mat.find()){
                    System.out.println("Correo Válido");
               }else{
                    System.out.println("Correo No Válido");
               }*/
        }
        
        if(e.getSource()==bTerminos)
        {
            JOptionPane.showMessageDialog(this, "El único término y condición es:\n Que el proyecto <The Paradise> puntúe 100.\nEs broma, ¡Feliz Navidad!");
        }
        
        if(e.getSource()==bRegresar)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("CLICK.wav"));
            sonido.play();
            this.setVisible(false);
            Inicio menu = new Inicio();
            menu.setBounds(210,100,1500,800);
            menu.setVisible(true);
        }
        

    }
    
    public void mouseEntered(MouseEvent e)
    {
        ImageIcon fondo;
        fondo = new ImageIcon(getClass().getResource("REGISTROF.png"));
        
        ImageIcon registrarse;
        registrarse = new ImageIcon(getClass().getResource("REGISTRA.png"));
        ImageIcon registrarse2;
        registrarse2 = new ImageIcon(getClass().getResource("REGISTRA_1.png"));
        
        ImageIcon terminos;
        terminos = new ImageIcon(getClass().getResource("TERMINOS.png"));
        ImageIcon terminos2;
        terminos2 = new ImageIcon(getClass().getResource("TERMINOS_1.png"));
        
        ImageIcon regresar;
        regresar = new ImageIcon(getClass().getResource("REGRESAR.png"));
        ImageIcon regresar2;
        regresar2 = new ImageIcon(getClass().getResource("REGRESAR_1.png"));
        
        if(e.getSource()==bRegistrar)
        {
            bRegistrar.setIcon(registrarse2);
        }
        if(e.getSource()==bTerminos)
        {
            bTerminos.setIcon(terminos2);
        }
        if(e.getSource()==bRegresar)
        {
            bRegresar.setIcon(regresar2);
        }
        
    }

    public void mouseExited(MouseEvent e)
    { 
        ImageIcon fondo;
        fondo = new ImageIcon(getClass().getResource("REGISTROF.png"));
        
        ImageIcon registrarse;
        registrarse = new ImageIcon(getClass().getResource("REGISTRA.png"));
        ImageIcon registrarse2;
        registrarse2 = new ImageIcon(getClass().getResource("REGISTRA_1.png"));
        
        ImageIcon terminos;
        terminos = new ImageIcon(getClass().getResource("TERMINOS.png"));
        ImageIcon terminos2;
        terminos2 = new ImageIcon(getClass().getResource("TERMINOS_1.png"));
        
        ImageIcon regresar;
        regresar = new ImageIcon(getClass().getResource("REGRESAR.png"));
        ImageIcon regresar2;
        regresar2 = new ImageIcon(getClass().getResource("REGRESAR_1.png"));
        
        if(e.getSource()==bRegistrar)
        {
            bRegistrar.setIcon(registrarse);
        }
        if(e.getSource()==bTerminos)
        {
            bTerminos.setIcon(terminos);
        }
        if(e.getSource()==bRegresar)
        {
            bRegresar.setIcon(regresar);
        }
        
    }

    public void mousePressed(MouseEvent e)
    {
        
    }

    public void mouseReleased(MouseEvent e)
    {

    }

    public void mouseClicked(MouseEvent e)
    {
        
    }

    
   /* public static void main (String args[]){

        
        Registro m = new Registro();
        m.setBounds(700,100,500,850);
        m.setVisible(true);
        //Reproductor reproductor = new Reproductor();
        //reproductor.setBounds(210,100,5,5);
        //reproductor.setVisible(true);
        

    }*/

    @Override
    public void focusGained(FocusEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
        if(e.getSource()==tfNombre)
        {
            
            tfNombre.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        }
        if(e.getSource()==tfPass)
        {
            
            tfPass.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        }
        if(e.getSource()==tfDireccion)
        {
            
            tfDireccion.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        }
        if(e.getSource()==tfCorreo)
        {
            
            tfCorreo.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        }
        if(e.getSource()==tfTelefono)
        {
            
            tfTelefono.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==tfNombre)
        {
            tfNombre.setBorder(null);
        }
        if(e.getSource()==tfPass)
        {
            
            tfPass.setBorder(null);
        }
        if(e.getSource()==tfDireccion)
        {
            
            tfDireccion.setBorder(null);
        }
        if(e.getSource()==tfCorreo)
        {
            
            tfCorreo.setBorder(null);
        }
        if(e.getSource()==tfTelefono)
        {
            
            tfTelefono.setBorder(null);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}