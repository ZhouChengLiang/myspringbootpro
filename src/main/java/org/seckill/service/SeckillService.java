package org.seckill.service;

import java.util.List;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
public interface SeckillService{
	
	/**
	 * 查询所有秒杀记录
	 * @return
	 */
	List<Seckill> getSeckillList();
	
	/**
	 * 查询单个秒杀记录
	 * @param seckillId
	 * @return
	 */
	Seckill getById(Long seckillId);
	
	/**
	 * 秒杀开启时输出秒杀接口的地址
	 * 否则输出系统时间和秒杀时间
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(Long seckillId);
	
	
	/**
	 * 执行秒杀操作
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution executeSeckill(Long seckillId,Long userPhone,String md5) throws SeckillException,SeckillCloseException,RepeatKillException ;
	
	/**
	 * 执行秒杀操作  存储过程
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 * @return
	 * @throws SeckillException
	 * @throws SeckillCloseException
	 * @throws RepeatKillException
	 */
	SeckillExecution executeSeckillProcedure(Long seckillId,Long userPhone,String md5);
}
