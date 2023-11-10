package net.coinpurse.api.coinpurseapi.wallets;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Optional;

@Document(collection = "wallets")
public class Wallet {
    @Id
    private String id;

    private String owner;

    private String coinSymbol;

    private String coinId;

    private String coinImg;

    private Double amountOwned;

    // Constructor 0: None
    public Wallet() {}

    // Constructor 1: All
    public Wallet(String id, ObjectId user, String coinSymbol, String coinId, String coinImg, Double amountOwned) {
        System.out.println("Constructor 1");
        this.id = id;
        this.owner = user.toString();
        this.coinSymbol = coinSymbol;
        this.coinId = coinId;
        this.coinImg = coinImg;
        this.amountOwned = amountOwned;
    }

    // Constructor 2: No id for DB
    public Wallet(String user, String coinSymbol, String coinId, String coinImg, Double amountOwned) {
        System.out.println("Constructor 2");
        this.owner = user;
        this.coinSymbol = coinSymbol;
        this.coinId = coinId;
        this.coinImg = coinImg;
        this.amountOwned = amountOwned;
    }

    // Constructor 3: Update Amount
    public Wallet(Double amountOwned) {
        this.amountOwned = amountOwned;
    }

    // Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public String stringIdFromObjectId(ObjectId id) { return id.toString(); }

    public String getOwner() {
        return owner;
    }

    public void setOwner(ObjectId user) {
        this.owner = user.toString();
    }

    public String getCoinSymbol() {
        return coinSymbol;
    }

    public void setCoinSymbol(String coinSymbol) {
        this.coinSymbol = coinSymbol;
    }

    public String getCoinId() {
        return coinId;
    }

    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    public String getCoinImg() {
        return coinImg;
    }

    public void setCoinImg(String coinImg) {
        this.coinImg = coinImg;
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
                ", owner=" + owner +
                ", coinSymbol='" + coinSymbol + '\'' +
                ", coinId='" + coinId + '\'' +
                ", coinImg='" + coinImg + '\'' +
                ", amountOwned=" + amountOwned +
                '}';
    }
}
