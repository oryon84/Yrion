package fr.yrion.yrion;

/**
 * Created by oisn on 05/11/2015.
 */
public class task {
    String name;
    String description;
    String date;
    int surface;
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTache() {
        return tache;
    }

    public void setTache(int tache) {
        this.tache = tache;
    }

    int tache;

    task(String name, String description,String date,int surface, int id, int tache){

        this.name = name;
        this.description = description;
        this.date = date;
        this.surface = surface;
        this.id = id;
        this.tache = tache;

    }
}
