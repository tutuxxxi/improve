package com.gfr.improve.controller;

import com.gfr.improve.entity.Body;
import com.gfr.improve.entity.User;
import com.gfr.improve.result.ResponseCode;
import com.gfr.improve.result.ResponseData;
import com.gfr.improve.service.BodyService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Body)表控制层
 *
 * @author makejava
 * @since 2021-01-18 13:47:19
 */
@RestController
@RequestMapping("body")
public class BodyController {
    /**
     * 服务对象
     */
    @Resource
    private BodyService bodyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    public ResponseData selectOne(String id) {
        Body body = this.bodyService.queryById(id);
        if(body != null){
            return new ResponseData(ResponseCode.SUCCESS, body);
        }
        return new ResponseData(ResponseCode.FAILED);
    }

    @ApiOperation(value = "queryAll", notes = "查询所有的身体信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "page", value = "需要查询的页数", dataType = "int"),
                    @ApiImplicitParam(name = "limit", value = "每页查询的数据量", dataType = "int")
            }
    )
    @GetMapping("queryAll")
    public ResponseData queryAll(int page, int limit){
        return bodyService.queryAllByLimit((page-1)*limit, limit);
    }

    @ApiOperation(value = "deleteById", notes = "删除对应id的身体数据")
    @ApiImplicitParam(name = "userId", value = "需要删除身体数据的用户id")
    @DeleteMapping("deleteById/{userId}")
    public ResponseData deleteById(@PathVariable("userId") String userId){
        return new ResponseData(ResponseCode.SUCCESS, bodyService.deleteById(userId));
    }

    @ApiOperation(value = "queryByLike",notes = "模糊查询")
    @ApiImplicitParam(name = "value",value = "类型,标题")
    @GetMapping("queryByLike")
    public  ResponseData queryByLike(String value,Integer page,Integer limit){
        return bodyService.queryByLike(value, page, limit);
    }

    @ApiOperation(value = "updateBody", notes = "更新身体信息")
    @ApiImplicitParam(name = "body", value = "身体信息")
    @PatchMapping("updateBody")
    public  ResponseData updateBody(@RequestBody Body body){
        return bodyService.updateBody(body);
    }


    @ApiOperation(value = "deleteUsers", notes = "批量删除身体信息")
    @ApiImplicitParam(name = "userIdList", value = "用户ID")
    @DeleteMapping("deleteBodys")
    public ResponseData deleteBodys(@RequestBody List<String> userIdList){
        return bodyService.deleteBodys(userIdList);
    }

    @ApiOperation(value = "addBody", notes = "添加身体信息")
    @ApiImplicitParam(name = "body", value = "身体信息")
    @PostMapping("addBody")
    public  ResponseData addBody(@RequestBody Body body){
        return bodyService.addBody(body);
    }
}