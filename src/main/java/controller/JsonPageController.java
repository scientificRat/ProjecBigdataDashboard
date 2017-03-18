package controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import utility.GeneralJsonBuilder;

/**
 * Created by sky on 2017/3/14.
 */
@RestController
public abstract class JsonPageController {
    // Json 构造器
    protected Gson gson = new Gson();

    @ExceptionHandler
    public String handleAndReturnData(Exception ex) {
        return GeneralJsonBuilder.error("操作失败：" + ex.getMessage());
    }
}
