package com.zhou.forestProject.util;

/**
 * 文本信息类
 */
public class StringInfo {
    /**
     * 验证信息提示
     */
    public static  final  String USERORPASSEMPTY="用户名或密码不能为空";
    public static  final  String USERORPASSERROR="用户名或密码错误";
    public static  String filePath="";
    public static  final  String ERRORIMG="文件上传错误";


    /**
     * 获得新的文件名
     * @param path 文件名
     * @return 新的文件名
     */
    public static String getNewFileName(String path){
        path=path.substring(path.lastIndexOf("."),path.length());
        return  System.currentTimeMillis()+path;
    }
}
