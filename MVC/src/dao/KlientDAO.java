package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import model.Klient;

public class KlientDAO implements IKlientDAO {

	private static final Logger logger = Logger.getLogger(KlientDAO.class.getName());
    
	private static final String CREATE_QUERY = 
			"INSERT INTO klient(imie, nazwisko, miasto, rok_urodzenia)  VALUES (?,?,?,?)";
    private static final String READ_QUERY = 
    		"SELECT id_klienta, imie, nazwisko, miasto, rok_urodzenia FROM klient WHERE id_klienta =?";
    private static final String READALL_QUERY = 
    		"SELECT id_klienta, imie, nazwisko, miasto, rok_urodzenia FROM klient";
    private static final String UPDATE_QUERY = 
    		"UPDATE klient SET imie=?, nazwisko=?, miasto=?,rok_urodzenia=?  WHERE id_klienta =?";
    private static final String DELETE_QUERY = 
    		"DELETE FROM klient WHERE id_klienta =?";

	
	private static int lastDatabaseType = 0;
	private DAOFactory database = null;
	public KlientDAO(int databaseType) {
		database = DAOFactory.getDAOFactory(databaseType);
		logger.info("Create KlientDAO with database: " + database.getName());
		
		if(databaseType != lastDatabaseType) {
			lastDatabaseType = databaseType;
		}
	}
	//@Override
	public int create(Klient klient) {
		logger.info("create klient");
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = database.createConnection();
            preparedStatement = conn.prepareStatement(CREATE_QUERY,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, klient.getImie());
            preparedStatement.setString(2, klient.getNazwisko());
            preparedStatement.setString(3, klient.getMiasto());
            preparedStatement.setString(4, klient.getRokUrodzenia());
            preparedStatement.execute();
            result = preparedStatement.getGeneratedKeys();
 
            if (result.next() && result != null) {
                return result.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                logger.error(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                logger.error(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
                logger.error(cse.getMessage());
            }
        }
        return -1;
	}

	//@Override
	public Klient read(int id) {
		Klient klient = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
        	conn = database.createConnection();
            preparedStatement = conn.prepareStatement(READ_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            if (result.next() && result != null) {
            	klient = new Klient(result.getInt(1), 
            						result.getString(2), 
            						result.getString(3), 
            						result.getString(4), 
            						result.getString(5));
            } else {
                // TODO
            	logger.info("Brak klienta o ID = "+ id);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                logger.error(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                logger.error(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
                logger.error(cse.getMessage());
            }
        }
        return klient;
	}

	//@Override
	public List<Klient> readAll() {
		logger.info("create readAll Klienta");
		List<Klient> lista_klientow = new ArrayList<Klient>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
        	conn = database.createConnection();
            preparedStatement = conn.prepareStatement(READALL_QUERY);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            result = preparedStatement.executeQuery();
            if (result != null){
            while(result.next())
            	lista_klientow.add(
            					new Klient(
            							result.getInt(1), 
            							result.getString(2), 
            							result.getString(3), 
            							result.getString(4), 
            							result.getString(5)
            							)
            					);
            } else {
                // TODO
            	logger.info("Brak klientów");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage()+"błąd listy klientów");
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                logger.error(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                logger.error(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
                logger.error(cse.getMessage());
            }
        }
        return lista_klientow;
	}

	//@Override
	public boolean update(Klient klient) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = database.createConnection();
            preparedStatement = conn.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, klient.getImie());
            preparedStatement.setString(2, klient.getNazwisko());
            preparedStatement.setString(3, klient.getMiasto());
            preparedStatement.setString(4, klient.getRokUrodzenia());
            preparedStatement.setInt(5, klient.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                logger.error(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
                logger.error(cse.getMessage());
            }
        }
        return false;
	}

	//@Override
	public boolean delete(int id) {
		Connection conn = null;
	    PreparedStatement preparedStatement = null;
	    try {
	    	conn = database.createConnection();
	    	preparedStatement = conn.prepareStatement(DELETE_QUERY);
	    	preparedStatement.setInt(1, id);
	    	preparedStatement.execute();
	    	return true;
	    } catch (SQLException e) {
	    	logger.error(e.getMessage());
	    } finally {
	    	try {
	    		preparedStatement.close();
	    	} catch (Exception sse) {
	    		logger.error(sse.getMessage());
	    	}
	    	try {
	    		conn.close();
	        } catch (Exception cse) {
	        	logger.error(cse.getMessage());
	        }
	    }
	    return false;
	}
	

}