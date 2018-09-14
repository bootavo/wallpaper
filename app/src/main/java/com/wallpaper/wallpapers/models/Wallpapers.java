package com.wallpaper.wallpapers.models;

import java.util.ArrayList;
import java.util.List;

public class Wallpapers {

    private int id;
    private String title;
    private String size;
    private String upload_date;
    private String url_picture;

    public Wallpapers(int id, String title, String size, String upload_date, String url_picture) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.upload_date = upload_date;
        this.url_picture = url_picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(String upload_date) {
        this.upload_date = upload_date;
    }

    public String getUrl_picture() {
        return url_picture;
    }

    public void setUrl_picture(String url_picture) {
        this.url_picture = url_picture;
    }

    public static List<Wallpapers> getWallpapers(){

        List<Wallpapers> mList = new ArrayList<>();

        Wallpapers wallpapers1 = new Wallpapers(1, "Battle of Worlds", "5,300 kbps", "12-04-2018", "https://imgc.allpostersimages.com/img/print/posters/star-wars_a-G-1678159-0.jpg");
        mList.add(wallpapers1);

        Wallpapers wallpapers2 = new Wallpapers(2, "Episode 2", "2,500 kbps ","10-08-2018", "https://vignette.wikia.nocookie.net/es.starwars/images/f/f5/Rogue_One_A_Star_Wars_Story_theatrical_poster.png/revision/latest?cb=20161212223226");
        mList.add(wallpapers2);

        Wallpapers wallpapers3 = new Wallpapers(3, "Amazing Adventure", "4,600 kbps", "04-04-2018", "https://i.pinimg.com/originals/38/a9/e5/38a9e5018020cab10173ce5c0ac6ed06.jpg");
        mList.add(wallpapers3);

        Wallpapers wallpapers4 = new Wallpapers(4, "Battle of Words", "6,200 kbps", "23-05-2018", "https://imgc.allpostersimages.com/img/posters/star-wars-episode-viii-the-last-jedi-red-montage_u-L-F93H7K0.jpg?src=gp&w=300&h=375");
        mList.add(wallpapers4);

        Wallpapers wallpapers5 = new Wallpapers(5, "Battle of Worlds", "3,200 kbps", "17-02-2018", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQI51QhOxSSbv_HXLKxijUdANOkRz4PA3rwpDc6g7wHDHMsgV4_");
        mList.add(wallpapers5);

        Wallpapers wallpapers6 = new Wallpapers(6, "Battle of Worlds", "8,900 kbps", "11-09-2018", "https://i.ebayimg.com/images/g/mlwAAOSwux5YKajh/s-l300.jpg");
        mList.add(wallpapers6);

        return mList;

    }

}
