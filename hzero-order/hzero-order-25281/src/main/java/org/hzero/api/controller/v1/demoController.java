package org.hzero.api.controller.v1;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xuejun zhu
 * @create 2019-08-05 15:39
 */
@ResponseBody
public class demoController {

    @GetMapping
    @Permission(level = ResourceLevel.SITE,permissionLogin = true)
    public ResponseEntity<String> hello (){
        return new ResponseEntity<>("hello hzero!", HttpStatus.OK);
    }
}
