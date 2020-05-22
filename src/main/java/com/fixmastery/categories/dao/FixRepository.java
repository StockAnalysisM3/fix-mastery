package com.fixmastery.categories.dao;

import com.fixmastery.categories.dto.Fix;
import com.fixmastery.categories.model.MessageType;
import com.fixmastery.categories.model.OrderStatus;
import com.fixmastery.categories.model.OrderType;
import com.fixmastery.categories.model.Side;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface FixRepository extends CrudRepository<Fix, Integer>, JpaSpecificationExecutor<Fix> {
    Iterable<Fix> findAllByTag(int tag);

    default Map<String, MessageType> messageTypeRepo(){
        Iterable<Fix> categoriesAsFix = findAllByTag(35);
        Iterator<Fix> fixIterator = categoriesAsFix.iterator();
        Map<String, MessageType> repo = new HashMap<>();

        fixIterator.forEachRemaining(fix -> repo.put(
                fix.getValue(),
                new MessageType(fix.getValue(), fix.getName())
                )
        );
        return repo;
    };

    default Map<String, OrderStatus> orderStatusRepo(){
        Iterable<Fix> categoriesAsFix = findAllByTag(39);
        Iterator<Fix> fixIterator = categoriesAsFix.iterator();
        Map<String, OrderStatus> repo = new HashMap<>();

        fixIterator.forEachRemaining(fix -> repo.put(
                fix.getValue(),
                new OrderStatus(fix.getValue(), fix.getName())
            )
        );
        return repo;
    };

    default Map<String, OrderType> orderTypeRepo(){
        Iterable<Fix> allOrderStatusesAsFix = findAllByTag(40);
        Iterator<Fix> fixIterator = allOrderStatusesAsFix.iterator();
        Map<String, OrderType> repo = new HashMap<>();

        fixIterator.forEachRemaining(fix -> repo.put(
                fix.getValue(),
                new OrderType(fix.getValue(), fix.getName())
            )
        );
        return repo;
    };

    default Map<String, Side> sideRepo(){
        Iterable<Fix> categoriesAsFix = findAllByTag(54);
        Iterator<Fix> fixIterator = categoriesAsFix.iterator();
        Map<String, Side> repo = new HashMap<>();

        fixIterator.forEachRemaining(fix -> repo.put(
                fix.getValue(),
                new Side(fix.getValue(), fix.getName())
                )
        );
        return repo;
    };
}
