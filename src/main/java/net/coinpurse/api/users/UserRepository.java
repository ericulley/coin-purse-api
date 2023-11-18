package net.coinpurse.api.users;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userRepository")
interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findUserByEmail(String email);
}
