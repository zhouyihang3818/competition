package com.ustc.competition.converter;

import com.ustc.competition.VO.ExamVO;
import com.ustc.competition.dataobject.TestMaster;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yihangZhou
 * @create 2019-02-16 15:24
 */
public class ExamVO2TestMaster {

    public static TestMaster converter(ExamVO examVO) {

        TestMaster testMaster = new TestMaster();
        testMaster.setTestId(examVO.getId());
        Date start= examVO.getTime().get(0);
        Date end = examVO.getTime().get(1);
        testMaster.setStartTime(start);
        testMaster.setEndTime(end);
        testMaster.setTitle(examVO.getTitle());
        testMaster.setPaperId(examVO.getPaperTitle());
        testMaster.setStatus(examVO.getStatus());

        return testMaster;

    }

    public static List<TestMaster> converter(List<ExamVO> examVOList) {
        return examVOList.stream().map(e ->converter(e)).collect(Collectors.toList());
    }

}
