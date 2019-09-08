package com.swisscom.heroes.filter;

public enum Header {

	COOKIE("Cookie"),
	CSRF("X-XSRF-TOKEN"),
	USUARIO("x-usuario"),
	FAIL("x-fail")
	;

	private final String headerName;

	Header(final String headerName) {
		this.headerName = headerName;
	}

	public String getHeaderName() {
		return headerName;
	}
}
