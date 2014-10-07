package com.moke.jpa.ordermanager.dao;

import java.sql.Date;
import java.util.List;

import com.moke.jpa.ordermanager.entity.Order;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.VoidType;

/**
 * @用户想要如何操作order
 * 
 * 		0. 用户想要按一定要求查找订单
 * 					用户想要查看所有的订单
 * 					用户想要根据生成时间查找订单
 * 					用户想要根据最需要付款时间查找订单
 * 					用户想要根据已付款的的订单信息
 * 		1. 用户想要获订单信息
 * 			
 * 		2. 用户想要修改订单信息
 * 					用户想要修改订单的送货地址
 * 					用户想要修改订单的付款方式
 * 					用户想要修改订单的到货时间
 * 					用户想要修改订单的发票抬头
 * 		3. 用户想要新增一个订单
 * 		4. 用户想要删除一个订单
 * 
 * @author L 
 * @time     2014年10月2日 下午10:56:52
 * 
 *
 */
public interface OrderDao {
	
	public List<Order> queryByAll();
	public List<Order> queryByDealedTime(Order order);
	public List<Order> queryByPaidTime(Order order);
	public List<Order> queryByNeedPaidTime(Order order);
 	
	public Order getOrderById(Integer id);
	
	public void updateOrderOnAddrress(Order order);
	public void updateOrderOnPaidType(Order order);
	public void updateOrderOnArrivedDate(Order order);
	public void updateOrderOnChecksName(Order order);

	public void createAnOder(Order order) ;
	
	public void deleteOrder(Order order);
	public void deleteOrder(Integer id);
}
