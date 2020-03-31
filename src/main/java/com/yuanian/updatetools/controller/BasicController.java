package com.yuanian.updatetools.controller;

import com.yuanian.updatetools.service.ExecuteShellService;
import com.yuanian.updatetools.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Szp
 * @version 1.0
 * @date 2020/3/10 14:25
 */
@RestController
@RequestMapping("/shell")
public class BasicController {

    @Autowired
    private ExecuteShellService shellService;

    @RequestMapping(value = "/startTomcat",method = RequestMethod.GET)
    public Result startTomcat(String path){
        try {
            shellService.startTomcat(path);
            return Result.trueState("执行成功");
        } catch (IOException e) {
            return Result.falseState(e.getMessage());
        }
    }

    @RequestMapping(value = "/stopTomcat",method = RequestMethod.GET)
    public Result stopTomcat(String path){
        try {
            shellService.stopTomcat(path);
            return Result.trueState("执行成功");
        } catch (IOException e) {
            return Result.falseState(e.getMessage());
        }
    }

    @RequestMapping(value = "/restartTomcat",method = RequestMethod.GET)
    public Result restartTomcat(@RequestParam(value = "stopPath") String stopPath,
                                @RequestParam("startPath") String startPath){
        try {
            shellService.restartTomcat(stopPath,startPath);
            return Result.trueState("执行成功");
        } catch (IOException e) {
            return Result.falseState(e.getMessage());
        }
    }
}
