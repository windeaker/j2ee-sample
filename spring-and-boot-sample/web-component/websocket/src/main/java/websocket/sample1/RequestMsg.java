package websocket.sample1;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/8
 */
public class RequestMsg {
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "RequestMsg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
