package study.spring_security.context;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final Dotenv dotenv;
    private final Long jwtExpirationDate;
    private final String jwtSecret;

    public JwtTokenProvider() {
        dotenv = Dotenv.load();
        jwtSecret = dotenv.get("JWT_SECRET");
        jwtExpirationDate = Long.parseLong(dotenv.get("JWT_EXPIRATION"));

        if(jwtSecret.isEmpty() || jwtExpirationDate==null) {
            throw new RuntimeException("JWT_SECRET or JWT_EXPIRATION IS NULL");
        } else{
            System.out.println("Dotenv key: " + jwtSecret+ ", Expiration date: " + jwtExpirationDate);
        }
    }

    public String generateToken(Authentication authentication) {

        String email = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    // extract username from JWT token
    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(key())
                .parseClaimsJws(token)
                .getBody();
    }

    // validate JWT token
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(key()).
                    parseClaimsJws(token);

            return true;
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("Error with token validation: " + e.getMessage());
            return false;
        }
    }
}