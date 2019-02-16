package com.ustc.competition.service.impl;

import com.ustc.competition.dao.QuestionMapper;
import com.ustc.competition.dataobject.QuestionInfo;
import com.ustc.competition.enums.ResultEnum;
import com.ustc.competition.exception.CompetitionException;
import com.ustc.competition.form.QuestionForm;
import com.ustc.competition.form.QuestionInfoForm;
import com.ustc.competition.service.QuestionService;
import com.ustc.competition.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-02-01 20:40
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<QuestionInfo> findAll(Integer page, Integer limit) {

        List<QuestionInfo> questionInfoList = questionMapper.selectAllByPage(page, limit);
        return questionInfoList;

    }

    @Override
    public List<QuestionInfo> findAllByIds(List<String> questionIds) {

        List<QuestionInfo> questionInfoList = questionMapper.selectByIds(questionIds);

        return questionInfoList;

    }

    @Override
    public List<QuestionInfo> findAllBySelect( QuestionForm questionForm) {

        List<QuestionInfo> questionInfoList = questionMapper.selectAllBySelect(questionForm);

        return questionInfoList;
    }

    @Override
    public String save(QuestionInfoForm questionInfoForm) {

        String questionId = KeyUtil.genUniqueKey();
        Integer result = questionMapper.save(questionId, questionInfoForm);
        if(result == 0) {
            throw new CompetitionException(ResultEnum.INSERT_FAIL);
        }
        return questionId;
    }

    @Override
    public Integer modify(QuestionInfoForm questionInfoForm) {

        QuestionInfo questionInfo = questionMapper.selectById(questionInfoForm.getId());
        if(questionInfo == null) {
            throw new CompetitionException(ResultEnum.QUESTION_NOT_EXIST);
        }
        Integer result = questionMapper.modify(questionInfoForm);
        if(result == 0) {
            throw new CompetitionException(ResultEnum.UPDATE_FAIL);
        }
        return result;
    }

    @Override
    public Integer delete(String questionId) {

        QuestionInfo questionInfo = questionMapper.selectById(questionId);
        if(questionInfo == null) {
            throw new CompetitionException(ResultEnum.QUESTION_NOT_EXIST);
        }
        Integer result = questionMapper.delete(questionId);
        if(result == 0) {
            throw new CompetitionException(ResultEnum.UPDATE_FAIL);
        }

        //TODO
        return result;

    }

    @Override
    public List<QuestionInfo> findAllByPaperid(String paperId, Integer page, Integer limit) {

        List<QuestionInfo> questionInfoList = questionMapper.selectAllByPaperid(paperId, page, limit);

        return questionInfoList;
    }

    @Override
    public List<QuestionInfo> findAllByKeyword(String keyWord, Integer page, Integer limit) {

        List<QuestionInfo> questionInfoList = questionMapper.selectAllByKey(keyWord, page, limit);

        return questionInfoList;
    }
}
