import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * GUIMiniNet class has code to build the GUI and it uses PersonDao to access
 * Database tables.
 * 
 * @author Brion Pereira
 * @createdOn 18 May 2018
 * 
 * @lastUpdatedBy Abhilash Nunes
 * @lastUpdatedOn 21 May 2018
 */
public class GUIMiniNet extends javax.swing.JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	File files;
	PersonDao personDao = new PersonDao();

	public GUIMiniNet() {
		initComponents();
	}

	// GUI design
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel(); // Title Label
		jPanel1 = new javax.swing.JPanel(); // Panel 1
		jButton1 = new javax.swing.JButton(); // Add Button
		jButton2 = new javax.swing.JButton(); // Display Button
		jButton3 = new javax.swing.JButton(); // Delete Button
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel(); // Select person label
		jButton4 = new javax.swing.JButton(); // Submit Button
		jLabel3 = new javax.swing.JLabel();
		jButton7 = new javax.swing.JButton(); // Load Button
		jPanel2 = new javax.swing.JPanel(); // Panel 2
		jLabel4 = new javax.swing.JLabel(); // Name Label
		jTextField2 = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel(); // Status Label
		jTextField3 = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel(); // Age Label
		jTextField4 = new javax.swing.JTextField();
		jComboBox2 = new javax.swing.JComboBox<>(); // State list combobox
		jLabel7 = new javax.swing.JLabel(); // Gender
		jLabel8 = new javax.swing.JLabel(); // State Label
		jLabel9 = new javax.swing.JLabel(); // Choose image Label
		jComboBox3 = new javax.swing.JComboBox<>(); // List of People
		jButton6 = new javax.swing.JButton(); // Select image Button
		jPanel3 = new javax.swing.JPanel(); // Panel 3
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jButton5 = new javax.swing.JButton(); // Reset Button
		exit = new javax.swing.JButton(); // Exit Button
		b1 = new javax.swing.JButton(); // Find relation
		b2 = new javax.swing.JButton(); // Define relation
		b3 = new javax.swing.JButton(); // Find child/parent Button

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("MiniNet");
		setSize(900, 750);
		setLayout(null);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
		jLabel1.setText("MiniNet Network");
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

		// Adding Components to Panel1
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
		jTextField2.setEnabled(false);

		jTextField3.setBounds(100, 80, 150, 25);
		jTextField3.setEnabled(false);

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel3.setText("");
		jLabel3.setBounds(450, 80, 155, 25);

		jButton4.setText("Submit");
		jButton4.setFont(new java.awt.Font("Tahoma", 1, 14));
		jButton4.setBounds(650, 150, 200, 30);
		jButton4.addActionListener(this);
		jButton4.setEnabled(false);

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel5.setText("Status");
		jLabel5.setBounds(15, 80, 150, 25);

		jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel6.setText("Age");
		jLabel6.setBounds(290, 30, 150, 25);
		jButton6.setEnabled(false);

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
		jButton6.setEnabled(false);

		jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14));
		jTextField4.setBounds(340, 30, 210, 30);
		jTextField4.setEnabled(false);
		jComboBox2.setEnabled(false);

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "ACT", "NSW", "NT", "QLD", "SA", "TAS", "VIC", "WA" }));
		jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 14));
		jComboBox2.setBounds(340, 80, 210, 30);

		jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel7.setText("Gender");
		jLabel7.setBounds(15, 130, 150, 25);

		jTextField1.setBounds(100, 130, 150, 25);

		// Adding components to Panel2
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
		// System.out.println("MiniNet");

		// Action Event on clicking Add a Person and enable GUI component in jPanel2
		if (e.getSource() == jButton1) {
			jTextField1.setEnabled(true);
			jTextField2.setEnabled(true);
			jTextField3.setEnabled(true);
			jTextField4.setEnabled(true);
			jComboBox2.setEnabled(true);
			jButton6.setEnabled(true);
			jButton4.setEnabled(true);
		}

		// Action Event to add image
		if (e.getSource() == jButton6) {
			fileChooser = new JFileChooser(new File("./src"));
			int returnVal = fileChooser.showOpenDialog(jButton1);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				files = fileChooser.getSelectedFile();
				JOptionPane.showMessageDialog(this, "Photo name: " + files.getName(), "Choose Image",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		// Action Event to display person
		if (e.getSource() == jButton2) {
			if (jComboBox3.getItemCount() == 0)
				JOptionPane.showMessageDialog(this, "First Load Name From Database", "Loading",
						JOptionPane.INFORMATION_MESSAGE);
			else {

				String name = jComboBox3.getSelectedItem().toString();
				jTextArea1.setText("Name \t\t Gender \t Age \t State \t Status");
				jTextArea1.append(
						"\n================================================================================\n\n");

				Person person = personDao.getByName(name);
				try {
					personDao.commitConn();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				jTextArea1.append(person.getName() + " \t\t " + person.getGender() + "\t" + person.getAge() + "\t"
						+ person.getState() + "\t" + person.getStatus());
				jTextArea1.append(
						"\n================================================================================\n\n");
				Blob blob = person.getPhoto();
				ImageIcon imageIcon = null;
				try {
					imageIcon = new ImageIcon(blob.getBytes(1, (int) blob.length()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(this,
						"Name: " + person.getName() + "\nAge: " + person.getAge() + "\nStatus: " + person.getStatus()
								+ "\nState: " + person.getState() + "\nGender: " + person.getGender(),
						"Display Information", JOptionPane.INFORMATION_MESSAGE, imageIcon);

			}

		}

		// Action Event to delete person
		if (e.getSource() == jButton3) {
			if (jComboBox3.getItemCount() == 0)
				JOptionPane.showMessageDialog(this, "First Load Name From Database", "Loading",
						JOptionPane.INFORMATION_MESSAGE);
			else {
				String name = jComboBox3.getSelectedItem().toString();

				name = name.trim();
				try {
					personDao.delete(name);
					personDao.commitConn();
					JOptionPane.showMessageDialog(this, "Deleted Successfully in Network !!!", "Deleted",
							JOptionPane.INFORMATION_MESSAGE);
					jComboBox3.removeAllItems();
					List<String> persons = personDao.getAllNames();

					for (String person : persons) {
						jComboBox3.addItem(person);
					}

				} catch (Exception ex) {
				}
			}
		}

		// Action Event to submit button to add person
		if (e.getSource() == jButton4) {
			try {
				String name = jTextField2.getText().trim();
				String status = jTextField3.getText().trim();
				String gender = jTextField1.getText().trim();
				int age = Integer.parseInt(jTextField4.getText().trim());
				String state = jComboBox2.getSelectedItem().toString();

				if (age <= 0 || age > 150)
					throw new NoSuchAgeException("Age should be greater than 0 and less than 150");

				Person p = new Person();
				p.setName(name);
				p.setAge(age);
				p.setGender(gender);
				p.setState(state);
				p.setStatus(status);

				personDao.save(p, files);

				JOptionPane.showMessageDialog(this, "Added Successfully in Network !!!", "Add Person",
						JOptionPane.INFORMATION_MESSAGE);

				jComboBox3.removeAllItems();
				List<String> persons = null;
				try {
					persons = personDao.getAllNames();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (String person : persons) {
					jComboBox3.addItem(person);
				}

				personDao.commitConn();
			} catch (NoSuchAgeException ex) {
				JOptionPane.showMessageDialog(this, ex, "NoSuchAgeException", JOptionPane.ERROR_MESSAGE);
			} catch (IOException ex) {
			} catch (SQLException ex) {
			}

			// Disable to jPanel2
			jTextField1.setEnabled(false);
			jTextField2.setEnabled(false);
			jTextField3.setEnabled(false);
			jTextField4.setEnabled(false);
			jComboBox2.setEnabled(false);
			jButton6.setEnabled(false);
			jButton4.setEnabled(false);

		}

		// Action event on clicking "Load Person Name"
		if (e.getSource() == jButton7) {
			jComboBox3.removeAllItems();
			List<String> persons = null;
			try {
				persons = personDao.getAllNames();
				personDao.commitConn();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (String p : persons) {
				jComboBox3.addItem(p);
			}

		}

		// Action Event to Get Relation between 2 person
		if (e.getSource() == b1) {
			try {
				String name1 = JOptionPane.showInputDialog(this, "Enter First Person Name: ");
				String name2 = JOptionPane.showInputDialog(this, "Enter Second Person Name: ");

				System.out.println("name1 =" + name1 + "\n name2=" + name2);

				String r = personDao.getRelationship(name1, name2);

				personDao.commitConn();

				if (!r.equals(""))
					JOptionPane.showMessageDialog(this, "Relation between " + name1 + " and " + name2 + " is : " + r,
							"Search Relation", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(this, "Relation between " + name1 + " and " + name2 + " No Relation ",
							"Search Relation", JOptionPane.ERROR_MESSAGE);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		// Action Event to Define Relation Button
		if (e.getSource() == b2) {
			try {
				String name1 = JOptionPane.showInputDialog(this, "Enter First Person Name: ");
				String name2 = JOptionPane.showInputDialog(this, "Enter Second Person Name: ");
				String rel = JOptionPane.showInputDialog(this, "Enter Relation Between ");

				int age1 = personDao.isPersonExisting(name1);
				int age2 = personDao.isPersonExisting(name2);

				if (age1 != -1 && age2 != -1) {
					String re = "";

					String r = personDao.getRelationship(name1, name2);

					if (!r.equals("")) {
						JOptionPane.showMessageDialog(this,
								"Already Existing Relation between " + name1 + " and " + name2 + " is " + rel, "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						if (age2 <= 2)
							throw new TooYoungException(" age is less than or equal to 2 ");
						else if (((age1 > 16) && (age2 > 2 && age2 < 16)))
							throw new NotToBeFriendsException(" Adult and Children not friend");
						else if (((age1 > 2 && age1 < 16) && (age2 > 2 && age2 < 16)) && (age1 - age2) > 3)
							throw new NotToBeFriendsException("Two children age gap larger than 3.");
						else if (re.equalsIgnoreCase("couple")) {
							if ((age1 > 2 && age1 < 16) || (age2 > 2 && age2 < 16))
								throw new NotToBeCoupledException("Aleast one member is not an adult.");
						} else if (re.equalsIgnoreCase("colleague")) {
							if (age2 > 2 && age2 < 16)
								throw new NotToBeColleaguesException("a child in a colleague relation");
						} else if (re.equalsIgnoreCase("classmate")) {
							if (age2 <= 2)
								throw new NotToBeClassmatesException("a young child in a classmate relation");
						} else {
							personDao.save(name1, name2, rel);
							JOptionPane.showMessageDialog(this, "Added Successfully Relation !!!", "Relation",
									JOptionPane.INFORMATION_MESSAGE);

							personDao.commitConn();
						}

					}

				} else
					JOptionPane.showMessageDialog(this,
							"Both Name " + name1 + " and " + name2
									+ " Not Found in Social Network, Please Enter Existing Name",
							"Relation", JOptionPane.ERROR_MESSAGE);
			}

			catch (TooYoungException ex) {
				JOptionPane.showMessageDialog(this, ex, "TooYoungException", JOptionPane.ERROR_MESSAGE);
			} catch (NotToBeFriendsException ex) {
				JOptionPane.showMessageDialog(this, ex, "NotToBeFriendsException", JOptionPane.ERROR_MESSAGE);
			} catch (NotToBeCoupledException ex) {
				JOptionPane.showMessageDialog(this, ex, "NotToBeCoupledException", JOptionPane.ERROR_MESSAGE);
			} catch (NotToBeColleaguesException ex) {
				JOptionPane.showMessageDialog(this, ex, "NotToBeColleaguesException", JOptionPane.ERROR_MESSAGE);
			} catch (NotToBeClassmatesException ex) {
				JOptionPane.showMessageDialog(this, ex, "NotToBeClassmatesException", JOptionPane.ERROR_MESSAGE);
			}

			catch (SQLException ex) {
			}

		}

		// Action event to Reset
		if (e.getSource() == jButton5) {
			jTextField1.setText("");
			jTextField2.setText("");
			jTextField3.setText("");
			jTextField4.setText("");

			jComboBox3.removeAllItems();
			jTextArea1.setText("");

			try {
				personDao.commitConn();
				personDao.closeRS();
				personDao.closeConn();
			} catch (SQLException ex) {
			}

		}

		// Exit
		if (e.getSource() == exit) {
			System.exit(0);
		}
	}
}
