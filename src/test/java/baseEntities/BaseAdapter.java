package baseEntities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.BeforeTest;

public class BaseAdapter {
    protected Gson gson;

    @BeforeTest
    public void setupApi() {
        gson = new Gson();
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

    }
}
