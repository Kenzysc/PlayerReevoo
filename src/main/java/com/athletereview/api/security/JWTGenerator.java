package com.athletereview.api.security;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;


@Component
public class JWTGenerator {
	
	public String generateToken(Authentication authentication) {
		String username = authentication.getName();
		Date currentDate = new Date();
		Date expireDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);
		
		String token = Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(expireDate)
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SECRET)
				.compact();

		System.out.println("Token expiration: " + expireDate);
		
		return token;
	}
	
	public String getUsernameFromJWT(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(SecurityConstants.JWT_SECRET)
				.parseClaimsJws(token)
				.getBody();
		
		return claims.getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).parseClaimsJws(token);
			Claims claims = Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).parseClaimsJws(token).getBody();
			System.out.println("Token claims: " + claims);
			return true;
		// } catch (Exception ex) {
		// 	throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
		// }
		} catch (ExpiredJwtException ex) {
        	throw new AuthenticationCredentialsNotFoundException("JWT has expired");
		} catch (MalformedJwtException | SignatureException ex) {
			throw new AuthenticationCredentialsNotFoundException("Invalid JWT signature");
		} catch (Exception ex) {
			throw new AuthenticationCredentialsNotFoundException("JWT was incorrect");
		}

	}
	
}

