package org.seckill.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
	
	private final String salt = "qazwsxedc123";
	
	@Test
	public void testGetSeckillList(){
		List<Seckill> list = seckillService.getSeckillList();
		logger.info("list={}", list);
	}
	
	@Test
	public void testGetById(){
		Long seckillId = 1000L;
		Seckill seckill = seckillService.getById(seckillId);
		logger.info("seckill={}", seckill);
	}
	
	@Test
	public void testExportSeckillUrl(){
		Long seckillId = 1000L;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		logger.info("exposer={}",exposer);
	}
	
	
	@Test
	public void executeSeckill() throws SeckillException,SeckillCloseException,RepeatKillException{
		Long seckillId = 1002L;
		Long userPhone=15268594665L;
		String md5 = getMD5(seckillId);
		SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
		logger.info("seckillExecution={}",seckillExecution);
	}
	
	@Test
	public void testSeckillLogic() throws Exception{
		Long seckillId = 1002L;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		if(exposer.isExposed()){
			logger.info("exposer={}",exposer);
			long phone = 15268594665L;
			String md5 = exposer.getMd5();
			try {
				SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, phone, md5);
				logger.info("result={}",seckillExecution);
			} catch (RepeatKillException e) {
				logger.error(e.getMessage());
			}catch (SeckillCloseException e) {
				logger.error(e.getMessage());
			}
		}else{
			//��ɱδ����
			logger.warn("exposer={}",exposer);
		}
	}
	
	private String getMD5(Long seckillId){
		String base = seckillId +" "+salt;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}
	
	@Test
	public void testExecuteSeckillProcedure(){
		Long seckillId = 1000L;
		Long phone = 15677665432L;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		if(exposer.isExposed()){
			logger.info("exposer={}",exposer);
			String md5 = exposer.getMd5();
			try {
				SeckillExecution seckillExecution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
				logger.info("result={}",seckillExecution);
			} catch (RepeatKillException e) {
				logger.error(e.getMessage());
			}catch (SeckillCloseException e) {
				logger.error(e.getMessage());
			}
		}
	}
}
