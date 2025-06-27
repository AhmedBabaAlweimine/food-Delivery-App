package com.alweimine.order.service;

import com.alweimine.order.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class SequenceGenerator {

    @Autowired
    private MongoOperations mongoOperations;

    public int generateNextOderId(){
        Sequence counter=mongoOperations.findAndModify(
                new Query(where("_id").is("sequence")),
                new Update().inc("seque",1),
                options().returnNew(true).upsert(true),
                Sequence.class);
        return counter.getSeque();
    }
}
