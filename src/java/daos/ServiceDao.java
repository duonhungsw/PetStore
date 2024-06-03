package daos;

import java.util.ArrayList;
import java.sql.*;
import model.BookedPetGroomerSchedule;
import model.CustomerServiceBookings;
import model.PetGroomerInfo;
import model.Service;
import model.ViewBookedScheduleOfPetGroomer;
import model.ViewBookedService;

public class ServiceDao extends DBContext{
    private ArrayList<Service> services = new ArrayList<>();
    private ArrayList<CustomerServiceBookings> bookingInfo = new ArrayList<>();
    private ArrayList<ViewBookedScheduleOfPetGroomer> bookedScheduleOPG = new ArrayList<>();

    public ArrayList<Service> getAllService(){
        try {
            String query = "SELECT sd.service_id, sd.service_name, sp.service_price, sd.service_img "
                    + "FROM ServiceDetail sd INNER JOIN ServicePrice sp ON sd.service_id = sp.service_id";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Service ser = new Service();
                    ser.setService_id(rs.getInt("service_id"));
                    ser.setService_name(rs.getString("service_name"));
                    ser.setService_price(rs.getInt("service_price"));
                    ser.setService_img(rs.getString("service_img"));
                services.add(ser);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return services;
    }
    
    public ArrayList<ViewBookedService> getBookedService(int userId) {
         ArrayList<ViewBookedService> bookedServices = new ArrayList<>();
        try {
            String query = "SELECT csb.booking_id, csb.service_id, sd.service_name, csb.groomer_id, "
                    + "pgi.groomer_name, csb.booking_date, csb.booking_time, csb.is_completed "
                    + "FROM CustomerServiceBookings csb "
                    + "JOIN ServiceDetail sd ON csb.service_id = sd.service_id "
                    + "JOIN PetGroomerInfo pgi ON csb.groomer_id = pgi.groomer_id "
                    + "WHERE csb.customer_id = ? "
                    + "ORDER BY csb.booking_date, csb.booking_time";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ViewBookedService vbs = new ViewBookedService();
                vbs.setBooking_id(rs.getInt("booking_id"));
                vbs.setService_id(rs.getInt("service_id"));
                vbs.setService_name(rs.getString("service_name"));
                vbs.setGroomer_id(rs.getInt("groomer_id"));
                vbs.setGroomer_name(rs.getString("groomer_name"));
                vbs.setBooking_date(rs.getDate("booking_date"));
                vbs.setBooking_time(rs.getInt("booking_time"));
                vbs.setIsCompleted(rs.getInt("is_completed"));
                bookedServices.add(vbs);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return bookedServices;
    }
    
    public ArrayList<ViewBookedScheduleOfPetGroomer> getBookedScheduleOPG(int userId){
        try {
            String query = "SELECT csb.booking_id, csb.service_id, sd.service_name, csb.service_price, csb.customer_id, csb.booking_date, csb.booking_time, csb.is_completed "
                    + "FROM CustomerServiceBookings csb "
                    + "JOIN ServiceDetail sd ON sd.service_id = csb.service_id "
                    + "WHERE csb.groomer_id = ? "
                    + "ORDER BY csb.booking_date, csb.booking_time";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ViewBookedScheduleOfPetGroomer vbsOPG = new ViewBookedScheduleOfPetGroomer();
                    vbsOPG.setBooking_id(rs.getInt("booking_id"));
                    vbsOPG.setService_id(rs.getInt("service_id"));
                    vbsOPG.setService_name(rs.getString("service_name"));
                    vbsOPG.setService_price(rs.getInt("service_price"));
                    vbsOPG.setCustomer_id(rs.getInt("customer_id"));
                    vbsOPG.setBooking_date(rs.getDate("booking_date"));
                    vbsOPG.setBooking_time(rs.getInt("booking_time"));
                    vbsOPG.setIsCompleted(rs.getInt("is_completed"));
                bookedScheduleOPG.add(vbsOPG);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return bookedScheduleOPG;
    }
    
    public ArrayList<PetGroomerInfo> getPetGroomerInfo(){
        ArrayList<PetGroomerInfo> petGroomerInfo = new ArrayList<>();
        try {
            String query = "SELECT * FROM PetGroomerInfo";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                PetGroomerInfo pgInfo = new PetGroomerInfo();
                    pgInfo.setGroomer_id(rs.getInt("groomer_id"));
                    pgInfo.setGroomer_name(rs.getString("groomer_name"));
                petGroomerInfo.add(pgInfo);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return petGroomerInfo;
    }
    
    
    public void insertToCSB (CustomerServiceBookings csb){
        String query = "INSERT INTO CustomerServiceBookings (service_id, service_price, customer_id, groomer_id, customer_name, customer_phone, booking_date, booking_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, csb.getService_id());
            statement.setInt(2, csb.getService_price());
            statement.setInt(3, csb.getCustomer_id());
            statement.setInt(4, csb.getGroomer_id());
            statement.setString(5, csb.getCustomer_name());
            statement.setString(6, csb.getCustomer_phone());
            statement.setDate(7,  new java.sql.Date(csb.getBooking_date().getTime()));
            statement.setInt(8, csb.getBooking_time());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void deleteCSB (int booking_id){
        String query = "DELETE FROM CustomerServiceBookings WHERE booking_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, booking_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Integer> getBookedTime(int groomer_id, String booking_date) {
        ArrayList<Integer> employeeSchedules = new ArrayList<>();

        String query = "SELECT booking_time FROM BookedPetGroomerSchedule WHERE groomer_id = ? AND booking_date = ? AND is_available = 0";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, groomer_id);
            statement.setString(2, booking_date);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                employeeSchedules.add(rs.getInt("booking_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeSchedules;
    }

    public void insertToBookedPetGroomerSchedule(BookedPetGroomerSchedule bps) {
        String query = "INSERT INTO BookedPetGroomerSchedule (groomer_id, booking_date, booking_time, is_available) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, bps.getGroomer_id());
            statement.setDate(2, new java.sql.Date(bps.getBooking_date().getTime()));
            statement.setInt(3, bps.getBooking_time());
            statement.setInt(4, 0); //Default status is unavailable
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBookedSchedule(int userId, int booking_id) {
        String query = "DELETE FROM BookedPetGroomerSchedule "
                + "WHERE EXISTS ( SELECT BookedPetGroomerSchedule.schedule_id FROM CustomerServiceBookings csb "
                + "WHERE csb.customer_id = ? "
                + "AND csb.booking_id = ? "
                + "AND csb.groomer_id = BookedPetGroomerSchedule.groomer_id "
                + "AND csb.booking_date = BookedPetGroomerSchedule.booking_date "
                + "AND csb.booking_time = BookedPetGroomerSchedule.booking_time)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            statement.setInt(2, booking_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateStatus(int status, int bookingId){
        String query = "UPDATE CustomerServiceBookings SET is_completed = ? WHERE booking_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, status);
            statement.setInt(2, bookingId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
