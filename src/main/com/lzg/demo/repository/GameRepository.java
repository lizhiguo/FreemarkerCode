package com.lzg.Demo.repository.impl;

import org.apache.deltaspike.data.api.Repository;

import com.lzg.Demo.model.Game;
import com.lhl.fw.impl.repository.BaseRepository;

@Repository(forEntity = Game.class)
public abstract class GameRepository extends BaseRepository<Game, String> implements IGameRepository{

}