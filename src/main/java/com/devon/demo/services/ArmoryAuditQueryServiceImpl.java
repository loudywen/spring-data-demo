package com.devon.demo.services;

import com.devon.demo.model.ArmoryAudit;
import com.devon.demo.properties.ArmoryAuditQueryProperty;
import com.devon.demo.repository.ArmoryAuditRepository;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by diwenlao on 5/12/17.
 */
@Service("armoryAuditQueryServiceImpl")
public class ArmoryAuditQueryServiceImpl implements BaseQueryService {

    private ArmoryAuditRepository armoryAuditRepository;
    private CassandraOperations cassandraOperations;

    public ArmoryAuditQueryServiceImpl(ArmoryAuditRepository armoryAuditRepository, CassandraOperations cassandraOperations) {
        this.armoryAuditRepository = armoryAuditRepository;
        this.cassandraOperations = cassandraOperations;
    }

    @Override
    public Map<String, List<?>> select(Map<String, ?> criteria) {
        Map<String, List<?>> armoryAuditMap = new HashMap<>();
        List<ArmoryAudit> armoryAuditList = new ArrayList<>();
        CassandraConverter converter = this.cassandraOperations.getConverter();

        ArmoryAuditQueryProperty armoryAuditQueryProperty = new ArmoryAuditQueryProperty(criteria);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM armory.armory_audit");
        System.out.println("==== " + armoryAuditQueryProperty.getCqlString(stringBuilder));
//        ResultSet resultSets = this.cassandraOperations.getSession().execute(armoryAuditQueryProperty.getCqlString(stringBuilder));
//        for (Row row : resultSets) {
//            armoryAuditList.add(converter.read(ArmoryAudit.class, row));
//        }
//        armoryAuditMap.put(null, armoryAuditList);
//        return armoryAuditMap;
        return null;
    }
}
