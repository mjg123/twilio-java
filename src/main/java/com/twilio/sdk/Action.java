package com.twilio.sdk;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Action {
	ALL("*"),
	DELETE("DELETE"),
	GET("GET"),
	POST("POST"),
	PUT("PUT");

	private final String value;

	Action(final String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
