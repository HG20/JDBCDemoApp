import java.sql.*;


/**
 * Created by condor on 26/02/15.
 * FastTrackIT, 2015
 * <p/>
 * DEMO ONLY PURPOSES, IT MIGHT CONTAINS INTENTIONALLY ERRORS OR ESPECIALLY BAD PRACTICES
 *
 * make sure you refactor it and remove lots of bad practices like loading the driver multiple times or
 * repeating the same common code multiple times
 *
 * BTW, exercise 1: how we reorg this/refactor in small pieces
 */
public class DemoCRUDOperations {


    public static void main(String[] args) {
        System.out.println("Hello database users! We are going to call DB from Java");
        try {
            //demo CRUD operations
          //  demoCreate();
           // demoRead();
         //  demoUpdate();
       //     demoRead();
         //   demoDelete();

           // demoBlobInsert();
           // demoBlobRead();

           boolean result =  login("andrei@gmail.com", "mmmmmm");
            if(result)
                System.out.println("bravooo");
            else
                System.out.println("nuuuuuu");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void demoCreate() throws ClassNotFoundException, SQLException {

        // 1. load driver
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/Agenda_Horea";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO USERS (fullname, email, password) VALUES (?,?,?)");
        pSt.setString(1, "Andrei");
        pSt.setString(2, "andrei@gmail.com");
        pSt.setString(3, "lolo");

        // 5. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    private static void demoRead() throws ClassNotFoundException, SQLException {
        // 1. load driver
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/Agenda_Horea";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        // 5. execute a query
        ResultSet rs = st.executeQuery("SELECT fullname,email,password FROM users");

        // 6. iterate the result set and print the values
        while (rs.next()) {
            System.out.print(rs.getString("fullname").trim());
            System.out.print("---");
            System.out.println(rs.getString("email").trim());
            System.out.print("---");
            System.out.println(rs.getString("password"));
            System.out.println("---");
        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();
    }

    private static void demoUpdate() throws ClassNotFoundException, SQLException {

        // 1. load driver
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/Agenda_Horea";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, PASSWORD, USERNAME);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("UPDATE USERS set fullname=?, password=? WHERE email=?"); //so we have 3 params
        pSt.setString(1, "jjjjjjjjjjjjjj");
        pSt.setString(2, "mmmmmm");
        pSt.setString(3, "andrei@gmail.com");




        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }


    private static void demoDelete() throws ClassNotFoundException, SQLException {

        // 1. load driver
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://IP:5432/fast1";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("DELETE FROM USERS WHERE PK_USER=?");
        pSt.setLong(1, 1);

        // 5. execute a prepared statement
        int rowsDeleted = pSt.executeUpdate();
        System.out.println(rowsDeleted + " rows were deleted.");
        // 6. close the objects
        pSt.close();
        conn.close();
    }

    private static boolean login(String email, String password) throws ClassNotFoundException, SQLException  {
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/Agenda_Horea";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        // 5. execute a query
        String q="SELECT fullname,email,password FROM users where email='"+email+"' and password='"+password+"'";
        System.out.println(q);
        ResultSet rs = st.executeQuery(q);

        // 6. iterate the result set and print the values
        while (rs.next()) {
            System.out.print(rs.getString("fullname").trim());
            System.out.print("---");
            System.out.println(rs.getString("email").trim());
            System.out.print("---");
            System.out.println(rs.getString("password"));
            System.out.println("---");
            return true;
        }


return false;


    }
}

