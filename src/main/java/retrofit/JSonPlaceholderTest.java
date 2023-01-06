package retrofit;

import okhttp3.OkHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class JSonPlaceholderTest {
    private static final String JSON_PLACEHOLDER_BASE_URL = "https://jsonplaceholder.typicode.com";
    private Retrofit retrofit;

    @BeforeEach
    void setup() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        retrofit = new Retrofit.Builder()
                .baseUrl(JSON_PLACEHOLDER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    @Test
    void getPostsTest() {
//        given
        RetrofitPostService service = retrofit.create(RetrofitPostService.class);
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
}
