package DatabaseConnect;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect implements DBConnectivity {

    Connection dbConnect = null;
    Statement sqlStatement = null;
    PreparedStatement st = null;
    ResultSet resultSet = null;

    /**
     *
     * @param db
     */
    public void DBConnect() {

    }

    /**
     *
     * @param sql
     */
    public Connection connect() {
        try {
            return dbConnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/garitsdb", "garitsuser", "garitsdb");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param connect
     */
    public void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (sqlStatement != null) {
                sqlStatement.close();
            }

            if (dbConnect != null) {
                dbConnect.close();
            }

            if (st != null) {
                st.close();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    /**
     *
     * @param sql
     */
    public ResultSet read(String sql) {
        try {
            connect();
            sqlStatement = dbConnect.createStatement();
            resultSet = sqlStatement.executeQuery(sql);
            return resultSet;
        } catch (Exception exc) {
            exc.printStackTrace();
            closeConnection();
        }

        return null;
    }

    /**
     *
     * @param sql
     * @param conn
     */
    public void write(String sql) {
        try {
            connect();
            st = dbConnect.prepareStatement(sql);
            int a = st.executeUpdate();

            if (a > 0) {
                System.out.println("Customer Updated");
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            closeConnection();
        }

    }

    public PreparedStatement setPreparedStatement(Connection connect, String sql) throws SQLException {
        return st = connect.prepareStatement(sql);
    }

    public PreparedStatement setIDPreparedStatement(Connection connect, String sql) throws SQLException {
        return st = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    }

    public void executeWriteQuery(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            try {
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                ps.getConnection().rollback();
            } finally {

            }

        }
    }

    public ResultSet executeReadQuery(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            try {
                return ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {

            }

        }

        return null;
    }

    public ResultSet executeGetIDQuery(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            try {
                ps.executeUpdate();
                return ps.getGeneratedKeys();
            } catch (SQLException e) {
                e.printStackTrace();
                ps.getConnection().rollback();
            }
        }
        return null;
    }

    public void Backup() {
        // TODO - implement DBConnect.Backup
        throw new UnsupportedOperationException();
    }

    public void Restore() {
        // TODO - implement DBConnect.Restore
        throw new UnsupportedOperationException();
    }

}
