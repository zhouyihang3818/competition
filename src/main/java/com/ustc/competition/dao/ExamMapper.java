package com.ustc.competition.dao;

import com.ustc.competition.VO.ExamVO;
import com.ustc.competition.dataobject.TestMaster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 考试管理
 * @author yihangZhou
 * @create 2019-02-16 10:38
 */
@Mapper
@Repository
public interface ExamMapper {

    TestMaster findById(@Param("id") String id);

    List<TestMaster> findAllByPage(@Param("page") Integer page, @Param("limit") Integer limit);

    List<TestMaster> findAllBySelect(@Param("page") Integer page,
                                     @Param("limit") Integer limit,
                                     @Param("title") String title,
                                     @Param("status") String status);

    Integer save(@Param("testMaster") TestMaster testMaster);

    Integer modify(@Param("testMaster") TestMaster testMaster);

    Integer delete(@Param("testId") String testId);

}
