package tk.amrom.socket;

/**
 * @author linjinbao66@gmail.com
 * @date 2020/6/7
 */
public class MyAjaxResult {
    private String msg;
    private String code;
    private String data;

    public MyAjaxResult(){

    }

    public MyAjaxResult(String uid) {
        this.msg = uid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
