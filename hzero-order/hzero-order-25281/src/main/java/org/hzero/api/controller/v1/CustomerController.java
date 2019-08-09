package org.hzero.api.controller.v1;

import io.swagger.annotations.Api;
import org.hzero.app.service.CustomerService;
import org.hzero.config.SwaggerApiConfig;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import org.hzero.domain.entity.Customer;
import org.hzero.domain.repository.CustomerRepository;
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
 * 客户 管理 API
 *
 * @author xuejun.zhu@china-hand.com 2019-08-05 11:38:52
 */
@Api(tags = SwaggerApiConfig.CUSTMOMER)
@RestController("customerSiteController.v1")
@RequestMapping("/v1/{organizationId}/customers")
public class CustomerController extends BaseController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService service;

    @ApiOperation(value = "客户列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<Page<Customer>> list(Customer customer, @ApiIgnore @SortDefault(value = Customer.FIELD_CUSTOMER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Customer> list = customerRepository.pageAndSort(pageRequest, customer);
        return Results.success(list);
    }

    @ApiOperation(value = "客户明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> detail(@PathVariable Long customerId) {
        Customer customer = customerRepository.selectByPrimaryKey(customerId);
        return Results.success(customer);
    }

    @ApiOperation(value = "创建客户")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        validObject(customer);
        customerRepository.insertSelective(customer);
        return Results.success(customer);
    }

    @ApiOperation(value = "修改客户")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        SecurityTokenHelper.validToken(customer);
        customerRepository.updateByPrimaryKeySelective(customer);
        return Results.success(customer);
    }

    @ApiOperation(value = "删除客户")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Customer customer) {
        SecurityTokenHelper.validToken(customer);
        customerRepository.deleteByPrimaryKey(customer);
        return Results.success();
    }

    @ApiOperation(value = "根据公司查询客户")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/he")
    public List<Customer> selCustomer( @RequestParam  String companyId){
        return service.selCustomer(companyId);

    }

}
