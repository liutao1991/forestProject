package com.zhou.forestProject.util;

/**
 * 验证类
 */
public class Verify {
    /**
     * 验证字符串是否为空
     * @param strs 字符串数组
     * @return 不为空返回true,为空返回false
     */
    public static boolean verifyString(String...strs){
        boolean bl=true;
        for (String s:strs) {
           //只要任何一次循环为空，bl改为false
            if(null==s || "".equals(s)){
                bl=false;
                break;
            }
        }
        return bl;
    }

    /**
     * 验证文件上传是否合法
     * @param path 文件名
     * @param beforeStrs 后缀名数组
     * @return 验证成功返回true，不成功false
     */
    public static boolean verifyFile(String path,String[] beforeStrs){
       boolean bl=false;
       //截取最后一个点后面的字符串做验证
       path=path.substring(path.lastIndexOf(".")+1,path.length());
       for(int i=0;i<beforeStrs.length;i++){
           if(path.equals(beforeStrs[i])){
               bl=true;
                break;
           }
       }
        return  bl;
    }

    public static void main(String[] args) {
        String s="gffgfg.hh.ff..5jpg";
        boolean b =verifyFile(s,new String[]{"jpg"});
        System.out.println(b);
    }

}
