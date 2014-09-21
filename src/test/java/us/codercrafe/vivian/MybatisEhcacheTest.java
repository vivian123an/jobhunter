package us.codercrafe.vivian;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import us.codecraft.jobhunter.dao.FootballMatchDAO;
import us.codecraft.jobhunter.dao.JobInfoDAO;
import us.codecraft.jobhunter.model.FootballMatch;
import us.codecraft.jobhunter.model.LieTouJobInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext-*.xml"})
public class MybatisEhcacheTest {
	@Resource
    private JobInfoDAO jobInfoDAO;
	@Resource
	private FootballMatchDAO footballMatchDAO;
	
	@Test
	public void testSelect() {
	    // the first time
		Map<String,Object> params = new HashMap<String, Object>();
		//params.put("urlMd5", "82dc3c989731b883fb17863949e320d1");
		params.put("source", "lietou.com");
		
	    long begin = System.currentTimeMillis();
	    List<LieTouJobInfo> list = jobInfoDAO.findLieTouJobInfo(params);
	    long end = System.currentTimeMillis() - begin;
	    System.out.println("count----1 :" + end);
	    System.out.println("size ----  :"+list.size());
	    
	    // the second time
	    begin = System.currentTimeMillis();
	    list = jobInfoDAO.findLieTouJobInfo(params);
	    end = System.currentTimeMillis() - begin;
	    System.out.println("count----2 :" + end);
	    System.out.println("size ----  :"+list.size());
	    
	    for(int i=0;i<100;i++){
		    LieTouJobInfo jobInfo = new LieTouJobInfo();
		    jobInfo.setCompany("测试");
		    jobInfo.setTitle("测试");
		    jobInfo.setSource("lietou.com");
		    jobInfoDAO.saveLieTouJobInfo(jobInfo);
	    }
	    
	    // the third time
	    begin = System.currentTimeMillis();
	    list = jobInfoDAO.findLieTouJobInfo(params);
	    end = System.currentTimeMillis() - begin;
	    System.out.println("count----3 :" + end);
	    System.out.println("size ----  :"+list.size());
	}
	
	
	public void testSelect2() {
	    // the first time
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("updateDate", "2014-08-18 00:55:01");
	    long begin = System.currentTimeMillis();
	    List<FootballMatch> list = footballMatchDAO.findFootballMatch(params);
	    long end = System.currentTimeMillis() - begin;
	    System.out.println("count----1 :" + end);
	    System.out.println("size ----  :"+list.size());
	    // the second time
	    begin = System.currentTimeMillis();
	    list = footballMatchDAO.findFootballMatch(params);
	    end = System.currentTimeMillis() - begin;
	    System.out.println("count----2 :" + end);
	    System.out.println("size ----  :"+list.size());
	    // the third time
	    begin = System.currentTimeMillis();
	    list = footballMatchDAO.findFootballMatch(params);
	    end = System.currentTimeMillis() - begin;
	    System.out.println("count----3 :" + end);
	    System.out.println("size ----  :"+list.size());
	     
	} 
}
