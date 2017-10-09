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

public class ReadQuery {
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery(){
    
        Properties props = new Properties(); //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void doRead(){
    
        try {
            String query = "Select * from family";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLtable(){
        
        String table = "";
        try {
            while(this.results.next()){
                Family fam = new Family();
                fam.setFamilyID(this.results.getInt("familyID"));
                fam.setFamMemName(this.results.getString("famMemName"));
                fam.setAge(this.results.getInt("age"));
                fam.setBirthday(this.results.getString("birthday"));
                fam.setRelation(this.results.getString("relation"));
                
                table += "<tr>";
                table += "<td>";
                table += fam.getFamilyID();
                table += "</td>";
                table += "<td>";
                table += fam.getFamMemName();
                table += "</td>";
                table += "<td>";
                table += fam.getAge();
                table += "</td>";
                table += "<td>";
                table += fam.getBirthday();
                table += "</td>";
                table += "<td>";
                table += fam.getRelation();
                table += "</td>";
                table += "<td>";
                table += "<a href= delete?familyID=" + fam.getFamilyID() + "> Delete </a>";
                table += "</td>";
                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        table+="</table>";
            
            return table;
    }
}
