package org.hzero.config;

import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hzero.boot.imported.infra.constant.HimpBootConstants;
import org.hzero.boot.imported.infra.validator.annotation.ImportValidator;
import org.hzero.boot.imported.infra.validator.annotation.ImportValidators;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author xuejun zhu
 * @create 2019-08-08 14:17
 */
@ImportValidators({
        @ImportValidator(templateCode = "ORDER")
})
public class ImportValidatorTest extends ValidatorHandler<String> {


//    private ObjectMapper objectMapper;
//    @Autowired
//    private CapacityConfigRepository capacityConfigRepository;

    @Override
    public boolean validate(ValidatorContext context, String data) {
        // 获取自定义参数
        Map args = context.getAttribute(HimpBootConstants.ARGS, Map.class);

        // do something
        return true;
    }
}
