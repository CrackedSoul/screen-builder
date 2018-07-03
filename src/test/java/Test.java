import com.cs.screen.builder.html.TrxCompHtmlBuilder;
import com.cs.screen.builder.item.TrxComponment;
import com.cs.screen.builder.ts.TrxCompTsBuilder;
import com.cs.screen.builder.utils.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Test {
	public static void main(String args[]) {
		 String json=JsonUtils.readJson("E:\\Eclipse\\oxygen3\\ws\\Simple\\screen-builder\\src\\main\\resources\\accTakeDown.json");
	     JsonObject jsonObject=new Gson().fromJson(json,JsonObject.class);
	     TrxComponment trxComp=JsonUtils.convertComp(jsonObject);	
		System.out.println(TrxCompHtmlBuilder.genTrxCompHtml(trxComp));
		System.out.println(TrxCompTsBuilder.genTrxCompTs(trxComp));
	}
}
