package com.ustc.competition.service;

import com.ustc.competition.VO.ExamVO;
import com.ustc.competition.dataobject.TestMaster;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-02-16 13:45
 */
public interface ExamService {

    List<ExamVO> findAll(Integer page, Integer limit);

    List<ExamVO> findAllBySelect(Integer page, Integer limit, String title, String status);

    Integer save(ExamVO examVO);

    Integer modify(ExamVO examVO);

    Integer delete(String testId);

}
