package com.gzeport.casserver.pojo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * PlanTable entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PLAN_TABLE", schema = "PORTAL")
public class PlanTable implements java.io.Serializable {

	// Fields

	private PlanTableId id;

	// Constructors

	/** default constructor */
	public PlanTable() {
	}

	/** full constructor */
	public PlanTable(PlanTableId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "statementId", column = @Column(name = "STATEMENT_ID", length = 30)),
			@AttributeOverride(name = "planId", column = @Column(name = "PLAN_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "timestamp", column = @Column(name = "TIMESTAMP", length = 7)),
			@AttributeOverride(name = "remarks", column = @Column(name = "REMARKS", length = 4000)),
			@AttributeOverride(name = "operation", column = @Column(name = "OPERATION", length = 30)),
			@AttributeOverride(name = "options", column = @Column(name = "OPTIONS")),
			@AttributeOverride(name = "objectNode", column = @Column(name = "OBJECT_NODE", length = 128)),
			@AttributeOverride(name = "objectOwner", column = @Column(name = "OBJECT_OWNER", length = 30)),
			@AttributeOverride(name = "objectName", column = @Column(name = "OBJECT_NAME", length = 30)),
			@AttributeOverride(name = "objectAlias", column = @Column(name = "OBJECT_ALIAS", length = 65)),
			@AttributeOverride(name = "objectInstance", column = @Column(name = "OBJECT_INSTANCE", precision = 22, scale = 0)),
			@AttributeOverride(name = "objectType", column = @Column(name = "OBJECT_TYPE", length = 30)),
			@AttributeOverride(name = "optimizer", column = @Column(name = "OPTIMIZER")),
			@AttributeOverride(name = "searchColumns", column = @Column(name = "SEARCH_COLUMNS", precision = 22, scale = 0)),
			@AttributeOverride(name = "id", column = @Column(name = "ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "parentId", column = @Column(name = "PARENT_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "depth", column = @Column(name = "DEPTH", precision = 22, scale = 0)),
			@AttributeOverride(name = "position", column = @Column(name = "POSITION", precision = 22, scale = 0)),
			@AttributeOverride(name = "cost", column = @Column(name = "COST", precision = 22, scale = 0)),
			@AttributeOverride(name = "cardinality", column = @Column(name = "CARDINALITY", precision = 22, scale = 0)),
			@AttributeOverride(name = "bytes", column = @Column(name = "BYTES", precision = 22, scale = 0)),
			@AttributeOverride(name = "otherTag", column = @Column(name = "OTHER_TAG")),
			@AttributeOverride(name = "partitionStart", column = @Column(name = "PARTITION_START")),
			@AttributeOverride(name = "partitionStop", column = @Column(name = "PARTITION_STOP")),
			@AttributeOverride(name = "partitionId", column = @Column(name = "PARTITION_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "other", column = @Column(name = "OTHER", length = 0)),
			@AttributeOverride(name = "distribution", column = @Column(name = "DISTRIBUTION", length = 30)),
			@AttributeOverride(name = "cpuCost", column = @Column(name = "CPU_COST", precision = 22, scale = 0)),
			@AttributeOverride(name = "ioCost", column = @Column(name = "IO_COST", precision = 22, scale = 0)),
			@AttributeOverride(name = "tempSpace", column = @Column(name = "TEMP_SPACE", precision = 22, scale = 0)),
			@AttributeOverride(name = "accessPredicates", column = @Column(name = "ACCESS_PREDICATES", length = 4000)),
			@AttributeOverride(name = "filterPredicates", column = @Column(name = "FILTER_PREDICATES", length = 4000)),
			@AttributeOverride(name = "projection", column = @Column(name = "PROJECTION", length = 4000)),
			@AttributeOverride(name = "time", column = @Column(name = "TIME", precision = 22, scale = 0)),
			@AttributeOverride(name = "qblockName", column = @Column(name = "QBLOCK_NAME", length = 30)) })
	public PlanTableId getId() {
		return this.id;
	}

	public void setId(PlanTableId id) {
		this.id = id;
	}

}