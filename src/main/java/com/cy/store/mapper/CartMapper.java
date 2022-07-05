package com.cy.store.mapper;

import com.cy.store.entity.Cart;

import java.util.Date;

public interface CartMapper {

    /**
     * insert into cart
     * @param cart
     * @return rows been influenced
     */
    Integer insert(Cart cart);

    /**
     * update num for cart
     * @param cid
     * @param num
     * @param modifiedUser
     * @param modifiedTime
     * @return rows been influenced
     */
    Integer updateNumByCid(Integer cid,
                           Integer num,
                           String modifiedUser,
                           Date modifiedTime);

    /**
     *
     * @param uid
     * @param pid
     * @return
     */
    Cart findByUidAndPid(Integer uid, Integer pid);

}