package org.hzero.api.dto;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hzero.core.util.Regexs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xuejun zhu
 * @create 2019-08-06 15:08
 */
@ApiModel("修改订单参数")
public class OrderArgUpdateRecode {


	@ApiModelProperty(value = "表头id",required = true)
	private Long soHeaderId;
	@ApiModelProperty(value = "公司id",required = true)
	private Long companyId;
	@ApiModelProperty(value = "客户id",required = true)
	private Long customerId;
	@ApiModelProperty(value = "物料id",required = true)
	private Long itemId;
	@ApiModelProperty(value = "行号",required = true)
	private Long lineNumber;
	@ApiModelProperty(value = "订单日期",required = true)
	private Date orderDate;
	@ApiModelProperty(value = "商品数量",required = true)
	@Pattern(regexp = Regexs.POSITIVE_NUMBER)
	private Long orderQuantity;
	@ApiModelProperty(value = "商品单价",required = true)
	private Long unitSellingPrice;

	public Long getSoHeaderId() {
		return soHeaderId;
	}

	public void setSoHeaderId(Long soHeaderId) {
		this.soHeaderId = soHeaderId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Long getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Long orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Long getUnitSellingPrice() {
		return unitSellingPrice;
	}

	public void setUnitSellingPrice(Long unitSellingPrice) {
		this.unitSellingPrice = unitSellingPrice;
	}

	public Long getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Long lineNumber) {
		this.lineNumber = lineNumber;
	}

	@Override
	public String toString() {
		return "OrderArgUpdateRecode{" +
				"soHeaderId=" + soHeaderId +
				", companyId=" + companyId +
				", customerId=" + customerId +
				", itemId=" + itemId +
				", orderDate=" + orderDate +
				", orderQuantity=" + orderQuantity +
				", unitSellingPrice=" + unitSellingPrice +
				'}';
	}
}
