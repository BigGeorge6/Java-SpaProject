import java.applet.AudioClip;
import javax.swing.*; //Ventanas
import java.awt.event.*; //Botones y Combo, Menus
import java.awt.*;  //Fuente,Color,Imagenes
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.Desktop;
import java.net.URI;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal extends JFrame implements ActionListener, MouseListener, ItemListener,FocusListener {

    public JMenuBar menuBar;
    public JMenu menu1,menu2,home;
    public JMenuItem menu1item1,menu1item2, menu2item1,menu2item2;
    public String opc;
    public JLabel ePara;
    public JLabel eFondo;
    public JButton bSalir,bNosotros,bServicios,bJennyLu;
    public JButton bFacial,bMasaje,bAlterno,bBuscar,bBorrar;
    public Font fuente4 = new Font("Goudy Stout", Font.BOLD, 32);
    public String nombreC,passC,domicilioC,telefonoC,emailC,descripcionC,nivelC;
    public int id_clienteC,id_citaC;
    public Connection con;// = DriverManager.getConnection("jdbc:mysql://localhost:3306/estetica","root","");
    public PreparedStatement pst;
    public int contS=0,contO=0;
    public JLabel eAgendar;
    public JButton bAgendar;
     public String predeterminado="|  ID CITA  |   FECHA/HORARIO   |  DESCRIPCION  |  NIVEL  |",anexo=" No se encontraron datos...";//horarioC,
    public JComboBox <String> cFacial,cMasaje,cAlterno,cDia,cMes,cAno,cHorario,cNivel;
    public String dia=" ",mes=" ",ano=" ",hora=" ",sDescripcion=" ",sNivel=" ",sHorario=" ";
    public JTextArea aMostrador,aDatosPersonales;
    public JScrollPane scroll,scroll2;
    public JTextField tfId;
    
    public Principal() {
        super();                   
        configurarMenuG();        
        inicializarComponentes();   
    }

    public void configurarMenuG()
    {
        setLayout(null);
        setTitle("MENU");
        this.setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(210,100,1500,800);
        Inicio m = new Inicio();
        nombreC= m.nombreF;
        id_clienteC = m.id_cliente;
        domicilioC = m.domicilioF;
        telefonoC = m.telefonoF;
        emailC = m.emailF;   
        //JOptionPane.showMessageDialog(this, nombreC);
        
    }

    public void inicializarComponentes (){
        
        ///////////////////////////  FUENTES  //////////////////////////////////////////
        
        Font fuente1 = new Font("Harlow Solid Italic", Font.PLAIN, 20);
        Font fuente2 = new Font("Copperplate Gothic Bold", Font.PLAIN, 16);
        Font fuente3 = new Font("Goudy Stout", Font.PLAIN, 28);
        
        Font fuente5 = new Font("Comic Sans MS", Font.PLAIN, 18);
        Font fuente6 = new Font("Copperplate Gothic Bold", Font.PLAIN, 60);
        Font fuente7 = new Font("Adobe Heiti Std R", Font.PLAIN, 12);
        Font fuente8 = new Font("Cooper Black", Font.PLAIN, 22);
        Font fuente9 = new Font("Comic Sans MS", Font.PLAIN, 30);
        
        ///////////////////////////////////////////////////////////////////////////////
        
        ImageIcon lobby;
        lobby = new ImageIcon(getClass().getResource("LOBBY.png"));
        ImageIcon cuenta;
        cuenta = new ImageIcon(getClass().getResource("MICUENTA.png"));
        ImageIcon productos;
        productos = new ImageIcon(getClass().getResource("PRODUCTOS.png"));
        ImageIcon servicios;
        servicios = new ImageIcon(getClass().getResource("SERVICIOS.png"));
        
        ImageIcon salirA;
        salirA = new ImageIcon(getClass().getResource("SALIDA.gif"));
        ImageIcon salirN;
        salirN = new ImageIcon(getClass().getResource("SALIR.png"));
        
        ImageIcon acercade;
        acercade = new ImageIcon(getClass().getResource("ACERCADE.png"));
        
        ImageIcon paradise;
        paradise = new ImageIcon(getClass().getResource("PARADISE2.png"));
        ImageIcon servicios2;
        servicios2 = new ImageIcon(getClass().getResource("SERVICIOS2.png"));
        
        ImageIcon jenny;
        jenny = new ImageIcon(getClass().getResource("JENNY.png"));
        
        ImageIcon facial;
        facial = new ImageIcon(getClass().getResource("FACIALES.png"));
        ImageIcon masaje;
        masaje = new ImageIcon(getClass().getResource("MASAJES.png"));
        ImageIcon alterno;
        alterno = new ImageIcon(getClass().getResource("ALTERNO.png"));
        
        ImageIcon agendar;
        agendar = new ImageIcon(getClass().getResource("AGENDAR.png"));
        ImageIcon agendar1;
        agendar1 = new ImageIcon(getClass().getResource("AGENDAR_1.png"));
        
        ImageIcon buscar;
        buscar = new ImageIcon(getClass().getResource("BUSCAR.png"));
        ImageIcon buscar1;
        buscar1 = new ImageIcon(getClass().getResource("BUSCAR_1.png"));
        
        ImageIcon borrar;
        borrar = new ImageIcon(getClass().getResource("BORRAR.png"));
        ImageIcon borrar1;
        borrar1 = new ImageIcon(getClass().getResource("BORRAR_1.png"));
        
        ///////////////////////////////////////////////////////////////////////////////
        
        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(124,51,2));
        
        
        setJMenuBar(menuBar);
        
        home = new JMenu("          HOME          ");
        home.setFont(fuente4);
        home.setForeground(Color.white);
        this.menuBar.add(home);
        home.addActionListener(this);
        home.addMouseListener(this);

       /* menu1 = new JMenu("    MI CUENTA    ");
        menu1.setFont(fuente4);
        menu1.setForeground(Color.white);
        this.menuBar.add(menu1);
        menu1.addActionListener(this);
        menu1.addMouseListener(this);
        
        menu1item1= new JMenuItem("MI PERFIL");
        menu1item1.setFont(fuente4);
        menu1item1.setBackground(new Color(124,51,2));
        menu1item1.setForeground(Color.white);
        menu1item1.addActionListener(this);
        menu1item1.addMouseListener(this);
        this.menu1.add(menu1item1);

        menu1item2= new JMenuItem("MIS CITAS");
        menu1item2.setFont(fuente4);
        menu1item2.setBackground(new Color(124,51,2));
        menu1item2.setForeground(Color.white);
        menu1item2.addActionListener(this);
        menu1item2.addMouseListener(this);
        this.menu1.add(menu1item2);*/

        //////////////////////////////////////////////////////////////////////
     
        menu2 = new JMenu("          SERVICIOS    ");
        menu2.setFont(fuente4);
        menu2.setForeground(Color.white);
        this. menuBar.add(menu2);
        menu2.addActionListener(this);
        menu2.addMouseListener(this);

        menu2item1= new JMenuItem("AGENDAR CITA");
        menu2item1.setFont(fuente4);
        menu2item1.setBackground(new Color(124,51,2));
        menu2item1.setForeground(Color.white);
        menu2item1.addActionListener(this);
        menu2item1.addMouseListener(this);
        this.menu2.add(menu2item1);

        menu2item2= new JMenuItem("ELIMINAR CITA");
        menu2item2.setFont(fuente4);
        menu2item2.setBackground(new Color(124,51,2));
        menu2item2.setForeground(Color.white);
        menu2item2.addActionListener(this);
        menu2item2.addMouseListener(this);
        this.menu2.add(menu2item2);
        
        ////////////////////////  BOTONES HOME //////////////////////////////
        
        bNosotros = new JButton(acercade);
        bNosotros.setBounds(470,45,1000,360);
        add(bNosotros);
        bNosotros.addActionListener(this);
        bNosotros.addMouseListener(this);
        
        bServicios = new JButton(servicios2);
        bServicios.setBounds(470,418,1000,296);
        add(bServicios);
        bServicios.addActionListener(this);
        bServicios.addMouseListener(this);
        
        bJennyLu = new JButton(jenny);
        bJennyLu.setBounds(15, 300, 440, 370);
        add(bJennyLu);
        bJennyLu.addActionListener(this);
        bJennyLu.addMouseListener(this);
        
        bSalir = new JButton(salirN);
        bSalir.setBounds(-130,600,160,128);
        add(bSalir);
        bSalir.addActionListener(this);
        bSalir.addMouseListener(this);
        
        ///////////////////////// BOTONES AGENDAR CITA //////////////////////
        
        bFacial = new JButton(facial);
        bFacial.setBounds(85,37,400,670);
        add(bFacial);
        bFacial.addActionListener(this);
        bFacial.addMouseListener(this);
        bFacial.setVisible(false);
        
        bMasaje = new JButton(masaje);
        bMasaje.setBounds(570, 37, 400, 670);
        add(bMasaje);
        bMasaje.addActionListener(this);
        bMasaje.addMouseListener(this);
        bMasaje.setVisible(false);
        
        bAlterno = new JButton(alterno);
        bAlterno.setBounds(1055, 37, 400, 670);
        add(bAlterno);
        bAlterno.addActionListener(this);
        bAlterno.addMouseListener(this);
        bAlterno.setVisible(false);
        
        bAgendar = new JButton(agendar);
        bAgendar.setBounds(735,573,534,134);
        add(bAgendar);
        bAgendar.addActionListener(this);
        bAgendar.addMouseListener(this);
        bAgendar.setVisible(false);
        
        eAgendar = new JLabel("AGENDAR CITA");
        eAgendar.setBounds(600,37,700,50);
        eAgendar.setFont(fuente6);
        eAgendar.setForeground(Color.white);
        add(eAgendar);
        eAgendar.setVisible(false);
        
        ////////////////////////  COMBO AGENDAR CITA /////////////////////////////////////
        
        cFacial = new JComboBox<String>();
        cFacial.setBounds(950,160,300,50);
        add(cFacial);

        cFacial.addItem("Limpieza Facial");
        cFacial.addItem("Desincrustante");
        cFacial.addItem("Hidratante");
        cFacial.addItem("Nutritivo");
        cFacial.addItem("Oxigenante");
        cFacial.addItem("Anti-edad");
        cFacial.addItem("Velo de colageno");
        cFacial.addItem("Despigmentante");
        cFacial.addItem("Holistico");

        cFacial.setEditable(true);
        cFacial.setSelectedItem("Servicio");
        cFacial.setFont(fuente9);
        cFacial.setEditable(false);
        cFacial.setVisible(false);
        
        cMasaje = new JComboBox<String>();
        cMasaje.setBounds(950,160,300,50);
        add(cMasaje);

        cMasaje.addItem("Masaje relajante");
        cMasaje.addItem("Masaje antiestres");
        cMasaje.addItem("Masaje brisa de mar");
        cMasaje.addItem("Masaje holistico");
        cMasaje.addItem("Masaje reductivo");
        cMasaje.addItem("Masaje de pies");
        cMasaje.addItem("Masaje deportivo");
        cMasaje.addItem("Masaje reafirmante");
        cMasaje.addItem("Manicura y pedicura");

        cMasaje.setEditable(true);
        cMasaje.setSelectedItem("Servicio");
        cMasaje.setFont(fuente9);
        cMasaje.setEditable(false);
        cMasaje.setVisible(false);
        
        cAlterno = new JComboBox<String>();
        cAlterno.setBounds(950,160,300,50);
        add(cAlterno);

        cAlterno.addItem("Acupuntura");
        cAlterno.addItem("Reflexologia");
        cAlterno.addItem("Tratamientos esteticos");
        cAlterno.addItem("Vendas Calientes");
        cAlterno.addItem("Vendas Frías");
        cAlterno.addItem("Chocolaterapia");
        cAlterno.addItem("Depillacion con cera");
        cAlterno.addItem("Planchado Express");

        cAlterno.setEditable(true);
        cAlterno.setSelectedItem("Servicio");
        cAlterno.setFont(fuente9);
        cAlterno.setEditable(false);
        cAlterno.setVisible(false);
        
        cDia = new JComboBox<String>();
        cDia.setBounds(950,250,90,50);
        add(cDia);

        cDia.addItem("1");cDia.addItem("2");cDia.addItem("3");cDia.addItem("4");
        cDia.addItem("5");cDia.addItem("6");cDia.addItem("7");cDia.addItem("8");
        cDia.addItem("9");cDia.addItem("10");cDia.addItem("11");cDia.addItem("12");
        cDia.addItem("13");cDia.addItem("14");cDia.addItem("15");cDia.addItem("16");
        cDia.addItem("17");cDia.addItem("18");cDia.addItem("19");cDia.addItem("20");
        cDia.addItem("21");cDia.addItem("22");cDia.addItem("23");cDia.addItem("24");
        cDia.addItem("25");cDia.addItem("26");cDia.addItem("27");cDia.addItem("28");
        cDia.addItem("29");cDia.addItem("30");cDia.addItem("31");

        cDia.setEditable(true);
        cDia.setSelectedItem("DIA");
        cDia.setFont(fuente9);
        cDia.setEditable(false);
        cDia.setVisible(false);
        
        cMes = new JComboBox<String>();
        cMes.setBounds(1060,250,100,50);
        add(cMes);

        cMes.addItem("01");cMes.addItem("02");cMes.addItem("03");cMes.addItem("04");
        cMes.addItem("05");cMes.addItem("06");cMes.addItem("07");cMes.addItem("08");
        cMes.addItem("09");cMes.addItem("10");cMes.addItem("11");cMes.addItem("12");

        cMes.setEditable(true);
        cMes.setSelectedItem("MES");
        cMes.setFont(fuente9);
        cMes.setEditable(false);
        cMes.setVisible(false);
        
        cAno = new JComboBox<String>();
        cAno.setBounds(1180,250,100,50);
        add(cAno);

        cAno.addItem("2020");cAno.addItem("2021");cAno.addItem("2022");/*cAno.addItem("04");
        cAno.addItem("05");cAno.addItem("06");cAno.addItem("07");cAno.addItem("08");
        cAno.addItem("09");cAno.addItem("10");cAno.addItem("11");cAno.addItem("12");*/

        cAno.setEditable(true);
        cAno.setSelectedItem("AÑO");
        cAno.setFont(fuente9);
        cAno.setEditable(false);
        cAno.setVisible(false);
        
        cHorario = new JComboBox<String>();
        cHorario.setBounds(950,340,300,50);
        add(cHorario);

        cHorario.addItem("14:00:00");
        cHorario.addItem("15:00:00");
        cHorario.addItem("16:00:00");
        cHorario.addItem("17:00:00");
        cHorario.addItem("18:00:00");
        cHorario.addItem("19:00:00");

        cHorario.setEditable(true);
        cHorario.setSelectedItem("Horario");
        cHorario.setFont(fuente9);
        cHorario.setEditable(false);
        cHorario.setVisible(false);
        
        cNivel = new JComboBox<String>();
        cNivel.setBounds(950,430,300,50);
        add(cNivel);

        cNivel.addItem("Final Feliz");
        cNivel.addItem("Final Cremoso");
        cNivel.addItem("Final Premium");
        cNivel.addItem("Final XXX");

        cNivel.setEditable(true);
        cNivel.setSelectedItem("Nivel");
        cNivel.setFont(fuente9);
        cNivel.setEditable(false);
        cNivel.setVisible(false);
        
        cNivel.addItemListener(this);
        cHorario.addItemListener(this);
        cAno.addItemListener(this);
        cMes.addItemListener(this);
        cDia.addItemListener(this);
        cAlterno.addItemListener(this);
        cMasaje.addItemListener(this);
        cFacial.addItemListener(this);
        
        ////////////////////////////  ELIMINAR CITA  /////////////////////////////
        
        aMostrador= new JTextArea("Presione buscar...");
        scroll = new JScrollPane(aMostrador);
        scroll.setBounds(100,95,1000,600);
        aMostrador.setFont(fuente9);
        add(scroll);
        scroll.setVisible(false);
        aMostrador.setEditable(false);
        
        bBuscar = new JButton(buscar);
        bBuscar.setBounds(1200, 95, 250, 85);
        add(bBuscar);
        bBuscar.addActionListener(this);
        bBuscar.addMouseListener(this);
        bBuscar.setVisible(false);
        
        bBorrar = new JButton(borrar);
        bBorrar.setBounds(1150, 596, 308, 99);
        add(bBorrar);
        bBorrar.addActionListener(this);
        bBorrar.addMouseListener(this);
        bBorrar.setVisible(false);
        
        /*
        
        nombreC= m.nombreF;
        id_clienteC = m.id_cliente;
        domicilioC = m.domicilioF;
        telefonoC = m.telefonoF;
        emailC = m.emailF;
        
        */
        
        aDatosPersonales= new JTextArea("Datos Personales: \n" + "ID Cliente: " + id_clienteC
        + "\nNombre: " + nombreC + "\nDomicilio: " + domicilioC + "\nTeléfono: " + telefonoC + "\nEmail: " + emailC);
        scroll2 = new JScrollPane(aDatosPersonales);
        scroll2.setBounds(1150,200,310,280);
        aDatosPersonales.setFont(fuente9);
        add(scroll2);
        scroll2.setVisible(false);
        aDatosPersonales.setEditable(false);
        
        tfId = new JTextField("Id de la cita:");
        tfId.setBounds(1150, 500, 310, 50);
        tfId.setFont(fuente9);
        add(tfId);
        tfId.addFocusListener(this);
        tfId.setVisible(false);
        
        ///////////////////////////////////////////////////////////////////////
        
        /*java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = 
        new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);
        
        JOptionPane.showMessageDialog(this, currentTime);*/
        
        /////////////////////////////// UTILLIZAR PARA FECHAS //////////////////////////////////////////////
        
        /*String fecha="2020-12-02 17:25:00";
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fechaDate = null;
           
            
            
        try {
            fechaDate = formato.parse(fecha);
            Timestamp timestamp = new Timestamp(fechaDate.getTime());
            //java.sql.Date date2 = new java.sql.Date(fechaDate.getTime());
            JOptionPane.showMessageDialog(this, timestamp);
            
            Connection con;
                    try {
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/estetica","root","");
                        PreparedStatement pst = con.prepareStatement("INSERT INTO citas (fecha) VALUES"
                                + "(?)");
                        pst.setTimestamp(1, timestamp);
                        pst.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        } */
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        //////////////////////////////////////////////////////////////////
        
        //eAgendar.setVisible(false);
        
        ePara = new JLabel(paradise);
        ePara.setBounds(0, 37, 440, 259);
        add(ePara);
        
        eFondo = new JLabel(lobby);
        eFondo.setBounds(0,0,1500,800);
        this.add(eFondo);
        
        

    }

    public void actionPerformed (ActionEvent e){
        
        ImageIcon lobby;
        lobby = new ImageIcon(getClass().getResource("LOBBY.png"));
        ImageIcon cuenta;
        cuenta = new ImageIcon(getClass().getResource("MICUENTA.png"));
        ImageIcon productos;
        productos = new ImageIcon(getClass().getResource("PRODUCTOS.png"));
        ImageIcon servicios;
        servicios = new ImageIcon(getClass().getResource("SERVICIOS.png"));
        
        //AnimationClass cuadro = new AnimationClass();
        
        
        if(e.getSource()==bAgendar)
        {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date fechaDate = null;
            JOptionPane.showMessageDialog(this, sHorario);
            
            try {
            fechaDate = formato.parse(sHorario);
            Timestamp horario = new Timestamp(fechaDate.getTime());
            //java.sql.Date date2 = new java.sql.Date(fechaDate.getTime());
            JOptionPane.showMessageDialog(this, horario);
            Timestamp horario2 = new Timestamp(fechaDate.getTime());
            
            Connection con;
            ResultSet rs=null;
                        
                                try {
                                con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net/sql9380136","sql9380136","UFbzlaVNRt");
                                //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/estetica","root","");
                                pst = con.prepareStatement("INSERT INTO citas (id_cliente,fecha,descripcion,nivel) VALUES"
                                + "(?, ?, ?, ?)");
                                pst.setInt(1,id_clienteC);
                                pst.setTimestamp(2, horario);
                                pst.setString(3, sDescripcion);
                                pst.setString(4,sNivel);
                                pst.executeUpdate();
                                
                                eFondo.setIcon(lobby);
                                bServicios.setVisible(true);
                                bJennyLu.setVisible(true);
                                bNosotros.setVisible(true);
                                ePara.setVisible(true);
            
                                bFacial.setVisible(false);
                                bMasaje.setVisible(false);
                                bAlterno.setVisible(false);
                                bAgendar.setVisible(false);
                                eAgendar.setVisible(false);
                                cFacial.setVisible(false);
                                cMasaje.setVisible(false);
                                cAlterno.setVisible(false);
                                cDia.setVisible(false);
                                cMes.setVisible(false);
                                cAno.setVisible(false);
                                cHorario.setVisible(false);
                                cNivel.setVisible(false);
            
                                bFacial.setBounds(85,37,400,670);
                                bMasaje.setBounds(570, 37, 400, 670);
                                bAlterno.setBounds(1055, 37, 400, 670);
                                contS=0;
                                
                                JOptionPane.showMessageDialog(this, "Cita registrada con exito!");
                        
                                } catch (SQLException i) {
                                    //Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, i);
                                    
                                    eFondo.setIcon(lobby);
                                    bServicios.setVisible(true);
                                    bJennyLu.setVisible(true);
                                    bNosotros.setVisible(true);
                                    ePara.setVisible(true);
            
                                    bFacial.setVisible(false);
                                    bMasaje.setVisible(false);
                                    bAlterno.setVisible(false);
                                    bAgendar.setVisible(false);
                                    eAgendar.setVisible(false);
                                    cFacial.setVisible(false);
                                    cMasaje.setVisible(false);
                                    cAlterno.setVisible(false);
                                    cDia.setVisible(false);
                                    cMes.setVisible(false);
                                    cAno.setVisible(false);
                                    cHorario.setVisible(false);
                                    cNivel.setVisible(false);
            
                                    bFacial.setBounds(85,37,400,670);
                                    bMasaje.setBounds(570, 37, 400, 670);
                                    bAlterno.setBounds(1055, 37, 400, 670);
                                    contS=0;
                                    
                                    JOptionPane.showMessageDialog(this, "Intentelo de nuevo mas tarde!");
                                }
            } catch (ParseException ex) 
            {
                System.out.println(ex);
            } 
            
            
            
        }
        
        if(e.getSource()==bBuscar)
        {
            if(contO==0)//DESCENDENTE
            {
                    Connection con=null;
                    ResultSet rs=null;
                    try {
                        //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/estetica","root","");
                        con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net/sql9380136","sql9380136","UFbzlaVNRt");
                        PreparedStatement pst = con.prepareStatement("SELECT id_cita,fecha,descripcion,nivel FROM citas WHERE id_cliente = ?");
                        
                        pst.setInt(1,id_clienteC);
                        rs = pst.executeQuery();
                        
                        String horarioC="";
                        anexo="";
                        while(rs.next())
                        {
                            anexo=anexo + " \n         ";
                            id_citaC = rs.getInt(1);
                            anexo= anexo + id_citaC + "         ";
                            horarioC = rs.getString(2);
                            anexo=anexo + horarioC + "  ";
                            descripcionC = rs.getString(3);
                            anexo=anexo + descripcionC + "  ";
                            nivelC = rs.getString(4);
                            anexo=anexo + nivelC + "  ";
                            
                        }
                        
                        predeterminado=predeterminado+anexo;
                        aMostrador.setText(predeterminado);
                        
                        
                        //entrada=false;
                        //JOptionPane.showMessageDialog(this, "No se ha encontrado usuario en la base de datos");
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "No se ha encontrado citas en la base de datos");
                    }
                    anexo=" No se encontraron datos...";
                    predeterminado="|  ID CITA  |   FECHA/HORARIO   |  DESCRIPCION  |  NIVEL  |";
            }
            if(contO==1)//ASCENDENTE
            {
                
            }
        }
        
        if(e.getSource()==bBorrar)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("CLICK.wav"));
            sonido.play();
            String Id=tfId.getText();
            boolean bId;
            
            if(Id.length()==0)
            {
                tfId.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                JOptionPane.showMessageDialog(this, "¡Necesita ingresar un ID!");
                tfId.requestFocus();
            }else{
                //JOptionPane.showMessageDialog(this, "¡BIEN!");
                
                bId=Id.matches("^[0-9]{1,2}$");
                
                if(bId==false)
                {
                    tfId.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                    JOptionPane.showMessageDialog(this, "El formato para el ID es: (1-9) Minimo 1");
                    tfId.setText("");
                    tfId.requestFocus();
                }else
                {
                    //JOptionPane.showMessageDialog(this, "YA CASIIIII");
                    int idF = Integer.parseInt(Id);
                    Connection con;
                    try {
                        //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/estetica","root","");
                        con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net/sql9380136","sql9380136","UFbzlaVNRt");
                        PreparedStatement pst = con.prepareStatement("DELETE FROM citas WHERE id_cita = ?");
                        pst.setInt(1,idF);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Cita cancelada con éxito!");
                        
                    } catch (SQLException ex) {
                        //Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "Algo salió mal, vuelve a intentarlo más tarde");
                    }
                    
                }
                
            }
        }
        
        if(e.getSource()==bFacial)
        {
            if(contS==0)
            {
                bMasaje.setVisible(false);
                bAlterno.setVisible(false);
                eAgendar.setVisible(true);
                bAgendar.setVisible(true);
                cFacial.setVisible(true);
                cDia.setVisible(true);
                cMes.setVisible(true);
                cAno.setVisible(true);
                cHorario.setVisible(true);
                cNivel.setVisible(true);
                
                contS=1;
            }else
            if(contS==1)
            {
                bMasaje.setVisible(true);
                bAlterno.setVisible(true);
                eAgendar.setVisible(false);
                bAgendar.setVisible(false);
                cFacial.setVisible(false);
                cDia.setVisible(false);
                cMes.setVisible(false);
                cAno.setVisible(false);
                cHorario.setVisible(false);
                cNivel.setVisible(false);
                
                contS=0;
            }
            //bFacial.setEnabled(false);
            
            
            
        }
        
        if(e.getSource()==bMasaje)
        {
            if(contS==0)
            {
                //bMasaje.setEnabled(false);
                bFacial.setVisible(false);
                bAlterno.setVisible(false);
                bMasaje.setBounds(85, 37, 400, 670);
                //cuadro.jButtonXLeft(570, 85, 6, 5, bMasaje);
                eAgendar.setVisible(true);
                bAgendar.setVisible(true);
                cMasaje.setVisible(true);
                cDia.setVisible(true);
                cMes.setVisible(true);
                cAno.setVisible(true);
                cHorario.setVisible(true);
                cNivel.setVisible(true);
                
                contS=1;
            }else
            if(contS==1)
            {
                //bMasaje.setEnabled(false);
                bFacial.setVisible(true);
                bAlterno.setVisible(true);
                bMasaje.setBounds(570, 37, 400, 670);
                //cuadro.jButtonXRight(85, 570, 6, 5, bMasaje);
                eAgendar.setVisible(false);
                bAgendar.setVisible(false);
                cMasaje.setVisible(false);
                cDia.setVisible(false);
                cMes.setVisible(false);
                cAno.setVisible(false);
                cHorario.setVisible(false);
                cNivel.setVisible(false);
                
                contS=0;
            }
            
        }
        
        if(e.getSource()==bAlterno)
        {
            if(contS==0)
            {
                //bAlterno.setEnabled(false);
                bFacial.setVisible(false);
                bMasaje.setVisible(false);
                bAlterno.setBounds(85, 37, 400, 670);
                //cuadro.jButtonXLeft(1055, 85, 12, 10, bAlterno);
                eAgendar.setVisible(true);
                bAgendar.setVisible(true);
                cAlterno.setVisible(true);
                cDia.setVisible(true);
                cMes.setVisible(true);
                cAno.setVisible(true);
                cHorario.setVisible(true);
                cNivel.setVisible(true);
                
                contS=1;
            }else
            if(contS==1)
            {
                bFacial.setVisible(true);
                bMasaje.setVisible(true);
                bAlterno.setBounds(1055, 37, 400, 670);
                //cuadro.jButtonXRight(85, 1055, 12, 10, bAlterno);
                eAgendar.setVisible(false);
                bAgendar.setVisible(false);
                cAlterno.setVisible(false);
                cDia.setVisible(false);
                cMes.setVisible(false);
                cAno.setVisible(false);
                cHorario.setVisible(false);
                cNivel.setVisible(false);
                
                contS=0;
            }
            
        }
        
        if(e.getSource()==bServicios)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("CLICK.wav"));
            sonido.play();
            eFondo.setIcon(servicios);
            bServicios.setVisible(false);
            bJennyLu.setVisible(false);
            bNosotros.setVisible(false);
            ePara.setVisible(false);
            
            bFacial.setBounds(85,37,400,670);
            bMasaje.setBounds(570, 37, 400, 670);
            bAlterno.setBounds(1055, 37, 400, 670);
            contS=0;
            
            eFondo.setIcon(servicios);
            bServicios.setVisible(false);
            bJennyLu.setVisible(false);
            bNosotros.setVisible(false);
            ePara.setVisible(false);
            
            bFacial.setVisible(true);
            bMasaje.setVisible(true);
            bAlterno.setVisible(true);
            eAgendar.setVisible(false);
            bAgendar.setVisible(false);
            cFacial.setVisible(false);
            cMasaje.setVisible(false);
            cAlterno.setVisible(false);
            cDia.setVisible(false);
            cMes.setVisible(false);
            cAno.setVisible(false);
            cHorario.setVisible(false);
            cNivel.setVisible(false);
            
            
        }
        
        if(e.getSource()==bJennyLu)
        {
          try{
                Desktop.getDesktop().browse(new URI("https://www.instagram.com/jlo/?hl=es-la"));
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "ERROR, no se pudo conectar a internet");
            }
        }
        
        if(e.getSource()==bNosotros)
        {
            try{
                Desktop.getDesktop().browse(new URI("https://www.delalmaspa.com/"));
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "ERROR, no se pudo conectar a internet");
            }
        }
        
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
        
        
        
      /*  if(e.getSource()==menu1item1)
        {
            bFacial.setBounds(85,37,400,670);
            bMasaje.setBounds(570, 37, 400, 670);
            bAlterno.setBounds(1055, 37, 400, 670);
            contS=0;
            AudioClip sonidoC;
            sonidoC = java.applet.Applet.newAudioClip(getClass().getResource("CLICK.wav"));
            sonidoC.play();
            eFondo.setIcon(cuenta);
            bServicios.setVisible(false);
            bJennyLu.setVisible(false);
            bNosotros.setVisible(false);
            ePara.setVisible(false);
            
            bFacial.setVisible(false);
            bMasaje.setVisible(false);
            bAlterno.setVisible(false);
            eAgendar.setVisible(false);
            bAgendar.setVisible(false);
            cFacial.setVisible(false);
            cMasaje.setVisible(false);
            cAlterno.setVisible(false);
            cDia.setVisible(false);
            cMes.setVisible(false);
            cAno.setVisible(false);
            cHorario.setVisible(false);
            cNivel.setVisible(false);
            JOptionPane.showMessageDialog(this, "Regresando al lobby...");
            scroll.setVisible(false);
            bBuscar.setVisible(false);
            bBorrar.setVisible(false);
            
            
        }
        if(e.getSource()==menu1item2)
        {
            bFacial.setBounds(85,37,400,670);
            bMasaje.setBounds(570, 37, 400, 670);
            bAlterno.setBounds(1055, 37, 400, 670);
            contS=0;
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("CLICK.wav"));
            sonido.play();
            eFondo.setIcon(productos);
            bServicios.setVisible(false);
            bJennyLu.setVisible(false);
            bNosotros.setVisible(false);
            ePara.setVisible(false);
            
            bFacial.setVisible(false);
            bMasaje.setVisible(false);
            bAlterno.setVisible(false);
            eAgendar.setVisible(false);
            bAgendar.setVisible(false);
            cFacial.setVisible(false);
            cMasaje.setVisible(false);
            cAlterno.setVisible(false);
            cDia.setVisible(false);
            cMes.setVisible(false);
            cAno.setVisible(false);
            cHorario.setVisible(false);
            cNivel.setVisible(false);
            JOptionPane.showMessageDialog(this, "Regresando al lobby...");
            scroll.setVisible(false);
            bBuscar.setVisible(false);
            bBorrar.setVisible(false);
            
            
        }*/
        
        if(e.getSource()==menu2item1)
        {
            bFacial.setBounds(85,37,400,670);
            bMasaje.setBounds(570, 37, 400, 670);
            bAlterno.setBounds(1055, 37, 400, 670);
            contS=0;
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("CLICK.wav"));
            sonido.play();
            eFondo.setIcon(servicios);
            bServicios.setVisible(false);
            bJennyLu.setVisible(false);
            bNosotros.setVisible(false);
            ePara.setVisible(false);
            
            bFacial.setVisible(true);
            bMasaje.setVisible(true);
            bAlterno.setVisible(true);
            eAgendar.setVisible(false);
            bAgendar.setVisible(false);
            cFacial.setVisible(false);
            cMasaje.setVisible(false);
            cAlterno.setVisible(false);
            cDia.setVisible(false);
            cMes.setVisible(false);
            cAno.setVisible(false);
            cHorario.setVisible(false);
            cNivel.setVisible(false);
            JOptionPane.showMessageDialog(this, "Agendar una cita...");
            scroll.setVisible(false);
            scroll2.setVisible(false);
            bBuscar.setVisible(false);
            bBorrar.setVisible(false);
            tfId.setVisible(false);
            
            
        }
        
        if(e.getSource()==menu2item2)
        {
            bFacial.setBounds(85,37,400,670);
            bMasaje.setBounds(570, 37, 400, 670);
            bAlterno.setBounds(1055, 37, 400, 670);
            contS=0;
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("CLICK.wav"));
            sonido.play();
            eFondo.setIcon(servicios);
            bServicios.setVisible(false);
            bJennyLu.setVisible(false);
            bNosotros.setVisible(false);
            ePara.setVisible(false);
            
            bFacial.setVisible(false);
            bMasaje.setVisible(false);
            bAlterno.setVisible(false);
            eAgendar.setVisible(false);
            bAgendar.setVisible(false);
            cFacial.setVisible(false);
            cMasaje.setVisible(false);
            cAlterno.setVisible(false);
            cDia.setVisible(false);
            cMes.setVisible(false);
            cAno.setVisible(false);
            cHorario.setVisible(false);
            cNivel.setVisible(false);
            JOptionPane.showMessageDialog(this, "Ingresando a cancelación...");
            scroll.setVisible(true);
            scroll2.setVisible(true);
            bBuscar.setVisible(true);
            bBorrar.setVisible(true);
            tfId.setVisible(true);
            
            
        }
       
        
    }


   /* public static void main (String args[]){

        int t11;

        Principal pagP = new Principal();
        pagP.setBounds(210,100,1500,800);
        pagP.setVisible(true);
        pagP.setResizable(false);

    }*/

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ImageIcon lobby;
        lobby = new ImageIcon(getClass().getResource("LOBBY.png"));
        if(e.getSource()==home)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("CLICK.wav"));
            sonido.play();
            eFondo.setIcon(lobby);
            bServicios.setVisible(true);
            bJennyLu.setVisible(true);
            bNosotros.setVisible(true);
            ePara.setVisible(true);
            
            bFacial.setVisible(false);
            bMasaje.setVisible(false);
            bAlterno.setVisible(false);
            bAgendar.setVisible(false);
            eAgendar.setVisible(false);
            cFacial.setVisible(false);
            cMasaje.setVisible(false);
            cAlterno.setVisible(false);
            cDia.setVisible(false);
            cMes.setVisible(false);
            cAno.setVisible(false);
            JOptionPane.showMessageDialog(this, "Regresando al lobby...");
            cHorario.setVisible(false);
            cNivel.setVisible(false);
            scroll.setVisible(false);
            scroll2.setVisible(false);
            bBuscar.setVisible(false);
            bBorrar.setVisible(false);
            tfId.setVisible(false);
            
            bFacial.setBounds(85,37,400,670);
            bMasaje.setBounds(570, 37, 400, 670);
            bAlterno.setBounds(1055, 37, 400, 670);
            contS=0;
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
        //AnimationClass cuadro = new AnimationClass();
        ImageIcon salirA;
        salirA = new ImageIcon(getClass().getResource("SALIDA.gif"));
        
        ImageIcon salirN;
        salirN = new ImageIcon(getClass().getResource("SALIR.png")); 
        
        ImageIcon agendar;
        agendar = new ImageIcon(getClass().getResource("AGENDAR.png"));
        ImageIcon agendar1;
        agendar1 = new ImageIcon(getClass().getResource("AGENDAR_1.png"));
        
        ImageIcon buscar;
        buscar = new ImageIcon(getClass().getResource("BUSCAR.png"));
        ImageIcon buscar1;
        buscar1 = new ImageIcon(getClass().getResource("BUSCAR_1.png"));
        
        ImageIcon borrar;
        borrar = new ImageIcon(getClass().getResource("BORRAR.png"));
        ImageIcon borrar1;
        borrar1 = new ImageIcon(getClass().getResource("BORRAR_1.png"));
        
        if(e.getSource()==bBorrar)
        {
            bBorrar.setIcon(borrar1);
        }
        
        if(e.getSource()==bAgendar)
        {
            bAgendar.setIcon(agendar1);
        }
        
        if(e.getSource()==bBuscar)
        {
            bBuscar.setIcon(buscar);
        }
        
        if(e.getSource()==bSalir)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("POPW.wav"));
            sonido.play();
            bSalir.setIcon(salirA);
            bSalir.setBounds(0,600,160,128);
            //cuadro.jButtonXRight(-130, 0, 10, 20, bSalir);
        }
        
        if(e.getSource()==home)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("POPW.wav"));
            sonido.play();
        }
        
        if(e.getSource()==menu1)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("POPW.wav"));
            sonido.play();
        }
        
        if(e.getSource()==menu1item1)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("POPW.wav"));
            sonido.play();
        }
        
        if(e.getSource()==menu1item2)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("POPW.wav"));
            sonido.play();
        }
        
        if(e.getSource()==menu2)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("POPW.wav"));
            sonido.play();
        }
        
        if(e.getSource()==menu2item1)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("POPW.wav"));
            sonido.play();
        }
        
        if(e.getSource()==menu2item2)
        {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("POPW.wav"));
            sonido.play();
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //AnimationClass cuadro = new AnimationClass();
        ImageIcon salirA;
        salirA = new ImageIcon(getClass().getResource("SALIDA.gif"));
        
        ImageIcon salirN;
        salirN = new ImageIcon(getClass().getResource("SALIR.png")); 
        
        ImageIcon agendar;
        agendar = new ImageIcon(getClass().getResource("AGENDAR.png"));
        ImageIcon agendar1;
        agendar1 = new ImageIcon(getClass().getResource("AGENDAR_1.png"));
        
        ImageIcon buscar;
        buscar = new ImageIcon(getClass().getResource("BUSCAR.png"));
        ImageIcon buscar1;
        buscar1 = new ImageIcon(getClass().getResource("BUSCAR_1.png"));
        
        ImageIcon borrar;
        borrar = new ImageIcon(getClass().getResource("BORRAR.png"));
        ImageIcon borrar1;
        borrar1 = new ImageIcon(getClass().getResource("BORRAR_1.png"));
        
        if(e.getSource()==bBorrar)
        {
            bBorrar.setIcon(borrar);
        }
        
        if(e.getSource()==bBuscar)
        {
            bBuscar.setIcon(buscar);
        }
        
        if(e.getSource()==bSalir)
        {
            bSalir.setIcon(salirN);
            //cuadro.jButtonXLeft(0, -130, 10, 20, bSalir);
            bSalir.setBounds(-130,600,160,128);
        }
        
        if(e.getSource()==bAgendar)
        {
            bAgendar.setIcon(agendar);
        }
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        dia = cDia.getSelectedItem().toString();
        mes = cMes.getSelectedItem().toString();
        ano = cAno.getSelectedItem().toString();
        hora = cHorario.getSelectedItem().toString();
        
        if(e.getSource()==cFacial)
        {
            sDescripcion = cFacial.getSelectedItem().toString();
        }
        if(e.getSource()==cMasaje)
        {
            sDescripcion = cMasaje.getSelectedItem().toString();
        }
        if(e.getSource()==cAlterno)
        {
            sDescripcion = cAlterno.getSelectedItem().toString();
        }
        
        sNivel = cNivel.getSelectedItem().toString();
        //yyyy-MM-dd HH:mm:ss
        sHorario = ano + "-" + mes + "-" + dia + " " + hora; 
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==tfId)
        {
            
            tfId.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
            tfId.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==tfId)
        {
            
            tfId.setBorder(null);
            //tfId.setText("Id de la cita:");
        }
    }

}
