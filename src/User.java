import java.lang.reflect.Array;
import java.util.ArrayList;
import java.security.MessageDigest;

public class User {

    private String firstName; // The first name of the user.

    private String lastName; // The last name of the user.

    private String uuid; //The ID number of the user (universally unique identifier).

    private byte pinHash[]; // The MD5 hash of the user's pin number.

    private ArrayList<Account> accounts; // The list of accounts for this user.

    public User(String firstName, String lastName, String pin, Bank theBank){

        // set user's name
        this.firstName = firstName;
        this.lastName = lastName;

        //  store the pin's MD5 hash, rather than the original value, for
        // security reason


    }


}
