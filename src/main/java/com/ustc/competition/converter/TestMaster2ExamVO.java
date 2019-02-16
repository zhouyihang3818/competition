package com.ustc.competition.converter;

import com.ustc.competition.VO.ExamVO;
import com.ustc.competition.dataobject.TestMaster;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yihangZhou
 * @create 2019-02-16 14:15
 */
public class TestMaster2ExamVO {

    public static ExamVO converter(TestMaster testMaster) {

        ExamVO examVO = new ExamVO();
        examVO.setId(testMaster.getTestId());
        examVO.setTitle(testMaster.getTitle());
        List<Date> dateList = new ArrayList<>();
        dateList.add(testMaster.getStartTime());
        dateList.add(testMaster.getEndTime());
        examVO.setTime(dateList);
        examVO.setPaperTitle(testMaster.getPaperId());
        examVO.setStatus(testMaster.getStatus());

        return examVO;

    }

    public static List<ExamVO> converter(List<TestMaster> testMasterList) {

        return testMasterList.stream().map(e ->converter(e)).collect(Collectors.toList());

    }

}
