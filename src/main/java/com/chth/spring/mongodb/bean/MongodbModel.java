package com.chth.spring.mongodb.bean;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: 程泰恒
 * @date: 2019/2/27 13:37
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MongodbModel implements Serializable {

        private static final long serialVersionUID = -6928644017793720484L;

        private Integer id;

        private Integer age;

        private  String name;


}
