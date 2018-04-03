package Model;


public class User {

    private int userid;
    private String name;
    private int ssn;
    private String userName;
    private String password;
    private Reservation reservation;
    //private Search search;

    //Constructor
    public User(int userID, String nafn, int kennitala, String notendaNafn, String lykilord) {
        userid = userID;
        name = nafn;
        ssn = kennitala;
        userName = notendaNafn;
        password = lykilord;
    }

    public void writeReview(int stjarna, String review) {
        
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the ssn
     */
    public int getSsn() {
        return ssn;
    }
}