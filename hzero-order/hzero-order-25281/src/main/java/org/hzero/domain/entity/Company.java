package org.hzero.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;

import io.choerodon.mybatis.domain.AuditDomain;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 公司
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
@ApiModel("公司")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hodr_company")
public class Company extends AuditDomain {

    public static final String FIELD_COMPANY_ID = "companyId";
    public static final String FIELD_COMPANY_NUMBER = "companyNumber";
    public static final String FIELD_COMPANY_NAME = "companyName";
    public static final String FIELD_ENABLED_FLAG = "enabledFlag";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long companyId;
    @ApiModelProperty(value = "公司编号", required = true)
    @NotBlank
    private String companyNumber;
    @ApiModelProperty(value = "公司名称", required = true)
    @NotBlank
    private String companyName;
    @ApiModelProperty(value = "启用标识", required = true)
    @NotNull
    private Integer enabledFlag;

    @ApiModelProperty(value = "版本号", required = true)
    @NotNull
    @Column(name="object_version_number")
    private BigDecimal versionNumber;

    @ApiModelProperty(value = "创建时间", required = true)
    @NotNull
    private Date  creationDate;
    @ApiModelProperty(value = "创建者", required = true)
    @NotNull
    private BigDecimal createBy;
    @ApiModelProperty(value = "更新者", required = true)
    @NotNull
    @Column(name = "last_updated_by")
    private  BigDecimal updatedBy;
    @ApiModelProperty(value = "更新时间", required = true)
    @NotNull
    private  Date lastUpdateDate;

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getCreateBy() {
        return createBy;
    }

    public void setCreateBy(BigDecimal createBy) {
        this.createBy = createBy;
    }

    public BigDecimal getupdatedBy() {
        return updatedBy;
    }

    public void setupdatedBy(BigDecimal updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    @Override
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }


//
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 表ID，主键，供其他表做外键
     */
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * @return 公司编号
     */
    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    /**
     * @return 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return 启用标识
     */
    public Integer getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Integer enabledFlag) {
        this.enabledFlag = enabledFlag;
    }


    public BigDecimal getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(BigDecimal versionNumber) {
        this.versionNumber = versionNumber;
    }
}
