package mealplan;

/**
 *
 * @author Isaac Erickson
 */

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;





public class Version {
        private static Connection con = null;
        private static PreparedStatement pst = null;
        private static Statement st = null;
        private static ResultSet rs = null;

        private static Connection con2 = null;
        private static PreparedStatement pst2 = null;
        private static Statement st2 = null;
        private static ResultSet rs2 = null;

        static java.util.Random randam = new java.util.Random();


//Restricted Query method, takes four string:
        //What we will be asking for to be returned
        //Where it is we are telling the query to look, aka the table
        //What column we will be examining
        //What the column item should be equal too for the search
        //
        //It will return one and only one value.  If the query gernates more
        //results, then any extra values will be dropped.
public static String getSingledata(String getWhat, String lookWhere, String lookatWhat, String isWhat){
        String results = "";
        String url = "jdbc:mysql://localhost:3306/mealz";
        String user = "meal2013";
        String password = "password";


        try{
            con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement("SELECT " + getWhat + " FROM " + lookWhere + " WHERE " + lookatWhat + " = " + isWhat + ";");
            rs = pst.executeQuery();

            results = rs.getString(1);
            return results;
        }
        catch (SQLException ex){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally{
            try {
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
                if(con != null){
                    con.close();
                }
            } catch (SQLException ex){
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return results;
}


//This is an open Execution method for any Query if anyone needs to execute an
//add or other query that wont easily fit into any other method, the burden of
//generating the query is placed on the calling method though, so this could
//easily break or be missused.  The maximum size that can be return from this is
// a 20X400 array, so Select * could be dangerous.
public static String[][] getOPENdata(String Query){
        String results[][] = new String[200][10];
        String url = "jdbc:mysql://localhost:3306/mealz";
        String user = "meal2013";
        String password = "password";

        try{
            con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement(Query);
            rs = pst.executeQuery();

            int x = 0;
            int z = 1;
            while(rs.next()){               
                z = 1;
                for(int y = 0; y < 5; y++){
                    results[x][y] = rs.getString(z);                  
                    z++;
                    //System.out.println(results[x][y]);
                }
                x++;
            }

            return results;
        }
        catch (SQLException ex){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally{
            try {
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
                if(con != null){
                    con.close();
                }
            } catch (SQLException ex){
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return results;
}






public static boolean INSERT(String command){
        String url = "jdbc:mysql://localhost:3306/mealz";
        String user = "meal2013";
        String password = "password";

        try{
                con = DriverManager.getConnection(url, user, password);
                pst = con.prepareStatement(command);
                pst.execute();
            return true;
        }
        catch (SQLException ex){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally{
            try {
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
                if(con != null){
                    con.close();
                }
            } catch (SQLException ex){
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return true;
}



public static boolean ARRAYINSERT(String[][] data, int resp){
        String url = "jdbc:mysql://localhost:3306/mealz";
        String user = "meal2013";
        String password = "password";
        int x = 0;

        try{
                con2 = DriverManager.getConnection(url, user, password);


                while(data[x][0] != null){

                    pst2 = con2.prepareStatement("Insert into ingredients values (" + resp + ", '" + data[x][2] + "', '" + data[x][3] + "', " + data[x][0] + "', " + data[x][1] + "');" );
                    pst2.execute();

                    x++;
                }

            return true;
        }
        catch (SQLException ex){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally{
            try {
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
                if(con != null){
                    con.close();
                }
            } catch (SQLException ex){
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return true;
}





















//This Returns ONE random meal in a 1D array containing CRN and Meal Name.
public static String[] getONE(){
        String results[] = new String[3];
        String url = "jdbc:mysql://localhost:3306/mealz";
        String user = "meal2013";
        String password = "password";
        int nextMEAL = 0;

        try{
           
                int num = getNumResp();
                nextMEAL = randam.nextInt(num)+1;
                results[0] = String.valueOf(nextMEAL);

                con = DriverManager.getConnection(url, user, password);
                pst = con.prepareStatement("Select Name FROM CookBook Where CRN = " + nextMEAL + ";");
                rs = pst.executeQuery();
                while(rs.next()){
                       results[1] = rs.getString(1);

                }


                //System.out.println(results[0]);
                //System.out.println(results[1]);

            return results;
        }
        catch (SQLException ex){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally{
            try {
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
                if(con != null){
                    con.close();
                }


            } catch (SQLException ex){
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return results;
}


//This returns 7 Meals in a 2D Array.
public static String[][] getSEVEN(){
        String results[][] = new String[8][3];

        String url = "jdbc:mysql://localhost:3306/mealz";
        String user = "meal2013";
        String password = "password";
        boolean good = true;    

        try{
            con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement("Select count(CRN) FROM CookBook;");
            rs = pst.executeQuery();

            for(int x = 0; x < 7; x++){
                results[x] = getONE();

                for(int y = 0; y <= x; y++){
                    if(y != x){
                        if(results[x][0].equals(results[y][0])){
                            x--;
                         
                        }
                    }
                }
            }
            //System.out.println(results[0][0]);

            return results;
        }
        catch (SQLException ex){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally{
            try {
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
                if(con != null){
                    con.close();
                }

            } catch (SQLException ex){
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return results;
}


public static int getNumResp(){
        
        int value = 0;


        String url = "jdbc:mysql://localhost:3306/mealz";
        String user = "meal2013";
        String password = "password";
        
        try{
            con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement("Select count(CRN) from cookbook;");
            rs = pst.executeQuery();

            while(rs.next()){
                value = Integer.valueOf(rs.getString(1));


                //value = Integer.valueOf(rs.getString(0));
            }
            return value;
        }
        catch (SQLException ex){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally{
            try {
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
                if(con != null){
                    con.close();
                }
            } catch (SQLException ex){
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return value;
}


public static String[] getTypeResp(){

        String value[] = new String[50];
        int x = 0;

        String url = "jdbc:mysql://localhost:3306/mealz";
        String user = "meal2013";
        String password = "password";

        try{
            con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement("Select MType from cookbook group by MType order by MType;");
            rs = pst.executeQuery();

            while(rs.next()){
                value[x] = rs.getString(1);
                x++;
            }
            return value;
        }
        catch (SQLException ex){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally{
            try {
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
                if(con != null){
                    con.close();
                }
            } catch (SQLException ex){
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return value;
}




}

