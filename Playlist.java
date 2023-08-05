//Assignment #: Arizona State University Spring 2023 CSE205 #9
//Name: Joel Hudgens
//StudentID: 1224491216
//Lecture: 10 30 T, Th
//Description: This class is a playlist (A linked list), which contains nodes of object type songs
//This class contains many methods which manipulate the playlist, and give the driver class function 
//over the playlist

public class Playlist {
    String name;
    Song first;
 
    
    public Playlist(){
        name = "library";
        first = Song.END;
    }

    public Playlist(String name) {
        this.name = name;
        first = Song.END;
    }

    public String getName() {
        return name;
    }
    
    //adds a song to the end of the linked list
    public void add(Song song){
    	if (size() == 0) { //If no songs in playlist
    		first = song;	//song is the first node
    		return;
    	}
    	Song tempSong = first; //otherwise, create a temp song
		while (tempSong.next != Song.END) {	//while there is another song
			tempSong = tempSong.next; //traverse to next node
		}
		
		tempSong.next = song; //Song after the last song in the list = the song we passed in
    }
    
    //calculates the size of the playerList linked list
    public int size() {
    	if (first == Song.END) { //If list is empty
    		return 0;
    	}
    	if (first.next == Song.END) { //If list is size 1
    		return 1;
    	}
    	
    	int counter = 1;
    	Song tempSong = first;//temporary song to set equal to each node as we traverse through list
    	while (tempSong.next != Song.END) {	//while there is another song
			tempSong = tempSong.next;
			counter++;
		}
    	return counter;
    }
    
    //Returns the first value in playlist and removes it from list
    public Song removeFirst() {
        if (first != Song.END){ 
        	Song temp = first;
        	first = first.next;
        	return temp;
        }
        return first;
    }
    //Removes a song that it is supplied in parameter
    //Returns the position from which the song was removed
    public int remove(Song song) {
    	if (first == Song.END) { // list is empty
            return -1;
        }
    	
    	int index = 0;
        Song previous = first;
        Song current = first.next;
        
        while (current != Song.END) { //traversing through list
        	index++;
        	previous = current;
			current = current.next;
        }
        if (current != Song.END) {
			previous.next = current.next; // cut off current!
		}
        return index;
    }

    public Song head() {
        return first;
    }
    //Returns the position of a given song in the playlist
    public int getPosition(Song song) {
    	Song tempSong = first;
    	int counter = 1;
    	
    	if (first == Song.END){ //If there are no songs
        	return 0;
        }
    	 while (!tempSong.next.equals(song)) {
    		 counter += 1;
    		 tempSong = tempSong.next;
    	 }
    	 return counter;
    }
    
    //returns a formatted list of songs in a given playlist
    public String listSongs() {
    	Song tempSong = first;
        String result = "";
        
        if (size() == 0){ //If there are no songs
        	result += "No songs in playlist.";
        	return result;
        }
        result+= first.toString() + "\n";
        while (tempSong.next != Song.END) {	//while there is another song
			tempSong = tempSong.next; 
			result += tempSong.toString() + "\n";//Add song to output String
		}
        result += "\nTotal songs: " + size() + ".";
        return result;
    }
    
}
