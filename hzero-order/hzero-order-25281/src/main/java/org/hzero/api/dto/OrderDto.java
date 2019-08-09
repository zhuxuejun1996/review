
package org.hzero.api.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hzero.core.base.BaseConstants;
import org.hzero.export.annotation.ExcelColumn;
import org.hzero.export.annotation.ExcelSheet;
import org.hzero.export.render.ValueRenderer;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel("订单")
@ExcelSheet(zh = "销售订单", en = "Sales Order")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {

    public static final String FIELD_ORDER_NUMBER = "orderNumber";

    @ApiModelProperty(value = "订单编号")
    @ExcelColumn(zh = "订单编号", en = "order_number", showInChildren = true)
    private String orderNumber;

    @ApiModelProperty(value = "公司名称")
    @ExcelColumn(zh = "公司名称", en = "company_name")
    private String companyName;

    @ApiModelProperty(value = "客户名称")
    @ExcelColumn(zh = "客户名称", en = "customer_name")
    private String customerName;

    @ApiModelProperty(hidden = true)
    @ExcelColumn(zh = "订单日期", en = "order_date", pattern = BaseConstants.Pattern.DATE)
    private Date orderDate;

    @ApiModelProperty(value = "订单状态")
    @ExcelColumn(zh = "订单状态", en = "order_status")
    private String orderStatus;

    @ApiModelProperty(hidden = true)
    @ExcelColumn(zh = "行号", en = "line_number")
    private String lineNumber;

    @ApiModelProperty(value = "物料")
    @ExcelColumn(zh = "物料编码", en = "item_code", order = 4)
    private String itemCode;

    @ApiModelProperty(hidden = true)
    @ExcelColumn(zh = "数量", en = "order_quantity")
    private Long orderQuantity;

    @ApiModelProperty(hidden = true)
    @ExcelColumn(zh = "数量单位", en = "order_quantity_uom")
    private String orderquantityUom;

    @ApiModelProperty(hidden = true)
    @ExcelColumn(zh = "销售单价", en = "unit_selling_price")
    private BigDecimal unitSellingPrice;

    @ApiModelProperty(hidden = true)
    @ExcelColumn(zh = "订单金额", en = "netAmount", pattern = BaseConstants.Pattern.TB_ONE_DECIMAL)
    private BigDecimal netAmount;

    @ApiModelProperty(hidden = true)
    @ExcelColumn(zh = "行金额", en = "netAmount", pattern = BaseConstants.Pattern.TB_ONE_DECIMAL)
    private  BigDecimal lineAmount;

    @ApiModelProperty(hidden = true)
    @ExcelColumn(zh = "备注", en = "description", renderers = RemarkValueRenderer.class)
    private String itemDescription;


    public class RemarkValueRenderer implements ValueRenderer {
        @Override
        public Object render(Object value, Object data) {
            OrderDto dto = (OrderDto) data;
            return "显示备注：" + dto.itemDescription;
        }
    }

// getter/setter




    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Long getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Long orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderquantityUom() {
        return orderquantityUom;
    }

    public void setOrderquantityUom(String orderquantityUom) {
        this.orderquantityUom = orderquantityUom;
    }

    public BigDecimal getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getLineAmount() {
        return lineAmount;
    }

    public void setLineAmount(BigDecimal lineAmount) {
        this.lineAmount = lineAmount;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public OrderDto() {
    }

    public OrderDto(String orderNumber, String companyName, String customerName, Date orderDate, String orderStatus, String lineNumber, String itemCode, Long orderQuantity, String orderquantityUom, BigDecimal unitSellingPrice, BigDecimal netAmount, BigDecimal lineAmount, String itemDescription) {
        this.orderNumber = orderNumber;
        this.companyName = companyName;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.lineNumber = lineNumber;
        this.itemCode = itemCode;
        this.orderQuantity = orderQuantity;
        this.orderquantityUom = orderquantityUom;
        this.unitSellingPrice = unitSellingPrice;
        this.netAmount = netAmount;
        this.lineAmount = lineAmount;
        this.itemDescription = itemDescription;
    }
}