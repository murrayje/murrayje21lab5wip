package edu.up.cs371.soccer_application;

import android.util.Log;

import edu.up.cs371.soccer_application.soccerPlayer.SoccerPlayer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Soccer player database -- presently, all dummied up
 * 
 * @author *** put your name here ***
 * @version *** put date of completion here ***
 *
 */
public class SoccerDatabase implements SoccerDB {

    HashMap<String, SoccerPlayer> hmap = new HashMap<String, SoccerPlayer>();

    /**
     * add a player
     *
     * @see SoccerDB#addPlayer(String, String, int, String)
     */
    @Override
	public boolean addPlayer(String firstName, String lastName,
			int uniformNumber, String teamName) {
        String key = firstName + "##" + lastName;
        if(!(hmap.containsKey(key)))
        {
            SoccerPlayer g = new SoccerPlayer(firstName, lastName, uniformNumber, teamName);
            hmap.put(key, g);
            return true;
        }
        else {
            return false;
        }
	}

    /**
     * remove a player
     *
     * @see SoccerDB#removePlayer(String, String)
     */
    @Override
    public boolean removePlayer(String firstName, String lastName) {
        String key = firstName + "##" + lastName;
        if(hmap.containsKey(key))
        {
            hmap.remove(key);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * look up a player
     *
     * @see SoccerDB#getPlayer(String, String)
     */
    @Override
	public SoccerPlayer getPlayer(String firstName, String lastName) {
        String key = firstName + "##" + lastName;
        if(hmap.containsKey(key))
        {
            return hmap.get(key);
        }
        else
        {
            return null;
        }
    }

    /**
     * increment a player's goals
     *
     * @see SoccerDB#bumpGoals(String, String)
     */
    @Override
    public boolean bumpGoals(String firstName, String lastName) {
        String key = firstName + "##" + lastName;
        if(hmap.containsKey(key))
        {
            hmap.get(key).bumpGoals();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's assists
     *
     * @see SoccerDB#bumpAssists(String, String)
     */
    @Override
    public boolean bumpAssists(String firstName, String lastName) {
        String key = firstName + "##" + lastName;
        if(hmap.containsKey(key))
        {
            hmap.get(key).bumpAssists();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's shots
     *
     * @see SoccerDB#bumpShots(String, String)
     */
    @Override
    public boolean bumpShots(String firstName, String lastName) {
        String key = firstName + "##" + lastName;
        if(hmap.containsKey(key))
        {
            hmap.get(key).bumpShots();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's saves
     *
     * @see SoccerDB#bumpSaves(String, String)
     */
    @Override
    public boolean bumpSaves(String firstName, String lastName) {
        String key = firstName + "##" + lastName;
        if(hmap.containsKey(key))
        {
            hmap.get(key).bumpSaves();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's fouls
     *
     * @see SoccerDB#bumpFouls(String, String)
     */
    @Override
    public boolean bumpFouls(String firstName, String lastName) {
        String key = firstName + "##" + lastName;
        if(hmap.containsKey(key))
        {
            hmap.get(key).bumpFouls();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's yellow cards
     *
     * @see SoccerDB#bumpYellowCards(String, String)
     */
    @Override
    public boolean bumpYellowCards(String firstName, String lastName) {
        String key = firstName + "##" + lastName;
        if(hmap.containsKey(key))
        {
            hmap.get(key).bumpYellowCards();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's red cards
     *
     * @see SoccerDB#bumpRedCards(String, String)
     */
    @Override
    public boolean bumpRedCards(String firstName, String lastName) {
        String key = firstName + "##" + lastName;
        if(hmap.containsKey(key))
        {
            hmap.get(key).bumpRedCards();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * tells the number of players on a given team
     *
     * @see SoccerDB#numPlayers(String)
     */
    @Override
    // report number of players on a given team (or all players, if null)
	public int numPlayers(String teamName) {
        if(teamName == null)
        {
            return hmap.size();
        }
        else {
            int numPlayers = 0;
            for (SoccerPlayer value : hmap.values()) {
                if (value.getTeamName().equals(teamName)) {
                    numPlayers++;
                }
            }
            return numPlayers;
        }
	}

    /**
     * gives the nth player on a the given team
     *
     * @see SoccerDB#playerNum(int, String)
     */
	// get the nTH player
	@Override
    public SoccerPlayer playerNum(int idx, String teamName) {
	    if(idx < hmap.size()) {
	        if(teamName == null) {
                Set<String> keySet = hmap.keySet();
                ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
                String key = listOfKeys.get(idx);
                return hmap.get(key);
            }
            else
            {
                Set<String> keySet = hmap.keySet();
                ArrayList<String> listOfKeys = new ArrayList<String>();
                for (SoccerPlayer value : hmap.values()) {
                    if (value.getTeamName().equals(teamName)) {
                        return value;
                    }
                }
            }
        }
        else
        {
            return null;
        }
        return null;
    }

    /**
     * reads database data from a file
     *
     * @see SoccerDB#readData(java.io.File)
     */
	// read data from file
    @Override
	public boolean readData(File file) {
        return file.exists();
	}

    /**
     * write database data to a file
     *
     * @see SoccerDB#writeData(java.io.File)
     */
	// write data to file
    @Override
	public boolean writeData(File file) {
        return false;
	}

    /**
     * helper method that logcat-logs a string, and then returns the string.
     * @param s the string to log
     * @return the string s, unchanged
     */
    private String logString(String s) {
        Log.i("write string", s);
        return s;
    }

    /**
     * returns the list of team names in the database
     *
     * @see edu.up.cs371.soccer_application.SoccerDB#getTeams()
     */
	// return list of teams
    @Override
	public HashSet<String> getTeams() {
        return new HashSet<String>();
	}

}
