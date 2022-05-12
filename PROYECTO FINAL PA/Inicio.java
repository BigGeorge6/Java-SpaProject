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
//import clases.Conectar;
import java.sql.Connection;
import java.applet.AudioClip;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.awt.Desktop;
import java.net.URI;

public class Inicio extends JFrame implements ActionListener, MouseListener,FocusListener{

	//private static final String driver = "com.mysql.jdbc.Driver";
    public JLabel eSlider, eParadise,eMarco,eUsuario,ePass,eRegistrar,eIniciar;
    public JTextField tfUsuario,tfPass;
    public JTextArea tAviso,tIniciar; 
    public JButton bIzq,bDer,bSalir,bCajon,bFacebook,bWhatss,bGoogle,bInstagram,bConexion,bIngresar,bRegistrar;
    public JLabel Ltienda, Lpantalon, Lcamisa, Lcalceta, Lropainf,banner;
    public JButton caja,aviso;
    public JTextArea pedido;
    int cont=1,cont2=1;
    public Connection con;// = DriverManager.getConnection("jdbc:mysql://localhost:3306/estetica","root","");
    public PreparedStatement pst;
    public String nombre,pass;
    public static String nombreF,passF,domicilioF,telefonoF,emailF;
    public static int id_cliente;

    public Inicio() {
        super();                   
        configurarTiendaRopa();        
        inicializarComponentes();
        
    }

    public void configurarTiendaRopa()
    {
        this.setLayout(null);
        this.setTitle("TIENDA DE ROPA");
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(70,48,231));
    }

    public void inicializarComponentes()
    {
        //AudioClip sonido;
        //sonido = java.applet.Applet.newAudioClip(getClass().getResource("CANCION.wav"));
        //sonido.play();
        //sonido.stop();

        ////////////////////  FUENTES  ///////////////////////////////  
        
        Font fuente1 = new Font("Harlow Solid Italic", Font.PLAIN, 20);
        Font fuente2 = new Font("Copperplate Gothic Bold", Font.PLAIN, 16);
        Font fuente3 = new Font("Goudy Stout", Font.PLAIN, 28);
        Font fuente4 = new Font("Cooper Black", Font.PLAIN, 22);
        Font fuente5 = new Font("Comic Sans MS", Font.PLAIN, 18);
        Font fuente6 = new Font("Copperplate Gothic Bold", Font.PLAIN, 40);
        Font fuente7 = new Font("Adobe Heiti Std R", Font.PLAIN, 12);

        ////////////////////  IMAGENES  /////////////////////////////
        
        ImageIcon slider;
        slider = new ImageIcon(getClass().getResource("INICIOSLIDER.png"));
        ImageIcon slider1;
        
        ImageIcon izquierda;
        izquierda = new ImageIcon(getClass().getResource("IZQUIERDA.png"));
        ImageIcon derecha;
        derecha = new ImageIcon(getClass().getResource("DERECHA.png"));
        
        ImageIcon paradise;
        paradise = new ImageIcon(getClass().getResource("THEPARADISE.png"));
        
        ImageIcon salirA;
        salirA = new ImageIcon(getClass().getResource("SALIDA.gif"));
        ImageIcon salirN;
        salirN = new ImageIcon(getClass().getResource("SALIR.png"));
        
        ImageIcon facebook;
        facebook = new ImageIcon(getClass().getResource("FACEBOOK.png"));
        ImageIcon whatss;
        whatss = new ImageIcon(getClass().getResource("WHATSSAPP.png"));
        ImageIcon instagram;
        instagram = new ImageIcon(getClass().getResource("INSTAGRAM.png"));
        ImageIcon google;
        google = new ImageIcon(getClass().getResource("GOOGLE.png"));
        ImageIcon cajon;
        cajon = new ImageIcon(getClass().getResource("CAJON.png"));
        
        ImageIcon conexionA;
        conexionA = new ImageIcon(getClass().getResource("ANDROIDA.gif"));
        ImageIcon conexionN;
        conexionN = new ImageIcon(getClass().getResource("ANDROIDN.png"));
        
        ImageIcon marco;
        marco = new ImageIcon(getClass().getResource("MARCO.png"));

        ImageIcon ingresar;
        ingresar = new ImageIcon(getClass().getResource("INGRESAR.png"));
        ImageIcon ingresar2;
        ingresar2 = new ImageIcon(getClass().getResource("INGRESAR_1.png"));
        
        ImageIcon registrar;
        registrar = new ImageIcon(getClass().getResource("REGISTRAR.png"));
        ImageIcon registrar2;
        registrar2 = new ImageIcon(getClass().getResource("REGISTRAR_1.png"));
        
        //////////////////////////  ETIQUETAS  /////////////////////////////////

        eParadise = new JLabel(paradise);
        eParadise.setBounds(576,0,349,243);
        add(eParadise);
        
        eIniciar = new JLabel("Iniciar Sesion");
        eIniciar.setFont(fuente6);
        eIniciar.setBounds(588,295,330,45);
        add(eIniciar);
        
        tfUsuario = new JTextField();
        tfUsuario.setFont(fuente7);
        tfUsuario.setBounds(730,370,150,40);
        add(tfUsuario);
        tfUsuario.addFocusListener(this);
        tfUsuario.requestFocus();
        
        tfPass = new JTextField();
        tfPass.setFont(fuente7);
        tfPass.setBounds(730,430,150,40);
        add(tfPass);
        tfPass.addFocusListener(this);
        
        eUsuario = new JLabel("Usuario:");
        eUsuario.setFont(fuente4);
        eUsuario.setBounds(605,380,100,20);
        add(eUsuario);
        
        ePass = new JLabel("Contrasena:");
        ePass.setFont(fuente4);
        ePass.setBounds(588,440,150,20);
        add(ePass);
        
        bIngresar = new JButton(ingresar);
        bIngresar.setBounds(610,485,275,50);
        bIngresar.setBorder(null);
        add(bIngresar);
        bIngresar.addActionListener(this);
        bIngresar.addMouseListener(this);
        
        bRegistrar = new JButton(registrar);
        bRegistrar.setBounds(610,585,275,50);
        bRegistrar.setBorder(null);
        add(bRegistrar);
        bRegistrar.addActionListener(this);
        bRegistrar.addMouseListener(this);
        
        eRegistrar = new JLabel("Todavia no estas registrado?");
        eRegistrar.setFont(fuente2);
        eRegistrar.setBounds(610,545,275,30);
        add(eRegistrar);
        
        eMarco = new JLabel(marco);
        eMarco.setBounds(581,290,338,360);
        add(eMarco);
        
        /////////////////////////  BOTON  /////////////////////////////////
        
        
       /* bConexion = new JButton(conexionN);
        bConexion.setBounds(581,300,338,338);
        add(bConexion);
        bConexion.addActionListener(this);
        bConexion.addMouseListener(this);*/
        
        
        bIzq = new JButton(izquierda);
        bIzq.setBounds(0,368,64,64);
        //bIzq.setBackground(new Color(0,0,0,0));
        add(bIzq);
        bIzq.addActionListener(this);
        
        bDer = new JButton(derecha);
        bDer.setBounds(1436,368,64,64);
        // bDer.setBackground(new Color(0,0,0,0));
        add(bDer);
        bDer.addActionListener(this);
        
        bSalir = new JButton(salirN);
        bSalir.setBounds(0,640,160,128);
        add(bSalir);
        bSalir.addActionListener(this);
        bSalir.addMouseListener(this);
        
        ////////////////////////   REDES   //////////////////////////////
        
        bFacebook = new JButton(facebook);
        bFacebook.setBounds(965,655,118,118);
        add(bFacebook);
        bFacebook.addActionListener(this);
        bFacebook.setVisible(false);
        
        bWhatss = new JButton(whatss);
        bWhatss.setBounds(1099,655,118,118);
        add(bWhatss);
        bWhatss.addActionListener(this);
        bWhatss.setVisible(false);
        
        bInstagram = new JButton(instagram);
        bInstagram.setBounds(1233,655,118,118);
        add(bInstagram);
        bInstagram.addActionListener(this);
        bInstagram.setVisible(false);
        
        bGoogle = new JButton(google);
        bGoogle.setBounds(1367,655,118,118);
        add(bGoogle);
        bGoogle.addActionListener(this);
        bGoogle.setVisible(false);
        
        bCajon = new JButton(cajon);
        bCajon.setBounds(1465,650,587,126);
        add(bCajon);
        bCajon.addActionListener(this);
        bCajon.addMouseListener(this);
        

        ////////////////////////  SLIDER  ////////////////////////////////
        
        eSlider = new JLabel(slider);
        eSlider.setBounds(0,0,7500,800);
        add(eSlider);
        

        
    }
     
        
    
    

    public void actionPerformed (ActionEvent e) {
        ImageIcon slider;
        slider = new ImageIcon(getClass().getResource("INICIOSLIDER.png"));
        ImageIcon slider1;
        slider1 = new ImageIcon(getClass().getResource("INICIOSLIDER1.png"));
        ImageIcon slider2;
        slider2 = new ImageIcon(getClass().getResource("INICIOSLIDER2.png"));
        ImageIcon slider3;
        slider3 = new ImageIcon(getClass().getResource("INICIOSLIDER3.png"));
        ImageIcon slider4;
        slider4 = new ImageIcon(getClass().getResource("INICIOSLIDER4.png"));
        ImageIcon slider5;
        slider5 = new ImageIcon(getClass().getResource("INICIOSLIDER5.png"));
        
        //AnimationClass cuadro = new AnimationClass();
        //AnimationClass red = new AnimationClass();
        
        boolean entrada = false;
        
        if(e.getSource()==bFacebook)
        {
            try{
                Desktop.getDesktop().browse(new URI("https://www.facebook.com/FashionParadiseMayoreo/"));
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "ERROR, no se pudo conectar a internet");
            }
        }
        
        if(e.getSource()==bInstagram)
        {
            try{
                Desktop.getDesktop().browse(new URI("https://www.instagram.com/paradise/?hl=es-la"));
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "ERROR, no se pudo conectar a internet");
            }
        }
        
        if(e.getSource()==bWhatss)
        {
            
                JOptionPane.showMessageDialog(this, "3929415452 para mas atencion");
            
        }
        
        if(e.getSource()==bGoogle)
        {
            try{
                Desktop.getDesktop().browse(new URI("https://www.expedia.mx/Atlantida-Hoteles-Paradise-Spa-Complejo-Turistico.h8450399.Informacion-Hotel"));
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "ERROR, no se pudo conectar a internet");
            }
        }
        
        if(e.getSource()==bIngresar)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("CLICK.wav"));
            sonido.play();
            boolean bNombre,bPass;
            
            nombre=tfUsuario.getText();
            pass=tfPass.getText();
            
            if(nombre.length()==0)
            {
                tfUsuario.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                JOptionPane.showMessageDialog(this, "Necesita ingresar un nombre!");
                tfUsuario.requestFocus();
            }else if(pass.length()==0){
                tfPass.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                JOptionPane.showMessageDialog(this, "Necesita ingresar una contrasena!");
                tfPass.requestFocus();
            }else{
                //JOptionPane.showMessageDialog(this, "¡BIEN!");
                
                bNombre=nombre.matches("^([A-Z]{1}[a-z]+[ ]*){1,2}$");
                bPass=pass.matches("^([A-Z]{1}[a-z]{8,24}){1}+[!|-|*|+]{1}+[0-9]{1}$");
                
                if(bNombre==false)
                {
                    tfUsuario.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                    JOptionPane.showMessageDialog(this, "El formato para el nombre es:\nNombre Apellido");
                    tfUsuario.setText("");
                    tfUsuario.requestFocus();
                }else if(bPass==false){
                    tfPass.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                    JOptionPane.showMessageDialog(this, "El formato para la contrasena es:\nAaaaaaaaaaaaa(!+-*)(0-9)");
                    tfPass.setText("");
                    tfPass.requestFocus();
                }else
                {
                    
                    //JOptionPane.showMessageDialog(this, "YA CASIIIII");
                    Connection con;
                    ResultSet rs=null;
                    try {
                       
	//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/estetica","root","");
                      con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net/sql9380136","sql9380136","UFbzlaVNRt");
	PreparedStatement pst = con.prepareStatement("SELECT id_cliente,nombre,pass,domicilio,telefono,email FROM clientes WHERE nombre = ?");
                        
                        pst.setString(1,nombre);
                        rs = pst.executeQuery();
                        
                        if(rs.next())
                        {
                            if(pass.equals(rs.getString(3)))
                            {
                                id_cliente = rs.getInt(1);
                                nombreF = rs.getString(2);
                                passF = rs.getString(3);
                                domicilioF = rs.getString(4);
                                telefonoF = rs.getString(5);
                                emailF = rs.getString(6);
                                entrada=true;
                            }else{
                                entrada=false;
                            }
                        }
                        
                        //entrada=false;
                        //JOptionPane.showMessageDialog(this, "No se ha encontrado usuario en la base de datos");
                        
                    } catch (SQLException ex) {
                       
	 Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                        entrada=false;
                        JOptionPane.showMessageDialog(this, "No se ha encontrado usuario en la base de datos");
                    }
                    
                }
                
            }
            
            if(entrada==true)
            {
                //JOptionPane.showMessageDialog(this, "INICIO DE SESION EXITOSO! \n BIENVENIDO!");
                this.setVisible(false);
                /*Principal pagP = new Principal();
                pagP.setBounds(210,100,1500,800);
                pagP.setVisible(true);
                pagP.setResizable(false);*/
                Bienvenida pagP = new Bienvenida();
                pagP.setBounds(600,200,600,600);
                pagP.setVisible(true);
                pagP.setResizable(false);
                
            }
            
        } //Ingresar
        
        /*if(e.getSource()==bDer){
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("CORTINAW.wav"));
            sonido.play();
            if(cont==1)
            {
                cuadro.jLabelXLeft(0, -1500, 10, 20, eSlider);
            }else
            if(cont==2)
            {
                cuadro.jLabelXLeft(-1500, -3000, 10, 20, eSlider);
            }else
            if(cont==3)
            {
                cuadro.jLabelXLeft(-3000, -4500, 10, 20, eSlider);
            }else
            if(cont==4)
            {
                cuadro.jLabelXLeft(-4500, -6000, 10, 20, eSlider);
            }else
            if(cont==5)
            {
                cuadro.jLabelXRight(-6000, 0, 10, 50, eSlider);
                cont=0;
            }
            cont=cont+1;
        } */
       /* if(e.getSource()==bIzq){
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("CORTINAW.wav"));
            sonido.play();
            if(cont==1)
            {
                cuadro.jLabelXLeft(0, -6000, 10, 50, eSlider);
                cont=5;
            }else
            if(cont==2)
            {
                cuadro.jLabelXRight(-1500, 0, 10, 20, eSlider);
            }else
            if(cont==3)
            {
                cuadro.jLabelXRight(-3000, -1500, 10, 20, eSlider);
            }else
            if(cont==4)
            {
                cuadro.jLabelXRight(-4500, -3000, 10, 20, eSlider);
            }else
            if(cont==5)
            {
                cuadro.jLabelXRight(-6000,-4500 , 10, 20, eSlider);
            }
            
            cont=cont-1;
        } */
        
        if(e.getSource()==bSalir)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("CLICK.wav"));
            sonido.play();
            con=null;
            JOptionPane.showMessageDialog(null, "Conexion finalizada de manera exitosa!");
            //con.desconectar();
            System.exit(0);
            
        }
        if(e.getSource()==bCajon)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("CAJONW.wav"));
            sonido.play();
            if(cont2==1)
            {
                //red.jButtonXLeft(1465, 913, 10, 20, bCajon);
                cont2=0;
                bCajon.setBounds(913,650,587,126);
                bFacebook.setVisible(true);
                bWhatss.setVisible(true);
                bInstagram.setVisible(true);
                bGoogle.setVisible(true);
                bCajon.setBounds(913,650,587,126);
                //red.jButtonYUp(655, 400, 10, 20, bFacebook);
                
            }else if(cont2==0)
            {
                //red.jButtonXRight(913, 1465, 10, 20, bCajon);
                cont2=1;
                bCajon.setBounds(1465,650,587,126);
                bFacebook.setVisible(false);
                bWhatss.setVisible(false);
                bInstagram.setVisible(false);
                bGoogle.setVisible(false);
                
            }
        }
        
        if(e.getSource()==bRegistrar)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("CLICK.wav"));
            sonido.play();
            Registro formulario = new Registro();
            formulario.setBounds(700,100,500,850);
            formulario.setVisible(true);
            this.setVisible(false);
        }
        
      /*  if(e.getSource()==bConexion)
        {
            //con = new Conectar();
            //Connection reg = con.getConnection();
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/estetica","root","");
                if(con != null){
                    JOptionPane.showMessageDialog(null, "Conexion establecida de manera exitosa!");
                    bConexion.setVisible(false);
                    eMarco.setVisible(true);
                    eIniciar.setVisible(true);
                    eUsuario.setVisible(true);
                    ePass.setVisible(true);
                    bIngresar.setVisible(true);
                    bRegistrar.setVisible(true);
                    eRegistrar.setVisible(true);
                    tfUsuario.setVisible(true);
                    tfPass.setVisible(true);
                }
            }catch(Exception u){
                JOptionPane.showMessageDialog(null, "No se pudo acceder a la base de datos");
            }
            
            
            //this.setVisible(false);
            
            //Principal pagP = new Principal();
            //pagP.setBounds(210,100,1500,800);
            //pagP.setVisible(true);
        }*/

    }
    
    public void mouseEntered(MouseEvent e)
    {
        ImageIcon salirA;
        salirA = new ImageIcon(getClass().getResource("SALIDA.gif"));
        
        ImageIcon salirN;
        salirN = new ImageIcon(getClass().getResource("SALIR.png"));
        
        ImageIcon conexionA;
        conexionA = new ImageIcon(getClass().getResource("ANDROIDA.gif"));
        ImageIcon conexionN;
        conexionN = new ImageIcon(getClass().getResource("ANDROIDN.png"));
        
        ImageIcon ingresar;
        ingresar = new ImageIcon(getClass().getResource("INGRESAR.png"));
        ImageIcon ingresar2;
        ingresar2 = new ImageIcon(getClass().getResource("INGRESAR_1.png"));
        
        ImageIcon registrar;
        registrar = new ImageIcon(getClass().getResource("REGISTRAR.png"));
        ImageIcon registrar2;
        registrar2 = new ImageIcon(getClass().getResource("REGISTRAR_1.png"));
        
        //AnimationClass cuadro = new AnimationClass();
        //AnimationClass red = new AnimationClass();
        
        if(e.getSource()==bSalir)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("POPW.wav"));
            sonido.play();
            bSalir.setIcon(salirA);
            bSalir.setBounds(0,640,160,128);
            //cuadro.jButtonXRight(-130, 0, 10, 20, bSalir);
        }
        
        /*if(e.getSource()==bConexion)
        {
            bConexion.setIcon(conexionA);
        }*/
        
       /* if(e.getSource()==bCajon)
        {
                red.jButtonXLeft(1465, 913, 10, 20, bCajon);
                
                //red.jButtonXRight(913, 1465, 10, 20, bCajon);
                
        }*/
       
       if(e.getSource()==bIngresar)
       {
          
           AudioClip sonido;
           sonido = java.applet.Applet.newAudioClip(getClass().getResource("POPW.wav"));
           sonido.play();
        
           bIngresar.setIcon(ingresar2);
       }
       if(e.getSource()==bRegistrar)
       {
           AudioClip sonido;
           sonido = java.applet.Applet.newAudioClip(getClass().getResource("POPW.wav"));
           sonido.play();
           bRegistrar.setIcon(registrar2);
       }
        
    }

    public void mouseExited(MouseEvent e)
    {
        ImageIcon salirA;
        salirA = new ImageIcon(getClass().getResource("SALIDA.gif"));
        
        ImageIcon salirN;
        salirN = new ImageIcon(getClass().getResource("SALIR.png"));     
        
        ImageIcon conexionA;
        conexionA = new ImageIcon(getClass().getResource("ANDROIDA.gif"));
        ImageIcon conexionN;
        conexionN = new ImageIcon(getClass().getResource("ANDROIDN.png"));
        
        ImageIcon ingresar;
        ingresar = new ImageIcon(getClass().getResource("INGRESAR.png"));
        ImageIcon ingresar2;
        ingresar2 = new ImageIcon(getClass().getResource("INGRESAR_1.png"));
        
        ImageIcon registrar;
        registrar = new ImageIcon(getClass().getResource("REGISTRAR.png"));
        ImageIcon registrar2;
        registrar2 = new ImageIcon(getClass().getResource("REGISTRAR_1.png"));
        
        //AnimationClass cuadro = new AnimationClass();
        
        if(e.getSource()==bSalir)
        {
            bSalir.setIcon(salirN);
            //cuadro.jButtonXLeft(0, -130, 10, 20, bSalir);
            bSalir.setBounds(-130,640,160,128);
        }
       /* if(e.getSource()==bConexion)
        {
            bConexion.setIcon(conexionN);
        }*/
        if(e.getSource()==bIngresar)
       {
           bIngresar.setIcon(ingresar);
       }
        if(e.getSource()==bRegistrar)
       {
           bRegistrar.setIcon(registrar);
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

    public static void main (String args[]){

        
        Inicio menu = new Inicio();
        menu.setBounds(210,100,1500,800);
        menu.setVisible(true);
        Reproductor reproductor = new Reproductor();
        reproductor.setBounds(210,100,5,5);
        reproductor.setVisible(true);
        

    }

    @Override
    public void focusGained(FocusEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        if(e.getSource()==tfUsuario)
        {
            tfUsuario.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        }
        
        if(e.getSource()==tfPass)
        {
            tfPass.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        }
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        if(e.getSource()==tfUsuario)
        {
            tfUsuario.setBorder(null);
        }
        
        if(e.getSource()==tfPass)
        {
            tfPass.setBorder(null);
        }
        
    }



}
