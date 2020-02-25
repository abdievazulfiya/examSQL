package exam2;

public class Main {
    public static void main(String[] args) {
        Dbworker dbworker = new Dbworker();
        String zagolovok = "Zavtra budet sneg";
        String textnews = "Cosmopolitan";
        String time = "19:00";
        dbworker.putnewnews(zagolovok, textnews, time);
    }
}
