package com.devon.demo.properties;

import java.util.Map;

/**
 * Created by diwenlao on 5/12/17.
 */
public abstract class AbstractQueryProperty {

    protected static final String SYSTEM_ID = "system_id";

    protected static final String ENVIRONMENT_CODE = "environment_code";

    protected static final String EVENT_DATE = "event_date";

    protected static final String COUNTRY_CODE = "country_code";

    protected static final String EVENT_ID = "event_id";

    protected static final String INSTANCE_ID = "instance_id";

    protected static final String EVENT_TIMESTAMP = "event_ts";

    protected static final String REPLAY_BATCH_ID = "replay_batch_id";

    private Map<String, ?> criteria;

    public AbstractQueryProperty(Map<String, ?> criteria) {
        this.criteria = criteria;
    }

    protected String generateCqlString(StringBuilder stringBuilder) {

        StringBuilder stringBuilder1 = stringBuilder;

        if (this instanceof ArmoryAuditQueryProperty) {
            this.criteria.forEach((key, value) -> {
                System.out.println("Key : " + key + " Value : " + value);
                appendFilter(stringBuilder1, key, value);
            });
        }
        return stringBuilder.toString();
    }

    abstract public String getCqlString(StringBuilder stringBuilder);


    // remove this later
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
                sb.append(" AND " + key + " = '" + (String) fieldValue + "'");
            }
        }
    }
}
