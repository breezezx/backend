package com.zhangxin.exam.controller;

import com.zhangxin.exam.entity.Exam;
import com.zhangxin.exam.entity.ExamRecord;
import com.zhangxin.exam.service.ExamService;
import com.zhangxin.exam.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
public class QuestionController {
    @Autowired
    private ExamService examService;

    @GetMapping("/question/list")
    @ApiOperation("获取问题的列表")
    ResultVO<QuestionPageVo> getQuestionList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        ResultVO<QuestionPageVo> resultVO;
        try {
            QuestionPageVo questionPageVo = examService.getQuestionList(pageNo, pageSize);
            resultVO = new ResultVO<>(0, "获取问题列表成功", questionPageVo);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = new ResultVO<>(-1, "获取问题列表失败", null);
        }
        return resultVO;
    }

    @PostMapping("/question/update")
    @ApiOperation("更新问题")
    ResultVO<String> questionUpdate(@RequestBody QuestionVo questionVo) {
        // 完成问题的更新
        System.out.println(questionVo);
        try {
            examService.updateQuestion(questionVo);
            return new ResultVO<>(0, "更新问题成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVO<>(-1, "更新问题失败", null);
        }
    }

    @PostMapping("/question/create")
    @ApiOperation("创建问题")
    ResultVO<String> questionCreate(@RequestBody QuestionCreateSimplifyVo questionCreateSimplifyVo, HttpServletRequest request) {
        QuestionCreateVo questionCreateVo = new QuestionCreateVo();
        // 把能拷贝过来的属性都拷贝过来
        BeanUtils.copyProperties(questionCreateSimplifyVo, questionCreateVo);
        // 设置创建者信息
        String userId = (String) request.getAttribute("user_id");
        questionCreateVo.setQuestionCreatorId(userId);
        System.out.println(questionCreateVo);
        try {
            examService.questionCreate(questionCreateVo);
            return new ResultVO<>(0, "问题创建成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVO<>(-1, "创建问题失败", null);
        }
    }

    @GetMapping("/question/selection")
    @ApiOperation("获取问题分类的相关选项")
    ResultVO<QuestionSelectionVo> getSelections() {
        QuestionSelectionVo questionSelectionVo = examService.getSelections();
        if (questionSelectionVo != null) {
            return new ResultVO<>(0, "获取问题分类选项成功", questionSelectionVo);
        } else {
            return new ResultVO<>(-1, "获取问题分类选项失败", null);
        }
    }

    @GetMapping("/question/detail/{id}")
    @ApiOperation("根据问题的id获取问题的详细信息")
    ResultVO<QuestionDetailVo> getQuestionDetail(@PathVariable String id) {
        //  根据问题id获取问题的详细信息
        System.out.println(id);
        ResultVO<QuestionDetailVo> resultVO;
        try {
            QuestionDetailVo questionDetailVo = examService.getQuestionDetail(id);
            resultVO = new ResultVO<>(0, "获取问题详情成功", questionDetailVo);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = new ResultVO<>(-1, "获取问题详情失败", null);
        }
        return resultVO;
    }
}
