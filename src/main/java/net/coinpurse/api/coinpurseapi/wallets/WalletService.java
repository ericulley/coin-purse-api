package net.coinpurse.api.coinpurseapi.wallets;

import net.coinpurse.api.coinpurseapi.wallets.Wallet;
import net.coinpurse.api.coinpurseapi.wallets.WalletRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public List<Wallet> allWallets() {
        return walletRepository.findAll();
    }

    public Wallet getWallet(String id) throws Exception {
        System.out.println("PATH ID: " + id);
        Optional<Wallet> optionalWallet = walletRepository.findWalletByOwner(id);
        System.out.println("OPTIONAL WALLET: " + optionalWallet);
        if (optionalWallet.isPresent()) {
            return optionalWallet.get();
        } else {
            throw new Exception("Wallet could not be found.");
        }
    }

    public Wallet createWallet(Wallet newWallet) {
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
