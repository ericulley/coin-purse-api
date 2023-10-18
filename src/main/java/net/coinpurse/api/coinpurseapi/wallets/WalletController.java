package net.coinpurse.api.coinpurseapi.wallets;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping
    public ResponseEntity<List<Wallet>> getAllWallets() {
        return new ResponseEntity<List<Wallet>>(walletService.allWallets(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Wallet>> getOneWallet(@PathVariable ObjectId id) {
        try {
            return new ResponseEntity<Optional<Wallet>>(walletService.getWallet(id), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping()
    public ResponseEntity<Wallet> createWallet(@RequestBody Wallet newWallet) {
        try {
            return new ResponseEntity<Wallet>(walletService.createWallet(newWallet), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateWallet(@PathVariable ObjectId id, @RequestBody Wallet newAmount) {
        try {
            walletService.updateWallet(id, newAmount);
            return new ResponseEntity("Success", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWalletEntry(@PathVariable ObjectId id) {
        try {
            walletService.deleteWallet(id);
            return new ResponseEntity("Success", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            throw new RuntimeException(e);
        }
    }
}
