package retrofit;

import okhttp3.OkHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JSonPlaceholderTest {
    private RetrofitPostService service;

    @BeforeEach
    void setup() {
        service = JSonPlaceholderServiceGenerator.createService(RetrofitPostService.class);
    }

    @Test
    void getSynchronousPostsTest() {
//        given
        Call<List<RetrofitPost>> callSync = service.getRetrofitPosts();

//        when
        List<RetrofitPost> retrofitPosts = null;
        try {
            Response<List<RetrofitPost>> response = callSync.execute();
            retrofitPosts = response.body();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

//        then
        assertThat(retrofitPosts.size(), greaterThan(1));
    }

//    todo - test asynchroniczny nie działa - rozkminić dlaczego
//    @Test
//    void getAsynchronousPostsTest() throws InterruptedException {
////        given
//        RetrofitPostService service = retrofit.create(RetrofitPostService.class);
//        Call<List<RetrofitPost>> callAsync = service.getRetrofitPosts();
//
////        when
//        final List<RetrofitPost>[] retrofitPosts = new List[]{null};
//        callAsync.enqueue(new Callback<>() {
//            @Override
//            public void onResponse(Call<List<RetrofitPost>> call, Response<List<RetrofitPost>> response) {
//                retrofitPosts[0] = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<List<RetrofitPost>> call, Throwable throwable) {
//                System.out.println(throwable);
//            }
//        });
//
////        then
//        Thread.sleep(500);
//        assertThat(retrofitPosts[0].size(), greaterThan(1));
//    }

    @Test
    void getPostTest() {
//        given
        Call<RetrofitPost> callSync = service.getRetrofitPost(1);

//        when
        RetrofitPost retrofitPost = null;
        try {
            Response<RetrofitPost> response = callSync.execute();
            retrofitPost = response.body();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

//        then
        assert retrofitPost != null;
        assertThat(retrofitPost.getBody(), is(not(emptyOrNullString())));
    }

    @Test
    void postPostTest() {
//        given
        RetrofitPost post = new RetrofitPost("1", "test title", "test body");
        Call<RetrofitPost> callSync = service.postRetrofitPost(post);

//        when
        int responseCode = 0;
        try {
            Response<RetrofitPost> response = callSync.execute();
            responseCode = response.code();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

//        then
        assertThat(responseCode, is(both(greaterThan(200)).and(lessThan(204))));
    }
}
