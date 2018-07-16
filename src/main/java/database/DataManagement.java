package database;

import model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataManagement
{
    private static DataManagement instance;
    private Connection connection;
    private String url;
    private final Logger logger = LoggerFactory.getLogger(DataManagement.class);


    private DataManagement()
    {
        connect();
    }

    public static DataManagement getInstance()
    {
        if(instance == null)
        {
            instance = new DataManagement();
        }
        return instance;
    }

    private void connect()
    {
        this.url = "jdbc:sqlite:src/main/resources/database/accounts.db";
        try(Connection conn = getConnection())
        {
            if(conn != null)
            {
                DatabaseMetaData meta = conn.getMetaData();
                this.logger.info("Made connection with " + meta.getDriverName());
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void insert(Account account)
    {
        String sql = "INSERT INTO Accounts(company,username,recovery,password) VALUES(?,?,?,?)";

        try(Connection connection = getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getCompany());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getRecovery());
            preparedStatement.setString(4, account.getPassword());
            preparedStatement.execute();
            this.logger.info("Succesful added a new account to the database");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Account> retrieveAll()
    {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT company, username, recovery, password FROM Accounts";
        try(Connection connection = getConnection())
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                Account account = new Account.Builder(resultSet.getString("username"),
                                                        resultSet.getString("password")).recovery(resultSet.getString("recovery")).
                                                        company(resultSet.getString("company")).build();

                this.logger.info("Retrieving all of the accounts from database, currently retrieved: "
                        + account.getUsername() + " from: " + account.getCompany());
                accounts.add(account);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return accounts;
    }

    public List<Account> retrievebyUsername(String username)
    {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT company, username, recovery, password " + "FROM Accounts WHERE username == ?";
        try (Connection conn = getConnection())
        {
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                if(resultSet.getString("username").equals(username))
                {
                    Account account = new Account.Builder(resultSet.getString("username"),
                            resultSet.getString("password")).recovery(resultSet.getString("recovery")).
                            company(resultSet.getString("company")).build();

                    logger.info("Retrieving certain accounts based on username from database, currently retrieved: "
                            + account.getUsername() + " from: " + account.getCompany());
                    accounts.add(account);
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return accounts;
    }


    public void deleteByCompany(String company)
    {
        String sql = "DELETE FROM Accounts WHERE username = ?";
        try(Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,company);
            statement.execute();
            logger.info("Deleting account by company: " + company);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteByUsername(String username)
    {
        String sql = "DELETE FROM Accounts WHERE username = ?";
        try(Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.execute();
            logger.info("Deleting account by username " + username);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException
    {
        if(this.connection == null || this.connection.isClosed())
        {
            logger.info("Making a new connection with the database");
           return this.connection = DriverManager.getConnection(url);
        }
        logger.info("Retrieving old connection to database");
        return connection;
    }
}