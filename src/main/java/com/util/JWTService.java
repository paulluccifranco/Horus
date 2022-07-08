package com.util;

import java.util.Map;

import org.springframework.stereotype.Controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

@Controller
public class JWTService {

	private final String SECRET = "mySecretKey";

	public String generateJWTToken(int proyectId, String description) {
		Algorithm algorithm = Algorithm.HMAC512(SECRET);

		String generatedToken = JWT.create().withClaim("proyectId", proyectId).withClaim("description", description)
				.sign(algorithm);

		System.out.println(generatedToken);

		return generatedToken;
	}

	public int validateUserJWT(String token) {
		Algorithm algorithm = Algorithm.HMAC512(SECRET);
		try {
			JWTVerifier verifier = JWT.require(algorithm).build();

			DecodedJWT decodedJWT = verifier.verify(token);
			Map<String, Claim> claims = decodedJWT.getClaims();
			return claims.get("proyectId").asInt();
		} catch (JWTVerificationException ex) {
			return 0;
		}
	}
}
