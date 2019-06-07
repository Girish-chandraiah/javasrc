package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

/** A trivial example of a database query with JDBC. The database 
 * being queried only exists locally on Windows'95; it's the MS Access 
 * "Video Database" sample database. Note that you must select this as 
 * "System DSN" under the name "Video.Collection" (On '95 you
 * do this from Settings->Control Panel->32Bit ODBC->System DSN)
 * for this particular configuration of the demo to work.
 * Other than this (see the URL below), the demo would work on
 * any platform (UNIX, MS, Mac, Novell, etc.).
 *
 * We simply get a JDBC connection to the local Database server via ODBC,
 * create a Statement from that, and a ResultSet with its Query set
 * to a selection of three items from a database table, and print the
 * results in a while loop as they come in from the database.
 */
public class JDBCQuery {

	public static void main(String[] av) {
		try {
			System.out.println("Loading Driver (with Class.forName)");
			// Load the jdbc-odbc bridge driver
			Class.forName ("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Can't load driver " + e);
			return;	// game over!
		}

		try {
			// Enable logging
			// DriverManager.setLogStream(System.err);

			System.out.println("Getting Connection");
			Connection conn = DriverManager.getConnection (
					"jdbc:odbc:Companies",
					"ian", "");	// user, passwd

			// Any warnings generated by the connect?
			checkForWarning(conn.getWarnings());

			System.out.println("Creating Statement");
			Statement stmt = conn.createStatement();

			System.out.println("Executing Query");
			ResultSet rs = stmt.executeQuery("SELECT * FROM Companies");

			System.out.println("Retrieving Results");
			int i = 0;
			while (rs.next()) {

				System.out.println("Retrieving Company ID");
				int x = rs.getInt("CustNO");
				System.out.println("Retrieving Name");
				String s = rs.getString("Company");

				System.out.println("ROW " + ++i + ": " +
						x + "; " + s + "; " + ".");

			}

			rs.close();		// All done with that resultset
			stmt.close();	// All done with that statement
			conn.close();	// All done with that DB connection

		} catch (SQLException e) {
			System.out.println("Database access failed " + e);
		}
	}

	// Format and print any warnings from the connection
	private static void checkForWarning(SQLWarning warn) throws SQLException  {

		// If a SQLWarning object was given, display the
		// warning messages.  Note that there could be
		// multiple warnings chained together

		if (warn != null) {
			System.out.println("*** Warning ***\n");
			while (warn != null) {
				System.out.println("SQLState: " +
						warn.getSQLState());
				System.out.println("Message:  " +
						warn.getMessage());
				System.out.println("Vendor:   " +
						warn.getErrorCode());
				System.out.println("");
				warn = warn.getNextWarning();
			}
		}
	}
}
