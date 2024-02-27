package com.sky.controller.user;

import com.sky.context.BaseContext;
import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/shoppingCart")
@Api(tags = "C端-购物车接口")
@Slf4j
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 新增购物车
     *
     * @param shoppingCartDTO
     * @return
     */
    @RequestMapping("/add")
    @ApiOperation("新增购物车")
    public Result add(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        log.info("新增购物车: {}", shoppingCartDTO);
        shoppingCartService.addshoppingCart(shoppingCartDTO);
        return Result.success();
    }
    /**
     * 查询购物车
     *
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("查询购物车")
    public Result<List<ShoppingCart>> list() {
        List<ShoppingCart> list = shoppingCartService.showShoppingCart();
        return Result.success(list);
    }

    /**
     * 删除购物车
     *
     * @return
     */
    @DeleteMapping("/clean")
    @ApiOperation("删除购物车")
    public Result clean() {
        shoppingCartService.cleanShoppingCart();
        return Result.success();
    }

}
