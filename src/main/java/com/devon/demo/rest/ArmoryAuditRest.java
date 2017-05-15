package com.devon.demo.rest;

import com.devon.demo.properties.ArmoryAuditQueryProperty;
import com.devon.demo.services.BaseQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by diwenlao on 5/11/17.
 */
@RestController
public class ArmoryAuditRest {

    @Autowired
    @Qualifier("armoryAuditQueryServiceImpl")
    private BaseQueryService armoryAuditQueryServiceImpl;

    @PostMapping(value = "/armory/armoryaudit/systemid/{systemid}/environmentcode/{environmentcode}/eventdate/{eventdate}" +
            "/countrycode/{countrycode}/eventid/{eventid}/instanceid/{instanceid}/criteria", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String selectArmoryAudit(@PathVariable(value = "systemid", required = true) int systemId,
                                    @PathVariable(value = "environmentcode", required = true) int environmentCode,
                                    @PathVariable(value = "eventdate", required = true) String eventDate,
                                    @PathVariable(value = "countrycode", required = true) String countryCode,
                                    @PathVariable(value = "eventid", required = true) int eventId,
                                    @PathVariable(value = "instanceid", required = true) int instanceId,
                                    @RequestParam(value = "greaterthaneventts", required = false) String greaterThanEventTimestamp,
                                    @RequestParam(value = "lessthaneventts", required = false) String lessThanEventTimestamp) {

        //TODO: whatever

        /*StringBuilder buildQueryString = new StringBuilder();
        buildQueryString.append("SELECT * From armoryaudit");
        appendFilter(buildQueryString, "system_id", systemId);
        appendFilter(buildQueryString, "environment_code", environmentCode);
        appendFilter(buildQueryString, "event_date", eventDate);
        appendFilter(buildQueryString, "country_code", countryCode);
        appendFilter(buildQueryString, "event_id", eventId);
        appendFilter(buildQueryString, "instance_id", instanceId);
        appendFilter(buildQueryString, "event_ts", greaterThanEventTimestamp);
        appendFilter(buildQueryString, "event_ts", lessThanEventTimestamp);

       // String str = "SELECT * From armoryaudit WHERE system_id=1 AND environment_code=4 AND event_date='2017-05-11' AND country_code='UK' AND event_id=2 AND instance_id=1";
        System.out.println("==== " + buildQueryString.toString());*/

        Map<String, Object> armoryAuditQueryProperty = new HashMap<>();
        armoryAuditQueryProperty.put(ArmoryAuditQueryProperty.SYSTEM_ID, systemId);
        armoryAuditQueryProperty.put(ArmoryAuditQueryProperty.LESS_THAN_EVENT_TIMESTAMP, lessThanEventTimestamp);

        armoryAuditQueryServiceImpl.select(armoryAuditQueryProperty);
        return String.format("SystemId %s Environment_Code %s StartEvent  %s", systemId, environmentCode, greaterThanEventTimestamp);

    }

//    private void appendFilter(StringBuilder sb, String fieldName, Object fieldValue) {
//
//        if (!sb.toString().contains("WHERE") && fieldValue != null) {
//            if (fieldName.contains("_id") || fieldName.contains("environment_code")) {
//                sb.append(" WHERE " + fieldName + "=" + (Integer) fieldValue);
//            } else {
//                sb.append(" WHERE " + fieldName + "='" + (String) fieldValue + "'");
//            }
//        } else if (fieldValue != null) {
//            //  sb.append(" "+fieldName+"='"+fieldValue+"'");
//
//            if (fieldName.contains("_id") || fieldName.contains("environment_code")) {
//                sb.append(" AND " + fieldName + "=" + (int) fieldValue);
//            } else {
//                sb.append(" AND " + fieldName + "='" + (String) fieldValue + "'");
//            }
//        }
//
//
//    }

}
