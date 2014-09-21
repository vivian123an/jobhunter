package us.codecraft.jobhunter.dao;

import java.util.List;
import java.util.Map;

import us.codecraft.jobhunter.model.FootballMatch;

public interface FootballMatchDAO {

	public List<FootballMatch> findFootballMatch(Map<String,Object> params);
}
