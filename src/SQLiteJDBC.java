import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

public class SQLiteJDBC {

    private Connection connection;
    private Statement statement;
    private Logger DBL;

    public SQLiteJDBC(){
        this.DBL = Logger.getLogger("SQLite");
        this.connection = null;
        this.statement = null;

        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:LessonScreenKeyboard.db");
            this.DBL.info("Opened database successfully!");
            this.connection.close();
        }catch (Exception err){
            err.printStackTrace();
        }

    }

    public void CreateHistoryTabel(){
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:LessonScreenKeyboard.db");
            this.statement = this.connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS History " +
                        "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "Content TEXT NOT NULL," +
                        "DATE TEXT NOT NULL)";
            this.statement.executeUpdate(sql);
            this.statement.close();
            this.connection.close();
            this.DBL.info("Table created/opened successfully!");
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    public void Insert2History(String string){
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:LessonScreenKeyboard.db");
            this.connection.setAutoCommit(false);
            this.DBL.info("Opened database successfully!");

            this.statement = this.connection.createStatement();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sql = "INSERT INTO History (Content, DATE) " +
                        "VALUES ('" + string + "', '" + simpleDateFormat.format(new Date(Long.parseLong(String.valueOf(System.currentTimeMillis())))) + "');";
            this.statement.executeUpdate(sql);
            this.statement.close();
            this.connection.commit();
            this.connection.close();
            this.DBL.info("Records created successfully!");
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    public ArrayList<String> SelectHistory(){
        ResultSet rs = null;
        ArrayList<String> strings = new ArrayList<String>();
        try{
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:LessonScreenKeyboard.db");
            this.connection.setAutoCommit(false);
            this.DBL.info("Opened database successfully!");

            this.statement = this.connection.createStatement();
            rs = this.statement.executeQuery("SELECT * FROM History;");
            while (rs.next()){
                strings.add(rs.getString("Content"));
            }
            rs.close();
            this.statement.close();
            this.connection.close();
        }catch (Exception err){
            err.printStackTrace();
        }
        return strings;
    }
}
