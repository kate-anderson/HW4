package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Family;

public class ReadRecord {
    private Connection conn;
    private ResultSet results;
    
    private Family family = new Family();
    private int familyID;
    
    public ReadRecord (int familyID){
    Properties props = new Properties(); //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        
        this.familyID = familyID;
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public void doRead(){
        try {
            //set up a string to hold our Query
            String query = "SELECT * FROM family WHERE familyID =?";
            
            //create a preparedStatement using our query string
            PreparedStatement ps = conn.prepareStatement(query);
            
            //fill in the preparedStatement
            ps.setInt(1, familyID);
            
            //execute the query
            this.results = ps.executeQuery();
            this.results.next();
            
            family.setFamilyID(this.results.getInt("familyID"));
            family.setFamMemName(this.results.getString("famMemName"));
            family.setAge(this.results.getInt("age"));
            family.setBirthday(this.results.getString("birthday"));
            family.setRelation(this.results.getString("relation"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public Family getFamily(){
        return this.family;
    }
}
