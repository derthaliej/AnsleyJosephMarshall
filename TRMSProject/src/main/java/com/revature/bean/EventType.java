package com.revature.bean;

public class EventType {
	
	 private int eventTyp;
     private String description;
     private double rate;
	
     
     public EventType() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EventType(int eventTyp, String description, double rate) {
		super();
		this.eventTyp = eventTyp;
		this.description = description;
		this.rate = rate;
	}


	public int getEventTyp() {
		return eventTyp;
	}


	public void setEventTyp(int eventTyp) {
		this.eventTyp = eventTyp;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	@Override
	public String toString() {
		return "EventType [eventTyp=" + eventTyp + ", description=" + description + ", rate=" + rate + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + eventTyp;
		long temp;
		temp = Double.doubleToLongBits(rate);
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
		EventType other = (EventType) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (eventTyp != other.eventTyp)
			return false;
		if (Double.doubleToLongBits(rate) != Double.doubleToLongBits(other.rate))
			return false;
		return true;
	}
     
     
     
     

}
