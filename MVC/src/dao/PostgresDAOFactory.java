package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class PostgresDAOFactory extends DAOFactory {
	private static final Logger logger = Logger.getLogger(PostgresDAOFactory.class);

	private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost/oschr";
    private static final String USERNAME = "postgres";
    private static final String USERPASSWORD = "admin1";

    /**
     * Method to create a Connection on the postgresql-database.
     * 
     * @return the Connection.
     */
    static Connection conn = null;
    static Statement stat=null;
    @Override
    public Connection createConnection() {
    	logger.info("Get connection postgres");
    try {
        Class.forName(DRIVER);
    } catch (ClassNotFoundException e) {
    	 System.err.println("Brak sterownika JDBC");
         e.printStackTrace();
    }
    try {
        conn = DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
        stat = conn.createStatement();
    } catch (SQLException e) {
        System.err.println("Problem z otwarciem polaczenia");
        e.printStackTrace();
    }

    createTables();
    return conn;
}

    public static boolean createTables()  {
//   	 String createTableklient = "drop table klient  cascade";
//   	 String createTableszamówienia = "drop table zamawianie_badan  cascade";
       String createTableklient = 
    		"CREATE TABLE IF NOT EXISTS klient ( id_klienta serial PRIMARY KEY," +
    		"						imie VARCHAR(50), " +
    		"						nazwisko VARCHAR(50), " +
    		"						miasto VARCHAR(50), " +
    		"						rok_urodzenia VARCHAR(50) " +
    		"						)";
       String createTableszamówienia = 
    		"CREATE TABLE IF NOT EXISTS zamawianie_badan (" +
       		"						id_zamówienia serial NOT NULL, " +
       		"						rodzaj_badan VARCHAR(50)  NOT NULL, " +
       		"						ilosc_prob int, " +
       		"						kwota VARCHAR(50)," +
       		"						CONSTRAINT zamówienia_pk PRIMARY KEY(id_zamówienia)," +
       		"						id_klienta int, " +
       		"						CONSTRAINT klient_id_fk FOREIGN KEY(id_klienta) REFERENCES klient(id_klienta))";

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
	public String getName() {
		// TODO Auto-generated method stub
		logger.trace("Get name");
		return "POSTGRES";
	}

	@Override
	public IKlientDAO getKlientDAO() {
		// TODO Auto-generated method stub
		return new KlientDAO(POSTGRES);
	}

	@Override
	public IZamówienieDAO getZamówienieDAO() {
		// TODO Auto-generated method stub
		return new ZamówienieDAO(POSTGRES);
	}

}
