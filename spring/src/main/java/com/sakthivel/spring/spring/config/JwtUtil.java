package com.sakthivel.spring.spring.config;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	private String secretKey = "MySuperSecretKeyForJWTSigningThatIsLongEnough1234";

	public String generateToken(String userName) {
		
		Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
		
		return Jwts.builder()
				.setSubject(userName)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
				.signWith(key)
				.compact();
		
	}
	
	public String extractUserName(String token) {
		
		Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
		
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	public Date extractExpirationDate(String token) {
		
		Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
		
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getExpiration();
		
	}
	
		public boolean validateToken(String token , String userName) {
			
			return extractExpirationDate(token).after(new Date()) && extractUserName(token).equals(userName);	
		}
}
