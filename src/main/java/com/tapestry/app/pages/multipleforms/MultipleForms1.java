package com.tapestry.app.pages.multipleforms;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;

import com.tapestry.app.pages.multipleforms.MultipleForms2.SearchType;

public class MultipleForms1 {

	@Property
	private String customerName;
	
	@Property
	private String supplierName;
	
	@InjectPage
	private MultipleForms2 page2;
	
	void onPrepareFromSearchCustomers() {
		// 可初始化 Customers表单元素
	}
	
	void onPrepareFromSearchSuppliers() {
		// 可初始化Suppliers表单元素
	}
	
	Object onSuccessFromSearchCustomers() {
		page2.set(SearchType.CUSTOMERS, customerName);
		return page2;
	}
	
	Object onSuccessFromSearchSuppliers() {
		page2.set(SearchType.SUPPLIERS, supplierName);
		return page2;
	}
}
