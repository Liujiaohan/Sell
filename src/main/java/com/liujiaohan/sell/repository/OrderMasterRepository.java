package com.liujiaohan.sell.repository;

import com.liujiaohan.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository  extends JpaRepository<OrderMaster,String>{
    Page<OrderMaster> findByBuyerOpenId(String openId, Pageable pageable);
}
