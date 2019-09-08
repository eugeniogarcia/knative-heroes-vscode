package com.swisscom.heroes.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.web.filter.OncePerRequestFilter;

public class HttpFiltro extends OncePerRequestFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpFiltro.class);
	private final RequestContext requestContext;

	public HttpFiltro(final RequestContext requestContext) {
		this.requestContext = requestContext;
	}

	@Override
	protected void doFilterInternal(@NonNull final HttpServletRequest httpServletRequest,
			@NonNull final HttpServletResponse httpServletResponse,
			@NonNull final FilterChain filterChain) throws ServletException, IOException {


		LOGGER.trace("Filter Start");
		requestContext.init(httpServletRequest, httpServletResponse);
		LOGGER.trace("Filter End");

		// Continue Processing
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}
