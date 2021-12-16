package cn.yangwanhao.model.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * BaseQueryPageDto
 *
 * @author 杨万浩
 * @version 1.0.0
 * @date 2020/7/20 14:36
 */

@Data
public class BaseQueryPageDto implements Serializable {

    private static final long serialVersionUID = -3133418092766629129L;

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 页面数据条数
     */
    private Integer pageSize;

    public BaseQueryPageDto() {
        init();
    }

    public BaseQueryPageDto(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    /**
     * init attribute
     */
    private void init() {
        this.pageNum  = 1;
        this.pageSize = 10;
    }

}
