package com.galaxy.droolspractice.api.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
* Created by Mybatis Generator on 2021/03/23
*/
@Data
@Accessors(chain = true)
public class AdsCrmBrandRelation implements Serializable {

    /**
     * brand_seller_code : 品牌直客销售的唯一码
     */
    private String brandSellerCode;

    private Integer id;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append("id = ").append(id);
        sb.append("品牌直客销售code=").append(brandSellerCode);
        sb.append("]");
        return sb.toString();
    }
}