package org.sorokovsky.lottery.repository;

import org.sorokovsky.lottery.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<UserEntity, Long> {
    @Override
    Optional<UserEntity> findById(Long id);

    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);

    UserEntity save(UserEntity user);

    void deleteById(long id);
}
