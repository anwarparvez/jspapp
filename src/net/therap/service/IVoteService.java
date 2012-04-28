package net.therap.service;

import net.therap.domain.User;

import java.sql.Date;
import java.util.Map;


/**
 * @author misbah
 */
public interface IVoteService {
    public Map<String, Float> getVoteMap() ;

}
