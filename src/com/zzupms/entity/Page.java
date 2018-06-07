package com.zzupms.entity;

import java.util.List;

public class Page {
    private int page;//当前页
    private int pagesize;//页面数据条数
    private int indexpage=1;//首页
    private int endpage;//尾页
    private int count;//总数据条数
    private int pagenumber;//总页面数
    private List<Person> list;//得到的数据放入list集合中
    private List<Recruit> list_recruit;//得到的数据放入list集合中
    private int page_recruit;//当前页
    private int pagesize_recruit;//页面数据条数
    private int indexpage_recruit=1;//首页
    private int endpage_recruit;//尾页
    private int count_recruit;//总数据条数
    private int pagenumber_recruit;//总页面数
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getPagesize() {
        return pagesize;
    }
    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
    public int getIndexpage() {
        return indexpage;
    }
    public void setIndexpage(int indexpage) {
        this.indexpage = indexpage;
    }
    public int getEndpage() {
        
        return endpage;
    }
    public void setEndpage() {
        this.endpage=pagenumber;
    }
    public int getCount() {
        this.count=list.size();
        return count;
    }
    public void setCount() {
        this.count=list.size();
    }
    
    public int getPagenumber() {
        return pagenumber;
    }
    public void setPagenumber() {
        this.pagenumber=(this.getCount()%pagesize==0)?this.getCount()/pagesize:this.getCount()/pagesize+1;
    }
    public List<Person> getList() {
        return list;
    }
    public void setList(List<Person> list) {
        this.list = list;
    }
	public List<Recruit> getList_recruit() {
		return list_recruit;
	}
	public void setList_recruit(List<Recruit> list_recruit) {
		this.list_recruit = list_recruit;
	}
    public int getPage_recruit() {
        return page_recruit;
    }
    public void setPage_recruit(int page) {
        this.page_recruit = page;
    }
    public int getPagesize_recruit() {
        return pagesize_recruit;
    }
    public void setPagesize_recruit(int pagesize) {
        this.pagesize_recruit = pagesize;
    }
    public int getIndexpage_recruit() {
        return indexpage_recruit;
    }
    public void setIndexpage_recruit(int indexpage) {
        this.indexpage_recruit = indexpage;
    }
    public int getEndpage_recruit() {
        
        return endpage_recruit;
    }
    public void setEndpage_recruit() {
        this.endpage_recruit=pagenumber_recruit;
    }
    public int getCount_recruit() {
        this.count=list_recruit.size();
        return count_recruit;
    }
    public void setCount_recruit() {
        this.count_recruit=list_recruit.size();
    }
    
    public int getPagenumber_recruit() {
        return pagenumber_recruit;
    }
    public void setPagenumber_recruit() {
        this.pagenumber_recruit=(this.getCount_recruit()%pagesize_recruit==0)?this.getCount_recruit()/pagesize_recruit:this.getCount_recruit()/pagesize_recruit+1;
    }
    

}