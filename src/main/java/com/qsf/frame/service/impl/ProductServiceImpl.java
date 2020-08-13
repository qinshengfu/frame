package com.qsf.frame.service.impl;

import com.qsf.frame.domain.Product;
import com.qsf.frame.mapper.ProductMapper;
import com.qsf.frame.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qsf
 * @since 2020-08-13
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
