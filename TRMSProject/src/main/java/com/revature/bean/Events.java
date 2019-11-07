package com.revature.bean;

import java.util.Date;
//import java.sql.Date;

public class Events {

	
	private int eventId;
	private int eventTyp;
	private String reason;
	private Date eventStartDate;
	private String eventLocation;
	private int eventLength;
	private double eventCost;
	private int absentDays;
	private Date approvalDate;
	private String resource;
	
	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Events(int eventId, int eventTyp, String reason, Date eventStartDate, String eventLocation, int eventLength,
			double eventCost, int absentDays, Date approvalDate, String resource) {
		super();
		this.eventId = eventId;
		this.eventTyp = eventTyp;
		this.reason = reason;
		this.eventStartDate = eventStartDate;
		this.eventLocation = eventLocation;
		this.eventLength = eventLength;
		this.eventCost = eventCost;
		this.absentDays = absentDays;
		this.approvalDate = approvalDate;
		this.resource = resource;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getEventTyp() {
		return eventTyp;
	}

	public void setEventTyp(int eventTyp) {
		this.eventTyp = eventTyp;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public int getEventLength() {
		return eventLength;
	}

	public void setEventLength(int eventLength) {
		this.eventLength = eventLength;
	}

	public double getEventCost() {
		return eventCost;
	}

	public void setEventCost(double eventCost) {
		this.eventCost = eventCost;
	}

	public int getAbsentDays() {
		return absentDays;
	}

	public void setAbsentDays(int absentDays) {
		this.absentDays = absentDays;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	
	@Override
	public String toString() {
		return "Events [eventId=" + eventId + ", eventTyp=" + eventTyp + ", reason=" + reason + ", eventStartDate="
				+ eventStartDate + ", eventLocation=" + eventLocation + ", eventLength=" + eventLength + ", eventCost="
				+ eventCost + ", absentDays=" + absentDays + ", approvalDate=" + approvalDate + ", resource=" + resource
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + absentDays;
		result = prime * result + ((approvalDate == null) ? 0 : approvalDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(eventCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + eventId;
		result = prime * result + eventLength;
		result = prime * result + ((eventLocation == null) ? 0 : eventLocation.hashCode());
		result = prime * result + ((eventStartDate == null) ? 0 : eventStartDate.hashCode());
		result = prime * result + eventTyp;
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((resource == null) ? 0 : resource.hashCode());
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
		Events other = (Events) obj;
		if (absentDays != other.absentDays)
			return false;
		if (approvalDate == null) {
			if (other.approvalDate != null)
				return false;
		} else if (!approvalDate.equals(other.approvalDate))
			return false;
		if (Double.doubleToLongBits(eventCost) != Double.doubleToLongBits(other.eventCost))
			return false;
		if (eventId != other.eventId)
			return false;
		if (eventLength != other.eventLength)
			return false;
		if (eventLocation == null) {
			if (other.eventLocation != null)
				return false;
		} else if (!eventLocation.equals(other.eventLocation))
			return false;
		if (eventStartDate == null) {
			if (other.eventStartDate != null)
				return false;
		} else if (!eventStartDate.equals(other.eventStartDate))
			return false;
		if (eventTyp != other.eventTyp)
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (resource == null) {
			if (other.resource != null)
				return false;
		} else if (!resource.equals(other.resource))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
