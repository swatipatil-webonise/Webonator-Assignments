package com.webonise.jwtsecurity.security.jwt;

import com.webonise.jwtsecurity.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author webonise on 24/02/20
 * @project jwt-security
 */
@Component
@Slf4j
public class JwtGeneratorAndValidator {

    private static final String USER_ID = "userId";

    private static final String USER_ROLE = "role";

    private static final String ISSUER = "issuer";

    private static final String AUDIENCE = "audience";

    @Value("${jwt.secret.key}")
    private String SECRET_KEY;

    @Value("${jwt.claims.issuer}")
    private String issuer;

    @Value("${jwt.claims.audience}")
    private String audience;

    @Autowired
    public JwtUserService userService;

    public String generate(JwtUser jwtUser) {
        jwtUser = userService.get(jwtUser);
        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserName());
        claims.put(USER_ID, String.valueOf(jwtUser.getId()));
        claims.put(USER_ROLE, jwtUser.getRole());
        claims.put(ISSUER, issuer);
        claims.put(AUDIENCE, audience);
        Date expirationTime = new Date();
        expirationTime.setMinutes(expirationTime.getMinutes() + 2);
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .setExpiration(expirationTime)
                .compact();
    }

    private Boolean isTokenExpired(Claims body) {
        return body.getExpiration().before(new Date());
    }

    public JwtUser validate(String token) {
        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            isTokenExpired(body);
            return new JwtUser(body.getSubject(), Long.parseLong((String) body.get(USER_ID)),
                (String) body.get(USER_ROLE));
        } catch (ExpiredJwtException ex) {
            throw new RuntimeException("Token expired");
        } catch (Exception ex) {
            log.error("Exception occurred while parsing token.", ex);
        }
        return jwtUser;
    }
}
