package rc.bootsecurity.security;

public class JwtProperties {
    public static final String SECRET = "RomanianCoderMonirAhmed";
    public static final int EXPIRATION_TIME = 864000000; // 10 Days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
