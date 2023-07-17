
public class Datenbankverbindung  
{
    
    Class.Datenbankverbindung("com.mysql.jdbc.Driver").newInstance;
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test?User=Benutzer&passwort=12345");
    //Driver verbinden und mit Datenbank bei local host verbinden
    
    public Datenbankverbindung()
    {
        
        Statment stat = conn.createSatment();
        //int anzahl = stat.executeUpdate("")
    }  
    
    public int GetKontoPasswort(String KontoNameA) //Holt das Passwort vom Kontoname 
    {
        ResultSet res = stat.executeQuery("SELECT Kontoname, Kontopasswort FROM Konto WHERE Kontoname='KontoNameA'");
        return KontoPasswort;
    }
     public Int GetKontoRecord(String KontoNameA) //Holt den Record vom Kontoname 
    {
        ResultSet res = stat.executeQuery("SELECT Kontoname, KontoRecord FROM Konto WHERE Kontoname='KontoNameA'");
        return KontoPasswort;
    }
    
}
