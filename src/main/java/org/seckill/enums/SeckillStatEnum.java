package org.seckill.enums;

/**
 * 使用枚举表述常量数据
 * @author Administrator
 *
 */
public enum SeckillStatEnum {
	SUCCESS(1,"秒杀成功"),
	END(0,"秒杀结束"),
	REPEAT_KILL(-1,"重复秒杀"),
	INNER_ERROR(-2,"系统异常"),
	DATA_REWRITE(-3,"数据篡改");
	private Integer state;
	
	private String stateInfo;

	SeckillStatEnum(Integer state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	
	public static SeckillStatEnum stateOf(Integer state){
		for(SeckillStatEnum ss:values()){
			if(ss.getState() ==state){
				return ss;
			}
		}
		return null;
	}
}
