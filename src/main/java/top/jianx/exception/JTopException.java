package top.jianx.exception;

/**
 * @description
 * @author Jianx jianx70687547@gmail.com
 * @date 2020/6/13 3:18
 */
public class JTopException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public JTopException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public JTopException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public JTopException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public JTopException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
