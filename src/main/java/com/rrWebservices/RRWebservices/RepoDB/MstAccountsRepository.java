package com.rrWebservices.RRWebservices.RepoDB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rrWebservices.RRWebservices.EntitySfsmdb.MstAccounts;

import java.util.Optional;

@Repository
public interface MstAccountsRepository extends JpaRepository<MstAccounts, Long> {

    Optional<MstAccounts> findByUsername(String username);

}