package websocket.sample1;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/8
 */
public class ResponseMsg {
    String msg;

    @Override
    public String toString() {
        return "ResponseMsg{" +
                "msg='" + msg + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
