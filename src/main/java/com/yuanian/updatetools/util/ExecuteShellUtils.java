package com.yuanian.updatetools.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

/**
 * @author Szp
 * @version 1.0
 * @date 2020/3/31 14:07
 */
@Slf4j
public class ExecuteShellUtils {

    //private Logger logger = LoggerFactory.getLogger(ExecuteShellUtils.class);


    /**
     * 问题1
     * java在调用shell的时候，默认用的是系统的/bin/下的指令。特别是你用root权限运行的时候。 这时候，你要在/bin下加软链了
     * 例如：NODE_HOME="/home/admin/node"
     * /home/admin/node/bin/node
     *
     * 问题2
     * 调用shell脚本提示：No such file or directory
     * 原因：文件格式不正确导致，在windows下编写的sh文件，文件是DOS格式。使用:set ff=unix 强制将文件转换为unix格式。
     * 具体操作：
     * vim模式打开这个shell脚本，查看编码格式后设置成unix编码，输入：set ff?,查看格式是否是fileformat=unix；如果不是，设置成unix
     * :set ff=unix后保存（：wq）即可。
     *
     *
     *
     * @param shellFileDir  shell脚本全路径地址
     * @param param
     * @return runningStatus
     * 返回代码为126，这是因为你的demo.sh脚本没有x的权限，一般情况下会有r w x的权限的，如果没有则需要赋给r权限
     * 返回代码为127，这个是因为没有找到命令，业务shell脚本有些空格什么问题的原因，注意编写shell脚本的规则
     * 返回码为1，一般性未知错误
     * 返回码为2，不适合的shell命令
     * 返回码为128，无效的退出参数
     * 返回码为128+x,与Linux信号x相关的严重错误
     * 返回码为130 通过Ctrl+C终止的命令
     * 返回码为255 正常范围内之外的退出状态码
     * 返回码为0 恭喜您，成功调用
     */
    public static int toExecuteShell(String shellFileDir, String... param) throws IOException {
        String[] cmd = new String[]{shellFileDir};
        //为了解决参数中包含空格

        cmd = (String[]) ArrayUtils.addAll(cmd, param);
        log.info("调用处理压缩包的shell脚本,cmd=" + cmd.toString());

        //ProcessBuilder processBuilder = new ProcessBuilder("./" + shellFileDir, param);
        //可能遇到授权问题，无权限执行
        ProcessBuilder processBuilder = new ProcessBuilder("/bin/chmod", "755", shellFileDir);
        processBuilder.command(cmd);
        int runningStatus = 0;
        String s = null;
        Process process = null;
        try {
            log.info("开始执行脚本：" + shellFileDir + "日期：" + LocalDate.now().toString());
            process = processBuilder.start();
            // 可能发生java进行一直等待shell返回。原因是， shell脚本中有echo或者print输出， 导致缓冲区被用完了
            //为了避免这种情况， 一定要把缓冲区读一下。可以对shell的具体运行状态进行log出来
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = stdInput.readLine()) != null) {
                log.info("打印shell输出内容");
                log.error(s);
            }
            while ((s = stdError.readLine()) != null) {
                log.info("打印shell错误信息");
                log.error(s);
            }
            runningStatus = process.waitFor();
            log.info("执行完毕 日期：" + LocalDate.now().toString());
        } catch (IOException | InterruptedException e) {
            return runningStatus;
        }finally {
            process.getInputStream().close();
            process.getErrorStream().close();
        }
        return runningStatus;
    }



    //shell脚本
//    #!/bin/sh
//#处理压缩包
//            fileName=$1
//    url=$2
//            homePath=$3
//
//#开始处理数据逻辑
//    echo fileName=$fileName, url=$url, homePath=$homePath
//
//#判断参数不为空
//if [  -n "$fileName" ];  then
//	if [  -n "$url" ]; then
//		#0.cd到对应目录
//    cd $homePath
//
//		#1.调用get方法获取zip包并下载到本地
//    wget -O $fileName.zip $url
//
//		#2.解压zip包
//    unzip $fileName.zip
//
//		#3.删除zip包
//    rm -f $fileName.zip
//
//		#4.进入解压完的文件夹
//    cd $fileName
//
//		#5.压缩当前文件夹下所有文件为指定文件名的zip
//    zip -r ../$fileName.zip ./*
//
//		#6.删除之前解压的文件夹
//		rm -rf $homePath$fileName
//	fi
//fi
//
//echo "deal package end"
}
