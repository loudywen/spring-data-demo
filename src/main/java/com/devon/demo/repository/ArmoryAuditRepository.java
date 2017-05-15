package com.devon.demo.repository;

import com.devon.demo.model.ArmoryAudit;
import org.springframework.data.cassandra.repository.CassandraRepository;

/**
 * Created by diwenlao on 5/12/17.
 */
public interface ArmoryAuditRepository extends CassandraRepository<ArmoryAudit> {

}
