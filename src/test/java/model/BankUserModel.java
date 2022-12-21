package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Base class for bank user model.
 *
 * @author am.garcia
 */
@Data
@NoArgsConstructor
@JsonPropertyOrder({"name", "lastName", "accountNumber", "amount",
        "transactionType", "email", "active", "country", "telephone", "id"})
public class BankUserModel {
    private String name;
    private String lastName;
    private String accountNumber;
    private String amount;
    private String transactionType;
    private String email;
    private String active;
    private String country;
    private String telephone;
    private String id;

    /**
     * Constructor method for standard bank user model.
     *
     * @param name            : name
     * @param lastName        : lastname
     * @param accountNumber   : account number
     * @param amount          : account amount
     * @param transactionType : transaction type
     * @param email           : email
     * @param active          : active user
     * @param country         : country
     * @param telephone       : telephone
     * @param id              : id
     */
    public BankUserModel(String name, String lastName, String accountNumber, String amount, String transactionType,
                         String email, String active, String country, String telephone, String id) {
        this.name = name;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.email = email;
        this.active = active;
        this.country = country;
        this.telephone = telephone;
        this.id = id;
    }
}
