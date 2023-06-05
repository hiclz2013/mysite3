package com.javaex.vo;

public class JsonResult {
	
	//필드
	private String result;  /* "success" or "fail" */
	private Object data;    /* 성공했을때 result=success" 일때 데이타*/	
	private String failMsg; /* 실패했을때 result=fail" 일때 참고할수 있는메세지*/
	
	/* 생성자 */
	public JsonResult() {
	}	
	
	public JsonResult(String result, Object data, String failMsg) {
		this.result = result;
		this.data = data;
		this.failMsg = failMsg;
	}

	/* 메소드 gs */
	public String getResult() {
		return result;
	}

	public Object getData() {
		return data;
	}

	public String getFailMsg() {
		return failMsg;
	}
	
	
	/* 메소드 일반 */
	//성공했을때 사용하는 메소드
	public void success(Object data) {
		this.result = "success";
		this.data = data;
	}



	

	//실패했을때 사용하는 메소드
	public void fail(String msg) {
		this.result = "fail";
		this.failMsg = msg;
	}
	
	@Override
	public String toString() {
		return "JsonResult [result=" + result + ", data=" + data + ", failMsg=" + failMsg + "]";
	}
	
}
