package com.rrWebservices.RRWebservices.RepoDB;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rrWebservices.RRWebservices.EntitySfsmdb.MstAccountValidate;





@Repository
public interface MstAccntsValidateRepository extends JpaRepository<MstAccountValidate, Long> {

   Optional<MstAccountValidate> findById(Long id);

}
