
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hsqldb.Server;

/**
 * PersonDao is Data object access. It contains CRUD operations
 * 
 * @author Abhilash Nunes
 * @createdOn 18 May 2018
 * 
 * @lastUpdatedBy Abhilash Nunes
 * @lastUpdatedOn 21 May 2018
 *
 */
public class PersonDao {

	Server hsqlServer = null;
	Connection connection = null;
	ResultSet rs = null;

	public PersonDao() {
		hsqlServer = new Server();
		hsqlServer.setLogWriter(null);
		hsqlServer.setSilent(true);
		hsqlServer.setDatabaseName(0, "MiniNetDB");
		hsqlServer.setDatabasePath(0, "file:MYDB");

		// DB configuration properties
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:MiniNetDB", "sa", "123");
			BufferedReader br = new BufferedReader(new FileReader(new File("src/people.txt")));
			connection.prepareStatement("Drop table people if exists;").execute();
			connection.prepareStatement(
					"create table people(name varchar(20) not null, photo blob, status varchar(60) not null, gender varchar(10) not null, age integer not null, state varchar(40) not null);")
					.execute();

			String line = br.readLine();
			while (line != null) {
				String[] data = line.split(",");
				PreparedStatement pstmt = connection.prepareStatement("insert into people values(?,?,?,?,?,?)");

				pstmt.setString(1, data[0].trim());

				File file = new File("src/" + data[1].trim());
				InputStream inputImage = new FileInputStream(file);
				pstmt.setBinaryStream(2, inputImage, (int) (file.length()));

				pstmt.setString(3, data[2].trim());
				pstmt.setString(4, data[3].trim());
				pstmt.setInt(5, Integer.parseInt(data[4].trim()));
				pstmt.setString(6, data[5].trim());
				pstmt.execute();
				line = br.readLine();
			}
			br.close();
			br = new BufferedReader(new FileReader(new File("src/relation.txt")));
			connection.prepareStatement("drop table relation if exists;").execute();
			connection.prepareStatement(
					"create table relation(name1 varchar(60) not null, name2 varchar(60) not null, relationship varchar(45) not null);")
					.execute();
			line = br.readLine();
			while (line != null) {
				String[] data = line.split(",");
				PreparedStatement pstmt = connection.prepareStatement("insert into relation values(?,?,?)");

				pstmt.setString(1, data[0].trim());
				pstmt.setString(2, data[1].trim());
				pstmt.setString(3, data[2].trim());
				pstmt.execute();
				line = br.readLine();
			}
			br.close();

			System.out.println("People and Relationship read successfully");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Implementation of method to get all the name
	 * 
	 * @return List of Person name
	 * @throws SQLException
	 */
	public List<String> getAllNames() throws SQLException {
		List<String> persons = new ArrayList();
		rs = connection.prepareStatement("select name from people;").executeQuery();
		while (rs.next()) {
			persons.add(rs.getString(1));
		}
		return persons;
	}

	/**
	 * Method to add image
	 * 
	 * @param p
	 *            Person
	 * @param photoFile
	 *            Image
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public void save(Person p, File photoFile) throws SQLException, FileNotFoundException {
		PreparedStatement pstmt = connection.prepareStatement("insert into people values(?,?,?,?,?,?)");
		pstmt.setString(1, p.getName());
		InputStream inputImage = new FileInputStream(photoFile);
		pstmt.setBinaryStream(2, inputImage, (int) (photoFile.length()));
		pstmt.setString(3, p.getStatus());
		pstmt.setString(4, p.getGender());
		pstmt.setInt(5, p.getAge());
		pstmt.setString(6, p.getState());
		pstmt.execute();
	}

	/**
	 * Override Save Method to define relation
	 * 
	 * @param name1
	 *            Name of Person1
	 * @param name2
	 *            Name of Person2
	 * @param rel
	 *            Relation i.e Parent/Friends/Classmates
	 * @throws SQLException
	 */

	public void save(String name1, String name2, String rel) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement("insert into relation values(?,?,?)");
		pstmt.setString(1, name1);
		pstmt.setString(2, name2);
		pstmt.setString(3, rel);
		pstmt.execute();
	}
	
	/**
	 * Delete person for the network.
	 * @param name Person Name
	 * @throws SQLException
	 */
	public void delete(String name) throws SQLException {
		Statement st = connection.createStatement();
		st.executeQuery("delete from people where name ='" + name + "';");
		st.executeQuery("delete from relation where name1 ='" + name + "' or name2 ='" + name + "';");
	}

	/**
	 * Method to search name of the person
	 * 
	 * @param name
	 *            Need to enter name of the person
	 * @return person
	 */
	public Person getByName(String name) {
		System.out.println("loading ");
		try {
			rs = connection.prepareStatement("select * from people where name = '" + name + "';").executeQuery();
			rs.next();
			Person person = new Person();
			person.setName(rs.getString(1));
			person.setAge(rs.getInt(5));
			person.setGender(rs.getString(4));
			person.setState(rs.getString(6));
			person.setStatus(rs.getString(3));
			person.setPhoto(rs.getBlob(2));

			return person;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Check whether the Person exists
	 * 
	 * @param name
	 *            Pass name of the person
	 * @return Name of the person if exists
	 * @throws SQLException
	 */
	public int isPersonExisting(String name) throws SQLException {
		rs = connection.prepareStatement("select * from people where name = '" + name + "';").executeQuery();
		if (rs.next()) {
			return rs.getInt(5);
		} else {
			return -1;
		}
	}

	/**
	 * @param name1
	 *            Person1 Name
	 * @param name2
	 *            Person2 Name
	 * @return relationship friends/classmate/couples
	 * @throws SQLException
	 */
	public String getRelationship(String name1, String name2) throws SQLException {

		rs = connection
				.prepareStatement("select * from relation where name1 = '" + name1 + "' and name2 = '" + name2 + "';")
				.executeQuery();
		String re = "";

		while (rs.next()) {
			re = rs.getString(3);
		}
		return re;
	}

	public void commitConn() throws SQLException {
		connection.commit();
	}

	public void closeConn() throws SQLException {
		connection.close();
	}

	public void closeRS() throws SQLException {
		rs.close();
	}

}
