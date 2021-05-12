import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Bank {
    private String name;

    private ArrayList<User> users;

    private ArrayList<Account> accounts;

    /**
     * Generate a new universally unique ID for a user
     * @return the uuid
     */
    public String getNewUserUUID() {
        //inits
        String uuid;
        Random rng = new Random();
        int len =6;
        boolean nonUnique = false;
        // loping until we get a unique ID
        do {
            //generate the number
            uuid ="";
            for (int c=0; c < len; c++){
                uuid += ((Integer)rng.nextInt(10)).toString();
            }
            //Check to make sure it's unique
            for (User u : this.users){
                if (uuid.compareTo(u.getUUID())==0){
                    nonUnique = true;
                    break;
                }
            }
        }while (nonUnique);



        return uuid;
    }

    /**
     * Generate a new universally unique getNewAccountUUID for a user
     * @return
     */

    public String getNewAccountUUID() {
        //inits
        String uuid;
        Random rng = new Random();
        int len =10;
        boolean nonUnique = false;
        // loping until we get a unique ID
        do {
            //generate the number
            uuid ="";
            for (int c=0; c < len; c++){
                uuid += ((Integer)rng.nextInt(10)).toString();
            }
            //Check to make sure it's unique
            for (Account a: this.accounts){
                if (uuid.compareTo(a.getUUID())==0){
                    nonUnique = true;
                    break;
                }
            }
        }while (nonUnique);



        return uuid;

    }

    /**
     * Add an account
     * @param anAcct the account to add
     */
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }
}
