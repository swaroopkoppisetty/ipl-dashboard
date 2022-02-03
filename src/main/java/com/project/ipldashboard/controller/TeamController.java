package com.project.ipldashboard.controller;

import com.project.ipldashboard.exception.TeamNotFoundException;
import com.project.ipldashboard.model.Team;
import com.project.ipldashboard.repository.MatchRepository;
import com.project.ipldashboard.repository.TeamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team teamInfo( @PathVariable String teamName) throws TeamNotFoundException {

        Team team = teamRepository.findByTeamName(teamName);
        if(team == null){
            throw new TeamNotFoundException("Team Not found with name "+ teamName);
        }
        team.setMatchList(matchRepository.findLatestMatchesOfTeam(teamName,4));
        return team;
    }
}
