package com.ustc.competition.dao;

import com.ustc.competition.dataobject.QuestionInfo;
import com.ustc.competition.form.QuestionForm;
import com.ustc.competition.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yihangZhou
 * @create 2019-02-01 19:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class QuestionMapperTest {

    @Autowired
    private QuestionMapper questionMapper;

    @Test
    public void selectAllByPage() {

//        List<QuestionInfo> result = questionMapper.selectAllByPage(0,2);
//        log.info("查询结果, {}", result);
//        Assert.assertNotEquals(result.size(), 0);
    }

    @Test
    public void selectAllBySelect() {
        QuestionForm questionInfo = new QuestionForm();
        questionInfo.setContent("折半");
        questionInfo.setType("单选");
        questionInfo.setGroup("数据结构");
        questionInfo.setDifficulty(1);
        questionInfo.setPage(0);
        questionInfo.setLimit(4);
        List<QuestionInfo> result = questionMapper.selectAllBySelect(questionInfo);
        log.info("查询结果, {}",result);
    }

    @Test
    public void selectByIds() {

        List<String> list = new ArrayList<>();
        list.add("1548680829132878993");
        list.add("1549724603125886224");
        List<QuestionInfo> result = questionMapper.selectByIds(list);
        log.info("结果 {}", result);

    }




}
