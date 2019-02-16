package com.ustc.competition.dao;

import com.ustc.competition.dataobject.PaperInfo;
import com.ustc.competition.dataobject.PaperQuestion;
import com.ustc.competition.dataobject.QuestionInfo;
import com.ustc.competition.form.PaperForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-02-11 13:35
 */
@Mapper
@Repository
public interface PaperMapper {

    PaperInfo findById(@Param("paperId") String paperId);

    List<PaperInfo> findByPage(@Param("page") Integer page,
                               @Param("limit") Integer limit);


    List<PaperInfo> findBySelect(@Param("page") Integer page,
                                 @Param("limit") Integer limit,
                                 @Param("paperInfo") PaperInfo paperInfo);

    List<PaperQuestion> findAll();

    Integer save(@Param("paperForm") PaperForm paperForm);

    Integer saveQuestionId(@Param("list") List<PaperQuestion> paperQuestions);

    Integer modify(@Param("form") PaperForm paperForm);

    Integer remove(@Param("paperId") String paperId);

    Integer delete(@Param("paperId") String paperId);
}
