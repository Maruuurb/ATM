import java.lang.reflect.Array;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.security.MessageDigest;

public class User {

    private String firstName; // The first name of the user.

    private String lastName; // The last name of the user.

    private String uuid; //The ID number of the user (universally unique identifier).

    private byte pinHash[]; // The MD5 hash of the user's pin number.

    private ArrayList<Account> accounts; // The list of accounts for this user.

    /**
     * Create new user
     *
     * @param firstName
     * @param lastName
     * @param pin
     * @param theBank
     */
    public User(String firstName, String lastName, String pin, Bank theBank) {

        // set user's name
        this.firstName = firstName;
        this.lastName = lastName;

        //  store the pin's MD5 hash, rather than the original value, for
        // security reason

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("error, caught NoSuchAlgorithmException ");
            e.printStackTrace();
            System.exit(1);

        }
        /**
         * Get a new, unique universal ID for the user
         */
        this.uuid = theBank.getNewUserUUID();

        /**
         * Create empty list of accounts
         */
        this.accounts = new ArrayList<Account>();

        /**
         * Print log message
         */
        System.out.printf("New user %s, %s, with ID %s created. \n", lastName, firstName, this.uuid);
    }
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

    /**
     * Return the user's UUID
     * @return
     */
    public String getUUID(){
        return this.uuid;
    }

    /**
     *
     * @param aPin
     * @return
     */
    public boolean validatePin(String aPin){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash );
        } catch (NoSuchAlgorithmException e) {
            System.err.println("error, caught NoSuchAlgorithmException ");
            e.printStackTrace();
            System.exit(1);
        }
        return false;
    }

    /**
     *
     * @return
     */
    public String getFirstName(){
        return this.firstName;
    }
    public void printAccountSummary(){
        System.out.printf("\n\n%s's accounts summary", this.firstName);
        for (int a =0; a <this.accounts.size(); a++){
            System.out.printf("%d) %s\n", a + 1,
                    this.accounts.get(a).getSummaryLine());
        }
        System.out.println();
    }
    public int numAccounts(){
        return this.accounts.size();
    }
    public void printAccountsSummary() {

        System.out.printf("\n\n%s's accounts summary\n", this.firstName);
        for (int a = 0; a < this.accounts.size(); a++) {
            System.out.printf("%d) %s\n", a+1,
                    this.accounts.get(a).getSummaryLine());
        }
        System.out.println();

    }
    public double getAcctBalance(int accIdx){
        return this.accounts.get(accIdx).getBalance();
    }
    public  String getAcctUUID(int acctIdx){
        return this.accounts.get(acctIdx).getUUID();
    }
    public void addAcctTransaction(int acctIdx, double amount, String memo){
        this.accounts.get(acctIdx).addTransaction(amount,memo);
    }
    public void printAcctTransHistory(int acctIdx) {
        this.accounts.get(acctIdx).printTransHistory();
    }
}
