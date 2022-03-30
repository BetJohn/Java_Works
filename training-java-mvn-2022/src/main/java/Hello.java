import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;

public class Hello {
    public static void main(String[] args) throws SQLException {
//        String connectionUrl = "jdbc:mysql://localhost:3306/spring_crud_sql";
//        String username = "root";
//        String password = "topsecretpassword";
//        Connection connection = DriverManager.getConnection(connectionUrl, username, password);
//        Statement ps = connection.createStatement();

        // PERFORM QUERY TO READ DATA
//        ResultSet rs = ps.executeQuery("SELECT * FROM project");
//        while (rs.next()) {
//            System.out.println(rs.getString("author_id"));
//        }

        // PERFORM QUERY TO WRITE DATA
//        PreparedStatement psw = connection.prepareStatement("INSERT INTO `project_v2` (`description`, `end_date`) VALUES (?, ?);");
//        psw.setString(1, "alabala");
//        psw.setInt(2, 123);
//        psw.execute();
//
//        insert(new Customer(2, "Player2", "Popesc", "Vasile", "074244444", "Str Victoriei",
//                "Ilfov", "625423", "Romania"));
        Orders comanda = new Orders(1,"14.03.2002","15.08.2003","shipped","no comments",2);
        viewAllOrders();
    }

    public static void insert(Customer customer) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/customers";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        PreparedStatement psw = connection.prepareStatement("INSERT INTO `customers` (`id`, `username`, `last_name`, `first_name`, `phone`, `address`, `city`, `postalCode`, `country`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
        psw.setInt(1, customer.getID());
        psw.setString(2, customer.getUsername());
        psw.setString(3, customer.getLast_name());
        psw.setString(4, customer.getFirst_name());
        psw.setString(5, customer.getPhone());
        psw.setString(6, customer.getAddress());
        psw.setString(7, customer.getCity());
        psw.setString(8, customer.getPostalCode());
        psw.setString(9, customer.getCountry());
        psw.execute();
    }
    public static void delete(int ID)throws SQLException{
        String connectionUrl = "jdbc:mysql://localhost:3306/customers";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);
        PreparedStatement psw = connection.prepareStatement("DELETE FROM customers WHERE ID = " + ID + ";");
        psw.execute();
    }
    public static void getByID(int ID) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/customers";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        String QUERY = "SELECT * FROM customers WHERE id = " + ID;

        Statement ps = connection.createStatement();

        ResultSet rs = ps.executeQuery(QUERY);

        while(rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("last_name"));
            System.out.println(rs.getString("first_name"));
            System.out.println(rs.getInt("phone"));
            System.out.println(rs.getString("address"));
            System.out.println(rs.getString("city"));
            System.out.println(rs.getInt("postalCode"));
            System.out.println(rs.getString("country"));
        }
    }
    public static void getAll()throws SQLException{
        String connectionUrl = "jdbc:mysql://localhost:3306/customers";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        String QUERY = "SELECT * FROM customers ";

        Statement ps = connection.createStatement();

        ResultSet rs = ps.executeQuery(QUERY);

        while(rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("last_name"));
            System.out.println(rs.getString("first_name"));
            System.out.println(rs.getInt("phone"));
            System.out.println(rs.getString("address"));
            System.out.println(rs.getString("city"));
            System.out.println(rs.getInt("postalCode"));
            System.out.println(rs.getString("country"));
            System.out.println("\n");
        }
    }
    public static void update(int ID, String p, String newValue)throws SQLException{
        String connectionUrl = "jdbc:mysql://localhost:3306/customers";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        String QUERY = "UPDATE customers SET " + p + "= '" + newValue + "' WHERE id = " + ID;

        PreparedStatement psw = connection.prepareStatement(QUERY);
        psw.execute();
    }
    public static void newOrder(Orders order)throws SQLException{
        String connectionUrl = "jdbc:mysql://localhost:3306/customers";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        PreparedStatement psw = connection.prepareStatement("INSERT INTO orders(id, order_date, shipped_date, status, comments, customer_id) VALUES (?, ?, ?, ?, ?, ?)");

        psw.setInt(1, order.getID());
        psw.setString(2, order.getOrder_date());
        psw.setString(3, order.getShipped_date());
        psw.setString(4, order.getStatus());
        psw.setString(5, order.getComments());
        psw.setInt(6, order.getCustomer_id());
        psw.execute();

    }
    public static void viewAllOrders()throws SQLException{
        String connectionUrl = "jdbc:mysql://localhost:3306/customers";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        String QUERY = "SELECT * FROM orders ";

        Statement ps = connection.createStatement();

        ResultSet rs = ps.executeQuery(QUERY);

        while(rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("order_date"));
            System.out.println(rs.getString("shipped_date"));
            System.out.println(rs.getString("status"));
            System.out.println(rs.getString("comments"));
            System.out.println(rs.getInt("customer_id"));
            System.out.println("\n");
        }

    }
    public static void update_status(int ID, String newValue)throws SQLException{
        String connectionUrl = "jdbc:mysql://localhost:3306/customers";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        String QUERY = "UPDATE orders SET status = '" + newValue + "' WHERE id = " + ID;

        PreparedStatement psw = connection.prepareStatement(QUERY);
        psw.execute();
    }
    public static void add_comment(int ID, String newValue)throws SQLException{
        String connectionUrl = "jdbc:mysql://localhost:3306/customers";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        String QUERY = "SELECT * FROM orders WHERE id = " + ID;

        Statement ps = connection.createStatement();

        ResultSet rs = ps.executeQuery(QUERY);
        String old = "";
        while(rs.next()){
            old = rs.getString("comments");
        }
        String QUERY2 = "UPDATE orders SET comments = '" + old + newValue + "' WHERE id = " + ID;
        PreparedStatement psw = connection.prepareStatement(QUERY);
        psw.execute();
    }
}
