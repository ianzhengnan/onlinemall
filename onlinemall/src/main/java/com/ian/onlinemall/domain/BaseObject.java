package com.ian.onlinemall.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class BaseObject {

	@Id
	@Column(name="UUID", length=36)
	private String uuid = UUID.randomUUID().toString();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATION_DATE", updatable=false)
	private Date createdAt = null;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MODIFICATION_DATE")
	private Date lastModifiedAt = null;
	
	@Column(name="CREATED_BY", updatable=false, length=20)
	private String createdBy = null;
	
	@Column(name="MODIFIED_BY")
	private String modifiedBy = null;
	
	@PreUpdate
	protected void updateAuditInfomation(){
		lastModifiedAt = new Date();
	}
	
	@PrePersist
	protected void generateAuditInformation(){
		final Date now = new Date();
		
		createdAt = now;
		lastModifiedAt = now;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastModifiedAt() {
		return lastModifiedAt;
	}

	public void setLastModifiedAt(Date lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}
