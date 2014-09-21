package us.codecraft.jobhunter.dao;

import java.util.List;
import java.util.Map;

import us.codecraft.jobhunter.model.LieTouJobInfo;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午4:27
 */
public interface JobInfoDAO {

    public int saveLieTouJobInfo(LieTouJobInfo jobInfo);
    
    public List<LieTouJobInfo> findLieTouJobInfo(Map<String,Object> params);
}
