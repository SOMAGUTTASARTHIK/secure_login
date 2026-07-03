package com.atlas.securelogin.repository.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecureEntityRepository extends JpaRepository<SecureEntity, Integer> {
	// Optional<SecureEntity> findByEmailIdAndPassword(String emailId, String
	// password );

	Optional<SecureEntity> findByEmailId(String emailId);

}
