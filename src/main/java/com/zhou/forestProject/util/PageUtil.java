package com.zhou.forestProject.util;

public class PageUtil {
    //当前页
    private int currentPage=1;
    //总行数
    private int allCount=0;
    //总页数
    private int allPage=0;
    //起始位置
    private int start=0;
    //每页显示行数
    private int countPage=5;

    public int getCurrentPage() {
        return currentPage;
    }


    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    public int getAllPage() {
        return allPage;
    }

    public int getStart() {
        return start;
    }



    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    /**
     * 修改当前页
     * @param currentPage 传入当前页
     * @param pageTag 页面标签
     */
    public void setCurrentPage(int currentPage,String pageTag){
        switch (pageTag) {
            case "first":
                this.currentPage = 1;
                break;
            case "next":
                if (currentPage == this.allPage) {
                    this.currentPage = 1;
                } else {
                    this.currentPage = currentPage + 1;
                }
                break;
            case "prev":
                if (currentPage == 1) {
                    this.currentPage = this.allPage;
                } else {
                    this.currentPage = currentPage - 1;
                }
                break;
            case "last":
                this.currentPage=this.allPage;
                break;
                default:
                    this.currentPage=1;

        }
    }
    //计算总页数
    public void setAllPage(){
        //获得总行数
        if(this.allCount%this.countPage==0){
            this.allPage=this.allCount/this.countPage;
        }else {
            this.allPage=this.allCount/this.countPage+1;
        }
    }
    /**
     * 计算起始位置
     */
    public int setStart(int currentPageNum){

        this.start=(currentPageNum-1)*this.countPage;

        return this.start;
    }
}
