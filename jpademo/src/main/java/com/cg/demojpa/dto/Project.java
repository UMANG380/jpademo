package com.cg.demojpa.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jpa_project")
public class Project {
	@Id
	@Column(name="proj_id")
	private Integer projId;
	@Column(name="proj_name")
	private String projName;
	@Column(name="proj_cost")
	private Double projCost;
	
	public Project() {
		
		
	}

	public Project(Integer projId, String projName, Double projCost) {
		super();
		this.projId = projId;
		this.projName = projName;
		this.projCost = projCost;
	}

	public Integer getProjId() {
		return projId;
	}

	public void setProjId(Integer projId) {
		this.projId = projId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public Double getProjCost() {
		return projCost;
	}

	public void setProjCost(Double projCost) {
		this.projCost = projCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projCost == null) ? 0 : projCost.hashCode());
		result = prime * result + ((projId == null) ? 0 : projId.hashCode());
		result = prime * result + ((projName == null) ? 0 : projName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (projCost == null) {
			if (other.projCost != null)
				return false;
		} else if (!projCost.equals(other.projCost))
			return false;
		if (projId == null) {
			if (other.projId != null)
				return false;
		} else if (!projId.equals(other.projId))
			return false;
		if (projName == null) {
			if (other.projName != null)
				return false;
		} else if (!projName.equals(other.projName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", projCost=" + projCost + "]";
	}
	
	

}
