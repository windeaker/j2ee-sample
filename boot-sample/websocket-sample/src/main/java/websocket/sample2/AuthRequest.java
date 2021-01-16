package websocket.sample2;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/9
 */
public class AuthRequest implements Message {
    public static final String TYPE = "AUTH_REQUEST";

    /**
     * 认证 Token
     */
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
