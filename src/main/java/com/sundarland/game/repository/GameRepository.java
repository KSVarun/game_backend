package com.sundarland.game.repository;

import com.sundarland.game.bean.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
     Iterable<Game> findByTitle(String title);
//     void deleteByTitle(String title);
}
