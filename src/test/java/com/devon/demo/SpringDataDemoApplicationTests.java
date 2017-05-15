package com.devon.demo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class SpringDataDemoApplicationTests {

    @Test
    public void contextLoads() {
        Map<String, Object> armoryAuditQueryProperty = new HashMap<>();
//        armoryAuditQueryProperty.put(ArmoryAuditQueryProperty.SYSTEM_ID, 1);
//        armoryAuditQueryProperty.put(ArmoryAuditQueryProperty.LESS_THAN_EVENT_TIMESTAMP, "ss");
//        armoryAuditQueryProperty.put(ArmoryAuditQueryProperty.GREATER_OR_EQUAL_TO_EVENT_TIMESTAMP, "sdds");
//        armoryAuditQueryProperty.put(ArmoryAuditQueryProperty.ENVIRONMENT_CODE, 1);
//
//        armoryAuditQueryProperty.put(ArmoryAuditQueryProperty.GREATER_THAN_EVENT_TIMESTAMP, "ssff");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM armory.armory_audit");
        armoryAuditQueryProperty.forEach((key, value) -> {
            appendFilter(stringBuilder, key, value);
        });
        System.out.println(stringBuilder.toString());
    }


    private void appendFilter(StringBuilder sb, String key, Object fieldValue) {

        if (!sb.toString().contains("WHERE") && fieldValue != null) {
            if (key.contains("_id") || key.contains("environment_code")) {
                sb.append(" WHERE " + key + " = " + (Integer) fieldValue);
            } else if (key.contains("gt_event_ts")) {
                sb.append(" WHERE " + "event_ts" + " > " + (String) fieldValue);
            } else if (key.contains("gt_eq_event_ts")) {
                sb.append(" WHERE " + "event_ts" + " >= " + (String) fieldValue);

            } else if (key.contains("lt_event_ts")) {
                sb.append(" WHERE " + "event_ts" + " < " + (String) fieldValue);

            } else {
                sb.append(" WHERE " + key + " = '" + (String) fieldValue + "'");
            }
        } else if (fieldValue != null) {
            //  sb.append(" "+fieldName+"='"+fieldValue+"'");

            if (key.contains("_id") || key.contains("environment_code")) {
                sb.append(" AND " + key + " = " + (int) fieldValue);
            } else if (key.contains("gt_event_ts")) {
                sb.append(" AND " + "event_ts" + " > " + (String) fieldValue);
            } else if (key.contains("gt_eq_event_ts")) {
                sb.append(" AND " + "event_ts" + " >= " + (String) fieldValue);

            } else if (key.contains("lt_event_ts")) {
                sb.append(" AND " + "event_ts" + " < " + (String) fieldValue);

            } else {
                sb.append(" AND " + key + "='" + (String) fieldValue + "'");
            }
        }
    }
}
