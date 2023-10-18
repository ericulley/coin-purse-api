package net.coinpurse.api.coinpurseapi.wallets;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wallets")
public class Wallet {
    @Id
    private ObjectId id;

    private Long owner;

    private String coinSymbol;

    private Double amountOwned;

    // Constructor 1: None
    public Wallet() {
    }

    // Constructor 2: All
    public Wallet(ObjectId id, Long user, String coinSymbol, Double amountOwned) {
        this.id = id;
        this.owner = user;
        this.coinSymbol = coinSymbol;
        this.amountOwned = amountOwned;
    }

    // Constructor 3: No id for DB
    public Wallet(Long user, String coinSymbol, Double amountOwned) {
        this.id = new ObjectId();
        this.owner = user;
        this.coinSymbol = coinSymbol;
        this.amountOwned = amountOwned;
    }

    // Constructor 4: Update Amount
    public Wallet(Double amountOwned) {
        this.amountOwned = amountOwned;
    }

    // Getters & Setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) { this.id = id; }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long user) {
        this.owner = user;
    }

    public String getCoinSymbol() {
        return coinSymbol;
    }

    public void setCoinSymbol(String coinSymbol) {
        this.coinSymbol = coinSymbol;
    }

    public Double getAmountOwned() {
        return amountOwned;
    }

    public void setAmountOwned(Double amountOwned) {
        this.amountOwned = amountOwned;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", clientId=" + owner +
                ", coinSymbol='" + coinSymbol + '\'' +
                ", amountOwned=" + amountOwned +
                '}';
    }
}
