package com.devon.demo.services;

import java.util.List;
import java.util.Map;

/**
 * Created by diwenlao on 5/12/17.
 */
public interface BaseQueryService {

    Map<String, List<?>> select(Map<String, ?> criteria);

    // List<ArmoryAudit> select(Map<String, ?> criteria);

}
