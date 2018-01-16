package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.sqlite.SQLiteConfig;

public final class SqliteDAOFactory extends DAOFactory {
	private static final Logger logger = Logger.getLogger(MysqlDAOFactory.class);

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DBURL = "jdbc:sqlite:test.db";

    /**
     * Method to create a Connection on the sqlite-database.
     * 
     * @return the Connection.
     */
    static Connection conn = null;
	static Statement stat=null;
	@Override
    public Connection createConnection() {
    	logger.info("Get connection sqlite");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
        	 System.err.println("Brak sterownika JDBC");
             e.printStackTrace();
        }
        try {
        	SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            conn = DriverManager.getConnection(DBURL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
 
        createTables();

        return conn;
    }
  
    public static boolean createTables()  {
//    	 String createTableklient = "drop table if exists klient";
//    	 String createTableszamówienia = "drop table if exists zamawianie_badan";
        String createTableklient = "CREATE TABLE IF NOT EXISTS klient (" +
        		"					id_klienta INTEGER PRIMARY KEY AUTOINCREMENT," +
        		"					imie CHAR(50), " +
        		"					nazwisko CHAR(50), " +
        		"					miasto CHAR(50), " +
        		"					rok_urodzenia DATETIME)";
        String createTableszamówienia = "CREATE TABLE IF NOT EXISTS zamawianie_badan (" +
        		"						id_zamówienia INTEGER PRIMARY KEY AUTOINCREMENT, " +
        		"						rodzaj_badan CHAR(50), " +
        		"						ilosc_prob int, " +
        		"						kwota double, " +
        		"						id_klienta INTEGER, FOREIGN KEY(id_klienta) REFERENCES klient(id_klienta))";

    	try {
            stat.execute(createTableklient);
            logger.info("create Table klient");
            stat.execute(createTableszamówienia);
            logger.info("create Table zamówienia");
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
	public IKlientDAO getKlientDAO() {
		return new KlientDAO(SQLITE);
	}
    
    @Override
	public String getName() {
		// TODO Auto-generated method stub
    	logger.trace("Get name");
		return "SQLITE";
	}

	@Override
    public IZamówienieDAO getZamówienieDAO() {
		return new ZamówienieDAO(SQLITE);
	}
}
