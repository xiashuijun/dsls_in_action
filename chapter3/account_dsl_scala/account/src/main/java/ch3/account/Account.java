// Listing 3.4 Account Domain Object in Java

package ch3.account;

import java.util.ArrayList;
import java.util.List;

/**
 * The core abstraction in Java that we will make smarter using Scala
 */
public class Account {
    public enum STATUS { OPEN, CLOSED }

    public enum TYPE { TRADING, SETTLEMENT, BOTH }

    private String number;
    private String firstName;
    private List<String> names = new ArrayList<String>();
    private STATUS status = STATUS.OPEN;
    private TYPE accountType = TYPE.TRADING;
    private double interestAccrued = 0.00;

    public Account(String number, String firstName) {
        this.number = number;
        this.firstName = firstName;
    }

    public Account(String number, String firstName, TYPE accountType) {
        this(number, firstName);
        this.accountType = accountType;
    }

    public double calculate(final Calculator c) {
        interestAccrued = c.calculate(this);
        return interestAccrued;
    }

    public TYPE getAccountType() {
        return accountType;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getInterestAccrued() {
        return interestAccrued;
    }

    public List<String> getNames() {
        return names;
    }

    public String getNumber() {
        return number;
    }

    public STATUS getStatus() {
        return status;
    }

    public boolean isOpen() {
        return status.equals(STATUS.OPEN);
    }

    public Account addName(String name) {
        names.add(name);
        return this;
    }
}

