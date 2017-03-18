package controller;

import domain.UserInput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utility.GeneralJsonBuilder;

/**
 * Created by sky on 2017/3/14.
 */
@RestController
@RequestMapping(value = "/sparkTask",produces = "application/json; charset=utf-8")
public class SparkTaskController extends JsonPageController{

    @RequestMapping("/submit")
    public String submitTask(@RequestParam String userInput){
        UserInput userInputObject = gson.fromJson(userInput,UserInput.class);
        //检查参数
        if(userInputObject.getTaskID()==null || userInputObject.getTaskID().isEmpty()){
            return GeneralJsonBuilder.error("parameter userInput is required");
        }
        return GeneralJsonBuilder.success();
    }

    @RequestMapping("/query/waiting-task/all")
    public String queryAllWaitingTask(){
        return GeneralJsonBuilder.success();
    }


    @RequestMapping("/query/finished-task/all")
    public String queryAllFinishedTask(){
        return GeneralJsonBuilder.success();
    }

    @RequestMapping("/delete/finished-task")
    public String deleteFinishedTask(){
        return GeneralJsonBuilder.success();
    }

}
