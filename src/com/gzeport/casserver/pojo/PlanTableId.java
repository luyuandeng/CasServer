package com.gzeport.casserver.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PlanTableId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class PlanTableId implements java.io.Serializable {

	// Fields

	private String statementId;
	private BigDecimal planId;
	private Date timestamp;
	private String remarks;
	private String operation;
	private String options;
	private String objectNode;
	private String objectOwner;
	private String objectName;
	private String objectAlias;
	private BigDecimal objectInstance;
	private String objectType;
	private String optimizer;
	private BigDecimal searchColumns;
	private BigDecimal id;
	private BigDecimal parentId;
	private BigDecimal depth;
	private BigDecimal position;
	private BigDecimal cost;
	private BigDecimal cardinality;
	private BigDecimal bytes;
	private String otherTag;
	private String partitionStart;
	private String partitionStop;
	private BigDecimal partitionId;
	private String other;
	private String distribution;
	private BigDecimal cpuCost;
	private BigDecimal ioCost;
	private BigDecimal tempSpace;
	private String accessPredicates;
	private String filterPredicates;
	private String projection;
	private BigDecimal time;
	private String qblockName;

	// Constructors

	/** default constructor */
	public PlanTableId() {
	}

	/** full constructor */
	public PlanTableId(String statementId, BigDecimal planId, Date timestamp,
			String remarks, String operation, String options,
			String objectNode, String objectOwner, String objectName,
			String objectAlias, BigDecimal objectInstance, String objectType,
			String optimizer, BigDecimal searchColumns, BigDecimal id,
			BigDecimal parentId, BigDecimal depth, BigDecimal position,
			BigDecimal cost, BigDecimal cardinality, BigDecimal bytes,
			String otherTag, String partitionStart, String partitionStop,
			BigDecimal partitionId, String other, String distribution,
			BigDecimal cpuCost, BigDecimal ioCost, BigDecimal tempSpace,
			String accessPredicates, String filterPredicates,
			String projection, BigDecimal time, String qblockName) {
		this.statementId = statementId;
		this.planId = planId;
		this.timestamp = timestamp;
		this.remarks = remarks;
		this.operation = operation;
		this.options = options;
		this.objectNode = objectNode;
		this.objectOwner = objectOwner;
		this.objectName = objectName;
		this.objectAlias = objectAlias;
		this.objectInstance = objectInstance;
		this.objectType = objectType;
		this.optimizer = optimizer;
		this.searchColumns = searchColumns;
		this.id = id;
		this.parentId = parentId;
		this.depth = depth;
		this.position = position;
		this.cost = cost;
		this.cardinality = cardinality;
		this.bytes = bytes;
		this.otherTag = otherTag;
		this.partitionStart = partitionStart;
		this.partitionStop = partitionStop;
		this.partitionId = partitionId;
		this.other = other;
		this.distribution = distribution;
		this.cpuCost = cpuCost;
		this.ioCost = ioCost;
		this.tempSpace = tempSpace;
		this.accessPredicates = accessPredicates;
		this.filterPredicates = filterPredicates;
		this.projection = projection;
		this.time = time;
		this.qblockName = qblockName;
	}

	// Property accessors

	@Column(name = "STATEMENT_ID", length = 30)
	public String getStatementId() {
		return this.statementId;
	}

	public void setStatementId(String statementId) {
		this.statementId = statementId;
	}

	@Column(name = "PLAN_ID", precision = 22, scale = 0)
	public BigDecimal getPlanId() {
		return this.planId;
	}

	public void setPlanId(BigDecimal planId) {
		this.planId = planId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TIMESTAMP", length = 7)
	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name = "REMARKS", length = 4000)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "OPERATION", length = 30)
	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Column(name = "OPTIONS")
	public String getOptions() {
		return this.options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	@Column(name = "OBJECT_NODE", length = 128)
	public String getObjectNode() {
		return this.objectNode;
	}

	public void setObjectNode(String objectNode) {
		this.objectNode = objectNode;
	}

	@Column(name = "OBJECT_OWNER", length = 30)
	public String getObjectOwner() {
		return this.objectOwner;
	}

	public void setObjectOwner(String objectOwner) {
		this.objectOwner = objectOwner;
	}

	@Column(name = "OBJECT_NAME", length = 30)
	public String getObjectName() {
		return this.objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	@Column(name = "OBJECT_ALIAS", length = 65)
	public String getObjectAlias() {
		return this.objectAlias;
	}

	public void setObjectAlias(String objectAlias) {
		this.objectAlias = objectAlias;
	}

	@Column(name = "OBJECT_INSTANCE", precision = 22, scale = 0)
	public BigDecimal getObjectInstance() {
		return this.objectInstance;
	}

	public void setObjectInstance(BigDecimal objectInstance) {
		this.objectInstance = objectInstance;
	}

	@Column(name = "OBJECT_TYPE", length = 30)
	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	@Column(name = "OPTIMIZER")
	public String getOptimizer() {
		return this.optimizer;
	}

	public void setOptimizer(String optimizer) {
		this.optimizer = optimizer;
	}

	@Column(name = "SEARCH_COLUMNS", precision = 22, scale = 0)
	public BigDecimal getSearchColumns() {
		return this.searchColumns;
	}

	public void setSearchColumns(BigDecimal searchColumns) {
		this.searchColumns = searchColumns;
	}

	@Column(name = "ID", precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "PARENT_ID", precision = 22, scale = 0)
	public BigDecimal getParentId() {
		return this.parentId;
	}

	public void setParentId(BigDecimal parentId) {
		this.parentId = parentId;
	}

	@Column(name = "DEPTH", precision = 22, scale = 0)
	public BigDecimal getDepth() {
		return this.depth;
	}

	public void setDepth(BigDecimal depth) {
		this.depth = depth;
	}

	@Column(name = "POSITION", precision = 22, scale = 0)
	public BigDecimal getPosition() {
		return this.position;
	}

	public void setPosition(BigDecimal position) {
		this.position = position;
	}

	@Column(name = "COST", precision = 22, scale = 0)
	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	@Column(name = "CARDINALITY", precision = 22, scale = 0)
	public BigDecimal getCardinality() {
		return this.cardinality;
	}

	public void setCardinality(BigDecimal cardinality) {
		this.cardinality = cardinality;
	}

	@Column(name = "BYTES", precision = 22, scale = 0)
	public BigDecimal getBytes() {
		return this.bytes;
	}

	public void setBytes(BigDecimal bytes) {
		this.bytes = bytes;
	}

	@Column(name = "OTHER_TAG")
	public String getOtherTag() {
		return this.otherTag;
	}

	public void setOtherTag(String otherTag) {
		this.otherTag = otherTag;
	}

	@Column(name = "PARTITION_START")
	public String getPartitionStart() {
		return this.partitionStart;
	}

	public void setPartitionStart(String partitionStart) {
		this.partitionStart = partitionStart;
	}

	@Column(name = "PARTITION_STOP")
	public String getPartitionStop() {
		return this.partitionStop;
	}

	public void setPartitionStop(String partitionStop) {
		this.partitionStop = partitionStop;
	}

	@Column(name = "PARTITION_ID", precision = 22, scale = 0)
	public BigDecimal getPartitionId() {
		return this.partitionId;
	}

	public void setPartitionId(BigDecimal partitionId) {
		this.partitionId = partitionId;
	}

	@Column(name = "OTHER", length = 0)
	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Column(name = "DISTRIBUTION", length = 30)
	public String getDistribution() {
		return this.distribution;
	}

	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}

	@Column(name = "CPU_COST", precision = 22, scale = 0)
	public BigDecimal getCpuCost() {
		return this.cpuCost;
	}

	public void setCpuCost(BigDecimal cpuCost) {
		this.cpuCost = cpuCost;
	}

	@Column(name = "IO_COST", precision = 22, scale = 0)
	public BigDecimal getIoCost() {
		return this.ioCost;
	}

	public void setIoCost(BigDecimal ioCost) {
		this.ioCost = ioCost;
	}

	@Column(name = "TEMP_SPACE", precision = 22, scale = 0)
	public BigDecimal getTempSpace() {
		return this.tempSpace;
	}

	public void setTempSpace(BigDecimal tempSpace) {
		this.tempSpace = tempSpace;
	}

	@Column(name = "ACCESS_PREDICATES", length = 4000)
	public String getAccessPredicates() {
		return this.accessPredicates;
	}

	public void setAccessPredicates(String accessPredicates) {
		this.accessPredicates = accessPredicates;
	}

	@Column(name = "FILTER_PREDICATES", length = 4000)
	public String getFilterPredicates() {
		return this.filterPredicates;
	}

	public void setFilterPredicates(String filterPredicates) {
		this.filterPredicates = filterPredicates;
	}

	@Column(name = "PROJECTION", length = 4000)
	public String getProjection() {
		return this.projection;
	}

	public void setProjection(String projection) {
		this.projection = projection;
	}

	@Column(name = "TIME", precision = 22, scale = 0)
	public BigDecimal getTime() {
		return this.time;
	}

	public void setTime(BigDecimal time) {
		this.time = time;
	}

	@Column(name = "QBLOCK_NAME", length = 30)
	public String getQblockName() {
		return this.qblockName;
	}

	public void setQblockName(String qblockName) {
		this.qblockName = qblockName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PlanTableId))
			return false;
		PlanTableId castOther = (PlanTableId) other;

		return ((this.getStatementId() == castOther.getStatementId()) || (this
				.getStatementId() != null
				&& castOther.getStatementId() != null && this.getStatementId()
				.equals(castOther.getStatementId())))
				&& ((this.getPlanId() == castOther.getPlanId()) || (this
						.getPlanId() != null
						&& castOther.getPlanId() != null && this.getPlanId()
						.equals(castOther.getPlanId())))
				&& ((this.getTimestamp() == castOther.getTimestamp()) || (this
						.getTimestamp() != null
						&& castOther.getTimestamp() != null && this
						.getTimestamp().equals(castOther.getTimestamp())))
				&& ((this.getRemarks() == castOther.getRemarks()) || (this
						.getRemarks() != null
						&& castOther.getRemarks() != null && this.getRemarks()
						.equals(castOther.getRemarks())))
				&& ((this.getOperation() == castOther.getOperation()) || (this
						.getOperation() != null
						&& castOther.getOperation() != null && this
						.getOperation().equals(castOther.getOperation())))
				&& ((this.getOptions() == castOther.getOptions()) || (this
						.getOptions() != null
						&& castOther.getOptions() != null && this.getOptions()
						.equals(castOther.getOptions())))
				&& ((this.getObjectNode() == castOther.getObjectNode()) || (this
						.getObjectNode() != null
						&& castOther.getObjectNode() != null && this
						.getObjectNode().equals(castOther.getObjectNode())))
				&& ((this.getObjectOwner() == castOther.getObjectOwner()) || (this
						.getObjectOwner() != null
						&& castOther.getObjectOwner() != null && this
						.getObjectOwner().equals(castOther.getObjectOwner())))
				&& ((this.getObjectName() == castOther.getObjectName()) || (this
						.getObjectName() != null
						&& castOther.getObjectName() != null && this
						.getObjectName().equals(castOther.getObjectName())))
				&& ((this.getObjectAlias() == castOther.getObjectAlias()) || (this
						.getObjectAlias() != null
						&& castOther.getObjectAlias() != null && this
						.getObjectAlias().equals(castOther.getObjectAlias())))
				&& ((this.getObjectInstance() == castOther.getObjectInstance()) || (this
						.getObjectInstance() != null
						&& castOther.getObjectInstance() != null && this
						.getObjectInstance().equals(
								castOther.getObjectInstance())))
				&& ((this.getObjectType() == castOther.getObjectType()) || (this
						.getObjectType() != null
						&& castOther.getObjectType() != null && this
						.getObjectType().equals(castOther.getObjectType())))
				&& ((this.getOptimizer() == castOther.getOptimizer()) || (this
						.getOptimizer() != null
						&& castOther.getOptimizer() != null && this
						.getOptimizer().equals(castOther.getOptimizer())))
				&& ((this.getSearchColumns() == castOther.getSearchColumns()) || (this
						.getSearchColumns() != null
						&& castOther.getSearchColumns() != null && this
						.getSearchColumns()
						.equals(castOther.getSearchColumns())))
				&& ((this.getId() == castOther.getId()) || (this.getId() != null
						&& castOther.getId() != null && this.getId().equals(
						castOther.getId())))
				&& ((this.getParentId() == castOther.getParentId()) || (this
						.getParentId() != null
						&& castOther.getParentId() != null && this
						.getParentId().equals(castOther.getParentId())))
				&& ((this.getDepth() == castOther.getDepth()) || (this
						.getDepth() != null
						&& castOther.getDepth() != null && this.getDepth()
						.equals(castOther.getDepth())))
				&& ((this.getPosition() == castOther.getPosition()) || (this
						.getPosition() != null
						&& castOther.getPosition() != null && this
						.getPosition().equals(castOther.getPosition())))
				&& ((this.getCost() == castOther.getCost()) || (this.getCost() != null
						&& castOther.getCost() != null && this.getCost()
						.equals(castOther.getCost())))
				&& ((this.getCardinality() == castOther.getCardinality()) || (this
						.getCardinality() != null
						&& castOther.getCardinality() != null && this
						.getCardinality().equals(castOther.getCardinality())))
				&& ((this.getBytes() == castOther.getBytes()) || (this
						.getBytes() != null
						&& castOther.getBytes() != null && this.getBytes()
						.equals(castOther.getBytes())))
				&& ((this.getOtherTag() == castOther.getOtherTag()) || (this
						.getOtherTag() != null
						&& castOther.getOtherTag() != null && this
						.getOtherTag().equals(castOther.getOtherTag())))
				&& ((this.getPartitionStart() == castOther.getPartitionStart()) || (this
						.getPartitionStart() != null
						&& castOther.getPartitionStart() != null && this
						.getPartitionStart().equals(
								castOther.getPartitionStart())))
				&& ((this.getPartitionStop() == castOther.getPartitionStop()) || (this
						.getPartitionStop() != null
						&& castOther.getPartitionStop() != null && this
						.getPartitionStop()
						.equals(castOther.getPartitionStop())))
				&& ((this.getPartitionId() == castOther.getPartitionId()) || (this
						.getPartitionId() != null
						&& castOther.getPartitionId() != null && this
						.getPartitionId().equals(castOther.getPartitionId())))
				&& ((this.getOther() == castOther.getOther()) || (this
						.getOther() != null
						&& castOther.getOther() != null && this.getOther()
						.equals(castOther.getOther())))
				&& ((this.getDistribution() == castOther.getDistribution()) || (this
						.getDistribution() != null
						&& castOther.getDistribution() != null && this
						.getDistribution().equals(castOther.getDistribution())))
				&& ((this.getCpuCost() == castOther.getCpuCost()) || (this
						.getCpuCost() != null
						&& castOther.getCpuCost() != null && this.getCpuCost()
						.equals(castOther.getCpuCost())))
				&& ((this.getIoCost() == castOther.getIoCost()) || (this
						.getIoCost() != null
						&& castOther.getIoCost() != null && this.getIoCost()
						.equals(castOther.getIoCost())))
				&& ((this.getTempSpace() == castOther.getTempSpace()) || (this
						.getTempSpace() != null
						&& castOther.getTempSpace() != null && this
						.getTempSpace().equals(castOther.getTempSpace())))
				&& ((this.getAccessPredicates() == castOther
						.getAccessPredicates()) || (this.getAccessPredicates() != null
						&& castOther.getAccessPredicates() != null && this
						.getAccessPredicates().equals(
								castOther.getAccessPredicates())))
				&& ((this.getFilterPredicates() == castOther
						.getFilterPredicates()) || (this.getFilterPredicates() != null
						&& castOther.getFilterPredicates() != null && this
						.getFilterPredicates().equals(
								castOther.getFilterPredicates())))
				&& ((this.getProjection() == castOther.getProjection()) || (this
						.getProjection() != null
						&& castOther.getProjection() != null && this
						.getProjection().equals(castOther.getProjection())))
				&& ((this.getTime() == castOther.getTime()) || (this.getTime() != null
						&& castOther.getTime() != null && this.getTime()
						.equals(castOther.getTime())))
				&& ((this.getQblockName() == castOther.getQblockName()) || (this
						.getQblockName() != null
						&& castOther.getQblockName() != null && this
						.getQblockName().equals(castOther.getQblockName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getStatementId() == null ? 0 : this.getStatementId()
						.hashCode());
		result = 37 * result
				+ (getPlanId() == null ? 0 : this.getPlanId().hashCode());
		result = 37 * result
				+ (getTimestamp() == null ? 0 : this.getTimestamp().hashCode());
		result = 37 * result
				+ (getRemarks() == null ? 0 : this.getRemarks().hashCode());
		result = 37 * result
				+ (getOperation() == null ? 0 : this.getOperation().hashCode());
		result = 37 * result
				+ (getOptions() == null ? 0 : this.getOptions().hashCode());
		result = 37
				* result
				+ (getObjectNode() == null ? 0 : this.getObjectNode()
						.hashCode());
		result = 37
				* result
				+ (getObjectOwner() == null ? 0 : this.getObjectOwner()
						.hashCode());
		result = 37
				* result
				+ (getObjectName() == null ? 0 : this.getObjectName()
						.hashCode());
		result = 37
				* result
				+ (getObjectAlias() == null ? 0 : this.getObjectAlias()
						.hashCode());
		result = 37
				* result
				+ (getObjectInstance() == null ? 0 : this.getObjectInstance()
						.hashCode());
		result = 37
				* result
				+ (getObjectType() == null ? 0 : this.getObjectType()
						.hashCode());
		result = 37 * result
				+ (getOptimizer() == null ? 0 : this.getOptimizer().hashCode());
		result = 37
				* result
				+ (getSearchColumns() == null ? 0 : this.getSearchColumns()
						.hashCode());
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getParentId() == null ? 0 : this.getParentId().hashCode());
		result = 37 * result
				+ (getDepth() == null ? 0 : this.getDepth().hashCode());
		result = 37 * result
				+ (getPosition() == null ? 0 : this.getPosition().hashCode());
		result = 37 * result
				+ (getCost() == null ? 0 : this.getCost().hashCode());
		result = 37
				* result
				+ (getCardinality() == null ? 0 : this.getCardinality()
						.hashCode());
		result = 37 * result
				+ (getBytes() == null ? 0 : this.getBytes().hashCode());
		result = 37 * result
				+ (getOtherTag() == null ? 0 : this.getOtherTag().hashCode());
		result = 37
				* result
				+ (getPartitionStart() == null ? 0 : this.getPartitionStart()
						.hashCode());
		result = 37
				* result
				+ (getPartitionStop() == null ? 0 : this.getPartitionStop()
						.hashCode());
		result = 37
				* result
				+ (getPartitionId() == null ? 0 : this.getPartitionId()
						.hashCode());
		result = 37 * result
				+ (getOther() == null ? 0 : this.getOther().hashCode());
		result = 37
				* result
				+ (getDistribution() == null ? 0 : this.getDistribution()
						.hashCode());
		result = 37 * result
				+ (getCpuCost() == null ? 0 : this.getCpuCost().hashCode());
		result = 37 * result
				+ (getIoCost() == null ? 0 : this.getIoCost().hashCode());
		result = 37 * result
				+ (getTempSpace() == null ? 0 : this.getTempSpace().hashCode());
		result = 37
				* result
				+ (getAccessPredicates() == null ? 0 : this
						.getAccessPredicates().hashCode());
		result = 37
				* result
				+ (getFilterPredicates() == null ? 0 : this
						.getFilterPredicates().hashCode());
		result = 37
				* result
				+ (getProjection() == null ? 0 : this.getProjection()
						.hashCode());
		result = 37 * result
				+ (getTime() == null ? 0 : this.getTime().hashCode());
		result = 37
				* result
				+ (getQblockName() == null ? 0 : this.getQblockName()
						.hashCode());
		return result;
	}

}