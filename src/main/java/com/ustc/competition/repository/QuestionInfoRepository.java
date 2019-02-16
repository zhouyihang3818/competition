package com.ustc.competition.repository;

import com.ustc.competition.dataobject.QuestionInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-01-28 20:35
 */
public interface QuestionInfoRepository extends JpaRepository<QuestionInfo, String> {
    List<QuestionInfo> findByQuestionGroup(String questionGroup);
}
