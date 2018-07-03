package com.cs.screen.builder.utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.cs.screen.builder.consts.Consts;
import com.cs.screen.builder.item.DatePickerFieldItem;
import com.cs.screen.builder.item.FormItem;
import com.cs.screen.builder.item.GroupItem;
import com.cs.screen.builder.item.InputFieldItem;
import com.cs.screen.builder.item.Item;
import com.cs.screen.builder.item.NumFieldItem;
import com.cs.screen.builder.item.SelectFieldItem;
import com.cs.screen.builder.item.TrxComponment;
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
            return content = buffer.toString();// 杩斿洖
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
        return "";// 娌″�煎氨杩斿洖绌�
    }
    public static TrxComponment convertComp(JsonObject jsonComp){
    	TrxComponment rtn=new TrxComponment();
        rtn.setName(getStr(jsonComp.get("name")));
        rtn.setGroup(getStr(jsonComp.get("group")));
        rtn.setForm(convertForm(jsonComp.get("form").getAsJsonObject()));
        rtn.setBreadCrumb(getBreadCurmbs(jsonComp.getAsJsonArray("breadCrumb")));
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
        List<Item> items=convertItems(jsonObject.getAsJsonArray("items"));     
        rtn.setItems(items);
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
            if (itemJson.get("items")!=null) {
            	String id=itemJson.get("id").getAsString();
            	String desc=itemJson.get("desc").getAsString();
            	List<Item> itemstemp=convertItems(itemJson.getAsJsonArray("items"));
            	GroupItem group=new GroupItem(itemstemp,desc,id);
            	rtn.add(group);
            }else {
            rtn.add(convertItem(itemJson));
            }
        }
        return  rtn;
    }
    private static Item convertItem(JsonObject item){
        Gson gson=new Gson();
        switch (item.get("type").getAsString()){
            case Consts.Type_TextInput:
                InputFieldItem textInputItem=gson.fromJson(item,InputFieldItem.class);
                return textInputItem;
            case Consts.Type_NumInput:
                NumFieldItem numInputItem=gson.fromJson(item,NumFieldItem.class);
                return numInputItem;
            case Consts.Type_DatePicker:
                DatePickerFieldItem datePickerItem=gson.fromJson(item,DatePickerFieldItem.class);
                return  datePickerItem;
            case Consts.Type_Select:
                SelectFieldItem selectItem=gson.fromJson(item,SelectFieldItem.class);
                return selectItem;
        }
        return null;
    }
    private static String getStr(JsonElement element){
        if (element==null)
            return "";
        return element.getAsString();
    }
}
