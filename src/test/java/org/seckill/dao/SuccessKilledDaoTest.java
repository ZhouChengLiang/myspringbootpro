package org.seckill.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Administrator
 */

public class SuccessKilledDaoTest {
	
	
	@Autowired private SuccessKilledDao successKilledDao;
	
	@Test
	public void testInsertSuccessKilled(){
		Long seckillId = 1000L;
		Long userPhone = 15268594665L;
		int updateCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
		System.out.println("updateCount>>>"+updateCount);
	}
	
	@Test
	public void testQueryByIdWithSeckill(){
		Long seckillId = 1000L;
		Long userPhone = 15268594665L;
		System.out.println(successKilledDao.queryByIdWithSeckill(seckillId,userPhone));
	}
}
