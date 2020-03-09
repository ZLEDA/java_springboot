package com.example.demo.web;

import com.example.demo.service.GradeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class HelloWorldController {
    @RequestMapping("hello")
    public String index() {
        return "Hello World\n ";
    }
    @RequestMapping("/account/login")
    public  List<account> jjj(){
        List<account> b = new ArrayList<>();
        account a = new account("fuck","123456");
       // b.add(a);
       // b.add(a);
        return b;
    }
    @RequestMapping(value = "/account/login", method = RequestMethod.POST)
    public  account ddd(@RequestParam("id")String id,@RequestParam("passwd")String passwd){
        account b = new account(id,passwd);

        return b;
    }
    @RequestMapping("/Users")
    public StuGrades gg(){
        StuGrades sg = new StuGrades("12","张三","2018-2019",
                2,3,"数据库", 2,80,"必修");
        return sg;
    }
    @RequestMapping(value = "/api/find", method = RequestMethod.POST)
    public List<Test> ggg(@RequestParam(value="keyname",required = false)String keyname, @RequestParam(value="keyvalue",required = false)String keyvalue){
        List<Test> a = new ArrayList<>();
        Test c1 = new Test(keyname,keyvalue);
        Test c2 = new Test(keyname,keyvalue);
        Test c3 = new Test(keyname,keyvalue);
        Test c4 = new Test(keyname,keyvalue);
        a.add(c1);
        a.add(c2);
        a.add(c3);
        a.add(c4);

        return  a;
    }

}
class account{
    String id;
    String passwd;
    public account(String id,String passwd){
        this.id = id;
        this.passwd = passwd;
    }
    public String getId(){
        return this.id;
    }
    public String getPasswd(){
        return this.passwd;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setPasswd(String passwd){
        this.passwd = passwd;
    }
   /* @Override
    public String toString(){
        return  "{" +
                "\"fId\":\"" + this.id +"\""+
                "\"passwd\":\"" + this.passwd + "\""+
                '}';
    }*/
}
class Test{
        String keyname;
        String keyvalue;
        public Test(String keyname,String keyvalue){
            this.keyname = keyname;
            this.keyvalue = keyvalue;
        }
        public String getKeyname(){
            return this.keyname;
        }
        public String getKeyvalue(){
            return this.keyvalue;
        }
        public void setKeyname(String keyname) {
            this.keyname = keyname;
        }
        public void setKeyvalue(String keyvalue){
            this.keyvalue = keyvalue;
        }
}


