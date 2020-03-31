package com.yuanian.updatetools.service.impl;

import com.yuanian.updatetools.service.ExecuteShellService;
import com.yuanian.updatetools.util.ExecuteShellUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Szp
 * @version 1.0
 * @date 2020/3/10 14:18
 */
@Service
public class ExecuteShellServiceImpl implements ExecuteShellService {
    @Override
    public void stopTomcat(String path) throws IOException {
        int i = ExecuteShellUtils.toExecuteShell(path, null);

        result(i);
    }

    @Override
    public void startTomcat(String path) throws IOException {
        int i = ExecuteShellUtils.toExecuteShell(path, null);
        result(i);
    }

    @Override
    public void restartTomcat(String stopPath, String startPath) throws IOException {
        stopTomcat(startPath);
        startTomcat(startPath);

    }


    private void result(int i){
        if (0 != i) {
            throw new RuntimeException("执行失败，详情请咨询技术人员，错误代码："+ i);
        }
    }
}
