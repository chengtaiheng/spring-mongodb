package com.chth.spring.mongodb.controller;

/**
 * @author: 程泰恒
 * @date: 2019/2/27 15:02
 */

import com.chth.spring.mongodb.bean.MongodbModel;
import com.chth.spring.mongodb.dao.MongodbTemplateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MongodbController {

    @Autowired
    private MongodbTemplateDao mongodbTemplateDao;

    @PostMapping(value = "/save")
    public void saveModel() throws Exception{
        MongodbModel mongodbModel = new MongodbModel();
        mongodbModel.setId(11);
        mongodbModel.setAge(23);
        mongodbModel.setName("程大大");
        mongodbTemplateDao.saveTest(mongodbModel);
    }

    @GetMapping(value = "/find")
    public MongodbModel findByName(@RequestParam("name") String name){
        MongodbModel mongodbModel = mongodbTemplateDao.findByName(name);

        System.out.println("mongodbModel+"+mongodbModel);
        return mongodbModel;
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam("id") Integer id){
        mongodbTemplateDao.deleteModelById(id);
    }

    @PutMapping("/update")
    public void  updateById(@RequestParam("id") Integer id,@RequestParam("age") Integer age,@RequestParam("name") String name){
        MongodbModel mongodbModel = new MongodbModel();
        mongodbModel.setId(id);
        mongodbModel.setAge(age);
        mongodbModel.setName(name);
        mongodbTemplateDao.updateModel(mongodbModel);

    }
}
