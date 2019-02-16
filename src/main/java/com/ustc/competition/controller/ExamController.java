package com.ustc.competition.controller;

import com.ustc.competition.VO.ExamVO;
import com.ustc.competition.VO.ResultVO;
import com.ustc.competition.converter.TestMaster2ExamVO;
import com.ustc.competition.dataobject.TestMaster;
import com.ustc.competition.enums.ResultEnum;
import com.ustc.competition.exception.CompetitionException;
import com.ustc.competition.service.ExamService;
import com.ustc.competition.utils.KeyUtil;
import com.ustc.competition.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yihangZhou
 * @create 2019-02-16 14:05
 */
@RestController
@RequestMapping("/exam")
@Slf4j
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping("/list")
    public ResultVO list(@RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "limit", defaultValue = "10") Integer limit) {

        List<ExamVO> examVOList = examService.findAll(page, limit);


        Map<String, Object> map = new HashMap<>();
        map.put("total", examVOList.size());
        map.put("items", examVOList);

        return ResultVOUtil.success(map);

    }

    @GetMapping("/index")
    public ResultVO index(@RequestParam(value = "page", defaultValue = "0") Integer page,
                          @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                          @RequestParam("title") String title,
                          @RequestParam("status") String status) {

        List<ExamVO> examVOList = examService.findAllBySelect(page, limit, title, status);
        Map<String, Object> map = new HashMap<>();
        map.put("total", examVOList.size());
        map.put("items", examVOList);

        return ResultVOUtil.success(map);

    }

    @PostMapping("/create")
    public ResultVO create(@Valid ExamVO examVO, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            log.error("表单参数不正确");
            throw new CompetitionException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        String id = KeyUtil.genUniqueKey();
        examVO.setId(id);
        examService.save(examVO);
        Map<String, String> map = new HashMap<>();
        map.put("id", id);

        return ResultVOUtil.success(map);
    }

    @PutMapping("/modify")
    public ResultVO modify(@Valid ExamVO examVO, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            log.error("表单参数不正确");
            throw new CompetitionException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        examService.modify(examVO);

        return ResultVOUtil.success();

    }

    @DeleteMapping("/delete")
    public ResultVO delete(@RequestParam("id") String testId) {

        examService.delete(testId);
        return ResultVOUtil.success();

    }

}
