package com.devon.demo.properties;

import java.util.Map;

/**
 * Created by diwenlao on 5/12/17.
 */
public class ArmoryAuditQueryProperty extends AbstractQueryProperty {

    public static final String SYSTEM_ID = AbstractQueryProperty.SYSTEM_ID;

    public static final String ENVIRONMENT_CODE = AbstractQueryProperty.ENVIRONMENT_CODE;

    public static final String EVENT_DATE = AbstractQueryProperty.EVENT_DATE;

    public static final String COUNTRY_CODE = AbstractQueryProperty.COUNTRY_CODE;

    public static final String EVENT_ID = AbstractQueryProperty.EVENT_ID;

    public static final String INSTANCE_ID = AbstractQueryProperty.INSTANCE_ID;

    public static final String EVENT_TIMESTAMP = AbstractQueryProperty.EVENT_TIMESTAMP;

    public static final String REPLAY_BATCH_ID = AbstractQueryProperty.REPLAY_BATCH_ID;

    public static final String EVENT_UUID = "event_uuid";

    public static final String CREATE_TIMESTAMP = "create_ts";

    public static final String EVENT_OPERATION = "event_operation";

    public static final String METADATA = "metadata";

    public static final String NODE_ID = "node_id";

    public static final String NODE_TIMESTAMP = "node_ts";

    public static final String PRODUCER_CLIENT_ID = "producer_client_id";

    public static final String SERVER_NAME = "server_name";

    public static final String TEST_FLAG = "test_fl";

    public static final String VM_NAME = "vm_name";

    // greater, less event_ts
    public static final String GREATER_THAN_EVENT_TIMESTAMP = "gt_event_ts";
    public static final String GREATER_OR_EQUAL_TO_EVENT_TIMESTAMP = "gt_eq_event_ts";
    public static final String LESS_THAN_EVENT_TIMESTAMP = "lt_event_ts";


    public ArmoryAuditQueryProperty(Map<String, ?> criteria) {
        super(criteria);
    }

    @Override
    public String getCqlString(StringBuilder stringBuilder) {
        return generateCqlString(stringBuilder);
    }

}
