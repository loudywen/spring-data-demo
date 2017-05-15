package com.devon.demo.model;

/**
 * Created by diwenlao on 5/11/17.
 */
import com.datastax.driver.core.DataType.Name;
import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

/**
 * Created by Devon on 4/30/2017.
 */

@Table(value = "armory_audit")
public class ArmoryAudit {

	/*
	  PRIMARY KEY ((system_id, environment_code, event_date, country_code, event_id, instance_id), event_ts, event_uuid, replay_batch_id)

	    system_id int,
	    environment_code int,
	    event_date text,
	    country_code text,
	    event_id int,
	    instance_id int,
	    event_ts timestamp,
	    event_uuid text,
	    replay_batch_id text,
	    create_ts timestamp,
	    event_operation text,
	    metadata list<text>,
	    node_id int,
	    node_ts timestamp,
	    producer_client_id int,
	    server_name text,
	    test_fl text,
	    vm_name text,
	*/

    private static DateTimeFormatter	formatter	= DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss.SSS").withLocale(Locale.US)
            .withZone(ZoneOffset.systemDefault());

    private static SimpleDateFormat	 dt	          = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	/* @Id
	 @GeneratedValue
	 private long id;*/

    @PrimaryKeyColumn(name = "system_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int	                     systemId;

    @PrimaryKeyColumn(name = "environment_code", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private int	                     environmentCode;

    @PrimaryKeyColumn(name = "event_date", ordinal = 2, type = PrimaryKeyType.PARTITIONED)
    private String	                 eventDate;

    @PrimaryKeyColumn(name = "country_code", ordinal = 3, type = PrimaryKeyType.PARTITIONED)
    private String	                 countryCode;

    @PrimaryKeyColumn(name = "event_id", ordinal = 4, type = PrimaryKeyType.PARTITIONED)
    private int	                     eventId;

    @PrimaryKeyColumn(name = "instance_id", ordinal = 5, type = PrimaryKeyType.PARTITIONED)
    private int	                     instanceId;

    @PrimaryKeyColumn(name = "event_ts", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    @CassandraType(type = Name.TIMESTAMP)
    private Instant	                 eventTs;

    @PrimaryKeyColumn(name = "event_uuid", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private String	                 eventUUID;

    @PrimaryKeyColumn(name = "replay_batch_id", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private String	                 replayBatchId;

    @Column(value = "create_ts")
    private Instant	                 createTs;

    @Column(value = "event_operation")
    private String	                 eventOperation;

    @Column(value = "metadata")
    private List<String>	         metadata;

    @Column(value = "node_id")
    private int	                     nodeId;

    @Column(value = "node_ts")
    private Instant	                 nodeTs;

    @Column(value = "producer_client_id")
    private int	                     procuderClientId;

    @Column(value = "server_name")
    private String	                 serverName;

    @Column(value = "test_fl")
    private String	                 testFl;

    @Column(value = "vm_name")
    private String	                 vmName;

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public int getEnvironmentCode() {
        return environmentCode;
    }

    public void setEnvironmentCode(int environmentCode) {
        this.environmentCode = environmentCode;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }

    public String getEventTs() {
        return formatter.format(eventTs);
    }

    public void setEventTs(Instant eventTs) {
        this.eventTs = eventTs;
    }

    public String getEventUUID() {
        return eventUUID;
    }

    public void setEventUUID(String eventUUID) {
        this.eventUUID = eventUUID;
    }

    public String getReplayBatchId() {
        return replayBatchId;
    }

    public void setReplayBatchId(String replayBatchId) {
        this.replayBatchId = replayBatchId;
    }

    public String getCreateTs() {
        return formatter.format(createTs);
    }

    public void setCreateTs(Instant createTs) {
        this.createTs = createTs;
    }

    public String getEventOperation() {
        return eventOperation;
    }

    public void setEventOperation(String eventOperation) {
        this.eventOperation = eventOperation;
    }

    public List<String> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<String> metadata) {
        this.metadata = metadata;
    }

    public int getNodeId() {

        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeTs() {
        return formatter.format(nodeTs);
    }

    public void setNodeTs(Instant nodeTs) {
        this.nodeTs = nodeTs;
    }

    public int getProcuderClientId() {
        return procuderClientId;
    }

    public void setProcuderClientId(int procuderClientId) {
        this.procuderClientId = procuderClientId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getTestFl() {
        return testFl;
    }

    public void setTestFl(String testFl) {
        this.testFl = testFl;
    }

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        this.vmName = vmName;
    }

    @Override
    public String toString() {
        return "ArmoryAudit{" +
                "systemId=" + systemId +
                ", environmentCode=" + environmentCode +
                ", eventDate='" + eventDate + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", eventId=" + eventId +
                ", instanceId=" + instanceId +
                ", eventTs=" + getEventTs() +
                ", eventUUID='" + eventUUID + '\'' +
                ", replayBatchId='" + replayBatchId + '\'' +
                ", createTs=" + getCreateTs() +
                ", eventOperation='" + eventOperation + '\'' +
                ", metadata=" + metadata +
                ", nodeId=" + nodeId +
                ", nodeTs=" + getNodeTs() +
                ", procuderClientId=" + procuderClientId +
                ", serverName='" + serverName + '\'' +
                ", testFl='" + testFl + '\'' +
                ", vmName='" + vmName + '\'' +
                '}';
    }

    /**
     * @return the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
