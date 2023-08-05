//Assignment #: Arizona State University Spring 2023 CSE205 #9
//Name: Joel Hudgens
//StudentID: 1224491216
//Lecture: 10 30 T, Th
//Description: This class is a song object. Each playlist has many songs

public class Song {
    private String title;
    private String artist;
    public Song next;
    public static final Song END = new Song();

    public Song(String title, String artist){
        this.title = title;
        this.artist = artist;
        next = END;
    }

    // This is used to construct the END Table.
    private Song() {
        title = "";
        artist = "";
        next = this;
    }

    public boolean equals(Song other) {
        if (this.title.equals(other.title) 
         && this.artist.equals(other.artist))
            return true;
        return false;
    }

    public String toString(){
        return "Title: " + title + "\tArtist: " + artist;
    }
}
