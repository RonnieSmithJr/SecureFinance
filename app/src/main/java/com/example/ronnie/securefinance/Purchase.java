package com.example.ronnie.securefinance;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ronnie on 10/12/15.
 */
public class Purchase implements Parcelable{
    public int amount;
    public String description;
    //public Location location;
    public String location;

    public Purchase(int amount, String description, String location) {
        this.amount = amount;
        this.description = description;
        this.location = location;
    }

    @Override
    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        //out.writeInt(mData);
    }

    public static final Parcelable.Creator<Purchase> CREATOR
            = new Parcelable.Creator<Purchase>() {
        public Purchase createFromParcel(Parcel in) {
            return new Purchase(in);
        }

        public Purchase[] newArray(int size) {
            return new Purchase[size];
        }
    };

    private Purchase(Parcel in) {
        //mData = in.readInt();
    }
//    public Purchase(int amount, String description) {
//        this.amount = amount;
//        this.description = description;
//
//    }

}
