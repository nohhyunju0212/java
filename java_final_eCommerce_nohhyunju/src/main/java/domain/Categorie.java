package domain;

public class Categorie {
    public int cID;
    public Integer upoID = null;
    public String name = null;
    public int number;

    public Categorie(){

    }
    public Categorie(int cID, Integer upoID, String name, int number) {
        this.cID = cID;
        this.upoID = upoID;
        this.name = name;
        this.number = number;
    }

    public int getcID(){
        return cID;
    }
    public Integer getUpoID(){
        return upoID;
    }
    public String getName(){
        return name;
    }
    public int getNumber(){
        return number;
    }

    public void setcID(int cID){
        this.cID = cID;
    }
    public void setUpoID(Integer upoID){
        this.upoID = upoID;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setNumber(int number){
        this.number = number;
    }
}

