package me.gacl.service.impl;

import me.gacl.dao.SchoolCodeMapper;
import me.gacl.dao.ScoreRankingMapper;
import me.gacl.domain.ScoreRanking;
import me.gacl.service.ScoreRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-21
 * Time: 8:47
 */
@Service("scoreRankingService")
public class ScoreRankingServiceImpl implements ScoreRankingService {

  @Autowired
  ScoreRankingMapper scoreRankingMapper;

  public ScoreRanking selectScorebyRanking(ScoreRanking scoreRanking) {
      return scoreRankingMapper.selectScorebyRanking(scoreRanking);
  }

  public ScoreRanking selectRankingbyScore(ScoreRanking scoreRanking) {
    return scoreRankingMapper.selectRankingbyScore(scoreRanking);

  }

  public boolean insertScoreRanking(ScoreRanking scoreRanking) {
    return (scoreRankingMapper.insertScoreRanking(scoreRanking)>0);
  }
}
