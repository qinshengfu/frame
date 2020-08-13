package com.qsf.frame.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author qsf
 * @since 2020-08-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_product_img")
public class ProductImg implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "product_img_id", type = IdType.AUTO)
    private Integer productImgId;

    private String imgAddr;

    private Integer productId;

    private String crr;


}
