package com.ustc.competition.service.impl;

import com.ustc.competition.dao.PaperMapper;
import com.ustc.competition.dataobject.PaperInfo;
import com.ustc.competition.dataobject.PaperQuestion;
import com.ustc.competition.enums.ResultEnum;
import com.ustc.competition.exception.CompetitionException;
import com.ustc.competition.form.PaperForm;
import com.ustc.competition.service.PaperService;
import com.ustc.competition.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-02-11 14:32
 */
@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Override
    public List<PaperInfo> findAll(Integer page, Integer limit) {
        return paperMapper.findByPage(page, limit);
    }

    @Override
    public List<PaperInfo> findAllBySelect(Integer page, Integer limit, PaperInfo paperInfo) {
        return paperMapper.findBySelect(page, limit, paperInfo);
    }

    @Override
    public List<PaperQuestion> selectAll() {
        return paperMapper.findAll();
    }

    @Override
    public Integer save(PaperForm paperForm) {

        //保存paper_info里的数据
        paperMapper.save(paperForm);

        //保存paper_question里的数据
        List<PaperQuestion> paperQuestionList = new ArrayList<>();
        for(String s : paperForm.getList()) {
            PaperQuestion paperQuestion = new PaperQuestion();
            paperQuestion.setPaperId(paperForm.getId());
            paperQuestion.setQuestionId(s);
            String paperQuestionId = KeyUtil.genUniqueKey();
            paperQuestion.setPaperQuestionId(paperQuestionId);
            paperQuestionList.add(paperQuestion);
        }
        return paperMapper.saveQuestionId(paperQuestionList);

    }

    @Override
    @Transactional
    public Integer modify(PaperForm paperForm) {

        //判断该试卷是否存在，不存在抛出异常
        if(paperMapper.findById(paperForm.getId()) == null) {
            throw new CompetitionException(ResultEnum.PAPER_NOT_EXIST);
        }
        //进行修改
        Integer modify = paperMapper.modify(paperForm);
        if(modify == 0) {
            throw new CompetitionException(ResultEnum.UPDATE_FAIL);
        }
        //删除原来的题目
        Integer remove = paperMapper.remove(paperForm.getId());
        if(remove == 0) {
            throw new CompetitionException(ResultEnum.UPDATE_FAIL);
        }
        //保存新的题目
        List<PaperQuestion> paperQuestionList = new ArrayList<>();
        for(String s : paperForm.getList()) {
            PaperQuestion paperQuestion = new PaperQuestion();
            paperQuestion.setPaperId(paperForm.getId());
            paperQuestion.setQuestionId(s);
            String paperQuestionId = KeyUtil.genUniqueKey();
            paperQuestion.setPaperQuestionId(paperQuestionId);
            paperQuestionList.add(paperQuestion);
        }
        Integer save = paperMapper.saveQuestionId(paperQuestionList);
        if(save == 0) {
            throw new CompetitionException(ResultEnum.UPDATE_FAIL);
        }

        return save;
    }

    @Override
    public Integer delete(String paperId) {

        //判断该试卷是否存在，不存在抛出异常
        if(paperMapper.findById(paperId) == null){
            throw new CompetitionException(ResultEnum.PAPER_NOT_EXIST);
        }
        //删除paper_info里的数据
        Integer delete = paperMapper.delete(paperId);
        if(delete == 0) {
            throw new CompetitionException(ResultEnum.PAPER_DELETE_FAIL);
        }
        //删除paper_question里的数据
        Integer remove = paperMapper.remove(paperId);
        if(remove == 0) {
            throw new CompetitionException(ResultEnum.PAPER_DELETE_FAIL);
        }

        return delete;
    }
}
