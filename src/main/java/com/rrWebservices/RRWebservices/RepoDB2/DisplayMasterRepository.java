package com.rrWebservices.RRWebservices.RepoDB2;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rrWebservices.RRWebservices.EntitySldb.TbTerminalDisplayMaster;




@Repository
public interface DisplayMasterRepository extends JpaRepository<TbTerminalDisplayMaster, String> {

   TbTerminalDisplayMaster findByterminalLineId(String id);

}
