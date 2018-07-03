import java.util.LinkedList;
import java.util.List;

import com.cs.screen.builder.FormBuilder;
import com.cs.screen.builder.item.FieldItem;
import com.cs.screen.builder.item.FormItem;
import com.cs.screen.builder.item.GroupItem;
import com.cs.screen.builder.item.InputFieldItem;
import com.cs.screen.builder.item.Item;

public class Test {
	public static void main(String args[]) {
		List<Item> items=new LinkedList<Item>();			
		List<Item> item1=new LinkedList<Item>();
		FieldItem f1=new InputFieldItem("TestFiel1","QWER");
		item1.add(f1);
		GroupItem group=new GroupItem(item1,"Group1","Group1Id");
		items.add(group);
		FormItem form=new FormItem(items);
		System.out.println(FormBuilder.genForm(form));
	}
}
