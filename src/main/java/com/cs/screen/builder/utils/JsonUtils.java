package com.cs.screen.builder.utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.cs.screen.builder.consts.Consts;
import com.cs.screen.builder.item.DatePickerFieldItem;
import com.cs.screen.builder.item.FieldItem;
import com.cs.screen.builder.item.FormItem;
import com.cs.screen.builder.item.GroupItem;
import com.cs.screen.builder.item.InputFieldItem;
import com.cs.screen.builder.item.Item;
import com.cs.screen.builder.item.NumFieldItem;
import com.cs.screen.builder.item.SelectFieldItem;
import com.cs.screen.builder.item.TrxComponent;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class JsonUtils {
    public static String readJson(String formPath) {
        String content = "";
        FileReader read = null;
        BufferedReader reader = null;
        try {
            read = new FileReader(new File(formPath));
            reader = new BufferedReader(read);
            StringBuffer buffer = new StringBuffer("");
            content = reader.readLine();
            while (content != null) {
                buffer.append(content).append("\n");
                content = reader.readLine();
            }
            return content = buffer.toString();// 鏉╂柨娲�
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (read != null)
                    read.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";// 濞屸�筹拷鐓庢皑鏉╂柨娲栫粚锟�
    }
    public static TrxComponent convertComp(JsonObject jsonComp){
    	TrxComponent rtn=new TrxComponent();
        rtn.setContent(convertForm(jsonComp.get("content").getAsJsonObject()));
        rtn.setComponent(jsonComp.get("component").getAsString());
        rtn.setEventType(jsonComp.get("eventType").getAsString());
        rtn.setName(jsonComp.get("name").getAsString());
        return  rtn;
    }
    private static List<String> getBreadCurmbs(JsonArray items){
    	List<String> rtn=new LinkedList<String>();
    	Iterator<JsonElement> itemIterator=items.iterator();
    	while(itemIterator.hasNext()){
    		rtn.add(itemIterator.next().getAsString());
    	}
    	return rtn;
    }

    public static FormItem convertForm(JsonObject jsonObject) {
    	FormItem rtn=new FormItem();
    	rtn.setForm(convertItems(jsonObject.getAsJsonArray("form")));     
    	rtn.setBreadCrumbs(getBreadCurmbs(jsonObject.getAsJsonArray("breadCrumb")));
		return rtn;
    }

    private static List<Item> convertItems(JsonArray items) {
        if (items==null||items.isJsonNull()){
            return  null;
        }
        List<Item> rtn=new LinkedList<>();
        Iterator<JsonElement> itemIterator=items.iterator();

        while(itemIterator.hasNext()){
            JsonObject itemJson=itemIterator.next().getAsJsonObject();
            if(Consts.Tag_Group.equals(itemJson.get("tag").getAsString())){
            	String id=itemJson.get("id").getAsString();
            	String desc=itemJson.get("desc").getAsString();
            	List<Item> itemstemp=convertItems(itemJson.getAsJsonArray("items"));
            	GroupItem group=new GroupItem(itemstemp,desc,id);
            	rtn.add(group);
            }else if(Consts.Tag_Item.equals(itemJson.get("tag").getAsString())){
            	rtn.add(convertItem(itemJson));
            }
        }
        return  rtn;
    }
    private static Item convertItem(JsonObject item){
        Gson gson=new Gson();
        FieldItem fieldItem = null;
        switch (item.get("type").getAsString()){
            case Consts.Type_TextInput:
            	fieldItem=gson.fromJson(item,InputFieldItem.class);
            	break;
            case Consts.Type_NumInput:
            	fieldItem=gson.fromJson(item,NumFieldItem.class);
            	break;
            case Consts.Type_DatePicker:
            	fieldItem=gson.fromJson(item,DatePickerFieldItem.class);
            	break;
            case Consts.Type_Select:
            	fieldItem=gson.fromJson(item,SelectFieldItem.class);
               break;
        }
        if (fieldItem!=null)
        	fieldItem.updaterequired();
        return fieldItem;
    }
}
