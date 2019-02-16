package com.ustc.competition.service.impl;

import com.ustc.competition.VO.ExamVO;
import com.ustc.competition.converter.ExamVO2TestMaster;
import com.ustc.competition.converter.TestMaster2ExamVO;
import com.ustc.competition.dao.ExamMapper;
import com.ustc.competition.dataobject.TestMaster;
import com.ustc.competition.enums.ResultEnum;
import com.ustc.competition.exception.CompetitionException;
import com.ustc.competition.service.ExamService;
import com.ustc.competition.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-02-16 14:03
 */
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamMapper examMapper;

    @Override
    public List<ExamVO> findAll(Integer page, Integer limit) {

        List<TestMaster> testMasterList = examMapper.findAllByPage(page, limit);
        return TestMaster2ExamVO.converter(testMasterList);

    }

    @Override
    public List<ExamVO> findAllBySelect(Integer page, Integer limit, String title, String status) {

        List<TestMaster> testMasterList =examMapper.findAllBySelect(page, limit, title, status);
        return TestMaster2ExamVO.converter(testMasterList);

    }

    @Override
    public Integer save(ExamVO examVO) {

        TestMaster testMaster = ExamVO2TestMaster.converter(examVO);
        Integer result = examMapper.save(testMaster);
        if(result == 0) {
            throw new CompetitionException(ResultEnum.EXAM_INSERT_FAIL);
        }

        return result;
    }

    @Override
    public Integer modify(ExamVO examVO) {

        if(examMapper.findById(examVO.getId()) == null) {
            throw new CompetitionException(ResultEnum.EXAM_NOT_EXIST);
        }
        TestMaster testMaster = ExamVO2TestMaster.converter(examVO);
        Integer result = examMapper.modify(testMaster);
        if(result == 0) {
            throw new CompetitionException(ResultEnum.EXAM_MODIFY_FAIL);
        }

        return result;
    }

    @Override
    public Integer delete(String testId) {

        if(examMapper.findById(testId) == null) {
            throw new CompetitionException(ResultEnum.EXAM_NOT_EXIST);
        }
        Integer result = examMapper.delete(testId);
        if(result == 0) {
            throw new CompetitionException(ResultEnum.EXAM_DELETE_FAIL);
        }

        return result;
    }
}
