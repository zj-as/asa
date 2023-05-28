package pers.zj.asa.module.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.zj.asa.framework.common.pojo.CommonResult;
import pers.zj.asa.module.test.controller.vo.TestReqVO;

/**
 * <p>测试控制器</p><br/>
 *
 * @author asa
 * @since 1.0.1
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @PostMapping("/jsonParam")
    public CommonResult<?> jsonParam(@RequestBody TestReqVO reqVO) {
        log.info("jsonParam reqVO ：{}", reqVO.toString());
        return CommonResult.success("jsonParam");
    }

}
