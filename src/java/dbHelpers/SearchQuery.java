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

public class SearchQuery {
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery(){
        Properties props = new Properties(); //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void doSearch(String famMemName){
        try {
            String query = "SELECT * FROM family WHERE UPPER(famMemName) LIKE ? ORDER BY familyID ASC";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%"+ famMemName.toUpperCase() +"%");
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public String getHTMLtable(){
        
        String table = "<table id=\"family\">"
                + "<tr>"
                + "<th>ID</th>"
                + "<th>Name</th>"
                + "<th>Age</th>"
                + "<th>Birthday</th>"
                + "<th>Relation</th>"
                + "<th></th>"
                + "</tr>";
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
                table += "<a href=update?familyID="+ fam.getFamilyID() + " class=\"delete\">Update </a>" + "<a href= delete?familyID=" + fam.getFamilyID() + " class=\"delete\"> Delete </a>";
                table += "</td>";
                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        table+="</table>";
            
            return table;
    }
}
