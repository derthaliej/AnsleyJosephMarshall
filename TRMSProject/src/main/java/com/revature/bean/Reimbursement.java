package com.revature.bean;

import java.util.Date;

public class Reimbursement {

	private int reimbursementId;
	private int eventId;
	private int empId;
	private int statusId;
	private Date requestDate;
	private String reason;
	private double projectedReimbursement;
	private double totalReimbursement;
	private double awardedReimbursements;
	private double pendingReimbursements;
	private double availableReimbursement;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int reimbursementId, int eventId, int empId, int statusId, Date requestDate,
			String reason, double projectedReimbursement, double totalReimbursement, double awardedReimbursements,
			double pendingReimbursements, double availableReimbursement) {
		super();
		this.reimbursementId = reimbursementId;
		this.eventId = eventId;
		this.empId = empId;
		this.statusId = statusId;
		this.requestDate = requestDate;
		this.reason = reason;
		this.projectedReimbursement = projectedReimbursement;
		this.totalReimbursement = totalReimbursement;
		this.awardedReimbursements = awardedReimbursements;
		this.pendingReimbursements = pendingReimbursements;
		this.availableReimbursement = availableReimbursement;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public double getProjectedReimbursement() {
		return projectedReimbursement;
	}

	public void setProjectedReimbursement(double projectedReimbursement) {
		this.projectedReimbursement = projectedReimbursement;
	}

	public double getTotalReimbursement() {
		return totalReimbursement;
	}

	public void setTotalReimbursement(double totalReimbursement) {
		this.totalReimbursement = totalReimbursement;
	}

	public double getAwardedReimbursements() {
		return awardedReimbursements;
	}

	public void setAwardedReimbursements(double awardedReimbursements) {
		this.awardedReimbursements = awardedReimbursements;
	}

	public double getPendingReimbursements() {
		return pendingReimbursements;
	}

	public void setPendingReimbursements(double pendingReimbursements) {
		this.pendingReimbursements = pendingReimbursements;
	}

	public double getAvailableReimbursement() {
		return availableReimbursement;
	}

	public void setAvailableReimbursement(double availableReimbursement) {
		this.availableReimbursement = availableReimbursement;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", eventId=" + eventId + ", empId=" + empId
				+ ", statusId=" + statusId + ", requestDate=" + requestDate + ", reason=" + reason
				+ ", projectedReimbursement=" + projectedReimbursement + ", totalReimbursement=" + totalReimbursement
				+ ", awardedReimbursements=" + awardedReimbursements + ", pendingReimbursements="
				+ pendingReimbursements + ", availableReimbursement=" + availableReimbursement + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(availableReimbursement);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(awardedReimbursements);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + empId;
		result = prime * result + eventId;
		temp = Double.doubleToLongBits(pendingReimbursements);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(projectedReimbursement);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + reimbursementId;
		result = prime * result + ((requestDate == null) ? 0 : requestDate.hashCode());
		result = prime * result + statusId;
		temp = Double.doubleToLongBits(totalReimbursement);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(availableReimbursement) != Double.doubleToLongBits(other.availableReimbursement))
			return false;
		if (Double.doubleToLongBits(awardedReimbursements) != Double.doubleToLongBits(other.awardedReimbursements))
			return false;
		if (empId != other.empId)
			return false;
		if (eventId != other.eventId)
			return false;
		if (Double.doubleToLongBits(pendingReimbursements) != Double.doubleToLongBits(other.pendingReimbursements))
			return false;
		if (Double.doubleToLongBits(projectedReimbursement) != Double.doubleToLongBits(other.projectedReimbursement))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (requestDate == null) {
			if (other.requestDate != null)
				return false;
		} else if (!requestDate.equals(other.requestDate))
			return false;
		if (statusId != other.statusId)
			return false;
		if (Double.doubleToLongBits(totalReimbursement) != Double.doubleToLongBits(other.totalReimbursement))
			return false;
		return true;
	}
	
	

	
}
