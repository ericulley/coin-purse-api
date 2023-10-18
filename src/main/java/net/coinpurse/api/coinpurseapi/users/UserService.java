package net.coinpurse.api.coinpurseapi.users;

import net.coinpurse.api.coinpurseapi.wallets.WalletRepository;
import org.bson.types.ObjectId;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WalletRepository walletRepository;

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private Boolean checkPassword(String password, String hashedPassword) {
        if (BCrypt.checkpw(password, hashedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(ObjectId id) {
        Optional<User> foundUser = userRepository.findById(id);
        System.out.println(foundUser);
        return foundUser;
    }

    public void createUser(User newUser) {
        // Verify Email is Unique
        Optional<User> userEmail = userRepository.findUserByEmail(newUser.getEmail());
        if (userEmail.isPresent()) {
            throw new IllegalStateException("Email already taken.");
        }
        // Encrypt Password
        String password = newUser.getPassword();
        String hashedPassword = hashPassword(password);
        newUser.setPassword(hashedPassword);
        // Save to Repo
        userRepository.save(newUser);
    }

    public void deleteUser(ObjectId id) {
        userRepository.deleteById(id);
        walletRepository.deleteById(id);
    }

    public AuthUser getCredentials(Session newSession) {
        Optional<User> credentials = userRepository.findUserByEmail(newSession.getEmail());
        System.out.println(credentials);
        if (credentials.isPresent()) {
            AuthUser authUser = new AuthUser(credentials.get().getId() , credentials.get().getName(), credentials.get().getEmail(), checkPassword(newSession.getPassword(), credentials.get().getPassword()));
            return authUser;
        } else {
            return null;
        }
    }
}
