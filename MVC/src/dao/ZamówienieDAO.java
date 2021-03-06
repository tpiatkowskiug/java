package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import model.Zamawianie_badan;

public class ZamówienieDAO implements IZamówienieDAO{

	private static final Logger logger = Logger.getLogger(ZamówienieDAO.class.getName());
    
	private static final String CREATE_QUERY = 
			"INSERT INTO zamawianie_badan(rodzaj_badan, ilosc_prob, kwota, id_klienta)  VALUES (?,?,?,?)";
    private static final String READ_QUERY = 
    		"SELECT id_zamówienia, rodzaj_badan, ilosc_prob, kwota, id_klienta FROM zamawianie_badan WHERE id_zamówienia = ?";
    private static final String READALL_QUERY = 
    		"SELECT id_zamówienia, rodzaj_badan, ilosc_prob, kwota, id_klienta FROM zamawianie_badan";
    private static final String UPDATE_QUERY = 
    		"UPDATE zamawianie_badan SET rodzaj_badan=?, ilosc_prob=?, kwota=?, id_klienta=? WHERE id_zamówienia = ?";
    private static final String DELETE_QUERY = 
    		"DELETE FROM zamawianie_badan WHERE id_zamówienia = ?";

 
	private DAOFactory database = null;
	private static int lastDatabaseType = 0;
	
	public ZamówienieDAO(int databaseType) {
		database = DAOFactory.getDAOFactory(databaseType);
		logger.info("Create ZamówienieDAO with database: " + database.getName());
		
		if( databaseType != lastDatabaseType) {
			lastDatabaseType = databaseType;
	
		}
	}
	
	
	
	public int create(Zamawianie_badan zamówienie) {
		logger.info("create zamówienie");
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = database.createConnection();
            preparedStatement = conn.prepareStatement(CREATE_QUERY,
                    Statement.RETURN_GENERATED_KEYS);
            
            String value=view.Zamawanie_badanView.cbBadania.getSelectedItem().toString();
            preparedStatement.setString(1, value);
            preparedStatement.setInt(2, zamówienie.getIlosc_prob());
            preparedStatement.setString(3, zamówienie.getKwota());
            preparedStatement.setInt(4, zamówienie.getKlient_id());
           
            boolean val = preparedStatement.execute();
            logger.info("create zamówienie: execute: "+ val);
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
	public Zamawianie_badan read(int id) {
		Zamawianie_badan zamówienie = null;
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
            	zamówienie = new Zamawianie_badan(	result.getInt(1), 
            										result.getString(2),
            										result.getInt(3), 
            										result.getString(4), 
            										result.getInt(5));
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
        return zamówienie;
	}

	//@Override
	public List<Zamawianie_badan> readAll() {
		logger.info("create readAll zamówienie");
		List<Zamawianie_badan> lista_zamówień = new ArrayList<Zamawianie_badan>();
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
            	lista_zamówień.add(
            					new Zamawianie_badan(
            							result.getInt(1), 
            							result.getString(2), 
            							result.getInt(3), 
            							result.getString(4), 
            							result.getInt(5)
            							)
            					);
            } else {
                // TODO
            	logger.info("Brak zamówień");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage()+"błąd listy zamówień");
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
        return lista_zamówień;
	}

	//@Override
	public boolean update(Zamawianie_badan zamówienie) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = database.createConnection();
            preparedStatement = conn.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, zamówienie.getRodzaj_badan());
            preparedStatement.setInt(2, zamówienie.getIlosc_prob());
            preparedStatement.setString(3, zamówienie.getKwota());
            preparedStatement.setInt(4, zamówienie.getKlient_id());
            preparedStatement.setInt(5, zamówienie.getId());
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