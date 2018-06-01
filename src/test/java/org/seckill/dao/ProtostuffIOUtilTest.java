package org.seckill.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import org.junit.Test;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

public class ProtostuffIOUtilTest {

	@Test
	public void test0_0() {
		SeckillTemp st = new SeckillTemp();
		st.setCreateTime(new Date());
		st.setEndTime(new Date());
		st.setName("测试数据001");
		st.setNumber(1000);
		st.setSeckillId(1L);
		st.setStartTime(new Date());
		//序列化
		RuntimeSchema<SeckillTemp> schema = RuntimeSchema.createFrom(SeckillTemp.class);
		byte[] bytes = ProtostuffIOUtil.toByteArray(st, schema,LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
		System.out.println(bytes.length);
		//反序列化
		SeckillTemp sc = schema.newMessage();
		ProtostuffIOUtil.mergeFrom(bytes, sc, schema);
		System.out.println("反序列化后>>>>>>>>>>>>"+sc);
	}

	@Test
	public void test1_0() {
		SeckillCopy skc = new SeckillCopy();
		skc.setCreateTime(new Date());
		skc.setEndTime(new Date());
		skc.setName("测试数据002");
		skc.setNumber(2000);
		skc.setSeckillId(2L);
		skc.setStartTime(new Date());
		//序列化
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos)) {
			oos.writeObject(skc);
			byte[] bytes = baos.toByteArray();
			System.out.println(bytes.length);
			SeckillCopy sc = (SeckillCopy) handle(bytes);
			System.out.println("反序列化后>>>>>>>>>>>>"+sc);
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	private Serializable handle(byte[] bytes){
		try(ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
				ObjectInputStream ois = new ObjectInputStream(bais)	) {
			Serializable copy = (Serializable) ois.readObject();
			return copy;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}

class SeckillCopy implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7244246854402197853L;

	private Long seckillId;

	private String name;

	private Integer number;

	private Date startTime;

	private Date endTime;

	private Date createTime;

	public Long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(Long seckillId) {
		this.seckillId = seckillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SeckillCopy [seckillId=" + seckillId + ", name=" + name + ", number=" + number + ", startTime="
				+ startTime + ", endTime=" + endTime + ", createTime=" + createTime + "]";
	}
}

class SeckillTemp{

	private Long seckillId;

	private String name;

	private Integer number;

	private Date startTime;

	private Date endTime;

	private Date createTime;

	public Long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(Long seckillId) {
		this.seckillId = seckillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SeckillTemp [seckillId=" + seckillId + ", name=" + name + ", number=" + number + ", startTime="
				+ startTime + ", endTime=" + endTime + ", createTime=" + createTime + "]";
	}

}