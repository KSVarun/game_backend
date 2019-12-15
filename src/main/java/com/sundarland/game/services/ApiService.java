package com.sundarland.game.services;

import com.sundarland.game.bean.Api;
import com.sundarland.game.exceptions.ApiKeyException;
import com.sundarland.game.repository.APIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

@Service
public class ApiService {
    @Autowired
    APIRepository apiRepository;

    public Boolean validateApiKey(String key) {
        try {
            Api api = apiRepository.findByKey(key);
            String keyValue = api.getKey();

            if (keyValue!=null) {
                return true;
            }
            return false;
        }
        catch (Exception e){
            throw new ApiKeyException("ISSUE WITH THE API_KEY");
        }

    }
    public Api addNewApiKey(Api key) {
        return apiRepository.save(key);
    }

    public void deleteApiKey(Long Id) {
        try{
            apiRepository.deleteById(Id);
        }
        catch (Exception e){
            throw new ApiKeyException("API KEY DOES NOT EXIST");
        }
    }
}
