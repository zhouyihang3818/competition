package com.ustc.competition.controller;

import com.ustc.competition.VO.QuestionVO;
import com.ustc.competition.VO.ResultVO;
import com.ustc.competition.dataobject.QuestionInfo;
import com.ustc.competition.enums.ResultEnum;
import com.ustc.competition.exception.CompetitionException;
import com.ustc.competition.form.QuestionForm;
import com.ustc.competition.form.QuestionInfoForm;
import com.ustc.competition.service.QuestionService;
import com.ustc.competition.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-02-01 20:49
 */
@RestController
@RequestMapping("/question")
@Slf4j
public class AdminQuestionController {

    @Autowired
    private QuestionService questionService;

    //点击试题管理列表
    @GetMapping("/list")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "limit", defaultValue = "5") Integer limit){
        List<QuestionInfo> questionInfoList = questionService.findAll(page, limit);
        QuestionVO questionVO = new QuestionVO();
        questionVO.setTotal(questionInfoList.size());
        questionVO.setItems(questionInfoList);
        return ResultVOUtil.success(questionVO);
    }

    //搜索栏输入数据并搜索
    @GetMapping("/index")
    public ResultVO index(@Valid QuestionForm questionForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()) {
            log.error("表单参数不正确");
            throw new CompetitionException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        List<QuestionInfo> questionInfoList = questionService.findAllBySelect(questionForm);
        QuestionVO questionVO = new QuestionVO();
        questionVO.setTotal(questionInfoList.size());
        questionVO.setItems(questionInfoList);
        return ResultVOUtil.success(questionVO);
    }

    //点击新建对话框的提交按钮
    @PostMapping("/save")
    public ResultVO save(@Valid QuestionInfoForm questionInfoForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            log.error("表单参数不正确");
            throw new CompetitionException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        String questionId = questionService.save(questionInfoForm);
        return ResultVOUtil.success(questionId);

    }

    //点击修改对话框的提交按钮
    @PutMapping("/modify")
    public ResultVO modify(@Valid QuestionInfoForm questionInfoForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            log.error("表单参数不正确");
            throw new CompetitionException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        questionService.modify(questionInfoForm);
        return ResultVOUtil.success();

    }

    //点击删除按钮
    @DeleteMapping("/delete")
    public ResultVO delete(@RequestParam("id") String questionId) {

        questionService.delete(questionId);
        return ResultVOUtil.success();

    }

    //试卷管理里的特殊请求--获取试卷的试题列表
    @GetMapping("/detail")
    public ResultVO detail(@RequestParam(value = "page", defaultValue = "0") Integer page,
                           @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                           @RequestParam("paperId") String paperId) {

        List<QuestionInfo> questionInfoList = questionService.findAllByPaperid(paperId, page, limit);
        QuestionVO questionVO = new QuestionVO();
        questionVO.setTotal(questionInfoList.size());
        questionVO.setItems(questionInfoList);

        return ResultVOUtil.success(questionVO);

    }

    //试卷管理里的特殊请求--配置试卷的题库列表
    @GetMapping("/configuration")
    public ResultVO configuration(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                  @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                  @RequestParam("keyword") String keyword) {
        List<QuestionInfo> questionInfoList = questionService.findAllByKeyword(keyword, page, limit);
        QuestionVO questionVO = new QuestionVO();
        questionVO.setTotal(questionInfoList.size());
        questionVO.setItems(questionInfoList);

        return ResultVOUtil.success(questionVO);
    }

}
