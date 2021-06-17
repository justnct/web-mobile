package com.laptrinhjavaweb.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.util.SecurityUtils;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		List<String> roles = SecurityUtils.getAuthorities();
		if (isUser(roles)) {
			url = "/khach-hang/trang-chu?nameBrand=all";
		} else if (isAdmin(roles)) {
			url = "/quan-tri";
		}
		return url;
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
 
	private boolean isAdmin(List<String> role) {
		if (role.contains("ADMIN")) {
			return true;
		}
		return false;
	}

	private boolean isUser(List<String> role) {
		if (role.contains("USER")) {
			return true;
		}
		return false;
	}
}
