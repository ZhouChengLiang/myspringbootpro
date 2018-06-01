package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
	
	/**
	 * 插入购买明细 可过滤重复
	 * @param seckillId
	 * @param userPhone
	 * @return 表示插入的结果集数量
	 */
	int insertSuccessKilled(@Param("seckillId") Long seckillId,@Param("userPhone") Long userPhone);
	
	/**
	 * 查询SuccessKilled 并携带产品对象
	 * @param seckillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId") Long seckillId,@Param("userPhone") Long userPhone);
}
