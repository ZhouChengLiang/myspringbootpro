package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.cache.RedisDao;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 配置spring 和 junit整合 junit 启动时加载springIOC容器
 * @author Administrator
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
	
	@Autowired
	private SeckillDao seckillDao;
	
	@Autowired
	private RedisDao redisDao;
	
	@Test
	public void testQueryById() throws Exception{
		Long seckillId = 1000L;
		System.out.println(seckillDao.queryById(seckillId));
	}
	
	@Test
	public void testQueryAll() throws Exception{
		Integer offset = 0;
		Integer limit = 100;
		List<Seckill> seckills = seckillDao.queryAll(offset, limit);
		seckills.forEach(System.out::println);
	}
	
	@Test
	public void testReduceNumber() throws Exception{
		Long seckillId = 1000L;
		Date killTime = new Date();
		int updateCount = seckillDao.reduceNumber(seckillId, killTime);
		System.out.println("updateCount>>>"+updateCount);
	}
	
	@Test
	public void testPutSeckill(){
		Long seckillId = 1300L;
		Seckill seckill = redisDao.getSeckill(seckillId);
		if(seckill == null){
			seckill = seckillDao.queryById(seckillId);
			if (seckill == null) {
				System.out.println("");
			}else{
				redisDao.putSeckill(seckill);
			}
		}
	}
	
	@Test
	public void testGetSeckill(){
		Long seckillId = 1000L;
		Seckill seckill = redisDao.getSeckill(seckillId);
		System.out.println(seckill);
	}
	
}
