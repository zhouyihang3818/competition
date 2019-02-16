package com.ustc.competition.service;

import com.ustc.competition.dataobject.PaperInfo;
import com.ustc.competition.dataobject.PaperQuestion;
import com.ustc.competition.form.PaperForm;
import com.ustc.competition.form.QuestionForm;

import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-02-11 14:29
 */
public interface PaperService {

    List<PaperInfo> findAll(Integer page, Integer limit);

    List<PaperInfo> findAllBySelect(Integer page, Integer limit, PaperInfo paperInfo);

    List<PaperQuestion> selectAll();

    Integer save(PaperForm paperForm);

    Integer modify(PaperForm paperForm);

    Integer delete(String paperId);

}
