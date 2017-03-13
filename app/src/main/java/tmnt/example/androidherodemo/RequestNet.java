package tmnt.example.androidherodemo;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by tmnt on 2017/3/13.
 */

public interface RequestNet {
    @POST("/PrintServlet")
    @FormUrlEncoded
    Observable<List<FileInfo>>getDat(@Field("name")String name, @Field("pass")String pass);
}
