package hiring.interview.acko.service;

/**
 * Created by asaxena on 10/6/2018.
 */

import java.util.*;

class Token {
    public static final Character STRING_BEGIN = '\"';
    public static final Character STRING_END = '\"';
    public static final Character LIST_BEGIN = '[';
    public static final Character LIST_END = ']';
    public static final Character DICT_BEGIN = '{';
    public static final Character DICT_END = '}';
    public static final Character DICT_SYMBOL = ':';
    public static final Character DELIMETER = ',';

    public static List list(){
        return Arrays.asList(Token.LIST_BEGIN,Token.LIST_END,Token.DICT_BEGIN,Token.DICT_END,Token.DICT_SYMBOL,Token.DELIMETER);
    }
    public static List openingList(){
        return Arrays.asList(Token.LIST_BEGIN,Token.DICT_BEGIN);
    }
    public static List closingList(){
        return Arrays.asList(Token.LIST_END,Token.DICT_END);
    }
}

interface JSONElement {}

class Pair {
    JSONElement jsonElement;
    Integer jsonElementEnd;
    String remainingString;
    public Pair(JSONElement jsonElement, Integer jsonElementEnd,String remainingString){
        this.jsonElement = jsonElement;
        this.jsonElementEnd=jsonElementEnd;
        this.remainingString = remainingString;
    }

    public JSONElement getJSONElement() {
        return this.jsonElement;
    }

    public String getRemainingString() {
        return this.remainingString;
    }

    public Integer getJsonElementEnd() { return this.jsonElementEnd; }

    public String toString(){
        return "jsonElement: " + jsonElement.toString() + "\nremainingString : " + remainingString;
    }
}

class JSONNumber implements JSONElement {
    Integer abc;
    public JSONNumber(Integer abc) {
        this.abc = abc;
    }

    public static Pair parseNumber(String str) {

        int index = 0,value = 0;
        String string = "\"";

        for(index = 0; index < str.length(); index++) {
            if(Utils.isDigit(str.charAt(index)))
                value = value*10 + (str.charAt(index)-'0');
            else{
                break;
            }
        }
        return new Pair(new JSONNumber(value), index-1, str.substring(index));
    }

    public String toString() {
        if(this.abc == null)
            return null;
        return this.abc.toString();
    }
}


class JSONString implements JSONElement {
    String str;

    public JSONString(String str) {
        this.str = str;
    }

    public static Pair parseString(String str) {
        int index = 1;
        String string = "\"";
        for(index = 1; index < str.length(); index++) {
            char ch = str.charAt(index);
            if(ch == Token.STRING_END) break;
            string += ch;
        }
        return new Pair(new JSONString(string+"\""), index, str.substring(index + 1));
    }

    public String toString() {
        if (this.str == null)
            return null;
        return this.str;
    }
}


class JSONList implements JSONElement {
    List<JSONElement> list;

    public JSONList(List<JSONElement> list) {
        this.list = list;
    }

    public static Pair parseList(String str) {
        List<JSONElement> list = new ArrayList<>();
        /*Traverse the list until delimiter and get the buffer */
        StringBuilder buffer = new StringBuilder();
        int i=0;
        char curr;
        Pair pair;

        for(i=1;i<str.length();i++){
            curr = str.charAt(i);
            if(Token.openingList().contains(curr)) {
                pair = Utils.parse(str.substring(i));
                i+=(pair.jsonElementEnd+1);
                list.add(pair.jsonElement);
            }
            else if(str.charAt(i)==Token.DELIMETER){
                if(buffer!=null && buffer.length()!=0)list.add(Utils.parse(buffer.toString()).jsonElement);
                buffer = new StringBuilder();
            }
            else if(Token.LIST_END==curr){
                if(buffer!=null && buffer.length()!=0)list.add(Utils.parse(buffer.toString()).jsonElement);
                return new Pair(new JSONList(list), i, str.substring(i+1));
            }
            else{
                buffer.append(str.charAt(i));
            }
        }
        return null;
    }

    public String toString() {
        return "" + this.list.toString();
    }
}

class JSONMap implements JSONElement {

    HashMap<String, JSONElement> hm;
    public JSONMap(HashMap<String, JSONElement> map) {
        this.hm = map;
    }
    public static Pair parseDict(String str) {
        return null;
        /*HashMap<String, JSONElement> dict = new HashMap<>();
        *//*Traverse the String until delimiter and get the buffer *//*
        StringBuilder buffer = new StringBuilder();

        int i=0;
        char curr;
        Pair pair;
*/
        /*for(i=1;i<str.length();i++){
            curr = str.charAt(i);
            if(Token.openingList().contains(curr)) {
                pair = Utils.parse(str.substring(i));
                i+=(pair.jsonElementEnd+1);
                list.add(pair.jsonElement);
            }
            else if(str.charAt(i)==Token.DELIMETER){
                if(buffer!=null && buffer.length()!=0)list.add(Utils.parse(buffer.toString()).jsonElement);
                buffer = new StringBuilder();
            }
            else if(Token.LIST_END==curr){
                if(buffer!=null && buffer.length()!=0)list.add(Utils.parse(buffer.toString()).jsonElement);
                return new Pair(new JSONList(list), i, str.substring(i+1));
            }
            else{
                buffer.append(str.charAt(i));
            }*/
        /*}

    for(i=1;i<str.length();i++){
            curr = str.charAt(i);
            if(curr==Token.DELIMETER){
                // parse map entry object which will always be String:JsonElement
                String[] entryObject = buffer.toString().split(Token.DICT_SYMBOL.toString());
                dict.put(entryObject[0],Utils.parse(entryObject[1].toString()).jsonElement);
                buffer = new StringBuilder();
            }
            else if(str.charAt(i)==Token.DICT_END){
                return new Pair(new JSONMap(dict),i, str.substring(i+1));
            }
            else{
                buffer.append(str.charAt(i));
            }
        }
        return new Pair(new JSONMap(dict),i, str.substring(i+1));*/
    }

    public String toString() {
        return "" + this.hm.toString();
    }
}


class ParseException extends RuntimeException {
    public ParseException(String parseException){
        super(parseException);
    }
}

class Utils {

    public static final String DIGITS = "0123456789";

    public static boolean isDigit(Character chr) {
        if (DIGITS.indexOf(chr) > -1 ) return true;
        return false;
    }

    public static Pair parse(String str) {
        if(str == null || str.length() == 0)
            return null;
        char chr = str.charAt(0);
        if(chr == Token.STRING_BEGIN)
            return JSONString.parseString(str);
        else if (isDigit(chr))
            return JSONNumber.parseNumber(str);
        else if(chr == Token.LIST_BEGIN)
            return JSONList.parseList(str);
        else if(chr == Token.DICT_BEGIN)
            return JSONMap.parseDict(str);
        else
            throw new ParseException("Unknown Token : " + chr);
    }
}

class MainParser {
    public static void main(String[] args) {
        String testCases[] = new String[]{
                "123",
                "123abc",
                "\"123\"abc",
                "\"abc\"[123]",
                "[1,2,3,4,5]",
                "[1,2,3,4,5]abc",
                "[[[]]]",
                "[[],[[]]]"	,
                "[\"a\",123,[\"x\",\"y\"]]",
                "{\"a\":1}",
                "{\"a\":1,\"b\":2}hh",
                "{}",
                "{}abc",
                "{\"a\":[[[]]]}",
                "{\"a\":1,\"b\":[1,2,3],\"c\":{\"d\":1}}",
                "{\"a\":{\"b\":{\"c\":{\"d\":[[[[[1,2,3,4,5]]]]]}}},\"e\":\"efg\"}abcd",
        };

        for(String str: testCases){
            System.out.println("Test Case parse string : " + str);
            Pair pair = Utils.parse(str);
            System.out.println(pair);
            System.out.println();
        }
        Pair pair = Utils.parse("[[[]]]");
        System.out.println(pair);
    }
}