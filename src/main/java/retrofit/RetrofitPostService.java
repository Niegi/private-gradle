package retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface RetrofitPostService {

    @GET("/posts")
    Call<List<RetrofitPost>> getRetrofitPosts();

    @GET("/posts/{postId}")
    Call<RetrofitPost> getRetrofitPost(@Path("postId") long postId);
}
