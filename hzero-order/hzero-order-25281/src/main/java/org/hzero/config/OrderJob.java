package org.hzero.config;

import java.util.List;
import java.util.Map;

import org.hzero.boot.scheduler.infra.annotation.JobHandler;
import org.hzero.boot.scheduler.infra.enums.ReturnT;
import org.hzero.boot.scheduler.infra.handler.IJobHandler;
import org.hzero.boot.scheduler.infra.tool.SchedulerTool;
import org.hzero.domain.entity.SoHeader;
import org.hzero.domain.repository.SoHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xuejun zhu
 * @create 2019-08-08 22:21
 */
@JobHandler("orderjob")
public class OrderJob implements IJobHandler {

    @Autowired
    private SoHeaderRepository soHeaderRepository;

    @Override
    public ReturnT execute(Map<String, String> map, SchedulerTool tool) {
        // 刷新任务进度及描述]
        tool.updateProgress(50, "任务执行中...");

        List<SoHeader> hodrSoHeaderList = soHeaderRepository.select("orderStatus", "APPROVED");

        for (SoHeader hodrSoHeader:hodrSoHeaderList
             ) {
            hodrSoHeader.setOrderStatus("CLOSED");
            soHeaderRepository.updateByPrimaryKey(hodrSoHeader);
        }

        // 任务日志记录
        tool.info("订单状态设置任务执行成功！");
        return ReturnT.SUCCESS;
    }
}