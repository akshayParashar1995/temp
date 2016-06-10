package com.example.akshay.warehouse.extras;

import com.example.akshay.warehouse.models.Client;
import com.example.akshay.warehouse.models.Product;
import com.example.akshay.warehouse.models.Rtag;
import com.example.akshay.warehouse.models.User;
import com.example.akshay.warehouse.requests.BaseRequest;

import java.util.List;

/**
 * Created by akshay on 14/12/15.
 */
public class Globals {
    public static User loggedUser=new User();
    public static BaseRequest baseRequest=new BaseRequest();
    public static List<Client> spinnerClientsList;
    public static List<Product> productsForCurrentlySelelctedRtag;
    public static List<Rtag> defaultListOfRtags;

}
