package net.coinpurse.api.coinpurseapi.wallets;

import net.coinpurse.api.coinpurseapi.wallets.Wallet;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends MongoRepository<Wallet, ObjectId> { }
