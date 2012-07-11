package metomeui.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


public class MsisdnSettings {
	
	
	@NotNull(message="Country code is required")
	private Integer countryCode;
	@NotEmpty(message="Country Domain is required")
	private String countryDomain;
	@NotEmpty(message="Currency code is required")
	private String currencyCode; 
	@NotEmpty(message="Currency ISO Number is required")
	private String currencyISONumber;
	@NotNull(message="MSISDN Length is required")
	private Integer msisdnLength;
	private Boolean msisdnLeadZero;

	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getCurrencyISONumber() {
		return currencyISONumber;
	}

	public void setCurrencyISONumber(String currencyISONumber) {
		this.currencyISONumber = currencyISONumber;
	}

	public String getCountryDomain() {
		return countryDomain;
	}

	public void setCountryDomain(String countryDomain) {
		this.countryDomain = countryDomain;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Integer getMsisdnLength() {
		return msisdnLength;
	}

	public void setMsisdnLength(Integer msisdnLength) {
		this.msisdnLength = msisdnLength;
	}

	public Boolean getMsisdnLeadZero() {
		return msisdnLeadZero;
	}

	public void setMsisdnLeadZero(Boolean msisdnLeadZero) {
		this.msisdnLeadZero = msisdnLeadZero;
	}

	public void clearFields() {
		this.countryCode = null;
		this.countryDomain = null;
	}
}
