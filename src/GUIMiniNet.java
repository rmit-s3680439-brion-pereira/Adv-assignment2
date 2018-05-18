
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GUIMiniNet extends javax.swing.JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	File files;
	PersonDao personDao = new PersonDao();

	public GUIMiniNet() {
		initComponents();
	}

	// GUI design
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jButton4 = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jButton7 = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jTextField4 = new javax.swing.JTextField();
		jComboBox2 = new javax.swing.JComboBox<>();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jComboBox3 = new javax.swing.JComboBox<>();
		jButton6 = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jButton5 = new javax.swing.JButton();
		exit = new javax.swing.JButton();
		b1 = new javax.swing.JButton();
		b2 = new javax.swing.JButton();
		b3 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Social Network System GUI");
		setSize(900, 750);
		setLayout(null);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
		jLabel1.setText("MiniNet");
		jLabel1.setBounds(270, 6, 480, 40);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 255), 3));
		jPanel1.setBounds(0, 50, 880, 200);
		jPanel1.setLayout(null);

		jButton1.setText("Add a Person into the Network");
		jButton1.setToolTipText("");
		jButton1.addActionListener(this);
		jButton1.setBounds(15, 30, 250, 25);

		jButton2.setText("Display Profile of Selected Person");
		jButton2.setToolTipText("");
		jButton2.addActionListener(this);
		jButton2.setBounds(15, 80, 250, 25);

		jButton3.setText("Delete Selected Person From Network");
		jButton3.addActionListener(this);
		jButton3.setBounds(15, 130, 250, 25);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel2.setText("Select Person: ");
		jLabel2.setBounds(480, 25, 155, 25);

		jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>());
		jComboBox3.setBounds(610, 25, 200, 25);

		jButton7.setFont(new java.awt.Font("Tahoma", 1, 14));
		jButton7.setText("Loading Person Name");
		jButton7.addActionListener(this);
		jButton7.setBounds(610, 80, 200, 25);

		exit.setFont(new java.awt.Font("Tahoma", 1, 14));
		exit.setText("EXIT");
		exit.addActionListener(this);
		exit.setBounds(760, 160, 100, 30);

		b1.setFont(new java.awt.Font("Tahoma", 1, 14));
		b1.setText("2 People Directly Connected");
		b1.addActionListener(this);
		b1.setBounds(300, 80, 250, 20);

		b2.setFont(new java.awt.Font("Tahoma", 1, 14));
		b2.setText("Define Relation b/w 2 People");
		b2.addActionListener(this);
		b2.setBounds(300, 120, 250, 20);

		b3.setFont(new java.awt.Font("Tahoma", 1, 14));
		b3.setText("Find Children or Parents");
		b3.addActionListener(this);
		b3.setBounds(300, 160, 250, 20);

		jPanel1.add(jButton1);
		jPanel1.add(jButton2);
		jPanel1.add(jButton3);
		jPanel1.add(jLabel2);
		jPanel1.add(jComboBox3);
		jPanel1.add(jButton7);
		add(jPanel1);
		jPanel1.add(exit);
		jPanel1.add(b1);
		jPanel1.add(b2);
		jPanel1.add(b3);

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));
		jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0), 3));
		jPanel2.setBounds(0, 255, 880, 200);
		jPanel2.setLayout(null);

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel4.setText("Name");
		jLabel4.setBounds(15, 30, 150, 25);

		jTextField2.setBounds(100, 30, 150, 25);

		jTextField3.setBounds(100, 80, 150, 25);

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel3.setText("");
		jLabel3.setBounds(450, 80, 155, 25);

		jButton4.setText("Submit");
		jButton4.setFont(new java.awt.Font("Tahoma", 1, 14));
		jButton4.setBounds(650, 150, 200, 30);
		jButton4.addActionListener(this);

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel5.setText("Status");
		jLabel5.setBounds(15, 80, 150, 25);

		jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel6.setText("Age");
		jLabel6.setBounds(290, 30, 150, 25);

		jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel8.setText("State");
		jLabel8.setBounds(290, 80, 150, 25);

		jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel9.setText("Choose Image");
		jLabel9.setBounds(290, 130, 150, 25);

		jButton6.setFont(new java.awt.Font("Tahoma", 1, 18));
		jButton6.setText("select image");
		jButton6.addActionListener(this);
		jButton6.setBounds(400, 130, 150, 25);

		jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14));
		jTextField4.setBounds(340, 30, 210, 30);

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "ACT", "NSW", "NT", "QLD", "SA", "TAS", "VIC", "WA" }));
		jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 14));
		jComboBox2.setBounds(340, 80, 210, 30);

		jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel7.setText("Gender");
		jLabel7.setBounds(15, 130, 150, 25);

		jTextField1.setBounds(100, 130, 150, 25);

		jPanel2.add(jLabel4);
		jPanel2.add(jLabel5);
		jPanel2.add(jLabel6);
		jPanel2.add(jLabel7);
		jPanel2.add(jTextField2);
		jPanel2.add(jTextField3);
		jPanel2.add(jTextField4);
		jPanel2.add(jLabel3);
		jPanel2.add(jButton6);
		add(jPanel2);
		jPanel2.add(jTextField1);
		jPanel2.add(jComboBox2);
		;
		jPanel2.add(jButton4);
		jPanel2.add(jLabel8);
		jPanel2.add(jLabel9);

		jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51), 3));
		jPanel3.setBounds(0, 459, 880, 200);
		jPanel3.setLayout(null);

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);
		jScrollPane1.setBounds(2, 2, 876, 196);
		jPanel3.add(jScrollPane1);
		add(jPanel3);

		jButton5.setBackground(new java.awt.Color(255, 255, 255));
		jButton5.setFont(new java.awt.Font("Tahoma", 1, 24));
		jButton5.setText("RESET");
		jButton5.setBounds(2, 665, 876, 40);
		jButton5.addActionListener(this);

		add(jLabel1);
		add(jButton5);

	}

	// Variables declaration
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton exit;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JComboBox<String> jComboBox3, jComboBox2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6, jLabel9;
	private javax.swing.JLabel jLabel7, jLabel8;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private JFileChooser fileChooser;
	private javax.swing.JButton b1;
	private javax.swing.JButton b2;
	private javax.swing.JButton b3;

	String[] items = {};
	// End of variables declaration

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("MiniNet");
	}
}
