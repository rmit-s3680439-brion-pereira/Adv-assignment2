
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
			try {
				Class.forName("org.hsqldb.jdbcDriver");
				connection = DriverManager.getConnection("jdbc:hsqldb:MiniNetDB", "sa", "123");
				BufferedReader br = new BufferedReader(new FileReader(new File("src/people.txt")));
				connection.prepareStatement("drop table people if exists;").execute();
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

}
