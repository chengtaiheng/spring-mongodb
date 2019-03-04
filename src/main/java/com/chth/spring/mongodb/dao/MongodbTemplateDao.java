package com.chth.spring.mongodb.dao;

import com.chth.spring.mongodb.bean.MongodbModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * @author: 程泰恒
 * @date: 2019/2/27 15:08
 */
@Component
public class MongodbTemplateDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     */
    public void saveTest(MongodbModel mongodbModel) {
        mongoTemplate.save(mongodbModel);
    }

    /**
     * 根据用户名查询对象
     *
     * @return
     */
    public MongodbModel findByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        MongodbModel mongodbModel = mongoTemplate.findOne(query, MongodbModel.class);
        return mongodbModel;
    }

    /**
     * 跟新对象
     */
    public void updateModel(MongodbModel mongodbModel) {
        Query query = new Query(Criteria.where("id").is(mongodbModel.getId()));
        Update update = new Update().set("age", mongodbModel.getAge()).set("name", mongodbModel.getName());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, mongodbModel.getClass());
        //更新查询返回结果集的所有
//        mongoTemplate.updateMulti(query, update, mongodbModel.getClass());
    }

    /**
     * 删除对象
     *
     * @param id
     */
    public void deleteModelById(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, MongodbModel.class);
    }

}
