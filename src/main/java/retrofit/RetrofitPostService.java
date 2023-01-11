package retrofit;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface RetrofitPostService {

    @GET("/posts")
    Call<List<RetrofitPost>> getRetrofitPosts();

    @GET("/posts/{postId}")
    Call<RetrofitPost> getRetrofitPost(@Path("postId") long postId);

    @POST("/posts")
    Call<RetrofitPost> postRetrofitPost(@Body RetrofitPost post);

    @PUT("/posts/{postId}")
    Call<RetrofitPost> putRetrofitPost(@Body RetrofitPost post, @Path("postId") long postId);
}
