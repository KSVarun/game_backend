package com.sundarland.game.repository;

import com.sundarland.game.bean.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface APIRepository extends JpaRepository<Api,Long> {
    Api findByKey(String key);


}
