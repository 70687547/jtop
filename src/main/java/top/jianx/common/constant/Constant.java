package top.jianx.common.constant;

/**
 * @author Jianx jianx70687547@gmail.com
 */
public class Constant {
    /**
     * 排序方式
     */
    public static final String ORDER = "order";
    /**
     *  升序
     */
    public static final String ASC = "asc";

    /**
     * 定时任务状态
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
        NORMAL(0, "正常"),
        /**
         * 暂停
         */
        PAUSE(1, "暂停"),
        ;

        private int code;
        private String value;

        ScheduleStatus(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }

    }

    /**
     * 云服务商
     */
    public enum CloudService {
        /**
         * 七牛云
         */
        QINIU(1, "七牛云"),
        /**
         * 阿里云
         */
        ALIYUN(2, "阿里云"),
        /**
         * 腾讯云
         */
        QCLOUD(3, "腾讯云"),
        ;

        private int code;
        private String value;

        CloudService(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }
    }
}
