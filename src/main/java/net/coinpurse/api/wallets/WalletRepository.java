package net.coinpurse.api.wallets;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Qualifier("walletRepository")
public interface WalletRepository extends MongoRepository<Wallet, String> {
    Optional<Wallet[]> findAllWalletsByOwner(String id);
}
