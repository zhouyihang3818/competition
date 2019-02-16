package com.ustc.competition.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 文章表
 * @author yihangZhou
 * @create 2019-01-29 21:47
 */
@Entity
@Data
public class ArticleInfo {

    /** 文章id */
    @Id
    private String articleId;

    /** 文章名称 */
    private String articleName;

    /** 文章内容 */
    private String articleContent;

}
