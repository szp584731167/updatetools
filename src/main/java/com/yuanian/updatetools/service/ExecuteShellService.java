package com.yuanian.updatetools.service;

import java.io.IOException;

/**
 * @author Szp
 * @version 1.0
 * @date 2020/3/10 14:17
 */
public interface ExecuteShellService {

    /**
     * 关闭
     * @param path
     */
    void stopTomcat(String path) throws IOException;

    /**
     * 开启
     * @param path
     */
    void startTomcat(String path) throws IOException;

    /**
     * 重启
     * @param stopPath
     * @param startPath
     */
    void restartTomcat(String stopPath,String startPath) throws IOException;
}
