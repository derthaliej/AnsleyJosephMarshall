package com.revature.bean;

public class GradingFormat {

	private int formatType;
	private int eventId;
	private String gradeNeeded;
	private String gradeReceived;
	
	public GradingFormat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GradingFormat(int formatType, int eventId, String gradeNeeded, String gradeReceived) {
		super();
		this.formatType = formatType;
		this.eventId = eventId;
		this.gradeNeeded = gradeNeeded;
		this.gradeReceived = gradeReceived;
	}

	public int getFormatType() {
		return formatType;
	}

	public void setFormatType(int formatType) {
		this.formatType = formatType;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getGradeNeeded() {
		return gradeNeeded;
	}

	public void setGradeNeeded(String gradeNeeded) {
		this.gradeNeeded = gradeNeeded;
	}

	public String getGradeReceived() {
		return gradeReceived;
	}

	public void setGradeReceived(String gradeReceived) {
		this.gradeReceived = gradeReceived;
	}

	
	@Override
	public String toString() {
		return "GradingFormat [formatType=" + formatType + ", eventId=" + eventId + ", gradeNeeded=" + gradeNeeded
				+ ", gradeReceived=" + gradeReceived + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventId;
		result = prime * result + formatType;
		result = prime * result + ((gradeNeeded == null) ? 0 : gradeNeeded.hashCode());
		result = prime * result + ((gradeReceived == null) ? 0 : gradeReceived.hashCode());
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
		GradingFormat other = (GradingFormat) obj;
		if (eventId != other.eventId)
			return false;
		if (formatType != other.formatType)
			return false;
		if (gradeNeeded == null) {
			if (other.gradeNeeded != null)
				return false;
		} else if (!gradeNeeded.equals(other.gradeNeeded))
			return false;
		if (gradeReceived == null) {
			if (other.gradeReceived != null)
				return false;
		} else if (!gradeReceived.equals(other.gradeReceived))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
