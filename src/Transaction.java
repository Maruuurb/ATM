import java.util.Date;

public class Transaction {

    private double amount; // The amount of this transaction

    private Date timestamp; // The time and date of this transaction

    private String memo; // A memo for this transaction

    private Account inAccount; //The account in which the transaction was performed

    /**
     * Create a new transaction
     *
     * @param amount    the amount transacted
     * @param inAccount the account the transactions belong to
     */
    public Transaction(double amount, Account inAccount) {
        this.amount = amount;
        this.inAccount = inAccount;
        this.timestamp = new Date();
        this.memo = "";
    }

    /**
     * @param amount    the amount transacted
     * @param memo      the memo for the transaction
     * @param inAccount the account the transactions belong to
     */
    public Transaction(double amount, String memo, Account inAccount) {
        // call  the two-ara constructor first
        this(amount, inAccount);

        //set the memo
        this.memo = memo;
    }

    public double getAmount() {
        return this.amount;
    }
    public  String getSummaryLine(){
        if (this.amount >= 0){
            return  String.format("%s : $%.02f", this.timestamp.toString(), this.amount, this.memo);
        }else {
            return String.format("%s : $(%.02f)", this.timestamp.toString(), -this.amount, this.memo);
        }
    }
}
