package us.codercrafe.vivian;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import us.codecraft.jobhunter.dao.JobInfoDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext-*.xml"})
public class MybatisEhcacheTest {
	@Resource
    private JobInfoDAO jobInfoDAO;
	
	@Test
	public void testSelect() {
	    // the first time
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("urlMd5", "82dc3c989731b883fb17863949e320d1");
	    long begin = System.currentTimeMillis();
	    jobInfoDAO.findLieTouJobInfo(params);
	    long end = System.currentTimeMillis() - begin;
	    System.out.println("count----1 :" + end);
	    // the second time
	    begin = System.currentTimeMillis();
	    jobInfoDAO.findLieTouJobInfo(params);
	    end = System.currentTimeMillis() - begin;
	    System.out.println("count----2 :" + end);
	    // the third time
	    begin = System.currentTimeMillis();
	    jobInfoDAO.findLieTouJobInfo(params);
	    end = System.currentTimeMillis() - begin;
	    System.out.println("count----3 :" + end);
	}
	@Test
	public void testInsert() {
/*	    // the second time
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("urlMd5", "82dc3c989731b883fb17863949e320d1");
	    long begin = System.nanoTime();
	    LieTouJobInfo p1 = jobInfoDAO.findLieTouJobInfo(params);
	    long end = System.nanoTime() - begin;
	    System.out.println("count :" + end);
	    System.out.println("Category :"+p1.getJobinfoId());
	    Map<String, String> parame = new HashMap<String, String>();
	    parame.put("categoryId", "DOGS");
	    parame.put("productId", "FI-SW-01");
	     
	    begin = System.nanoTime();
	    productMapper.updateProductById(parame);
	    end = System.nanoTime() - begin;
	    System.out.println("count :"+end);
	    begin = System.nanoTime();
	    Product p2 = productMapper.getProduct("FI-SW-01");
	    end = System.nanoTime() - begin;
	    System.out.println("count :"+end);
	    System.out.println("Category :"+p2.getCategoryId());*/
	     
	} 
}
