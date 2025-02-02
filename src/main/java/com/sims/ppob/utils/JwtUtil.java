package com.sims.ppob.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.sims.ppob.models.entity.AppUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtUtil {
  @Value("${spring.application.name}")
  private String jwtIss;

  @Value("${silent-meeting.configuration.jwt.jwt-secret}")
  private String jwtSecret;

  @Value("${silent-meeting.configuration.jwt.jwt-expires-at}")
  private Integer jwtExpAt;

  public String generateToken(AppUser appUser) {
    Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes(StandardCharsets.UTF_8));
    return JWT.create()
        .withIssuer(jwtIss)
        .withSubject(appUser.getId())
        .withIssuedAt(Instant.now())
        .withExpiresAt(Instant.now().plusSeconds(jwtExpAt))
        .withClaim("email", appUser.getEmail())
        .sign(algorithm);
  }

  private DecodedJWT decodedToken(String token, String secretKey) {
    Algorithm algorithm = Algorithm.HMAC256(secretKey.getBytes(StandardCharsets.UTF_8));
    JWTVerifier verifier = JWT.require(algorithm).withIssuer(jwtIss).build();
    return verifier.verify(token);
  }

  public String extractSubJwt(String accessToken) {
    return decodedToken(accessToken, jwtSecret).getSubject();
  }

  public String extractClaimJwt(String accessToken) {
    return decodedToken(accessToken, jwtSecret).getClaim("email").asString();
  }

  public void verifyJwt(String accessToken, String currentUserId, String currentEmail) {
    DecodedJWT decodedJWT = decodedToken(accessToken, jwtSecret);

    if (decodedJWT.getExpiresAt().before(new Date())) {
      throw new JWTVerificationException("Token tidak tidak valid atau kadaluwarsa");
    }

    String subDecode = decodedJWT.getSubject();
    if (subDecode == null || subDecode.isEmpty()) {
      throw new JWTVerificationException("Token tidak tidak valid atau kadaluwarsa");
    } else if (!subDecode.equals(currentUserId)) {
      throw new JWTVerificationException("Token tidak tidak valid atau kadaluwarsa");
    }

    String claimDecode = decodedJWT.getClaim("email").asString();
    if (!claimDecode.equals(currentEmail)) {
      throw new JWTVerificationException("Token tidak tidak valid atau kadaluwarsa");
    }
  }
}
