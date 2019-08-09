package org.hzero.api.controller.v1;

import io.choerodon.core.domain.PageInfo;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.hzero.config.SwaggerApiConfig;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import org.hzero.domain.entity.Company;
import org.hzero.domain.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.hzero.mybatis.helper.SecurityTokenHelper;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 公司 管理 API
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
@Api(tags = SwaggerApiConfig.COMPANY)
@RestController("companySiteController.v1")
@RequestMapping("/v1/{organizationId}/companys")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @ApiOperation(value = "公司列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<Page<Company>> list(Company company, @ApiIgnore @SortDefault(value = Company.FIELD_COMPANY_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {


            Page<Company> list = companyRepository.pageAndSort(pageRequest, company);

        return Results.success(list);
    }




//    @ApiOperation(value = "公司分页")
//    @Permission(level = ResourceLevel.SITE)
//    @GetMapping
//    public ResponseEntity<Page<Company>> pageCompany(Company company,PageRequest pageRequest){
//        return Results.success(companyRepository.pageAndSort(pageRequest,company));
//    }

//    @ApiOperation(value = "公司列表 ")
//    @Permission(level = ResourceLevel.SITE)
//    @GetMapping
//    public List<Company> queryCompany(){
//       List<Company> list =  companyRepository.selectAll();
//      return list;
//
//    }




    @ApiOperation(value = "公司明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{companyId}")
    public ResponseEntity<Company> detail(@PathVariable Long companyId) {
        Company company = companyRepository.selectByPrimaryKey(companyId);
        return Results.success(company);
    }

    @ApiOperation(value = "创建公司")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<Company> create(@RequestBody Company company) {
        validObject(company);
        companyRepository.insertSelective(company);
        return Results.success(company);
    }

    @ApiOperation(value = "修改公司")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<Company> update(@RequestBody Company company) {
        SecurityTokenHelper.validToken(company);
        companyRepository.updateByPrimaryKeySelective(company);
        return Results.success(company);
    }

    @ApiOperation(value = "删除公司")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Company company) {
        SecurityTokenHelper.validToken(company);
        companyRepository.deleteByPrimaryKey(company);
        return Results.success();
    }

}
