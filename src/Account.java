import java.util.ArrayList;

public class Account {

    private String name; // The name of the account.


    private String uuid; // The account ID number

    private User holder; // The User object that owns this account

    private ArrayList<Transaction> transactions; // The list of transactions for this account

    /**
     *
     * @param name
     * @param holder
     * @param theBank
     */

    public Account(String name, User holder, Bank theBank) {
        // set the account name and holder
        this.name = name;
        this.holder = holder;

        //get new account UUID
        this.uuid = theBank.getNewAccountUUID();

        //init transaction
        this.transactions = new ArrayList<Transaction>();

        // add to holder and bank lists
        holder.addAccount(this);
        theBank.addAccount(this);
    }
    public String getUUID(){
        return this.uuid;

    }
}

