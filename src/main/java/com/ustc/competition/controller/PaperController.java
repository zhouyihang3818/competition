package com.ustc.competition.controller;

import com.ustc.competition.VO.PaperInfoVO;
import com.ustc.competition.VO.PaperVO;
import com.ustc.competition.VO.ResultVO;
import com.ustc.competition.dataobject.PaperInfo;
import com.ustc.competition.dataobject.PaperQuestion;
import com.ustc.competition.dataobject.QuestionInfo;
import com.ustc.competition.enums.ResultEnum;
import com.ustc.competition.exception.CompetitionException;
import com.ustc.competition.form.PaperForm;
import com.ustc.competition.service.PaperService;
import com.ustc.competition.service.QuestionService;
import com.ustc.competition.utils.KeyUtil;
import com.ustc.competition.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yihangZhou
 * @create 2019-02-11 14:40
 */
@RestController
@RequestMapping("/paper")
@Slf4j
public class PaperController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private QuestionService questionService;

    //点击试卷管理列表
    @GetMapping("/detail")
    public ResultVO detail(@RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "limit", defaultValue = "10") Integer limit) {

        List<PaperInfo> paperInfoList = paperService.findAll(page, limit);
        List<PaperQuestion> paperQuestionList = paperService.selectAll();

        //获取每个试卷的所有题号
        List<PaperInfoVO> paperInfoVOList = new ArrayList<>();
        for(PaperInfo paperInfo : paperInfoList) {
            PaperInfoVO paperInfoVO = new PaperInfoVO();
            BeanUtils.copyProperties(paperInfo, paperInfoVO);
            List<String> list = new ArrayList<>();
            for(PaperQuestion paperQuestion : paperQuestionList) {
                if(paperQuestion.getPaperId().equals(paperInfo.getPaperId())) {
                    list.add(paperQuestion.getQuestionId());
                }
            }
            paperInfoVO.setQuestionIds(list);
            paperInfoVOList.add(paperInfoVO);
        }

        PaperVO paperVO = new PaperVO();
        paperVO.setTotal(paperInfoVOList.size());
        paperVO.setItems(paperInfoVOList);

        return ResultVOUtil.success(paperVO);
    }

    //搜索栏输入数据并搜索
    @GetMapping("/index")
    public ResultVO index(@RequestParam(value = "page", defaultValue = "0") Integer page,
                          @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                          @Valid PaperInfo paperInfo,
                          BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            log.error("表单参数不正确");
            throw new CompetitionException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        List<PaperInfo> paperInfoList = paperService.findAllBySelect(page, limit, paperInfo);
        List<PaperQuestion> paperQuestionList = paperService.selectAll();

        //获取每个试卷的所有题号
        List<PaperInfoVO> paperInfoVOList = new ArrayList<>();
        for(PaperInfo p : paperInfoList) {
            PaperInfoVO paperInfoVO = new PaperInfoVO();
            BeanUtils.copyProperties(p, paperInfoVO);
            List<String> list = new ArrayList<>();
            for(PaperQuestion paperQuestion : paperQuestionList) {
                if(paperQuestion.getPaperId().equals(p.getPaperId())) {
                    list.add(paperQuestion.getQuestionId());
                }
            }
            paperInfoVO.setQuestionIds(list);
            paperInfoVOList.add(paperInfoVO);
        }

        PaperVO paperVO = new PaperVO();
        paperVO.setTotal(paperInfoVOList.size());
        paperVO.setItems(paperInfoVOList);

        return ResultVOUtil.success(paperVO);
    }

    //考试管理里的特殊请求--请求试卷名称列表
    @GetMapping("/list")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "limit", defaultValue = "10") Integer limit) {

        List<PaperInfo> paperInfoList = paperService.findAll(page, limit);
        List<String> paperTitleList = paperInfoList.stream().map(e->e.getTitle()).collect(Collectors.toList());

        return ResultVOUtil.success(paperTitleList);

    }

    //点击新建对话框的提交按钮
    @PostMapping("/create")
    public ResultVO create(@Valid PaperForm paperForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            log.error("表单参数不正确");
            throw new CompetitionException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        List<QuestionInfo> questionInfoList = questionService.findAllByIds(paperForm.getList());
        //计算难度
        Integer difficulty = 0;
        for(QuestionInfo questionInfo : questionInfoList) {
            difficulty += questionInfo.getQuestionDifficulty();
        }
        if(questionInfoList.size() != 0) {
            difficulty = difficulty/questionInfoList.size();
        }
        paperForm.setDifficulty(difficulty);

        String paperId = KeyUtil.genUniqueKey();
        paperForm.setId(paperId);
        Integer result = paperService.save(paperForm);
        if(result == 0) {
            throw new CompetitionException(ResultEnum.PAPER_CREATE_FAIL);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("id", paperId);
        map.put("difficulty", difficulty);

        return ResultVOUtil.success(map);
    }

    @PutMapping("/modify")
    public ResultVO modify(@Valid PaperForm paperForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            log.error("表单参数不正确");
            throw new CompetitionException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        List<QuestionInfo> questionInfoList = questionService.findAllByIds(paperForm.getList());
        //计算难度
        Integer difficulty = 0;
        for(QuestionInfo questionInfo : questionInfoList) {
            difficulty += questionInfo.getQuestionDifficulty();
        }
        if(questionInfoList.size() != 0) {
            difficulty = difficulty/questionInfoList.size();
        }
        paperForm.setDifficulty(difficulty);

        Integer result = paperService.modify(paperForm);
        if(result == 0) {
            throw new CompetitionException(ResultEnum.PAPER_MODIFY_FAIL);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("difficulty", difficulty);

        return ResultVOUtil.success(map);
    }

    @DeleteMapping("/delete")
    public ResultVO delete(@RequestParam("id") String paperId) {

        Integer result = paperService.delete(paperId);
        if(result == 0) {
            throw new CompetitionException(ResultEnum.PAPER_DELETE_FAIL);
        }

        return ResultVOUtil.success();

    }

}
