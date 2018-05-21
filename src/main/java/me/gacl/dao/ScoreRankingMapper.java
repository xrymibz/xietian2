package me.gacl.dao;

import me.gacl.domain.SchoolCode;
import me.gacl.domain.ScoreRanking;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-21
 * Time: 8:34
 */
public interface ScoreRankingMapper {



  /**
   * 根据排名查分数
   * @param scoreRanking
   * @return
   */
  ScoreRanking selectScorebyRanking(ScoreRanking scoreRanking);

  /**
   * 根据分数查排名
   * @param scoreRanking
   * @return
   */
  ScoreRanking selectRankingbyScore(ScoreRanking scoreRanking);


  /**
   * 添加分数排名
   * @param scoreRanking
   * @return
   */
  int  insertScoreRanking(ScoreRanking scoreRanking);
}
