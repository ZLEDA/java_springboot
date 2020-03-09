package com.example.demo.bean;

//returnbool  增删改成功时返回给前端的对象
public class returnbool {
    int result;
    public returnbool(boolean flag){
        if(flag == true)
            this.result =1;
        else
            this.result=0;
    }
    public int getResult(){
        return this.result;
    }
    public void setResult(int result){
        this.result = result;
    }
}