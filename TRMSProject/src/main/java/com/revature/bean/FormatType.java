package com.revature.bean;

public class FormatType {
	
	private int FormatType;  
	private String FormatDesc;
	
	public FormatType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormatType(int formatType, String formatDesc) {
		super();
		FormatType = formatType;
		FormatDesc = formatDesc;
	}

	public int getFormatType() {
		return FormatType;
	}

	public void setFormatType(int formatType) {
		FormatType = formatType;
	}

	public String getFormatDesc() {
		return FormatDesc;
	}

	public void setFormatDesc(String formatDesc) {
		FormatDesc = formatDesc;
	}

	@Override
	public String toString() {
		return "FormatType [FormatType=" + FormatType + ", FormatDesc=" + FormatDesc + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FormatDesc == null) ? 0 : FormatDesc.hashCode());
		result = prime * result + FormatType;
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
		FormatType other = (FormatType) obj;
		if (FormatDesc == null) {
			if (other.FormatDesc != null)
				return false;
		} else if (!FormatDesc.equals(other.FormatDesc))
			return false;
		if (FormatType != other.FormatType)
			return false;
		return true;
	}
	
	
	
	

}
