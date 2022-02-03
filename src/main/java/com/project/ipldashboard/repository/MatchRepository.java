package com.project.ipldashboard.repository;

import com.project.ipldashboard.model.Match;
import com.project.ipldashboard.model.Team;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Match,Long> {

    List<Match> findByTeam1OrTeam2OrderByDateDesc(String team1, String team2, Pageable pageable);

    default List<Match> findLatestMatchesOfTeam(String teamName,int count){
        return findByTeam1OrTeam2OrderByDateDesc(teamName,teamName, (Pageable) PageRequest.of(0,count));
    }
}
