package dao;


import java.sql.Connection;
import java.util.logging.Logger;

import dao.IZamówienieDAO;
import dao.IKlientDAO;

public abstract class DAOFactory {
	private static final Logger log = Logger.getLogger(DAOFactory.class.getName());
	
	public static final int MYSQL = 0;  
    public static final int SQLITE = 1;
    public static final int POSTGRES = 2;

    private static int defaultFactory = SQLITE;
    public abstract IKlientDAO getKlientDAO();
    public abstract IZamówienieDAO getZamówienieDAO();
    public abstract String getName();
    public abstract Connection createConnection();
  
    public static DAOFactory getDAOFactory() {
		log.info("Get default database factory");
		return getDAOFactory(defaultFactory);
	}
    
    public static DAOFactory getDAOFactory(int database) {
    	if(database == SQLITE) {
			log.info("Get SQLite database factory1");
			return new SqliteDAOFactory();
		}
		else if(database == MYSQL) {
			log.info("Get MYSQL database factory0");
			return new MysqlDAOFactory();
		}
		else if(database == POSTGRES) {
			log.info("Get PostgreSql database factory2");
			return new PostgresDAOFactory();
		}
		else {
			log.warning("Wrong database selection");
			return null;
		}
    }
    
	public static void setDefaultFactory(int factory) {
		log.info("Set new default factory: " + getDAOFactory(factory).getName());
		defaultFactory = factory;
	}
}
