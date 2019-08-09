package org.hzero.app.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;import com.fasterxml.jackson.databind.ObjectMapper;
import org.hzero.boot.imported.app.service.IBatchImportService;
import org.hzero.boot.imported.infra.validator.annotation.ImportService;
import org.hzero.domain.entity.SoHeader;
import org.hzero.domain.entity.SoLine;
import org.hzero.domain.repository.SoHeaderRepository;
import org.hzero.domain.repository.SoLineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author xuejun zhu
 * @create 2019-08-08 11:19
 */


//@ImportService(templateCode = "TEST1")
public class ImportServiceImpl  implements IBatchImportService {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private  SoHeaderRepository soHeaderRepository;

    @Autowired
    private  SoLineRepository soLineRepository;


    @Override
    public Boolean doImport(List<String> data) {
        // 获取自定义参数
        Map<String, Object> args = getArgs();
        // do import

        for(String oneData:data){
            SoHeader soHeader = null;
            SoLine soLine = null;
            try {
                soHeader = objectMapper.readValue(oneData,SoHeader.class);
                soLine = objectMapper.readValue(oneData,SoLine.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            soHeaderRepository.insertSelective(soHeader);
            soLineRepository.insertSelective(soLine);

        }
        return true;
    }

    @Override
    public int getSize(){
        return 500;
    }
}