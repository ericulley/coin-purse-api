package net.coinpurse.api.coinpurseapi.wallets;

import net.coinpurse.api.coinpurseapi.wallets.Wallet;
import net.coinpurse.api.coinpurseapi.wallets.WalletRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public List<Wallet> allWallets() {
        return walletRepository.findAll();
    }

    public Wallet[] getWalletsByOwner(String id) throws Exception {
        Optional<Wallet[]> optionalWallets = walletRepository.findAllWalletsByOwner(id);
        if (optionalWallets.isPresent()) {
            Wallet[] wallets = optionalWallets.get();
            return wallets;
        } else {
            throw new Exception("Wallet could not be found.");
        }
    }

    public Wallet createWallet(Wallet newWallet) {
//        System.out.println("New Wallet: " + newWallet);
        return walletRepository.insert(newWallet);
    }

    public void updateWallet(ObjectId id, Wallet newAmount) throws Exception {
        Optional<Wallet> optionalWallet = walletRepository.findById(id);
        if (optionalWallet.isPresent()) {
            Wallet foundWallet = optionalWallet.get();
            foundWallet.setAmountOwned(newAmount.getAmountOwned());
            walletRepository.save(foundWallet);
        } else {
            throw new Exception("Wallet could not be updated.");
        }
    }

    public void deleteWallet(ObjectId id) {
        walletRepository.deleteById(id);
    }
}
