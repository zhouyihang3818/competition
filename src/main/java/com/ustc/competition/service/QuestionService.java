package com.ustc.competition.service;

import com.ustc.competition.dataobject.QuestionInfo;
import com.ustc.competition.form.QuestionForm;
import com.ustc.competition.form.QuestionInfoForm;

import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-01-28 21:13
 */
public interface QuestionService {

    List<QuestionInfo> findAll(Integer page, Integer limit);

    List<QuestionInfo> findAllBySelect(QuestionForm questionForm);

    List<QuestionInfo> findAllByIds(List<String> questionIds);

    String save(QuestionInfoForm questionInfoForm);

    Integer modify(QuestionInfoForm questionInfoForm);

    Integer delete(String questionId);

    List<QuestionInfo> findAllByPaperid(String paperId, Integer page, Integer limit);

    List<QuestionInfo> findAllByKeyword(String keyWord, Integer page, Integer limit);
}
