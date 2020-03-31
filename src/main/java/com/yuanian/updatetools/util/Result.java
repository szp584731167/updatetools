package com.yuanian.updatetools.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Szp
 * @version 1.0
 * @date 2020/3/31 16:24
 */
@Getter
@Setter
public class Result {
    /**
     * 接口成功与否
     */
    boolean state;

    /**
     * 接口报错信息或者修改成功、失败等信息
     */
    String message;

    /**
     * 接口返回数据
     */
    Object data;

    public Result() {
    }

    public Result(boolean state, String message) {
        this.state = state;
        this.message = message;
    }

    public Result(boolean state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }


    @Override
    public String toString(){
        return "state:" + state + ", message:" + message + ", data:" + data;
    }

    public static final Result TRUE = new Result(true, "操作成功！");

    public static final Result FALSE = new Result(false, "操作失败！");

    public static final Result INSERT_TRUE = new Result(true, "增加成功");

    public static final Result UPDATE_TRUE = new Result(true, "修改成功");

    public static final Result UPDATE_FALSE = new Result(false, "修改失败，此记录不存在或已被删除！");

    public static final Result DELETE_FALSE = new Result(false, "删除失败，此记录不存在或已被删除！");

    public static final Result FALSE_NO_WARRANT = new Result(false, "抱歉，您没有权限操作！");



    public static Result trueState(String message) {
        return new Result(true, message);
    }

    public static Result trueState(String message, Object data) {
        return new Result(true, message, data);
    }

    public static Result deleteTrueState() {
        return trueState("删除成功");
    }

    public static Result deleteTrueState(Object data) {
        return trueState("删除成功", data);
    }

    public static Result addTrueState() {
        return trueState("增加成功");
    }

    public static Result addTrueState(Object data) {
        return trueState("增加成功", data);
    }

    public static Result updateTrueState() {
        return trueState("修改成功");
    }

    public static Result updateTrueState(Object data) {
        return trueState("修改成功", data);
    }

    public static Result seachTrueState() {
        return trueState("查询成功");
    }

    public static Result searchTrueState(Object data) {
        return trueState("查询成功", data);
    }

    public static Result falseState(String message) {
        return new Result(false, message);
    }

    public static Result falseState(Throwable t) {
        return new Result(false, t.getMessage());
    }

    public static Result falseState(Throwable t, Object data) {
        return new Result(false, t.getMessage(), data);
    }

    public static Result falseState(String message, Object data) {
        return new Result(false, message, data);
    }

    public static Result deleteFalseState() {
        return falseState("删除失败");
    }

    public static Result deleteFalseState(Object data) {
        return falseState("删除失败", data);
    }

    public static Result addFalseState() {
        return falseState("增加失败");
    }

    public static Result addFalseState(Object data) {
        return falseState("增加失败", data);
    }

    public static Result updateFalseState() {
        return falseState("修改失败");
    }
    public static Result updateFalseState2() {
        return falseState("归还失败");
    }
    public static Result updateFalseState(Object data) {
        return falseState("修改失败", data);
    }

    public static Result searchFalseState() {
        return falseState("查询失败");
    }

    public static Result searchFalseState(Object data) {
        return falseState("查询失败", data);
    }

}
