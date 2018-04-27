package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.List;

public class JsonUtils {

    // string constants which identify object keys for retrieving data

    private static final String jName = "name";
    private static final String jMainName = "mainName";
    private static final String jAlsoKnownAs = "alsoKnownAs";
    private static final String jPlaceOfOrigin = "placeOfOrigin";
    private static final String jDescription = "description";
    private static final String jImage = "image";
    private static final String jIngredients = "ingredients";

    //initialize local variables used to call Sandwich constructor

    private static String locMainName;
    private static List<String> locAlsoKnownAs = null;
    private static String locPlaceOfOrigin;
    private static String locDescription;
    private static String locImage;
    private static List<String> locIngredients = null;

    // Array used to read in List

    private static JSONArray localArray = null;

    public static Sandwich parseSandwichJson(String json) throws JSONException
    {
        Sandwich sandwich = null;
       JSONObject jsonObject = new JSONObject(json);
       locMainName = jsonObject.getJSONObject(jName).getString(jMainName);
       localArray =  jsonObject.getJSONObject(jName).getJSONArray(jAlsoKnownAs);
        for (int i=0; i < localArray.length();  i++ )
        { locAlsoKnownAs.add(localArray.getString(i));}
       locPlaceOfOrigin = jsonObject.getJSONObject(jPlaceOfOrigin).getString(jPlaceOfOrigin);
       locDescription = jsonObject.getString(jDescription);
       locImage = jsonObject.getString(jImage);
       localArray = jsonObject.getJSONArray(jIngredients);
        for (int i=0; i < localArray.length(); i++)
        { locIngredients.add(localArray.getString(i));}
        // call Sandwich constructor:
        sandwich = new Sandwich(locMainName, locAlsoKnownAs, locPlaceOfOrigin, locDescription, locImage, locIngredients);
        return sandwich;
    }
}
