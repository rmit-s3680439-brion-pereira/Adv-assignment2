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
	File files = null;
	PersonDao personDao = new PersonDao();

	public GUIMiniNet() {
		initComponents();
	}

	// GUI design
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel(); // Title Label
		jPanel1 = new javax.swing.JPanel(); // Panel 1
		addBtn = new javax.swing.JButton(); // Add Button
		displayBtn = new javax.swing.JButton(); // Display Button
		deleteBtn = new javax.swing.JButton(); // Delete Button
		genderTextField = new javax.swing.JTextField();
		selectPersonLbl = new javax.swing.JLabel(); // Select person label
		submitBtn = new javax.swing.JButton(); // Submit Button
		jLabel3 = new javax.swing.JLabel();
		loadBtn = new javax.swing.JButton(); // Load Button
		jPanel2 = new javax.swing.JPanel(); // Panel 2
		nameLbl = new javax.swing.JLabel(); // Name Label
		nameTextField = new javax.swing.JTextField();
		statusLbl = new javax.swing.JLabel(); // Status Label
		statusTextField = new javax.swing.JTextField();
		ageLbl = new javax.swing.JLabel(); // Age Label
		ageTextField = new javax.swing.JTextField();
		stateListComBox = new javax.swing.JComboBox<>(); // State list combobox
		genderLbl = new javax.swing.JLabel(); // Gender
		stateLbl = new javax.swing.JLabel(); // State Label
		chooseImageLbl = new javax.swing.JLabel(); // Choose image Label
		personListComBox = new javax.swing.JComboBox<>(); // List of People
		selectImgBtn = new javax.swing.JButton(); // Select image Button
		jPanel3 = new javax.swing.JPanel(); // Panel 3
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		resetBtn = new javax.swing.JButton(); // Reset Button
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

		addBtn.setText("Add a Person into the Network");
		addBtn.setToolTipText("");
		addBtn.addActionListener(this);
		addBtn.setBounds(15, 30, 250, 25);

		displayBtn.setText("Display Profile of Selected Person");
		displayBtn.setToolTipText("");
		displayBtn.addActionListener(this);
		displayBtn.setBounds(15, 80, 250, 25);

		deleteBtn.setText("Delete Selected Person From Network");
		deleteBtn.addActionListener(this);
		deleteBtn.setBounds(15, 130, 250, 25);

		selectPersonLbl.setFont(new java.awt.Font("Tahoma", 1, 18));
		selectPersonLbl.setText("Select Person: ");
		selectPersonLbl.setBounds(480, 25, 155, 25);

		personListComBox.setModel(new javax.swing.DefaultComboBoxModel<>());
		personListComBox.setBounds(610, 25, 200, 25);

		loadBtn.setFont(new java.awt.Font("Tahoma", 1, 14));
		loadBtn.setText("Loading Person Name");
		loadBtn.addActionListener(this);
		loadBtn.setBounds(610, 80, 200, 25);

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
		jPanel1.add(addBtn);
		jPanel1.add(displayBtn);
		jPanel1.add(deleteBtn);
		jPanel1.add(selectPersonLbl);
		jPanel1.add(personListComBox);
		jPanel1.add(loadBtn);
		add(jPanel1);
		jPanel1.add(exit);
		jPanel1.add(b1);
		jPanel1.add(b2);
		jPanel1.add(b3);

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));
		jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0), 3));
		jPanel2.setBounds(0, 255, 880, 200);
		jPanel2.setLayout(null);

		nameLbl.setFont(new java.awt.Font("Tahoma", 1, 14));
		nameLbl.setText("Name");
		nameLbl.setBounds(15, 30, 150, 25);

		nameTextField.setBounds(100, 30, 150, 25);
		nameTextField.setEnabled(false);

		statusTextField.setBounds(100, 80, 150, 25);
		statusTextField.setEnabled(false);

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel3.setText("");
		jLabel3.setBounds(450, 80, 155, 25);

		submitBtn.setText("Submit");
		submitBtn.setFont(new java.awt.Font("Tahoma", 1, 14));
		submitBtn.setBounds(650, 150, 200, 30);
		submitBtn.addActionListener(this);
		submitBtn.setEnabled(false);

		statusLbl.setFont(new java.awt.Font("Tahoma", 1, 14));
		statusLbl.setText("Status");
		statusLbl.setBounds(15, 80, 150, 25);

		ageLbl.setFont(new java.awt.Font("Tahoma", 1, 14));
		ageLbl.setText("Age");
		ageLbl.setBounds(290, 30, 150, 25);
		selectImgBtn.setEnabled(false);

		stateLbl.setFont(new java.awt.Font("Tahoma", 1, 14));
		stateLbl.setText("State");
		stateLbl.setBounds(290, 80, 150, 25);

		chooseImageLbl.setFont(new java.awt.Font("Tahoma", 1, 14));
		chooseImageLbl.setText("Choose Image");
		chooseImageLbl.setBounds(290, 130, 150, 25);

		selectImgBtn.setFont(new java.awt.Font("Tahoma", 1, 18));
		selectImgBtn.setText("select image");
		selectImgBtn.addActionListener(this);
		selectImgBtn.setBounds(400, 130, 150, 25);
		selectImgBtn.setEnabled(false);

		ageTextField.setFont(new java.awt.Font("Tahoma", 1, 14));
		ageTextField.setBounds(340, 30, 210, 30);
		ageTextField.setEnabled(false);
		stateListComBox.setEnabled(false);

		stateListComBox.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "ACT", "NSW", "NT", "QLD", "SA", "TAS", "VIC", "WA" }));
		stateListComBox.setFont(new java.awt.Font("Tahoma", 1, 14));
		stateListComBox.setBounds(340, 80, 210, 30);

		genderLbl.setFont(new java.awt.Font("Tahoma", 1, 14));
		genderLbl.setText("Gender");
		genderLbl.setBounds(15, 130, 150, 25);

		genderTextField.setBounds(100, 130, 150, 25);

		// Adding components to Panel2
		jPanel2.add(nameLbl);
		jPanel2.add(statusLbl);
		jPanel2.add(ageLbl);
		jPanel2.add(genderLbl);
		jPanel2.add(nameTextField);
		jPanel2.add(statusTextField);
		jPanel2.add(ageTextField);
		jPanel2.add(jLabel3);
		jPanel2.add(selectImgBtn);
		add(jPanel2);
		jPanel2.add(genderTextField);
		jPanel2.add(stateListComBox);
		jPanel2.add(submitBtn);
		jPanel2.add(stateLbl);
		jPanel2.add(chooseImageLbl);

		jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51), 3));
		jPanel3.setBounds(0, 459, 880, 200);
		jPanel3.setLayout(null);

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);
		jScrollPane1.setBounds(2, 2, 876, 196);
		jPanel3.add(jScrollPane1);
		add(jPanel3);

		resetBtn.setBackground(new java.awt.Color(255, 255, 255));
		resetBtn.setFont(new java.awt.Font("Tahoma", 1, 24));
		resetBtn.setText("RESET");
		resetBtn.setBounds(2, 665, 876, 40);
		resetBtn.addActionListener(this);

		add(jLabel1);
		add(resetBtn);

	}

	// Variables declaration
	private javax.swing.JButton addBtn;
	private javax.swing.JButton displayBtn;
	private javax.swing.JButton deleteBtn;
	private javax.swing.JButton submitBtn;
	private javax.swing.JButton resetBtn;
	private javax.swing.JButton selectImgBtn;
	private javax.swing.JButton loadBtn;
	private javax.swing.JButton exit;
	private javax.swing.JTextField ageTextField;
	private javax.swing.JComboBox<String> personListComBox, stateListComBox;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel selectPersonLbl;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel nameLbl;
	private javax.swing.JLabel statusLbl;
	private javax.swing.JLabel ageLbl, chooseImageLbl;
	private javax.swing.JLabel genderLbl, stateLbl;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField genderTextField;
	private javax.swing.JTextField nameTextField;
	private javax.swing.JTextField statusTextField;
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
		if (e.getSource() == addBtn) {
			genderTextField.setEnabled(true);
			nameTextField.setEnabled(true);
			statusTextField.setEnabled(true);
			ageTextField.setEnabled(true);
			stateListComBox.setEnabled(true);
			selectImgBtn.setEnabled(true);
			submitBtn.setEnabled(true);
		}

		// Action Event to add image
		if (e.getSource() == selectImgBtn) {
			fileChooser = new JFileChooser(new File("./photos"));
			int returnVal = fileChooser.showOpenDialog(addBtn);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				files = fileChooser.getSelectedFile();
				JOptionPane.showMessageDialog(this, "Photo name: " + files.getName(), "Choose Image",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		// Action Event to display person
		if (e.getSource() == displayBtn) {
			if (personListComBox.getItemCount() == 0)
				JOptionPane.showMessageDialog(this, "First Load Name From Database", "Loading",
						JOptionPane.INFORMATION_MESSAGE);
			else {

				String name = personListComBox.getSelectedItem().toString();
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
				ImageIcon imageIcon = null;
				if (person.getPhoto() != null) {
					try {
						Blob blob = person.getPhoto();
						imageIcon = new ImageIcon(blob.getBytes(1, (int) blob.length()));
						JOptionPane.showMessageDialog(this,
								"Name: " + person.getName() + "\nAge: " + person.getAge() + "\nStatus: "
										+ person.getStatus() + "\nState: " + person.getState() + "\nGender: "
										+ person.getGender(),
								"Display Information", JOptionPane.INFORMATION_MESSAGE, imageIcon);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(this,
							"Name: " + person.getName() + "\nAge: " + person.getAge() + "\nStatus: "
									+ person.getStatus() + "\nState: " + person.getState() + "\nGender: "
									+ person.getGender());
				}

			}

		}

		// Action Event to delete person
		if (e.getSource() == deleteBtn) {
			if (personListComBox.getItemCount() == 0)
				JOptionPane.showMessageDialog(this, "First Load Name From Database", "Loading",
						JOptionPane.INFORMATION_MESSAGE);
			else {
				String name = personListComBox.getSelectedItem().toString();

				name = name.trim();
				try {
					personDao.delete(name);
					personDao.commitConn();
					JOptionPane.showMessageDialog(this, "Deleted Successfully in Network !!!", "Deleted",
							JOptionPane.INFORMATION_MESSAGE);
					personListComBox.removeAllItems();
					List<String> persons = personDao.getAllNames();

					for (String person : persons) {
						personListComBox.addItem(person);
					}

				} catch (Exception ex) {
				}
			}
		}

		// Action Event to submit button to add person
		if (e.getSource() == submitBtn) {
			try {
				String name = nameTextField.getText().trim();
				String status = statusTextField.getText().trim();
				String gender = genderTextField.getText().trim();
				int age = Integer.parseInt(ageTextField.getText().trim());
				String state = stateListComBox.getSelectedItem().toString();

				if (age <= 0 || age > 150)
					throw new NoSuchAgeException("Age should be greater than 0 and less than 150");

				Person p = new Person();
				p.setName(name);
				p.setAge(age);
				p.setGender(gender);
				p.setState(state);
				p.setStatus(status);

				try {
					personDao.save(p, files);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				JOptionPane.showMessageDialog(this, "Added Successfully in Network !!!", "Add Person",
						JOptionPane.INFORMATION_MESSAGE);

				personListComBox.removeAllItems();
				List<String> persons = null;
				try {
					persons = personDao.getAllNames();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (String person : persons) {
					personListComBox.addItem(person);
				}

				personDao.commitConn();
			} catch (NoSuchAgeException ex) {
				JOptionPane.showMessageDialog(this, ex, "NoSuchAgeException", JOptionPane.ERROR_MESSAGE);
			} catch (SQLException ex) {
			}

			// Disable to jPanel2
			genderTextField.setEnabled(false);
			nameTextField.setEnabled(false);
			statusTextField.setEnabled(false);
			ageTextField.setEnabled(false);
			stateListComBox.setEnabled(false);
			selectImgBtn.setEnabled(false);
			submitBtn.setEnabled(false);

		}

		// Action event on clicking "Load Person Name"
		if (e.getSource() == loadBtn) {
			personListComBox.removeAllItems();
			List<String> persons = null;
			try {
				persons = personDao.getAllNames();
				personDao.commitConn();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (String p : persons) {
				personListComBox.addItem(p);
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

		// Action Event for to Find child/parent
		if (e.getSource() == b3) {
			String type = JOptionPane.showInputDialog(this, "Press 1 to Find Parent\nPress 2 for Children");
			try {

				if (type.equals("1")) {
					String name = JOptionPane.showInputDialog(this, "Enter Person Name: ");
					String nm = personDao.isParent(name);
					if (!nm.equals(""))
						JOptionPane.showMessageDialog(this, "Parent Found Successfully, Name: " + nm, "Found",
								JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(this, "Parent Not Found......, Name: " + nm, "Found",
								JOptionPane.ERROR_MESSAGE);

				} else {
					String name = JOptionPane.showInputDialog(this, "Enter Person Name: ");
					String nm = personDao.isChild(name);

					if (!nm.equals(""))
						JOptionPane.showMessageDialog(this, "Children Found Successfully, Name: " + nm, "Found",
								JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(this, "Children Not Found......, Name: " + nm, "Found",
								JOptionPane.ERROR_MESSAGE);

				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

		// Action event to Reset
		if (e.getSource() == resetBtn) {
			genderTextField.setText("");
			nameTextField.setText("");
			statusTextField.setText("");
			ageTextField.setText("");

			personListComBox.removeAllItems();
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
			System.out.println("Exit");
			System.exit(0);

		}
	}
}
