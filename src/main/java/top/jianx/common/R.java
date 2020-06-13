package top.jianx.common;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 全局統一返回對象
 * @author Jianx jianx70687547@gmail.com
 * @Description
 * @Date 2020/6/13 3:29
 */
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code = 0;
    private String msg = "success";
    private T data;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss SSS"
    )
    private LocalDateTime timestamp = LocalDateTime.now();

    //Object ->  T
    public static <T> R<T> ok() {
        return restResult((T)null, 0, "success");
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, 0, "success");
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, 0, msg);
    }

    //Object ->  T
    public static <T> R<T> failed() {
        return restResult((T)null, 1, "error");
    }

    //Object ->  T
    public static <T> R<T> failed(String msg) {
        return restResult((T)null, 1, msg);
    }

    public static <T> R<T> failed(T data) {
        return restResult(data, 1, "error");
    }

    public static <T> R<T> failed(T data, String msg) {
        return restResult(data, 1, msg);
    }

    //Object ->  T
    public static <T> R<T> failed(int code, String msg) {
        return restResult((T)null, code, msg);
    }

    public static <T> R<T> failed(T data, int code) {
        return restResult(data, code, (String)null);
    }

    public static <T> R<T> failed(T data, int code, String msg) {
        return restResult(data, code, msg);
    }

    public R() {
    }

    public R(T data) {
        this.data = data;
    }

    public R(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public R(Throwable e) {
        this.msg = e.getMessage();
        this.code = 1;
    }

    private static <T> R<T> restResult(T data, int code, String msg) {
        R<T> apiResult = new R();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public boolean is() {
        return this.code == 0;
    }

    public static <T> R.RBuilder<T> builder() {
        return new R.RBuilder();
    }

    public String toString() {
        return "R(code=" + this.getCode() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ", timestamp=" + this.getTimestamp() + ")";
    }

    public R(final int code, final String msg, final T data, final LocalDateTime timestamp) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.timestamp = timestamp;
    }

    public int getCode() {
        return this.code;
    }

    public R<T> setCode(final int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public R<T> setMsg(final String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public R<T> setData(final T data) {
        this.data = data;
        return this;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public R<T> setTimestamp(final LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public static class RBuilder<T> {
        private int code;
        private String msg;
        private T data;
        private LocalDateTime timestamp;

        RBuilder() {
        }

        public R.RBuilder<T> code(final int code) {
            this.code = code;
            return this;
        }

        public R.RBuilder<T> msg(final String msg) {
            this.msg = msg;
            return this;
        }

        public R.RBuilder<T> data(final T data) {
            this.data = data;
            return this;
        }

        public R.RBuilder<T> timestamp(final LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public R<T> build() {
            return new R(this.code, this.msg, this.data, this.timestamp);
        }

        public String toString() {
            return "R.RBuilder(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", timestamp=" + this.timestamp + ")";
        }
    }
}
