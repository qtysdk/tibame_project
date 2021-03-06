package com.order.model;

import java.util.*;

import com.order_detail.model.Order_detailVO;

public interface OrderDAO_interface {
	public Object insert(OrderVO orderVO);
	public Object insert2(OrderVO orderVO);
	public OrderVO findByPrimaryKey(Integer order_no);
	public void update(OrderVO orderVO);
	public void delete(Integer order_no);
	public List<OrderVO> getAll();
	public List<OrderVO> getAllByID(String user_id);
	public List<OrderVO> getAllByID2(String seller_id);
	public void updateShipped(List<Integer> list);
	public void updateUnshipped(List<Integer> list);
	public void updateSrating(OrderVO orderVO);
	public void insertWithOrderList(OrderVO orderVO , List<Order_detailVO> list);
	public Set<Order_detailVO> getDetailsByNo(Integer order_no);
	public void cancel(Integer order_no);
}