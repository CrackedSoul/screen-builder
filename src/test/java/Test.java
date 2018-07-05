import java.io.FileNotFoundException;

import com.cs.screen.builder.CompBuilderFactory;
import com.cs.screen.builder.ComponentBuilder;
import com.cs.screen.builder.item.TrxComponment;
import com.cs.screen.builder.utils.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Test {
	public static void main(String args[]) throws FileNotFoundException {
		 String json=JsonUtils.readJson("E:\\Eclipse\\oxygen3\\ws\\Simple\\screen-builder\\src\\main\\resources\\accTakeDown.json");
	     JsonObject jsonObject=new Gson().fromJson(json,JsonObject.class);
	     TrxComponment trxComp=JsonUtils.convertComp(jsonObject);	
	     ComponentBuilder builder=CompBuilderFactory.getCompBuilder("");
	     builder.generateFile("Acc-TakeDown", trxComp);
	}
}
