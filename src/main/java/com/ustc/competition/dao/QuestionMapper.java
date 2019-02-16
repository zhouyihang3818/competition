package com.ustc.competition.dao;

import com.ustc.competition.dataobject.QuestionInfo;
import com.ustc.competition.form.QuestionForm;
import com.ustc.competition.form.QuestionInfoForm;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-02-01 16:46
 */
@Repository
@Mapper
public interface QuestionMapper {

    QuestionInfo selectById(@Param("questionId") String questionId);

    List<QuestionInfo> selectByIds(@Param("list") List<String> questionIds);

    @Select("select * from question_info limit #{page}, #{limit}")
    @Results({
            @Result(column = "question_id", property = "questionId"),
            @Result(column = "question_content", property = "questionContent"),
            @Result(column = "question_type", property = "questionType"),
            @Result(column = "question_group", property = "questionGroup"),
            @Result(column = "question_difficulty", property = "questionDifficulty"),
            @Result(column = "question_status", property = "questionStatus"),
            @Result(column = "question_select_a", property = "questionSelectA"),
            @Result(column = "question_select_b", property = "questionSelectB"),
            @Result(column = "question_select_c", property = "questionSelectC"),
            @Result(column = "question_select_d", property = "questionSelectD"),
            @Result(column = "question_answer", property = "questionAnswer")
    })
    List<QuestionInfo> selectAllByPage(@Param("page") Integer page, @Param("limit") Integer limit);


    List<QuestionInfo> selectAllBySelect(@Param("questionInfo") QuestionForm questionForm);



    Integer save(@Param("questionId") String questionId,
                 @Param("questionForm") QuestionInfoForm questionInfoForm);


    Integer modify(@Param("question") QuestionInfoForm questionInfoForm);

    Integer delete(@Param("deleteId") String questionId);

    List<QuestionInfo> selectAllByPaperid(@Param("paperId") String paperId,
                                          @Param("page") Integer page,
                                          @Param("limit") Integer limit);

    List<QuestionInfo> selectAllByKey(@Param("keyWord") String keyWord,
                                      @Param("page") Integer page,
                                      @Param("limit") Integer limit);


}
