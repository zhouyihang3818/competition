package com.ustc.competition.repository;

import com.ustc.competition.dataobject.QuestionInfo;
import com.ustc.competition.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author yihangZhou
 * @create 2019-01-28 20:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionInfoRepositoryTest {

    @Autowired
    private QuestionInfoRepository questionInfoRepository;

    @Test
    public void save(){
        QuestionInfo questionInfo = new QuestionInfo();
        questionInfo.setQuestionId(KeyUtil.genUniqueKey());
        questionInfo.setQuestionContent("Java 语言中创建一个对象使用的关键字是（）");
        questionInfo.setQuestionType("单选");
        questionInfo.setQuestionGroup("Java");
        questionInfo.setQuestionDifficulty(1);
        questionInfo.setQuestionStatus(0);
        questionInfo.setQuestionSelectA("class");
        questionInfo.setQuestionSelectB("interface");
        questionInfo.setQuestionSelectC("new");
        questionInfo.setQuestionSelectD("create");
        questionInfo.setQuestionAnswer("C");
        QuestionInfo result = questionInfoRepository.save(questionInfo);
        Assert.assertNotNull(result);
    }

}
