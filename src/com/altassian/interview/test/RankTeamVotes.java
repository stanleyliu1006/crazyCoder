package com.altassian.interview.test;

import java.util.*;
import java.util.logging.Logger;

//https://leetcode.com/problems/rank-teams-by-votes/description/

public class RankTeamVotes {
    private static final Logger logger = Logger.getLogger(RankTeamVotes.class.getName());
    public String rankTeams(String[] votes) {

        if (votes == null || votes.length == 0) {
            return "";
        }

        if (votes.length == 1){
            return votes[0];
        }

        //Construct voteMap for sorting of each team character
        Map<Character, int[]> voteMap = new HashMap<>();
        int teamLen = votes[0].length();
        for(String vote : votes) { //O(n * m)
            for (int i=0; i < teamLen; i++) {
                char team = vote.charAt(i);
                voteMap.putIfAbsent(team, new int[teamLen]);
                voteMap.get(team)[i]++;
            }
        }

        //Sorting algorithm
        List<Character> teams = new ArrayList<>(voteMap.keySet());
        teams.sort((a, b) -> {
            int[] votesA = voteMap.get(a);
            int[] votesB = voteMap.get(b);
            for (int i = 0; i < teamLen; i++) {
                if (votesA[i] != votesB[i]) {
                    return Integer.compare(votesB[i], votesA[i]); // Compare all rounds at once
                }
            }
            return Character.compare(a, b); // Alphabetical order if voting results are equal
        });

        //Append String and return result
        StringBuilder result = new StringBuilder();
        for(char team : teams) {  //O(n)
            result.append(team);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        RankTeamVotes ranker = new RankTeamVotes();
        String[] votes1 = {"ABC","ACB","ABC","ACB","ACB"};
        String[] votes2 = {"WXYZ","XYZW"};
        String[] votes3 = {"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
        String[] votes4 = {};
        logger.info(String.valueOf(ranker.rankTeams(votes1).equalsIgnoreCase("ACB")));
        logger.info(String.valueOf(ranker.rankTeams(votes2).equalsIgnoreCase("XWYZ")));
        logger.info(String.valueOf(ranker.rankTeams(votes3).equalsIgnoreCase("ZMNAGUEDSJYLBOPHRQICWFXTVK")));
        logger.info(String.valueOf(ranker.rankTeams(votes4).equalsIgnoreCase("")));
    }

}

class RankTeamVotesNoMap {
    private static final Logger logger = Logger.getLogger(RankTeamVotes.class.getName());
    public String rankTeams(String[] votes) {

        if (votes == null || votes.length == 0) {
            return "";
        }

        if (votes.length == 1){
            return votes[0];
        }

        int n = votes[0].length();
        int[][] voteCnt = new int[26][n + 1];
        for (int i = 0; i < 26; i++)
        {
            voteCnt[i][n] = i; //print output
        }

        for (String vote : votes) {
            for (int i = 0; i < n; i++) {
                voteCnt[vote.charAt(i) - 'A'][i]++;  //print output
                //logger.info(String.valueOf(voteCnt[vote.charAt(i) - 'A'][i]));
            }
        }

        Character[] res = new Character[n];
        for (int i = 0; i < n; i++) {
            res[i] = votes[0].charAt(i);
        }
        Arrays.sort(res, (a, b) -> Arrays.compare(voteCnt[b - 'A'], voteCnt[a - 'A'])); // O(n * log n)

        StringBuilder ss = new StringBuilder();
        for (char s : res) {
            ss.append(s);
        }
        return ss.toString();
    }

    public static void main(String[] args) {
        RankTeamVotesNoMap ranker = new RankTeamVotesNoMap();
        String[] votes1 = {"ABC","ACB","ABC","ACB","ACB"};
        String[] votes2 = {"WXYZ","XYZW"};
        String[] votes3 = {"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
        String[] votes4 = {};
        logger.info(String.valueOf(ranker.rankTeams(votes1).equalsIgnoreCase("ACB")));
        logger.info(String.valueOf(ranker.rankTeams(votes2).equalsIgnoreCase("XWYZ")));
        logger.info(String.valueOf(ranker.rankTeams(votes3).equalsIgnoreCase("ZMNAGUEDSJYLBOPHRQICWFXTVK")));
        logger.info(String.valueOf(ranker.rankTeams(votes4).equalsIgnoreCase("")));
    }

}
