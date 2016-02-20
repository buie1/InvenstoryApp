package ece651.duke.invenstory;

/**
 * Created by Young-hoon Kim on 2/19/2016.
 */
public class Item {
    //Label Table Name
    public static final String TABLE = "ITEM";

    //Label Table Column Names
    public static final String KEY_ID = "ID";
    public static final String KEY_Title = "Title";
    public static final String KEY_Author = "Author";
    public static final String KEY_Price = "Price";

    //property to help us keep data
    public int item_ID;
    public String item_Title;
    public String author;
    public int price;

}
