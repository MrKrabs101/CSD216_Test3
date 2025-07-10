package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.PizzaOrder;

public class PizzaOrderDAO {
    private Connection conn;

    public PizzaOrderDAO() throws SQLException {
        conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/pizza_app", "root", ""
        );
        conn.setAutoCommit(true); // Ensures inserts are saved
        System.out.println(conn.getMetaData().getURL());

    }

    public void insertOrder(PizzaOrder order) throws SQLException {
        String sql = "INSERT INTO PizzaOrders (customer_name, mobile_number, pizza_size, toppings, total_bill) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, order.getCustomerName());
        stmt.setString(2, order.getMobileNumber());
        stmt.setString(3, order.getPizzaSize());
        stmt.setInt(4, order.getToppings());
        stmt.setDouble(5, order.getTotalBill());
        stmt.executeUpdate();
        System.out.println("Order inserted into database!");
    }

    public List<PizzaOrder> getAllOrders() throws SQLException {
        List<PizzaOrder> orders = new ArrayList<>();
        String sql = "SELECT * FROM PizzaOrders";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            PizzaOrder order = new PizzaOrder(
                rs.getInt("id"),
                rs.getString("customer_name"),
                rs.getString("mobile_number"),
                rs.getString("pizza_size"),
                rs.getInt("toppings"),
                rs.getDouble("total_bill")
            );
            orders.add(order);
        }
        return orders;
    }
}
