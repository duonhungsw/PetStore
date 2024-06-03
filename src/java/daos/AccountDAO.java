package daos;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import model.Coin;
import model.Role;

public class AccountDAO extends DBContext {

    public Role getRoleById(int id) {
        String sql = "SELECT [role_id]\n"
                + "      ,[role_name]\n"
                + "  FROM [dbo].[Role] where role_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Role role = new Role(rs.getInt(1), rs.getString(2));
                return role;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public Coin getCoinById(int id) {
        String sql = "SELECT [coin_id]\n"
                + "      ,[numberCoin]\n"
                + "  FROM [dbo].[Coin] where coin_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Coin coin = new Coin(rs.getInt(1), rs.getInt(2));
                return coin;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public List<Account> listAccount() {
        List<Account> listacc = new ArrayList<>();
        String sql = "Select * from Account";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc.setAccId(rs.getInt(1));
                Role role = getRoleById(rs.getInt(2));
                acc.setRole_id(role);
                Coin coin = getCoinById(rs.getInt(3));
                acc.setCoin_id(coin);
                acc.setEmail(rs.getString(4));
                acc.setUsername(rs.getString(5));
                acc.setPass(rs.getString(6));
                acc.setName(rs.getString(7));
                acc.setPhone(rs.getString(8));
                acc.setAddress(rs.getString(9));
                acc.setImage(rs.getString(10));
                acc.setCreation_datetime(rs.getString(11));
                acc.setStatus(rs.getInt(12));
                acc.setToken(rs.getString(13));

                listacc.add(acc);
            }
        } catch (Exception e) {
        }
        return listacc;
    }

    public boolean getAccountByEmail(String email) {
        String sql = "SELECT [account_id]\n"
                + "      ,[role_id]\n"
                + "      ,[coin_Id]\n"
                + "      ,[email]\n"
                + "      ,[username]\n"
                + "      ,[pass]\n"
                + "      ,[image]\n"
                + "      ,[creation_datetime]\n"
                + "      ,[status]\n"
                + "      ,[token]\n"
                + "  FROM [dbo].[Account]\n"
                + "  Where [email] =?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (Exception e) {
        }
        return false;
    }

    public Account getAccountInfoByEmail(String email) {
        String sql = "SELECT [account_id]\n"
                + "      ,[role_id]\n"
                + "      ,[coin_Id]\n"
                + "      ,[email]\n"
                + "      ,[username]\n"
                + "      ,[pass]\n"
                + "      ,[image]\n"
                + "      ,[creation_datetime]\n"
                + "      ,[status]\n"
                + "      ,[token]\n"
                + "  FROM [dbo].[Account]\n"
                + "  Where [email] =?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc.setAccId(rs.getInt(1));
                Role role = getRoleById(rs.getInt(2));
                acc.setRole_id(role);
                Coin coin = getCoinById(rs.getInt(3));
                acc.setCoin_id(coin);
                acc.setEmail(rs.getString(4));
                acc.setUsername(rs.getString(5));
                acc.setPass(rs.getString(6));
                acc.setImage(rs.getString(7));
                acc.setCreation_datetime(rs.getString(8));
                acc.setStatus(rs.getInt(9));
                acc.setToken(rs.getString(10));

                return acc;

            }

        } catch (Exception e) {
        }
        return null;
    }

    public Account getAccountbyID(int id) {
        String sql = "SELECT [account_id],[role_id],[coin_Id],[email],[username],[pass],[name],[phone],[address],[image]\n"
                + "  FROM [dbo].[Account] where account_id =?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc.setAccId(rs.getInt(1));
                Role role = getRoleById(rs.getInt(2));
                acc.setRole_id(role);
                Coin coin = getCoinById(rs.getInt(3));
                acc.setCoin_id(coin);
                acc.setEmail(rs.getString(4));
                acc.setUsername(rs.getString(5));
                acc.setPass(rs.getString(6));
                acc.setName(rs.getString(7));
                acc.setPhone(rs.getString(8));
                acc.setAddress(rs.getString(9));
                acc.setImage(rs.getString(10));
                return acc;
            }

        } catch (Exception e) {
        }
        return null;
    }

    public void insertCoinOfAccount() {
        String sql = "INSERT INTO [dbo].[Coin]\n"
                + "           ([numberCoin])\n"
                + "     VALUES (100)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getLastCoinId() {
        String sql = "SELECT MAX(coin_id) AS LatestCoinID\n"
                + "FROM Coin;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("LatestCoinID");
            }

        } catch (Exception e) {
        }
        return 0;
    }

    public void insertAccount(Account acc) {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([role_id]\n"
                + "           ,[coin_Id]\n"
                + "           ,[email]\n"
                + "           ,[username]\n"
                + "           ,[pass]\n"
                + "           ,[name]\n"
                + "           ,[phone]\n"
                + "           ,[address]\n"
                + "           ,[image]\n"
                + "           ,[creation_datetime]\n"
                + "           ,[status]\n"
                + "           ,[token])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?,?)";

        try ( PreparedStatement st = connection.prepareStatement(sql)) {

            st.setInt(1, acc.getRole_id().getRole_id());
            st.setInt(2, acc.getCoin_id().getCoin_id());
            st.setString(3, acc.getEmail());
            st.setString(4, acc.getUsername());
            st.setString(5, acc.getPass());
            st.setString(6, acc.getName());
            st.setString(7, acc.getPhone());
            st.setString(8, acc.getAddress());
            st.setString(9, acc.getImage());
            st.setString(10, acc.getCreation_datetime());
            st.setInt(11, acc.getStatus());
            st.setString(12, acc.getToken());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePassOfAccount(String pass, String email) {
        String sql = "UPDATE Account Set pass = ? WHERE email = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pass);
            st.setString(2, email);

            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateToken(String token, String email) {
        String sql = "UPDATE Account Set token = ? WHERE email = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, token);
            st.setString(2, email);

            ResultSet rs = st.executeQuery();
        } catch (Exception e) {
        }
    }

    private int getMaxAccountId() {
        int maxAccountId = -1;
        String sql = "SELECT MAX(account_id) AS max_id FROM [dbo].[Account]";
        try ( PreparedStatement st = connection.prepareStatement(sql);  ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                maxAccountId = rs.getInt("max_id");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error getting maximum account ID: ", e);
        }
        return maxAccountId;
    }

    public Account getAccountByCoinId(int coinId) {
        String sql = "Select * from account where coin_Id =? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, coinId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc.setAccId(rs.getInt(1));
                Role role = getRoleById(rs.getInt(2));
                acc.setRole_id(role);
                Coin coin = getCoinById(rs.getInt(3));
                acc.setCoin_id(coin);
                acc.setEmail(rs.getString(4));
                acc.setUsername(rs.getString(5));
                acc.setPass(rs.getString(6));
                acc.setImage(rs.getString(7));
                acc.setCreation_datetime(rs.getString(8));
                acc.setStatus(rs.getInt(9));
                acc.setToken(rs.getString(10));

                return acc;

            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateAccount(int roleId, int coinId, String email, String fullName, String pass, String token) {
        int maxAccountId = getMaxAccountId();

        if (maxAccountId != -1) {
            String sql = "UPDATE [dbo].[Account] SET [role_id] = ?, [coin_Id] = ?, [email] = ?, [fullName] = ?, [pass] = ?, [token] = ? WHERE account_id = ?";
            try ( PreparedStatement st = connection.prepareStatement(sql)) {
                st.setInt(1, roleId);
                st.setInt(2, coinId);
                st.setString(3, email);
                st.setString(4, fullName);
                st.setString(5, pass);
                st.setString(6, token);
                st.setInt(7, maxAccountId);

                st.executeUpdate();

                LOGGER.info("Account with ID " + maxAccountId + " updated successfully.");
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Error updating account: ", e);
            }
        } else {
            LOGGER.warning("No accounts found.");
        }
    }

    public void updateProfile(String name, String pass, String image, int account_id) {

        String sql = "UPDATE [dbo].[Account]\n"
                + "   SET [username] = ?\n"
                + "      ,[pass] = ?\n"
                + "      ,[image] = ?\n"
                + " WHERE account_id = ?";
        try ( PreparedStatement st = connection.prepareStatement(sql)) {

            st.setString(1, name);
            st.setString(2, pass);
            st.setString(3, image);
            st.setInt(4, account_id);

            st.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating account: ", e);
        }
    }

    public void deleteAccount(int id) {
        String sql = "delete from account where account_id = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setInt(1, id);

            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteCoin(int id) {
        String sql = "delete from coin where coin_Id = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setInt(1, id);

            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Account login(String name, String password) {
        String sql = "SELECT [account_id],[role_id],[coin_Id],[email],[username],[pass],[name],[phone],[address],[image],[creation_datetime],[status],[token]\n"
                + "FROM [dbo].[Account] \n"
                + "WHERE (email = ? OR username = ?) AND pass = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, name);
            st.setString(3, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account acc = new Account();
                acc.setAccId(rs.getInt(1));
                Role role = getRoleById(rs.getInt(2));
                acc.setRole_id(role);
                Coin coin = getCoinById(rs.getInt(3));
                acc.setCoin_id(coin);
                acc.setEmail(rs.getString(4));
                acc.setUsername(rs.getString(5));
                acc.setPass(rs.getString(6));
                acc.setName(rs.getString(7));
                acc.setPhone(rs.getString(8));
                acc.setAddress(rs.getString(9));
                acc.setImage(rs.getString(10));
                acc.setCreation_datetime(rs.getString(11));
                acc.setStatus(rs.getInt(12));
                acc.setToken(rs.getString(13));
                return acc;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Better to log or handle exceptions properly
        }
        return null;
    }

    public boolean validToken(String token) {
        String sql = "SELECT [account_id],[role_id],[coin_Id],[email],[fullName],[pass],[image],[creation_datetime],[status],[token]\n"
                + "  FROM [dbo].[Account] where token = ?";
        String Token = "";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, token);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Token = rs.getString("token");
            }
        } catch (Exception e) {
        }
        return false;
    }

    public Account getAccountByToken(String token) {
        String sql = "SELECT [account_id],[role_id],[coin_Id],[email],[fullName],[pass],[image],[creation_datetime],[status],[token]\n"
                + "  FROM [dbo].[Account] where token = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, token);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc.setAccId(rs.getInt(1));
                Role role = getRoleById(rs.getInt(2));
                acc.setRole_id(role);
                Coin coin = getCoinById(rs.getInt(3));
                acc.setCoin_id(coin);
                acc.setEmail(rs.getString(4));
                acc.setUsername(rs.getString(5));
                acc.setPass(rs.getString(6));
                acc.setImage(rs.getString(7));
                acc.setCreation_datetime(rs.getString(8));
                acc.setStatus(rs.getInt(9));
                acc.setToken(rs.getString(10));
                return acc;

            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account getAccountByEmailAndPass(String email, String password) {
        String sql = "SELECT [account_id],[role_id],[coin_Id],[email],[fullName],[pass],[image],[creation_datetime],[status],[token]\n"
                + "  FROM [dbo].[Account] where email = ? and pass = ?";

        try ( PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, email);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc.setAccId(rs.getInt(1));
                Role role = getRoleById(rs.getInt(2));
                acc.setRole_id(role);
                Coin coin = getCoinById(rs.getInt(3));
                acc.setCoin_id(coin);
                acc.setEmail(rs.getString(4));
                acc.setUsername(rs.getString(5));
                acc.setPass(rs.getString(6));
                acc.setImage(rs.getString(7));
                acc.setCreation_datetime(rs.getString(8));
                acc.setStatus(rs.getInt(9));
                acc.setToken(rs.getString(10));

                return acc;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String Token = "2BBWpNwzVbGu0J1AgxVd";
        String email = "ddhung2003@gmail.com";
        String pass = "123456789";
        int role = 1;
        int coin = 3;
        String name = "hung";
        String image = null;
        

        AccountDAO accountDAO = new AccountDAO();
        Account acc = accountDAO.getAccountbyID(3);
        System.out.println(acc.toString());
        
        
//        List<Account> list = accountDAO.listAccount();
//        for (Account account : list) {
//            System.out.println(account);
//        }

    }

}
