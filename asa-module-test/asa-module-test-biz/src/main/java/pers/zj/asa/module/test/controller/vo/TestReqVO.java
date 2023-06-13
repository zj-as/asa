package pers.zj.asa.module.test.controller.vo;

import lombok.Data;

/**
 * <p>测试 Request VO</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
@Data
public class TestReqVO {

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private Character sex;

    /**
     * 年龄
     */
    private Integer age;

}
