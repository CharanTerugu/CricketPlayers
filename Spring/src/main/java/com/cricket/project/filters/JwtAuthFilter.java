package com.cricket.project.filters;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cricket.project.serviceimpl.JwtService;
import com.cricket.project.serviceimpl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JwtAuthFilter extends OncePerRequestFilter{

	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserDetailsServiceImpl userdetailsService;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		String authHeader=request.getHeader("Authorization");
		String token=null;
		String username = null;
		if(authHeader!=null && authHeader.startsWith("Bearer ")) {
			token=authHeader.substring(7);
			username=jwtService.extractUsername(token);
			
			
		}
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
		UserDetails userDetails=userdetailsService.loadUserByUsername(username);
		
		  if(jwtService.validateToken(token, userDetails)) {
			  UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
		        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request) );
  		      SecurityContextHolder.getContext().setAuthentication(authToken);
		  
		  }
		
		
		}
		filterChain.doFilter(request, response);
		}catch (ExpiredJwtException e) {
			// TODO: handle exception
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Token expired");
			return ;
		}
		catch (Exception e) {
			// TODO: handle exception
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Invalid Token");
			return ;
		}
		
	}

}