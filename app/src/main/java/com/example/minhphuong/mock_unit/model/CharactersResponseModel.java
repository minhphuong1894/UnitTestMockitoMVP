package com.example.minhphuong.mock_unit.model;

import java.util.List;

/**
 * Created by minhphuong on 1/24/18.
 */

public class CharactersResponseModel {
    public final int count;
    public final String next;
    public final String previous;
    public final List<CharacterModel> results;

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<CharacterModel> getResults() {
        return results;
    }

    public CharactersResponseModel(int count, String next, String previous, List<CharacterModel> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }
}
