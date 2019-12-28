
package com.zhangxin.exam.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zhangxin.exam.entity.QuestionCategory;
import com.zhangxin.exam.entity.QuestionLevel;
import com.zhangxin.exam.entity.QuestionType;
import lombok.Data;

import java.util.List;

@Data
public class QuestionSelectionVo {
    @JsonProperty("types")
    private List<QuestionType> questionTypeList;

    @JsonProperty("categories")
    private List<QuestionCategory> questionCategoryList;

    @JsonProperty("levels")
    private List<QuestionLevel> questionLevelList;
}
