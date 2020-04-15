package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("positions.json")
    Call<List<Job>> getJobs();
    @GET("positions.json?")
    Call<List<Job>> getJobsFromSearch(@Query("search") String search);
    @GET("positions.json?")
    Call<List<Job>> getFilteredJobs(@Query("description") String description,
                                    @Query("location") String location,
                                    @Query("full_time") boolean type);
}
