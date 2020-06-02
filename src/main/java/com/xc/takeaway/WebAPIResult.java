package com.xc.takeaway;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class WebAPIResult implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /** 成功 */
    public static final int SUCCESS = 1;

    /** 失败 */
    public static final int FAIL = 0;

    /** 警告 */
    public static final int WARN = 2;
    /** 错误 */
    public static final int ERROR = -1;

    /** 登陆超时 */
    public static final int TIMEOUT = -2;
    //数据库中数据条数
    private int total;
    // 返回结果(成功或失败)
    private int result = SUCCESS;
    // 返回消息
    private String message = "";
    // 引起原因
    private String cause = "";
    // 返回变量
    private Map<String, Object> vars = new HashMap<String, Object>();
    // 返回数据
    private Object data;
    //token
    private String token;


    public WebAPIResult() {
    }

    public WebAPIResult(int result) {
        super();
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public WebAPIResult(int result, String message) {
        this.result = result;
        this.message = message;
    }

    public WebAPIResult(int result, String message, String cause) {
        this.result = result;
        this.message = message;
        this.cause = cause;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    public void addVariable(String key, Object value) {
        this.vars.put(key, value);
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return SUCCESS == result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Object getVar(String key) {
        if(null == vars){
            return null;
        }
        return vars.get(key);
    }

    public Map<String, Object> getVars() {
        return vars;
    }

    public void setVars(Map<String, Object> vars) {
        this.vars = vars;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setResultMessage(int result, String message){
        this.setResult(result);
        this.setMessage(message);
    }

    public void setResultMessage(int result, String message, String cause){
        this.setResult(result);
        this.setMessage(message);
        this.setCause(cause);
    }

    public String toString() {
		/*JSONStringer stringer = new JSONStringer();
		stringer.object()
		.key("result").value(result)
		.key("data").value(data)
		.key("message").value(message)
		.key("cause").value(cause);
		if (!vars.isEmpty()) {
			for (Entry<String, Object> entry : vars.entrySet()) {
				stringer.key(entry.getKey()).value(entry.getValue());
			}
		}
		stringer.endObject();*/

        ObjectMapper mapper = new ObjectMapper();
        // 取消默认时间日期格式转换
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 设置JSON时间格式
        SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        mapper.setDateFormat(myDateFormat);
        // 设置北京时间
        mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));

        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "{}";
        }
    }

}